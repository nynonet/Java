/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fasb.edu.br.Model.Dao;

import fasb.edu.br.Model.Participante;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author andesonjesusdemenezes
 */
public class ParticipanteDao implements DaoInterface<Participante>{

    @Override
    public void insert(Participante t) throws SQLException {
        String sql = "INSERT INTO participantes (nome, status) VALUES (?,?)";
        PreparedStatement ps = Conexao.getConexao().prepareStatement(sql);
        ps.setString(1, t.getNome().toUpperCase());
        ps.setBoolean(2, t.isStatus());        
        ps.execute();        
    }

    @Override
    public void update(Participante t) throws SQLException {
        String sql = "UPDATE participantes SET nome = ?, status =? WHERE id = ?";
        PreparedStatement ps = Conexao.getConexao().prepareStatement(sql);
        ps.setString(1, t.getNome().toUpperCase());
        ps.setBoolean(2, t.isStatus());        
        ps.setInt(3, t.getId());
        ps.executeUpdate();  
    }

    @Override
    public void delete(Participante t) throws SQLException {
        String sql = "DELETE FROM participantes WHERE id=?";
        PreparedStatement ps = Conexao.getConexao().prepareStatement(sql);
        ps.setInt(1, t.getId());
        ps.executeUpdate();      
    }

    @Override
    public Participante getRow(int id) throws SQLException {
       String sql = "SELECT id, nome, status FROM participantes WHERE id=?";
        PreparedStatement ps = Conexao.getConexao().prepareStatement(sql);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        
        Participante participante = new Participante();
        while (rs.next()){
            participante.setId( rs.getInt("id") );
            participante.setNome( rs.getString("nome") );
            participante.setStatus(rs.getBoolean("status"));
        }        
        return participante;
    }

    @Override
    public List<Participante> getRows(String wheres) throws SQLException {
        List<Participante> list = new ArrayList<>();
        String sql = "SELECT id, nome, status FROM participantes "+ wheres;
        PreparedStatement ps = Conexao.getConexao().prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        
        
        while (rs.next()){
            Participante participante = new Participante();
            participante.setId( rs.getInt("id") );
            participante.setNome( rs.getString("nome") );
            participante.setStatus(rs.getBoolean("status"));
            list.add(participante);
        }        
        
        return list;
    }

    @Override
    public List<Participante> getFull() throws SQLException {
        return this.getRows("");
    }
    
}
