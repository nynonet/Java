/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exemploaula.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author LAB1
 */
public class ConexaoDB {
    //nome do usuário a logar no banco de dados
    private String usuario;
    
    //senha do usuário 
    private String senha;
    
    //Url de conexão com o banco de dados
    private String url;

    /**
     * Conexão padrão com usuáio, senha e url pré-definida
     */
    public ConexaoDB() {
        this.usuario = "root";
        this.senha = "";
        this.url = "127.0.0.1:3306/fasb"; //seu servidor + banco de dados.
    }
    
    /** as
     * Pasando os dados de login e senha e url pré-definida
     * @param usuario nome do usuário
     * @param senha  senha do usuário 
     */
    public ConexaoDB(String usuario, String senha) {
        this.usuario = usuario;
        this.senha = senha;
        this.url = "127.0.0.1:3306/fasb";
    }
    
    /**
     * Pasando todos os dados por parametro
     * @param usuario   usuário do banco
     * @param senha senha do banco
     * @param url servidor e database
     */
    public ConexaoDB(String usuario, String senha, String url) {
        this.usuario = usuario;
        this.senha = senha;
        this.url = url;
    }
    
    /**
     * Conecta e devolve a conexão, sendo que quem chamar 
     * deve fazer o tratamento da exceção
     * @return retorna uma conexão
     * @throws SQLException indica que a classe que invocar
     * deve fazer o tratamento de exceção;
     */
    public Connection getConexao() throws SQLException{
        Connection con;
        String urlDB = "jdbc:mysql://" + this.url;
        con = DriverManager.getConnection(urlDB, 
                                this.usuario, this.senha);
        return con;
    }
    
}
