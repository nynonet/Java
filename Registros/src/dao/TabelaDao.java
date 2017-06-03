/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import Model.Tabela;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 *
 * @author Andeson
 */
public class TabelaDao implements Dao<Tabela> {

    Connection con;

    public TabelaDao(Connection con) {
        this.con = con;
    }

    @Override
    public void Inserir(Tabela obj) {
        String sql = "INSERT INTO tabela (nome, valor,ativo, data) "
                + "VALUES (?,?,?,?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, obj.getNome());
            ps.setDouble(2, obj.getValor());
            ps.setBoolean(3, obj.isAtivo());
            Date d = new Date( obj.getData().getInstance().getTime().getTime() );
            System.out.println("Antes da Hora D "+ d.toString());
            ps.setDate(4, d);
            
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void Atualizar(Tabela obj) {
        String sql = "UPDATE tabela SET nome =?, valor =?, ativo =?, data=? "
                + " WHERE id = ?";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, obj.getNome());
            ps.setDouble(2, obj.getValor());
            ps.setBoolean(3, obj.isAtivo());
            ps.setDate(4, new Date( obj.getData().getInstance().getTimeInMillis() ));
            ps.setInt(5, obj.getId());

            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void Deletar(Tabela obj) {
        String sql = "DELETE FROM tabela WHERE id = ?";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, obj.getId());

            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public List<Tabela> getRegistro() {
        String SQL = "SELECT id, nome, valor, ativo, data FROM tabela";
        List<Tabela> retorno = new ArrayList<>();
        try {
            PreparedStatement ps = con.prepareStatement(SQL);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Tabela t = new Tabela();
                t.setAtivo(rs.getBoolean("ativo"));
                t.setId(rs.getInt("id"));
                t.setNome(rs.getString("nome"));
                t.setValor(rs.getDouble("valor"));
                
                Calendar d = Calendar.getInstance();
                d.setTime( rs.getDate("data") );                
                t.setData(d);

                retorno.add(t);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return retorno;
    }

    @Override
    public Tabela getRegistro(int Id) {
        String SQL = "SELECT nome, valor, ativo, data FROM tabela WHERE id=?";
        Tabela retorno = new Tabela();
        try {
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setInt(1, Id);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                retorno.setAtivo(rs.getBoolean("ativo"));
                retorno.setId(rs.getInt("id"));
                retorno.setNome(rs.getString("nome"));
                retorno.setValor(rs.getDouble("valor"));
                Calendar d = Calendar.getInstance();
                d.setTime( rs.getDate("data") );                
                retorno.setData(d);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return retorno;
    }
    
    public Object getValor( String campo ) {
        String SQL = "SELECT "+campo+" FROM tabela";
        Object retorno = null;
        try {
            PreparedStatement ps = con.prepareStatement(SQL);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                retorno = rs.getObject(1);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return retorno;
    }    

}
