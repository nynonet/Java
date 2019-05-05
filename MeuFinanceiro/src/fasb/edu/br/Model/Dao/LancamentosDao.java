/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fasb.edu.br.Model.Dao;

import fasb.edu.br.Model.Lancamentos;
import fasb.edu.br.Model.Tipo;

import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 *
 * @author andesonjesusdemenezes
 */
public class LancamentosDao implements DaoInterface<Lancamentos> {

    @Override
    public void insert(Lancamentos t) throws SQLException {
        String sql = "INSERT INTO lancamentos (participante, conta, grupo, data, valor, observacao, tipo) VALUES (?,?,?,?,?,?,?)";
        PreparedStatement ps = Conexao.getConexao().prepareStatement(sql);
        ps.setInt(1, t.getParticipante().getId());
        ps.setInt(2, t.getConta().getId());
        ps.setInt(3, t.getGrupo().getId());
        ps.setString(4, "2019-01-01");
        ps.setDouble(5, t.getValor().doubleValue());
        ps.setString(6, t.getObservacao());
        ps.setInt(7, t.getTipo().getId());
        ps.execute();                
    }

    @Override
    public void update(Lancamentos t) throws SQLException {
        String sql = "UPDATE lancamentos SET participante =?, conta=?, grupo=?, data=?, valor=?, observacao=?, tipo=? WHERE id=?";
        PreparedStatement ps = Conexao.getConexao().prepareStatement(sql);
        ps.setInt(1, t.getParticipante().getId());
        ps.setInt(2, t.getConta().getId());
        ps.setInt(3, t.getGrupo().getId());
        ps.setString(4, "2019-01-01");
        ps.setDouble(5, t.getValor().doubleValue());
        ps.setString(6, t.getObservacao());
        ps.setInt(7, t.getTipo().getId());
        ps.setInt(8, t.getId());
        
        ps.executeUpdate();
    }

    @Override
    public void delete(Lancamentos t) throws SQLException {
        String sql = "DELETE FROM lancamentos WHERE id=?";
        PreparedStatement ps = Conexao.getConexao().prepareStatement(sql);
        ps.setInt(1, t.getId());
        ps.executeUpdate();      
    }

    @Override
    public Lancamentos getRow(int id) throws SQLException {
        String sql = "SELECT id, participante, conta, grupo, data, valor, observacao, tipo FROM lancamentos WHERE id=?";
        PreparedStatement ps = Conexao.getConexao().prepareStatement(sql);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        
        Lancamentos lancamentos = new Lancamentos();
        while (rs.next()){
            lancamentos.setId( rs.getInt("id") );
            lancamentos.setConta( new ContaDao().getRow( rs.getInt("conta") ) );
            lancamentos.setGrupo( new GrupoDao().getRow( rs.getInt( "grupo" )) );
            lancamentos.setParticipante( new ParticipanteDao().getRow( rs.getInt("participante")) );
            lancamentos.setData( Calendar.getInstance());
            lancamentos.setValor(new BigDecimal( rs.getDouble("valor") ));
            lancamentos.setObservacao(rs.getString("observacao"));
            lancamentos.setTipo( (rs.getInt("tipo") == 1) ? Tipo.CREDITO : Tipo.DEBITO );                    
        }        
        return lancamentos;
    }

    @Override
    public List<Lancamentos> getRows(String wheres) throws SQLException {
        List<Lancamentos> list = new ArrayList<>();
        String sql = "SELECT id, participante, conta, grupo, data, valor, observacao, tipo FROM lancamentos "+wheres;
        PreparedStatement ps = Conexao.getConexao().prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        
        
        while (rs.next()){
            Lancamentos lancamentos = new Lancamentos();
            lancamentos.setId( rs.getInt("id") );
            lancamentos.setConta( new ContaDao().getRow( rs.getInt("conta") ) );
            lancamentos.setGrupo( new GrupoDao().getRow( rs.getInt( "grupo" )) );
            lancamentos.setParticipante( new ParticipanteDao().getRow( rs.getInt("participante")) );
            lancamentos.setData( Calendar.getInstance());
            lancamentos.setValor(new BigDecimal( rs.getDouble("valor") ));
            lancamentos.setObservacao(rs.getString("observacao"));
            lancamentos.setTipo( (rs.getInt("tipo") == 1) ? Tipo.CREDITO : Tipo.DEBITO );                    
            list.add(lancamentos);
        }        
        
        return list;
        
    }

    @Override
    public List<Lancamentos> getFull() throws SQLException {
        return getRows("");
    }


    
}
