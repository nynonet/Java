/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exemploaula.model.dao;

import exemploaula.model.Contato;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author macbook
 */
public class ContatoDao implements InterDao<Contato> {

    private ConexaoDB con;

    /**
     * Modificando o método construtor para receber uma conexão do banco de
     * dados
     *
     * @param con
     */
    public ContatoDao(ConexaoDB con) {
        this.con = con;
    }

    @Override
    public void Inserir(Contato objT) throws SQLException {
        String sql = "INSERT INTO contatos (nome) values (?)";
        PreparedStatement ps = con.getConexao().prepareStatement(sql);
        ps.setString(1, objT.getNome());
        ps.execute();
    }

    @Override
    public void Gravar(Contato objT) throws SQLException {
        String sql = "UPDATE contatos SET nome = ? WHERE id=?";
        PreparedStatement ps = con.getConexao().prepareStatement(sql);
        ps.setString(1, objT.getNome());
        ps.setInt(2, objT.getId());
        ps.executeUpdate();
    }

    @Override
    public void Deletar(Contato objT) throws SQLException {
        String sql = "DELETE FROM contatos WHERE id=?";
        PreparedStatement ps = con.getConexao().prepareStatement(sql);
        ps.setInt(1, objT.getId());
        ps.execute();
    }

    @Override
    public Contato getRegistro(int id) throws SQLException {
        String sql = "SELECT nome FROM contatos WHERE id=?";
        PreparedStatement ps = con.getConexao().
                prepareStatement(sql);
        ps.setInt(1, id);

        ResultSet rs = ps.executeQuery();
        Contato novo = new Contato();
        while (rs.next()) {
            novo.setId(id);
            novo.setNome(rs.getString("nome"));
        }
        return novo;
    }

    @Override
    public List<Contato> getRegistros(String condicao) throws SQLException {
        String sql = "SELECT id, nome FROM contatos " + condicao ;
        PreparedStatement ps = con.getConexao().
                prepareStatement(sql);

        ResultSet rs = ps.executeQuery();
        List<Contato> lista = new ArrayList<>();
        while (rs.next()) {
            Contato novo = new Contato();
            novo.setId( rs.getInt("id") );
            novo.setNome( rs.getString("nome") );
            lista.add(novo);
        }
        return lista;
    }

}
