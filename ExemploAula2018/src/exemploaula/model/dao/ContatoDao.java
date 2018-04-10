/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exemploaula.model.dao;

import exemploaula.model.Contato;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author macbook
 */
public class ContatoDao implements InterDao<Contato> {
    
    private ConexaoDB con;
    
    /**
     * Modificando o método construtor para
     * receber uma conexão do banco de dados
     * @param con 
     */
    public ContatoDao(ConexaoDB con) {
        this.con = con;
    }

    @Override
    public void Inserir(Contato objT) throws SQLException {
        String sql = "INSERT INTO contato (nome) values (?)";
        PreparedStatement ps = con.getConexao().prepareStatement(sql);
        ps.setString( 1, objT.getNome() );
        ps.execute();
    }

    @Override
    public void Gravar(Contato objT) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void Deletar(Contato objT) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Contato getRegistro(int id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Contato> getRegistros(String condicao) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
