/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Andeson
 */
public class Conexao {
    
    private Connection com; //Recebe e mantem a conexão com o banco de dados
    private String usuario = "root"; //usuário administrador do banco de dados
    private String senha = "Mysql12345"; //a senha do administrador do banco de dados
    private String url = "jdbc:mysql://192.168.2.101:3306/fasb"; //URL de Conexão
    
    /**
     * Método construtor alterado para já realizar a conexão com o banco
     * de dados. 
     * no nosso exemplo o nome do banco de dados encontra-se no final
     * da URL, bem como a porta de conexão
     */
    public Conexao() {
        
        try {
            com = DriverManager.getConnection(url, usuario, senha);
            System.out.println("Sucesso na conexão com o banco de dados!");
        } catch (Exception e) {
            e.printStackTrace();
        }
            
    }
    
    /**
     * Retorna a conexão Ativa
     * @return 
     */
    public Connection getConexao(){
        return com;
    }
    
    /**
     * Método para fecha a conexão com o bando de dados.
     */
    public void FechaConexao(){
        try {
            com.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    
    
    
    
}
