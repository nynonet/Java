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
 * @author Andeson
 */
public class ParenteDao {

    Connection Conexao;

    public ParenteDao(Connection c) {
        this.Conexao = c;
    }

    public void Inserir(Parente parente) throws Exception {
        String sql = "INSERT INTO parente (nome, contato) VALUES (?,?)";
        PreparedStatement ps = Conexao.prepareCall(sql);
        ps.setString(1, parente.getNome().toUpperCase());
        ps.setInt(2, parente.getContato().getId());
        ps.executeUpdate();
    }

    public void Alterar(Parente parente) throws Exception {
        String sql = "UPDATE parente SET nome = ?, contato =? WHERE id=?";
        PreparedStatement ps = Conexao.prepareCall(sql);
        ps.setString(1, parente.getNome().toUpperCase());
        ps.setInt(2, parente.getContato().getId());
        ps.setInt(3, parente.getId());
        ps.executeUpdate();
    }

    public void Deletar(Parente parente) throws Exception {
        String sql = "DELETE FROM parente WHERE id=?";
        PreparedStatement ps = Conexao.prepareCall(sql);
        ps.setInt(1, parente.getId());
        ps.executeUpdate();
    }

    public Parente GetParente(int id) throws Exception {
        String sql = "SELECT nome, contato FROM parente WHERE id=?";
        PreparedStatement ps = Conexao.prepareCall(sql);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        Parente c = new Parente();
        if (rs.next()) {
            c.setId(id);
            c.setNome(rs.getString("nome"));

            ContatoDao contato = new ContatoDao(Conexao);
            c.setContato(contato.GetContato(rs.getInt("contato")));

        }
        return c;
    }

    public List<Parente> GetListaParentes(String filtro) throws Exception {
        String sql = "SELECT id, nome, contato FROM parente " + filtro;
        PreparedStatement ps = Conexao.prepareCall(sql);
        ResultSet rs = ps.executeQuery();
        List<Parente> lista = new ArrayList();

        ContatoDao contato = new ContatoDao(Conexao);

        while (rs.next()) {
            Parente c = new Parente();
            c.setId(rs.getInt("id"));
            c.setNome(rs.getString("nome"));

            c.setContato(contato.GetContato(rs.getInt("contato")));

            lista.add(c);
        }

        return lista;
    }

    public List<Parente> GetListaMeusParentes(Contato contato) throws Exception {
        String sql = "SELECT id, nome, contato FROM parente where contato = ?";
        PreparedStatement ps = Conexao.prepareCall(sql);
        ps.setInt(1, contato.getId());
        ResultSet rs = ps.executeQuery();
        List<Parente> lista = new ArrayList();
    
        while (rs.next()) {
            Parente c = new Parente();
            c.setId(rs.getInt("id"));
            c.setNome(rs.getString("nome"));
            c.setContato(contato);

            lista.add(c);
        }

        return lista;
    }
}
