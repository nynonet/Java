/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.fasb.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author andesonjesusdemenezes
 */
public class ConexaoDB {

    private static Connection banco;

    private static void gerarConexao() {
        try {
            banco = DriverManager.getConnection("jdbc:sqlite:mycontatos.db");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConexao() {
        
        if (banco == null) {
            gerarConexao();
        }
        
        return banco;
    }
}
