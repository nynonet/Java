/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fasb.edu.br.Model.Dao;

import fasb.edu.br.Model.Conta;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author andesonjesusdemenezes
 */
public class ContaDao implements DaoInterface<Conta> {

    @Override
    public void insert(Conta t) throws SQLException {
        String sql = "INSERT INTO contas (nome, banco) VALUES (?,?)";
        PreparedStatement ps = Conexao.getConexao().prepareStatement(sql);
        ps.setString(1, t.getNome().toUpperCase());
        ps.setBoolean(2, t.isBanco());        
        ps.execute();        
    }

    @Override
    public void update(Conta t) throws SQLException {
        String sql = "UPDATE contas SET nome = ?, banco =? WHERE id = ?";
        PreparedStatement ps = Conexao.getConexao().prepareStatement(sql);
        ps.setString(1, t.getNome().toUpperCase());
        ps.setBoolean(2, t.isBanco());        
        ps.setInt(3, t.getId());
        ps.executeUpdate();        
    }

    @Override
    public void delete(Conta t) throws SQLException {
        String sql = "DELETE FROM contas WHERE id=?";
        PreparedStatement ps = Conexao.getConexao().prepareStatement(sql);
        ps.setInt(1, t.getId());
        ps.executeUpdate();      
    }

    @Override
    public Conta getRow(int id) throws SQLException {
        String sql = "SELECT id, nome, banco FROM contas WHERE id=?";
        PreparedStatement ps = Conexao.getConexao().prepareStatement(sql);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        
        Conta conta = new Conta();
        while (rs.next()){
            conta.setId( rs.getInt("id") );
            conta.setNome( rs.getString("nome") );
            conta.setBanco(rs.getBoolean("banco"));
        }        
        return conta;
    }

    @Override
    public List<Conta> getRows(String wheres) throws SQLException {
        List<Conta> list = new ArrayList<>();
        String sql = "SELECT id, nome, banco FROM contas "+ wheres;
        PreparedStatement ps = Conexao.getConexao().prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        
        
        while (rs.next()){
            Conta conta = new Conta();
            conta.setId( rs.getInt("id") );
            conta.setNome( rs.getString("nome") );
            conta.setBanco(rs.getBoolean("banco"));
            list.add(conta);
        }        
        
        return list;
    }

    @Override
    public List<Conta> getFull() throws SQLException {
        return this.getRows("");
    }
    
}
