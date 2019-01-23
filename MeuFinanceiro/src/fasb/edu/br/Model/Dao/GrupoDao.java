/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fasb.edu.br.Model.Dao;

import fasb.edu.br.Model.Grupo;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author andesonjesusdemenezes
 */
public class GrupoDao implements DaoInterface<Grupo>{
   

    @Override
    public void insert(Grupo t) throws SQLException {
        String sql = "INSERT INTO grupos (nome, fixo) VALUES (?,?)";
        PreparedStatement ps = Conexao.getConexao().prepareStatement(sql);
        ps.setString(1, t.getNome().toUpperCase());
        ps.setBoolean(2, t.isFixo());        
        ps.execute();        
    }

    @Override
    public void update(Grupo t) throws SQLException {
        String sql = "UPDATE grupos SET nome = ?, fixo =? WHERE id = ?";
        PreparedStatement ps = Conexao.getConexao().prepareStatement(sql);
        ps.setString(1, t.getNome().toUpperCase());
        ps.setBoolean(2, t.isFixo());        
        ps.setInt(3, t.getId());
        ps.executeUpdate();        
    }

    @Override
    public void delete(Grupo t) throws SQLException {
        String sql = "DELETE FROM grupos WHERE id=?";
        PreparedStatement ps = Conexao.getConexao().prepareStatement(sql);
        ps.setInt(1, t.getId());
        ps.executeUpdate();        
    }

    @Override
    public Grupo getRow(int id) throws SQLException {
        String sql = "SELECT id, nome, fixo FROM grupos WHERE id=?";
        PreparedStatement ps = Conexao.getConexao().prepareStatement(sql);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        
        Grupo grupo = new Grupo();
        while (rs.next()){
            grupo.setId( rs.getInt("id") );
            grupo.setNome( rs.getString("nome") );
            grupo.setFixo( rs.getBoolean("fixo"));
        }        
        return grupo;
    }

    @Override
    public List<Grupo> getRows(String wheres) throws SQLException {
        List<Grupo> list = new ArrayList<>();
        String sql = "SELECT id, nome, fixo FROM grupos "+ wheres;
        PreparedStatement ps = Conexao.getConexao().prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        
        
        while (rs.next()){
            Grupo grupo = new Grupo();
            grupo.setId( rs.getInt("id") );
            grupo.setNome( rs.getString("nome") );
            grupo.setFixo( rs.getBoolean("fixo"));
            list.add(grupo);
        }        
        
        return list;
    }

    @Override
    public List<Grupo> getFull() throws SQLException {
        return getRows("");
    }
    
    
    
}
