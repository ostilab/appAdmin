/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.osti.ostirh.appAdmin.DAO;

import com.osti.ostirh.appAdmin.JDBC.ConnectionFactory;
import com.osti.ostirh.appAdmin.Modelo.Organizacao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author len
 */
public class OrganizacaoDAOImpl implements OrganizacaoDAO {

    private Connection conexao;
    List<Organizacao> listaOrgs = new ArrayList<>();

    public OrganizacaoDAOImpl(Connection connection) {
        this.conexao = connection;
    }
    public OrganizacaoDAOImpl(HttpServletRequest request) {
        this.conexao = (Connection) request.getAttribute("conexao");
    }
    /*public OrganizacaoLogica(DataSource dataSource) {
        try {
            this.conexao = dataSource.getConnection();
        } catch (SQLException ex) {
            Logger.getLogger(OrganizacaoLogica.class.getName()).log(Level.SEVERE, null, ex);
        }
    }*/

    @Override
    public boolean Salvar(Organizacao organizacao) {
        String query = "INSERT INTO organizacao (nomedaorganizacao,objectosocial,enderecoweb,codigoorganizacao) VALUES(?,?,?,?);";

        try {
            PreparedStatement pst = conexao.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            //Organização
            pst.setString(1, organizacao.getNomedaorganizacao());
            pst.setString(2, organizacao.getObjectosocial());
            pst.setString(3, organizacao.getEnderecoWeb());
            pst.setString(4, organizacao.getCodigoorganizacao());
            pst.executeUpdate();
        } catch (SQLException ex) {
            return false;
        }
        return true;
    }

    @Override
    public boolean Alterar(Organizacao organizacao) {

        String query = "UPDATE organizacao set nomedaorganizacao =?,objectosocial=?,enderecoweb=?,codigoorganizacao=?, "
                + "plano =?,armazenamento=?, numerofuncionarios=?,data_inicio_adesao=?,data_fim_adesao=?,estado =?"
                + "where idorganizacao = ?";
        System.out.println("Alterando Organização...........");
        try {
            PreparedStatement pst = conexao.prepareStatement(query);
            //Organização
            pst.setString(1, organizacao.getNomedaorganizacao());
            pst.setString(2, organizacao.getObjectosocial());
            pst.setString(3, organizacao.getEnderecoWeb());
            pst.setString(4, organizacao.getCodigoorganizacao());
            pst.setString(5, organizacao.getPlano());
            pst.setInt(6, organizacao.getArmazenamento());
            pst.setInt(7, organizacao.getNumerofuncionarios());
            pst.setDate(8, organizacao.getDatainicioadesao());
            pst.setDate(9, organizacao.getDatafimadesao());
            pst.setBoolean(10, organizacao.isEstado());
            pst.setInt(11, organizacao.getIdorganizacao());
            pst.executeUpdate();
            pst.close();
        } catch (SQLException ex) {
            return false;
        }
        return true;
    }

    @Override
    public boolean Eliminar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Organizacao> getTodasOrgs() {
        List<Organizacao> listaTodasOrg = new ArrayList<>();
        try {
            PreparedStatement pst = conexao.prepareStatement("SELECT * FROM organizacao");
            ResultSet res = pst.executeQuery();

            while (res.next()) {
                Organizacao orgs = new Organizacao();
                orgs.setIdorganizacao(res.getInt("idorganizacao"));
                orgs.setNomedaorganizacao(res.getString("nomedaorganizacao"));
                orgs.setObjectosocial(res.getString("objectosocial"));
                orgs.setEnderecoWeb(res.getString("enderecoweb"));
                orgs.setCodigoorganizacao(res.getString("codigoorganizacao"));
                //Dados do Plano
                orgs.setArmazenamento(res.getInt("armazenamento"));
                orgs.setDatainicioadesao(res.getDate("data_inicio_adesao"));
                orgs.setDatafimadesao(res.getDate("data_fim_adesao"));
                orgs.setEstado(res.getBoolean("estado"));
                orgs.setPlano(res.getString("plano"));
                listaTodasOrg.add(orgs);
            }
            res.close();
            pst.close();

        } catch (SQLException ex) {
            System.out.println("Erro:" + ex);
            Logger.getLogger(OrganizacaoDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

        return listaTodasOrg;
    }

    @Override
    public Organizacao getOrgPorId(int idorg) {
        Organizacao org = new Organizacao();
        try {
            PreparedStatement pst = conexao.prepareStatement("SELECT * FROM organizacao where idorganizacao = ?");

            //Organização
            pst.setInt(1, idorg);

            ResultSet res = pst.executeQuery();
            if (!res.next()) {
                return null;
            }
            res.first();

            org.setIdorganizacao(res.getInt("idorganizacao"));
            org.setNomedaorganizacao(res.getString("nomedaorganizacao"));
            org.setObjectosocial(res.getString("objectosocial"));
            org.setEnderecoWeb(res.getString("enderecoweb"));
            org.setCodigoorganizacao(res.getString("codigoorganizacao"));
            //Dados do Plano
            org.setArmazenamento(res.getInt("armazenamento"));
            org.setDatainicioadesao(res.getDate("data_inicio_adesao"));
            org.setDatafimadesao(res.getDate("data_fim_adesao"));
            org.setEstado(res.getBoolean("estado"));
            org.setPlano(res.getString("plano"));

            res.close();
            pst.close();

        } catch (SQLException ex) {
            Logger.getLogger(OrganizacaoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return org;
    }

    @Override
    public List<Organizacao> getTodasOrgs(String nome, String obj_social, String plano, String datainicio_ia,String datafim_ia, String datainicio_fa, String datafim_fa) {
        List<Organizacao> listaOrg = new ArrayList<>();
        try {
            PreparedStatement pst = conexao.prepareStatement("SELECT * FROM organizacao where nomedaorganizacao like ? or objectosocial like ? or plano like ?"
                    + "or data_inicio_adesao between ? and ? or data_fim_adesao between ? and ?");

            //Organização
            pst.setString(1, "%" + nome + "%");
            pst.setString(2, "%" + obj_social + "%");
            pst.setString(3, "%" + plano + "%");
            pst.setString(4,  datainicio_ia );
            pst.setString(5, datafim_ia);
            pst.setString(6,  datainicio_fa );
            pst.setString(7, datafim_fa);
            ResultSet res = pst.executeQuery();

            while (res.next()) {
                Organizacao orgs = new Organizacao();
                orgs.setIdorganizacao(res.getInt("idorganizacao"));
                orgs.setNomedaorganizacao(res.getString("nomedaorganizacao"));
                orgs.setObjectosocial(res.getString("objectosocial"));
                orgs.setEnderecoWeb(res.getString("enderecoweb"));
                orgs.setCodigoorganizacao(res.getString("codigoorganizacao"));
                //Dados do Plano
                orgs.setArmazenamento(res.getInt("armazenamento"));
                orgs.setDatainicioadesao(res.getDate("data_inicio_adesao"));
                orgs.setDatafimadesao(res.getDate("data_fim_adesao"));
                orgs.setEstado(res.getBoolean("estado"));
                orgs.setPlano(res.getString("plano"));
                listaOrg.add(orgs);

            }
            res.close();
            pst.close();
        } catch (SQLException ex) {
            Logger.getLogger(OrganizacaoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return listaOrg;
    }

    @Override
    public Organizacao getOrgPorCodigo(String codigoOrganizacao) {
        Organizacao org = new Organizacao();
        try {
            PreparedStatement pst = conexao.prepareStatement("SELECT * FROM organizacao where codigoorganizacao = ?");

            //Organização
            pst.setString(1, codigoOrganizacao);

            ResultSet res = pst.executeQuery();
            if (!res.next()) {
                return null;
            }
            res.first();

            org.setIdorganizacao(res.getInt("idorganizacao"));
            org.setNomedaorganizacao(res.getString("nomedaorganizacao"));
            org.setObjectosocial(res.getString("objectosocial"));
            org.setEnderecoWeb(res.getString("enderecoweb"));
            org.setCodigoorganizacao(codigoOrganizacao);
            //Dados do Plano
            org.setArmazenamento(res.getInt("armazenamento"));
            org.setDatainicioadesao(res.getDate("data_inicio_adesao"));
            org.setDatafimadesao(res.getDate("data_fim_adesao"));
            org.setEstado(res.getBoolean("estado"));
            org.setPlano(res.getString("plano"));

            res.close();
            pst.close();

        } catch (SQLException ex) {
            Logger.getLogger(OrganizacaoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return org;
    }

    public static void main(String[] args) throws SQLException {
        new OrganizacaoDAOImpl(ConnectionFactory.getConexao()).alterarEstadoConta(30);
        //  System.out.println(res);

    }

    @Override
    public void alterarEstadoConta(int idorg) {

        try (PreparedStatement pst = conexao.prepareStatement("UPDATE organizacao set estado = ? where idorganizacao = ?")) {
            if (getOrgPorId(idorg).isEstado()) {
                pst.setBoolean(1, false);
            } else {
                pst.setBoolean(1, true);
            }
            pst.setInt(2, idorg);
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(OrganizacaoDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
