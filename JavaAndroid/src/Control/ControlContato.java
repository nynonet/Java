/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javaandroid.DAO.Conexao;
import javaandroid.DAO.Contato;
import javaandroid.DAO.ContatoDao;
import javaandroid.DAO.Parente;
import javaandroid.DAO.ParenteDao;
import javaandroid.DAO.TabDependentes;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Andeson
 */
public class ControlContato {

    public enum Move {
        PROXIMO, ANTERIOR, PRIMERIO, ULTIMO;
    }

    private ContatoDao dados;
    private ParenteDao parentes;
    private Conexao conexao = new Conexao();
    private ResultSet lista;
    private int qtd_record = 0;
    private TabDependentes tabDependentes;

    public ControlContato() {
        dados = new ContatoDao(conexao.GetConexao());
        parentes = new ParenteDao(conexao.GetConexao());
    }

    public void Inserir(String nome, String telefone) {
        Contato c = new Contato();
        c.setNome(nome);
        c.setTelefone(telefone);
        try {
            dados.Inserir(c);
            System.out.println("inserido!");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        //AtualizaLista();     
    }

    public void Atualizar(String id, String nome, String telefone) {
        Contato c = new Contato();
        c.setId(Integer.valueOf(id));
        c.setNome(nome);
        c.setTelefone(telefone);
        try {
            dados.Alterar(c);
            System.out.println("atualizado!");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        //AtualizaLista();     
    }

    public void AtualizaLista() {
        lista = dados.GetListaContatos(); //pega a nova lista de dados. 

        try {
            lista.last();
            qtd_record = lista.getRow();
            lista.first();
        } catch (Exception e) {
            qtd_record = 0;
            e.printStackTrace();
        }

    }

    public Contato Navegar(Move move) {
        Contato t = new Contato();
        t.setId(-1);
        boolean ler = false;

        try {
            switch (move) {
                case PRIMERIO:
                    ler = lista.first();
                    break;
                case ANTERIOR:
                    ler = lista.previous();
                    break;
                case PROXIMO:
                    ler = lista.next();
                    break;
                case ULTIMO:
                    ler = lista.last();
                    break;
            }
            if (ler) {
                t.setId(lista.getInt("id"));
                t.setNome(lista.getString("nome"));
                t.setTelefone(lista.getString("telefone"));
            }
        } catch (Exception e) {
            e.printStackTrace();

        }
        return t;
    }
    
    public int numeroRegistros () {
        return qtd_record;
    }
    
    public AbstractTableModel dependentes(Contato c) {
        TabDependentes retorno = null;
        
        try {
            retorno = new TabDependentes(parentes.GetListaMeusParentes(c));
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
        
        return retorno;
    }
    
    public void InsertParente( Contato c, String nome ) {
        Parente p = new Parente();
        p.setContato(c);
        p.setNome(nome);       
        try {
            parentes.Inserir(p);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void DeletaParente( Parente p ) {
        try {
            parentes.Deletar(p);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
