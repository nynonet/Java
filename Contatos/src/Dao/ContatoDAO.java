/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import model.Contato;

/**
 *
 * @author Andeson
 */
public class ContatoDAO implements ModeloDAO<Contato> {

    private Conexao conexao;

    public ContatoDAO(Conexao conexao) {
        this.conexao = conexao;
    }

    @Override
    public void Inserir(Contato objeto) throws Exception {
        String SQL = "INSERT INTO contato (nome, telefone, email, nascimento) "
                + "VALUES (?, ?, ? ,?)";
        PreparedStatement ps = conexao.getConexao().prepareStatement(SQL);
        ps.setString(1, objeto.getNome());
        ps.setString(2, objeto.getTelefone());
        ps.setString(3, objeto.getEmail());
//        Date dataInsert = new Date(objeto.getNascimento().getInstance().getTimeInMillis());
//        ps.setDate(4, dataInsert);
        ps.setDate(4, new Date(objeto.getNascimento().getInstance().getTimeInMillis()));
        int qtd_registros = ps.executeUpdate();

        System.out.println("Quantidade de registro inserido: " + qtd_registros);

    }

    @Override
    public void Atualizar(Contato objeto) throws Exception {
        String SQL = "UPDATE contato SET nome=?, telefone=?, email=?, nascimento=? "
                + "WHERE ID=?";
        PreparedStatement ps = conexao.getConexao().prepareStatement(SQL);
        ps.setString(1, objeto.getNome());
        ps.setString(2, objeto.getTelefone());
        ps.setString(3, objeto.getEmail());
        ps.setDate(4, new Date(objeto.getNascimento().getInstance().getTimeInMillis()));
        ps.setInt(5, objeto.getId());

        int qtd_registros = ps.executeUpdate();

        System.out.println("Quantidade de registro atualizado: " + qtd_registros);
    }

    @Override
    public void Excluir(Contato objeto) throws Exception {
        String SQL = "DELETE FROM contato WHERE id=?";
        PreparedStatement ps = conexao.getConexao().prepareStatement(SQL);
        ps.setInt(1, objeto.getId());

        int qtd_registros = ps.executeUpdate();

        System.out.println("Quantidade de registro deletado: " + qtd_registros);
    }

    @Override
    public List<Contato> getRegistros(String filtro) throws Exception {
        List<Contato> retorno = new ArrayList<>();
        String SQL = "SELECT id,nome,telefone,email,nascimento "
                + "FROM contatos " + filtro;
        PreparedStatement ps = conexao.getConexao().prepareStatement(SQL);

        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            Contato c = new Contato();
            c.setId(rs.getInt("id"));
            c.setEmail(rs.getString("email"));
            c.setTelefone(rs.getString("telefone"));
            c.setNome(rs.getString("nome"));

            Calendar data = Calendar.getInstance();
            data.setTime(rs.getDate("nascimento"));

            c.setNascimento(data);

            retorno.add(c);
        }

        return retorno;
    }

    @Override
    public Contato getRegistro(int id) throws Exception {
        String SQL = "SELECT id, nome, telefone, email, nascimento "
                + "FROM contatos WHERE id = ?";
        PreparedStatement ps = conexao.getConexao().prepareStatement(SQL);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        Contato c = new Contato();
        while (rs.next()) {
            c.setId(rs.getInt("id"));
            c.setEmail(rs.getString("email"));
            c.setTelefone(rs.getString("telefone"));
            c.setNome(rs.getString("nome"));

            Calendar data = Calendar.getInstance();
            data.setTime(rs.getDate("nascimento"));

            c.setNascimento(data);

        }
        return c;
    }

}
