/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import model.Contato;

/**
 *
 * @author Andeson
 */
public class ContatoDAO implements ModeloDAO<Contato>{
    
    private Conexao conexao;

    public ContatoDAO(Conexao conexao) {
        this.conexao = conexao;
    }

    @Override
    public void Inserir(Contato objeto) throws Exception {
        String SQL = "INSERT INTO contato (nome, telefone, email, nascimento) "
                + "VALUES (?, ?, ? ,?)"; 
        PreparedStatement ps = conexao.getConexao().prepareStatement(SQL);
        ps.setString(1, objeto.getNome() );
        ps.setString(2, objeto.getTelefone() );
        ps.setString(3, objeto.getEmail() );    
//        Date dataInsert = new Date(objeto.getNascimento().getInstance().getTimeInMillis());
//        ps.setDate(4, dataInsert);
        ps.setDate(4, new Date( objeto.getNascimento().getInstance().getTimeInMillis() ));
        int qtd_registros = ps.executeUpdate();
        
        System.out.println("Quantidade de registro inserido: "+ qtd_registros);
        
    }

    @Override
    public void Atualizar(Contato objeto) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void Excluir(Contato objeto) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Contato> getRegistros(String filtro) throws Exception {
           List<Contato> retorno= new ArrayList<>();
           String SQL = "SELECT id,nome,telefone,email,nascimento "
                   + "FROM contatos "+ filtro;
           
           return retorno;
    }

    @Override
    public Contato getRegistro(int id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
