/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.fasb.dao;

import br.edu.fasb.model.Contato;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author andesonjesusdemenezes
 */
public class ContatoDao {

    private Connection db;
    private boolean conexaoOk;

    private String mensagem;

    public ContatoDao() {
        this.db = ConexaoDB.getConexao();
        this.conexaoOk = (this.db != null);
        
        createTable();
    }

    public void gravar(Contato c) throws SQLException {
        String sql;
        boolean eUpdate;

        if (!this.conexaoOk) {
            this.mensagem = "Sem conexão com o banco de dados!\nComando não executado.";
            return;
        }

        if (c.getId() == -1) {
            //inserindo um registro 
            sql = "INSERT INTO contatos (nome, email, telefone) VALUES (?,?,?)";
            eUpdate = false;
        } else {
            //alrando um registros  
            sql = "UPDATE contatos SET nome=? , email=?, telefone=? WHERE id =?";
            eUpdate = true;
        }

        PreparedStatement ps = db.prepareStatement(sql);
        ps.setString(1, c.getNome());
        ps.setString(2, c.getEmail());
        ps.setString(3, c.getTelefone());

        if (eUpdate) {
            ps.setInt(4, c.getId());
            int q = ps.executeUpdate();
            this.mensagem = "Foram atualizado " + q + " registros";
        } else {
            boolean ok = ps.execute();
            this.mensagem = "Registro inserido com sucesso!";
        }

    }

    public void deletar(Contato c) throws SQLException {
        String sql = "DELETE FROM contatos WHERE id = ?";

        if (!this.conexaoOk) {
            this.mensagem = "Sem conexão com o banco de dados!\nComando não executado.";
            return;
        }

        PreparedStatement ps = db.prepareStatement(sql);
        ps.setInt(1, c.getId());
        System.out.println("id = "+ c.getId());
        int q = ps.executeUpdate();
        this.mensagem = "Foram removidos " + q + " registros";
    }

    public Contato getContato(int id) throws SQLException {
        String sql = "SELECT nome, email, telefone FROM contatos WHERE id=?";

        if (!this.conexaoOk) {
            this.mensagem = "Sem conexão com o banco de dados!\nComando não executado.";
            return null;
        }

        PreparedStatement ps = db.prepareStatement(sql);
        ps.setInt(1, id);

        ResultSet rs = ps.executeQuery();

        this.mensagem = "Registro não encontrado!";
        Contato retorno = new Contato();

        while (rs.next()) {
            retorno.setId(id);
            retorno.setNome(rs.getString("nome"));
            retorno.setEmail(rs.getString("email"));
            retorno.setTelefone(rs.getString("telefone"));

            this.mensagem = "Registro encontrado!";
        }

        return retorno;
    }

    public List<Contato> getContatos(String filtro) throws SQLException {
        String sql = "SELECT id, nome, email, telefone FROM contatos " + filtro;

        if (!this.conexaoOk) {
            this.mensagem = "Sem conexão com o banco de dados!\nComando não executado.";
            return null;
        }

        PreparedStatement ps = db.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();

        this.mensagem = "Registro não encontrado!";
        List<Contato> retorno = new ArrayList<>();
        while (rs.next()) {
            Contato c = new Contato();
            c.setId(rs.getInt("id"));
            c.setNome(rs.getString("nome"));
            c.setEmail(rs.getString("email"));
            c.setTelefone(rs.getString("telefone"));

            retorno.add(c);
            this.mensagem = "Registro(s) encontrado(s)!";
        }

        return retorno;
    }

    public String getMensagem() {
        return this.mensagem;
    }

    private void createTable() {
        String sql = "CREATE TABLE contatos (id integer primary key autoincrement, "
                + "nome varchar(120) not null,"
                + "email varchar(120),"
                + "telefone varchar(20) not null)";
        try {
            db.prepareStatement(sql).execute();
        } catch (SQLException e) {
           if (e.getErrorCode() != 1){
               e.printStackTrace();
           }
        }

    }

}
