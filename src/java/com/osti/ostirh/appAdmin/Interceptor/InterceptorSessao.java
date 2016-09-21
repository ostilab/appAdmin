/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.osti.ostirh.appAdmin.Interceptor;

import com.osti.ostirh.appAdmin.JDBC.ConnectionFactory;
import java.sql.Connection;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 *
 * @author len
 */
public class InterceptorSessao extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request,
            HttpServletResponse response,
            Object MainController) throws Exception {

        String uri = request.getRequestURI();
        if (uri.endsWith("login")
                /* || uri.endsWith("iniciarsessao")*/
                || uri.endsWith("/")
                || uri.contains("css")
                || uri.endsWith("redirect")) {
            return true;
        }

        if (request.getSession().getAttribute("utilizadorLogado") != null || uri.endsWith("iniciarsessao")) {
            request.setAttribute("conexao", ConnectionFactory.getConexao());
            System.out.println("Fltro executado PRE");
            return true;
        }

        response.sendRedirect("login?opr=1");
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        if (request.getSession().getAttribute("utilizadorLogado") != null) {

            if (request.getAttribute("conexao") != null) {
                Connection conn = (Connection) request.getAttribute("conexao");
                conn.close();
                request.setAttribute("conexao", conn);
                System.out.println("Conexao Fechada!");
            }
            System.out.println("Fintro executado POS");
        }
    }

}
