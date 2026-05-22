/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mecanicbase.util;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Pedro Carmo
 */
public class Conexao {
    private static final String url = "jdbc:mysql://localhost:3306/mecanic_base";
    private static final String user = "root";
    private static final String password = "";
    
    public static Connection conectar(){
        
        try{
            
            java.sql.Connection conex = DriverManager.getConnection(url, user, password);

            return conex;
            
        } catch (Exception ex) {
            System.out.println("Erro: " + ex.getMessage());
            
            return null;
        }
    }
       
}
