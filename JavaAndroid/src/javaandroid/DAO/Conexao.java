/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaandroid.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author andeson
 */
public class Conexao {

    Connection con;

    public Conexao() {
        String url = "jdbc:mysql://192.168.2.101:3306/contato";
        try {
            con = DriverManager.getConnection(url, "root", "Mysql12345");
        } catch (SQLException erro) {
            System.err.println("Erro no conectar com " + url);
            System.out.println(erro.getMessage());
        }

    }

    public Connection GetConexao() {
        return con;
    }

}
