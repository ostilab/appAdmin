/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.osti.ostirh.appAdmin.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author len
 */
public final class ConnectionFactory {

    public static Connection getConexao() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Conexão aberta com sucesso!");
            //return DriverManager.getConnection("jdbc:mysql://localhost/ostirhco_ostirh_v1", "ostirhco", "oZpg58T88y");
               return DriverManager.getConnection("jdbc:mysql://localhost/ostirh", "root", "1234");
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static void fecharConexao() {
        try {
            // System.out.println("Conexão Fechada");
            ConnectionFactory.getConexao().close();
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static Statement st = null;

    public static ResultSet executarSQL(String query) {
        try {
            System.out.println("chamando conexao");
            return ConnectionFactory.getConexao().createStatement().executeQuery(query);
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static boolean executarSQL2(String query) {
        try {
            return ConnectionFactory.getConexao().createStatement().execute(query);
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            fecharConexao();
        }
        return false;
    }

    public static void main(String[] args) throws SQLException {
         ResultSet res =  ConnectionFactory.executarSQL("SELECT * from organizacao");
         res.first();
        System.out.println(res.getInt(1));
       
    }
}
