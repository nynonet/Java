/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exemploaula;

import exemploaula.model.dao.ConexaoDB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author LAB1
 */
public class ExemploAula {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ConexaoDB minhaConexao = new ConexaoDB();
        try {
//            String sql = "UPDATE contato SET nome = ? where id=?";
//            
//            PreparedStatement ps = minhaConexao.getConexao().
//                    prepareStatement(sql);
//            System.out.println("Conexão com sucesso!");
//            
//            ps.setString(1, "FASB");
//            ps.setInt(2, 1);
//            ps.executeUpdate();
//            System.out.println("Dado inserido com sucesso!");

            String sql = "SELECT id, nome FROM contatos";
            PreparedStatement ps = minhaConexao.getConexao().
                    prepareStatement(sql);

            ResultSet rs = ps.executeQuery();
            while ( rs.next()) {
                System.out.println("==============");
                System.out.println("Id: " + rs.getString("id"));
                System.out.println("Nome: " + rs.getString("nome"));
            }
//            if (rs.last()) {
//                System.out.println("Id: " + rs.getString("id"));
//                System.out.println("Nome: " + rs.getString("nome"));
//            } else {
//                System.out.println("adicione registro no banco.");
//            }

        } catch (SQLException ex) {

            System.out.println("Falha de Conexão/operação!");

//            ex.printStackTrace();
            System.err.println(ex.getMessage());
        }
    }

}
