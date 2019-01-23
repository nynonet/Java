/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fasb.edu.br.Model.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author andesonjesusdemenezes
 */
public class Conexao {
    
    private static Connection con;
    
    public static Connection getConexao(){
        
        if (con == null) {
            conectar();
        }
        
        return con;
    }
    
    private static boolean conectar(){
        String url = "jdbc:sqlite:myfinance.db";
        try {
            con = DriverManager.getConnection(url);
            System.out.println("Conectado com sucesso!");
        } catch (SQLException e) {
            e.printStackTrace();
        }        
        
        return true;
    }
    
}
