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
public class Organizacao {
    // Detalhe da Organizacao
    private int idorganizacao;
    private String nomedaorganizacao;
    private String enderecoWeb;
    private String organigrama;
    private String objectosocial;
    private String codigoorganizacao;
    private String info;
    //Detalhes do Plano
    private String plano;
    private int armazenamento;
    private int numerofuncionarios;
    private boolean estado;
    private Date datainicioadesao;
    private Date datafimadesao;

    public int getIdorganizacao() {
        return idorganizacao;
    }

    public void setIdorganizacao(int idorganizacao) {
        this.idorganizacao = idorganizacao;
    }

    public String getNomedaorganizacao() {
        return nomedaorganizacao;
    }

    public void setNomedaorganizacao(String nomedaorganizacao) {
        this.nomedaorganizacao = nomedaorganizacao;
    }

    public String getEnderecoWeb() {
        return enderecoWeb;
    }

    public void setEnderecoWeb(String enderecoWeb) {
        this.enderecoWeb = enderecoWeb;
    }

    public String getOrganigrama() {
        return organigrama;
    }

    public void setOrganigrama(String organigrama) {
        this.organigrama = organigrama;
    }

    public String getObjectosocial() {
        return objectosocial;
    }

    public void setObjectosocial(String objectosocial) {
        this.objectosocial = objectosocial;
    }

    public String getCodigoorganizacao() {
        return codigoorganizacao;
    }

    public void setCodigoorganizacao(String codigoorganizacao) {
        this.codigoorganizacao = codigoorganizacao;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getPlano() {
        return plano;
    }

    public void setPlano(String plano) {
        this.plano = plano;
    }

    public int getArmazenamento() {
        return armazenamento;
    }

    public void setArmazenamento(int armazenamento) {
        this.armazenamento = armazenamento;
    }

    public int getNumerofuncionarios() {
        return numerofuncionarios;
    }

    public void setNumerofuncionarios(int numerofuncionarios) {
        this.numerofuncionarios = numerofuncionarios;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public Date getDatainicioadesao() {
        return datainicioadesao;
    }

    public void setDatainicioadesao(Date datainicioadesao) {
        this.datainicioadesao = datainicioadesao;
    }

    public Date getDatafimadesao() {
        return datafimadesao;
    }

    public void setDatafimadesao(Date datafimadesao) {
        this.datafimadesao = datafimadesao;
    }
}
