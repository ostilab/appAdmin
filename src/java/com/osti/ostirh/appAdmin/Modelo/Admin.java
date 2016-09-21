/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.osti.ostirh.appAdmin.Modelo;

import java.sql.Date;

/**
 *
 * @author len
 */
public class Admin {
    private String utilizador;
    private String senha;
    private int idadmin;
    private Date datacariacao;

    public Admin(String utilizador, String senha) {
        this.utilizador = utilizador;
        this.senha = senha;
    }

    public String getUtilizador() {
        return utilizador;
    }

    public void setUtilizador(String utilizador) {
        this.utilizador = utilizador;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public int getIdadmin() {
        return idadmin;
    }

    public void setIdadmin(int idadmin) {
        this.idadmin = idadmin;
    }

    public Date getDatacariacao() {
        return datacariacao;
    }

    public void setDatacariacao(Date datacariacao) {
        this.datacariacao = datacariacao;
    }
}
