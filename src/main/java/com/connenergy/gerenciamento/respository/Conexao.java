/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.connenergy.gerenciamento.respository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Aluno
 */
public class Conexao {
    public static final String url = "jdbc:mysql://localhost:3306/empresa";
    public static final String user = "root";
    public static final String senha= "Eva172024";
    private static Connection conn = null;
    
    
    private Conexao(){
    }
    
    public static synchronized Connection conectar(){
        
        try{
            if (conn == null || conn.isClosed()){
               conn = DriverManager.getConnection(url,user, senha);
            }
            
        }catch(SQLException e){
            e.printStackTrace(); 
                    
        }
        return conn;
        
        
    }
    
    
    
}
