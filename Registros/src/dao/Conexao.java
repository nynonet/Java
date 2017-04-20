/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Andeson
 */
public class Conexao {

    private Connection con;
    private boolean conectado = false;
    private String url = "jdbc:postgresql://192.168.2.101:5432/fasb";
    private String user = "fasb";
    private String pass = "fasb";

    public Conexao() {

        try {
            con = DriverManager.getConnection(url, user, pass);
            conectado = true;
            System.out.println("Conectado com "+url);
        } catch (Exception e) {
            conectado = false;
            e.printStackTrace();
        }

    }

    public boolean isConectado() {
        return conectado;
    }

    public Connection getCon() {
        return con;
    }

}
