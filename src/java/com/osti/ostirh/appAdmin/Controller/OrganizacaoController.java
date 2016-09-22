/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.osti.ostirh.appAdmin.Controller;

import com.osti.ostirh.appAdmin.JDBC.ConnectionFactory;
import com.osti.ostirh.appAdmin.Logica.OrganizacaoLogica;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.portlet.ModelAndView;

/**
 *
 * @author len
 */
@Controller
@RequestMapping("/org")
public class OrganizacaoController {

    private final OrganizacaoLogica OrgLogica;

    public OrganizacaoController() {
        Connection conexao = ConnectionFactory.getConexao();
        this.OrgLogica = new OrganizacaoLogica(conexao);
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String redirect() {
        return "forward:/redirect?p=admin/org&a=organizacao";
    }

    @RequestMapping(value = "/pesquisarOrg")
    public String pesquisarOrg(@RequestParam(value = "nome", required = true) String nome,
            @RequestParam(value = "obj_social", required = true) String objectosocial,
            @RequestParam(value = "plano", required = true) String plano,
            @RequestParam(value = "datainicio_ia", required = true) String datainicio_ia,
            @RequestParam(value = "datafim_ia", required = true) String datafim_ia,
            @RequestParam(value = "datainicio_fa", required = true) String datainicio_fa,
            @RequestParam(value = "datafim_fa", required = true) String datafim_fa, HttpServletRequest mod) {

        nome = nome.equals("") ? null : nome;
        objectosocial = objectosocial.equals("") ? null : objectosocial;
        plano = plano.equals("") ? null : plano;
        datainicio_ia = datainicio_ia.equals("") ? null : datainicio_ia;
        datafim_ia = datafim_ia.equals("") ? null : datafim_ia;
        datainicio_fa = datainicio_fa.equals("") ? null : datainicio_fa;
        datafim_fa = datafim_fa.equals("") ? null : datafim_fa;

        if (nome == null && objectosocial == null && plano == null && datainicio_ia == null && datafim_ia == null && datainicio_fa == null && datafim_fa == null) {
            mod.getSession().setAttribute("organizacao", OrgLogica.getTodasOrgs());
        } else {
            mod.getSession().setAttribute("organizacao", OrgLogica.getTodasOrgs(nome, objectosocial, plano, datainicio_ia, datafim_ia, datainicio_fa, datafim_fa));
        }
        return "forward:/org/pesquisarOrg?nome=&obj_social=&plano=&pesquisa=Pesquisar&datainicio_ia=&datafim_ia=&datainicio_fa=&datafim_fa=";
        //return "organizacao";
    }

    @RequestMapping(value = "/definicoes")
    public String getDefinicoes(@RequestParam(value = "idorg", required = true) int idorg,
            @RequestParam(value = "def_opr", required = true) String opr,
            ModelMap mod) {

        switch (opr) {
            case "defOrg":
                mod.addAttribute("organizacao", OrgLogica.getOrgPorId(idorg));
                return "admin/org/definicoes";
            case "defCand":
                return "admin/candidato/definicoes";
            default:
                return "admin/home";
        }

        //return "organizacao";
    }

    @RequestMapping(value = "/alterarOrg")
    public String alterarOrganizacao(@RequestParam(value = "idorg", required = true) int idorg,
            @RequestParam(value = "def_opr", required = true) String opr,
            @RequestParam("datainicioadesao") @DateTimeFormat(pattern = "yyyy-MM-dd") Date datainicioadesao,
            @RequestParam("datafimadesao") @DateTimeFormat(pattern = "yyyy-MM-dd") Date datafimadesao,
            ModelMap mod) {

        switch (opr) {
            case "defOrg":
                mod.addAttribute("organizacao", OrgLogica.getOrgPorId(idorg));
                return "admin/org/definicoes";
            case "defCand":
                return "admin/candidato/definicoes";
            default:
                return "redirect:/";
        }

    }

    @RequestMapping(value = "/alterarEstadoConta")
    public String alterarEstadoConta(HttpServletResponse response,
            @RequestParam("idorg") int idorg, ModelMap mod, ModelAndView mav) throws IOException {
        OrgLogica.alterarEstadoConta(idorg);
        return "redirect:/org/definicoes.html?def_opr=defOrg&idorg=" + idorg + "#EstadoDaConta";

    }
}
