/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.osti.ostirh.appAdmin.DAO;

import com.osti.ostirh.appAdmin.Modelo.Admin;

/**
 *
 * @author len
 */
public interface AdminDAO {
    public Admin getAdmin();
    public void salvar(Admin admin);
    public void eliminar(Admin admin);
    public boolean eAdmin(Admin admin);
}
