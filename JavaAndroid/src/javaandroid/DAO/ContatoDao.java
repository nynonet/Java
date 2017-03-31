/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaandroid.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author andeson
 */
public class ContatoDao {
    Connection Conexao;
    
    public ContatoDao( Connection c ) {
        this.Conexao = c;
    }
    
    public void Inserir( Contato contato ) throws Exception {
        String sql = "INSERT INTO contato (nome, telefone) VALUES (?,?)";
        PreparedStatement ps = Conexao.prepareCall(sql);
        ps.setString(1, contato.getNome().toUpperCase());
        ps.setString(2, contato.getTelefone());
        ps.executeUpdate();
    }

    public void Alterar( Contato contato ) throws Exception {
        String sql = "UPDATE contato SET nome = ?, telefone =? WHERE id=?";
        PreparedStatement ps = Conexao.prepareCall(sql);
        ps.setString(1, contato.getNome().toUpperCase());
        ps.setString(2, contato.getTelefone());
        ps.setInt(3, contato.getId());
        ps.executeUpdate();
    }
    
    public void Deletar( Contato contato ) throws Exception {
        String sql = "DELETE FROM contato WHERE id=?";
        PreparedStatement ps = Conexao.prepareCall(sql);
        ps.setInt(1, contato.getId());
        ps.executeUpdate();
    }
    
    public Contato GetContato(int id) throws Exception{
        String sql = "SELECT nome, telefone FROM contato WHERE id=?";
        PreparedStatement ps = Conexao.prepareCall(sql);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        Contato c = new Contato();
        if (rs.next()) {
            c.setId(id);
            c.setNome(rs.getString("nome"));
            c.setTelefone(rs.getString("telefone"));
        }
        return c;
    }

    public List<Contato> GetListaContato(String filtro) throws Exception{
        String sql = "SELECT id,nome, telefone FROM contato "+filtro;
        PreparedStatement ps = Conexao.prepareCall(sql);
        ResultSet rs = ps.executeQuery();
        List<Contato> lista = new ArrayList();
        while (rs.next()) {
            Contato c = new Contato();
            c.setId(rs.getInt("id"));
            c.setNome(rs.getString("nome"));
            c.setTelefone(rs.getString("telefone"));
            
            lista.add(c);
        }
        return lista;
    }
    
}
