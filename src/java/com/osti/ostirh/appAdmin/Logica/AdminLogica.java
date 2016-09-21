/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.osti.ostirh.appAdmin.Logica;

import com.osti.ostirh.appAdmin.DAO.AdminDAO;
import com.osti.ostirh.appAdmin.JDBC.ConnectionFactory;
import com.osti.ostirh.appAdmin.Modelo.Admin;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author len
 */
public class AdminLogica implements AdminDAO {
    Connection conexao = null;

    public AdminLogica() {
        conexao = ConnectionFactory.getConexao();
    }
    
    public AdminLogica(HttpServletRequest request){
        this.conexao = (Connection) request.getAttribute("conexao");
    }
    @Override
    public Admin getAdmin() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void salvar(Admin admin) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void eliminar(Admin admin) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean eAdmin(Admin admin) {
          try {
            PreparedStatement pst = conexao.prepareStatement("SELECT * FROM admin where utilizador = ? and senha  =?");

            //Organização
            pst.setString(1, admin.getUtilizador());
            pst.setString(2, admin.getSenha());

            ResultSet res = pst.executeQuery();
            if (!res.next()) {
                return false;
            }
            res.close();
            pst.close();

        } catch (SQLException ex) {
            Logger.getLogger(AdminDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        
       return true;
    }
    public static void main(String[] args) {
        Admin ad = new Admin("master@ostirh.com", "masteradmin");
        System.out.println(  new AdminLogica().eAdmin(ad));
    }
}
