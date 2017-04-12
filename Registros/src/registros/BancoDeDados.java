/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package registros;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Andeson
 */
public class BancoDeDados {

    private Connection con;

    public BancoDeDados() {
        String url = "jdbc:postgresql://192.168.2.101:5432/fasb";
        try {
            this.con = DriverManager.getConnection(url, "fasb", "fasb");
            System.out.println("Conectado...");
        } catch (Exception e) {
            System.out.println("falha: " + e.getMessage());
        }
    }

    public void InsertTabela(String nome, double valor, boolean status, int i) {
        String SQL = "INSERT INTO tabela (nome, valor,ativo, data) "
                + "values (?,?,?,current_timestamp) ";
        PreparedStatement ps;

        try {
            ps = this.con.prepareStatement(SQL);
            ps.setString(1, nome);
            ps.setDouble(2, valor);
            ps.setBoolean(3, status);          

            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("falha no inserir: " + ex.getMessage());
        }

    }

    public String getNum() {
        String SQL = "SELECT count(id) as id FROM tabela";
        PreparedStatement ps;
        String resposta = "";
        try {
            ps = this.con.prepareStatement(SQL);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                resposta = String.valueOf(rs.getInt(1));
            }

        } catch (SQLException ex) {
            System.out.println("falha ao buscar: " + ex.getMessage());
        }
        return resposta;
    }

    public Connection getCon() {
        return con;
    }

    public void setCon(Connection con) {
        this.con = con;
    }

}
