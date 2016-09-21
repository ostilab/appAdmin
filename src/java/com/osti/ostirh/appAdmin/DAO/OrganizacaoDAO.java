/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.osti.ostirh.appAdmin.DAO;

import com.osti.ostirh.appAdmin.Modelo.Organizacao;
import java.sql.Date;
import java.util.List;

/**
 *
 * @author len
 */
public interface OrganizacaoDAO {

    public boolean Salvar(Organizacao org);

    public boolean Alterar(Organizacao org);

    public boolean Eliminar();

    public List<Organizacao> getTodasOrgs();

    public Organizacao getOrgPorId(int idorg);

    public List<Organizacao> getTodasOrgs(String nome, String obj_social, String plano, String datainicio_ia, String datafim_ia,String datainicio_fa, String datafim_fa );

    public Organizacao getOrgPorCodigo(String codigoOrganizacao);

    public void alterarEstadoConta(int idorg);
}
