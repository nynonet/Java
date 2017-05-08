/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.Dependente;

/**
 *
 * @author Andeson
 */
public class DependenteDAO implements ModeloDAO<Dependente>{

    private Conexao conexao;

    public DependenteDAO(Conexao conexao) {
        this.conexao = conexao;
    }    

    @Override
    public void Inserir(Dependente objeto) throws Exception {        
        String SQL = "INSERT INTO dependente (id_contato, nome, telefone) "
                + "VALUES (?, ?, ?)";
        PreparedStatement ps = conexao.getConexao().prepareStatement(SQL);
        ps.setInt(1, objeto.getContato().getId());
        ps.setString(2, objeto.getNome());
        ps.setString(3, objeto.getTelefone());
        int qtd_registros = ps.executeUpdate();

        System.out.println("Quantidade de registro inserido: " + qtd_registros);
    }

    @Override
    public void Atualizar(Dependente objeto) throws Exception {
        String SQL = "UPDATE dependente SET nome=?, telefone=? "
                    + "WHERE id = ?";
        PreparedStatement ps = conexao.getConexao().prepareStatement(SQL);
        ps.setString(1, objeto.getNome());
        ps.setString(2, objeto.getTelefone());
        ps.setInt(3, objeto.getContato().getId());
        int qtd_registros = ps.executeUpdate();

        System.out.println("Quantidade de registro atualizado: " + qtd_registros);        
    }

    @Override
    public void Excluir(Dependente objeto) throws Exception {
        String SQL = "DELETE FROM dependente WHERE id = ?";
        PreparedStatement ps = conexao.getConexao().prepareStatement(SQL);
        ps.setInt(1, objeto.getContato().getId());
        int qtd_registros = ps.executeUpdate();

        System.out.println("Quantidade de registro atualizado: " + qtd_registros);        
    }

    @Override
    public List<Dependente> getRegistros(String filtro) throws Exception {
        List<Dependente> retorno = new ArrayList<>();
        String SQL = "SELECT id, id_contato, nome, telefone "
                + "FROM dependente " + filtro;
        PreparedStatement ps = conexao.getConexao().prepareStatement(SQL);

        ResultSet rs = ps.executeQuery();
        
        ContatoDAO c = new ContatoDAO(conexao);

        while (rs.next()) {
            Dependente d = new Dependente();
            d.setId(rs.getInt("id"));
            d.setTelefone(rs.getString("telefone"));
            d.setNome(rs.getString("nome"));
            
            d.setContato( c.getRegistro(rs.getInt("id_contato") ) );

            retorno.add(d);
        }

        return retorno;
        
    }

    @Override
    public Dependente getRegistro(int id) throws Exception {
        String SQL = "SELECT id, id_contato, nome, telefone "
                + "FROM dependente WHERE id=?";
        PreparedStatement ps = conexao.getConexao().prepareStatement(SQL);

        ResultSet rs = ps.executeQuery();
        
        //cria uma conexão com contato. 
        ContatoDAO c = new ContatoDAO(conexao);
        
        Dependente retorno = new Dependente();

        while (rs.next()) {
            
            retorno.setId(rs.getInt("id"));
            retorno.setTelefone(rs.getString("telefone"));
            retorno.setNome(rs.getString("nome"));
            //seta um objeto do tipo contato 
            retorno.setContato( c.getRegistro(rs.getInt("id_contato") ) );         
        }

        return retorno;        
    }
    
}
