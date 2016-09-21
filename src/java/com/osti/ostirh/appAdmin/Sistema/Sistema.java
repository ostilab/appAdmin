/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.osti.ostirh.appAdmin.Sistema;

import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author len
 */
public class Sistema {

    public static String alertarInformacao(String informacao, String mensagem) {
        return "<div class='alert alert-info alert-dismissible' role='alert'>\n"
                + "                            <button type='button' class='close' data-dismiss='alert' aria-label='Close'><span aria-hidden='true'>&times;</span></button>\n"
                + "                            <strong>" + informacao + "!</strong> " + mensagem + ".</div>";
    }

    public static String alertarAviso(String aviso, String mensagem) {
        return "<div class='alert alert-warning alert-dismissible' role='alert'>\n"
                + "                            <button type='button' class='close' data-dismiss='alert' aria-label='Close'><span aria-hidden='true'>&times;</span></button>\n"
                + "                            <strong>" + aviso + "!</strong> " + mensagem + ".</div>";
    }

    public static String alertarSucesso(String opercao, String mensagem) {
        return "<div class='alert alert-success alert-dismissible' role='alert'>\n"
                + "                            <button type='button' class='close' data-dismiss='alert' aria-label='Close'><span aria-hidden='true'>&times;</span></button>\n"
                + "                            <strong>" + opercao + "!</strong> " + mensagem + ".</div>";
    }

    public static String alertarErro(String erro, String mensagem) {
        return "<div class='alert alert-danger alert-dismissible' role='alert'>\n"
                + "                            <button type='button' class='close' data-dismiss='alert' aria-label='Close'><span aria-hidden='true'>&times;</span></button>\n"
                + "                            <strong>" + erro + "!</strong> " + mensagem + ".</div>";
    }

    public static int converterRequestToInt(String parametro) {
        parametro = ("".equals(parametro) || parametro == null) ? "-1" : parametro;
        return Integer.parseInt(parametro);
    }
    
     public static long converterRequestToLong(String parametro) {
        parametro = ("".equals(parametro) || parametro == null)  ? "000000000" : parametro;
        return Long.parseLong(parametro);
    }

    public static double converterRequestToDouble(String parametro) {
        parametro = ("".equals(parametro) || parametro == null)  ? "-1.0" : parametro;
        return Double.parseDouble(parametro);
    }
    public static java.sql.Date converterRequestToDate(String data) {
        data = (data == null || "".equals(data))? "01-01-2016": data;
        java.sql.Date sql = null;
        try {
            sql = new java.sql.Date(new SimpleDateFormat("dd-MM-yyyy").parse(data).getTime());
            // parametro = parametro == null ? "1.0" : parametro; 
        } catch (ParseException ex) {
            Logger.getLogger(Sistema.class.getName()).log(Level.SEVERE, null, ex);
        }
        return sql;
    }
     public static java.sql.Time converterRequestToTime(String hora) {
        hora = (hora == null || "".equals(hora))? "08:00:00" : hora+":00";
        java.sql.Time time = null;
        try {
            time = new java.sql.Time(new SimpleDateFormat("hh:mm:ss").parse(hora).getTime());
            // parametro = parametro == null ? "1.0" : parametro; 
        } catch (ParseException ex) {
            Logger.getLogger(Sistema.class.getName()).log(Level.SEVERE, null, ex);
        }
        return time;
    }
    public static void main(String[] args) {
        String a = "13:30:45";
        
        java.sql.Time tempo = Sistema.converterRequestToTime(a);
      
        System.out.println(tempo);
    }
}
