/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fasb.edu.br.Model.Dao;

import fasb.edu.br.Model.Lancamentos;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author andesonjesusdemenezes
 */
public class LancamentosDao implements DaoInterface<Lancamentos> {
//    private int id;
//    private Participante participante;
//    private Conta conta;
//    private Grupo grupo;
//    private Calendar data;
//    private BigDecimal valor;
//    private String observacao;
//    private Tipo tipo;

    @Override
    public void insert(Lancamentos t) throws SQLException {
        String sql = "INSERT INTO participantes (participante, status) VALUES (?,?)";
        PreparedStatement ps = Conexao.getConexao().prepareStatement(sql);
        ps.setString(1, t.getNome().toUpperCase());
        ps.setBoolean(2, t.isStatus());        
        ps.execute();                
    }

    @Override
    public void update(Lancamentos t) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Lancamentos t) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Lancamentos getRow(int id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Lancamentos> getRows(String wheres) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Lancamentos> getFull() throws SQLException {
        return getRows("");
    }


    
}
