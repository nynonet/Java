/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Dao.Conexao;
import Dao.ContatoDAO;
import java.sql.Date;
import java.sql.ResultSet;
import java.util.Calendar;
import model.Contato;

/**
 *
 * @author Andeson
 */
public class ContatoCtrl {

    public enum Tipo {
        PRIMEIRO, ANTERIOR, PROXIMO, ULTIMO;
    }

    //variável para receber a conexão ativa com o banco de dados
//    private Conexao conexao;
    //gerencia toda a parte de banco de dados do cadastro de contato 
    ContatoDAO contatoDAO;

    //resultset para gerenciar os dados 
    ResultSet dados;

    private int numRec; //número de registros.

    /**
     * Retorna a lista de dados atualizada do banco de dados.
     */
    public void atualizaDados() {

        try {
            dados = contatoDAO.getRegistros();
            dados.last();
            numRec = dados.getRow();
            dados.first();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    
    /**
     * Navega entre os registros conforme tipo de operaç
     * @param operacao
     * @return 
     */
    public Contato Navegacao(Tipo operacao) {
        boolean nav = false;
        Contato resposta = new Contato();
        try {
            switch (operacao) {
                case ANTERIOR:
                    nav = dados.previous();
                    break;
                case PRIMEIRO:
                    nav = dados.first();
                    break;
                case PROXIMO:
                    nav = dados.next();
                    break;
                case ULTIMO:
                    nav = dados.last();
                    break;
                default: ;
            }

            if (nav != false) {
                resposta.setId(dados.getInt("id"));
                resposta.setEmail(dados.getString("email"));
                resposta.setTelefone(dados.getString("telefone"));
                resposta.setNome(dados.getString("nome"));

                Calendar data = Calendar.getInstance();
                data.setTime(dados.getDate("nascimento"));

                resposta.setNascimento(data);
            }
        } catch (Exception e) {
            //e.printStackTrace();
            resposta.setId(-1);
        }
        
        return resposta;
    }

    /**
     * Modificamos o construtor da classe para passar uma conexão existente.
     *
     * @param conexao hum conexão já estabelecida com o banco de dados.
     */
    public ContatoCtrl(Conexao conexao) {
//        this.conexao = conexao;
        contatoDAO = new ContatoDAO(conexao);
        atualizaDados();
    }

    public String Novo(String nome, String email, String telefone,
            String nascimento) {
        String msg = "";

        if (nome.isEmpty()) {
            msg = "O nome do contato é obrigatório!";
        }
        if (telefone.isEmpty()) {
            msg += "\nO número do telefone é obrigatório!";
        }
        if (nascimento.isEmpty()) {
            msg += "\nInforme a data de nasciemnto!";
        }

        if (msg.length() > 0) {
            return msg;
        }

        Contato c = new Contato();
        c.setNome(nome);
        c.setEmail(email);
        c.setTelefone(telefone);
        Calendar datagrava = Calendar.getInstance();
        datagrava.setTime(Date.valueOf(nascimento));
        c.setNascimento(datagrava);

        try {
            contatoDAO.Inserir(c);
            msg = "OK";
        } catch (Exception e) {
            msg = e.getMessage();
            // e.printStackTrace();
        }

        return msg;
    }
    /**
     * Alterar um cadastro de contato.
     * @param id 
     * @param nome
     * @param email
     * @param telefone
     * @param nascimento
     * @return Ok para sucesso! qualquer outra coisa para falha.
     */
    public String Alterar(String id, String nome, String email, String telefone,
            String nascimento) {
        String msg = "";

        if (id.isEmpty()) {
            msg = "Contato sem id!";
        }
        
        if (nome.isEmpty()) {
            msg += "\nO nome do contato é obrigatório!";
        }
        
        if (telefone.isEmpty()) {
            msg += "\nO número do telefone é obrigatório!";
        }
        
        if (nascimento.isEmpty()) {
            msg += "\nInforme a data de nasciemnto!";
        }

        if (msg.length() > 0) {
            return msg;
        }

        Contato c = new Contato();
        c.setId(Integer.parseInt(id));
        c.setNome(nome);
        c.setEmail(email);
        c.setTelefone(telefone);
        Calendar datagrava = Calendar.getInstance();
        datagrava.setTime(Date.valueOf(nascimento));
        c.setNascimento(datagrava);

        try {
            contatoDAO.Atualizar(c);
            msg = "OK";
        } catch (Exception e) {
            msg = e.getMessage();
            // e.printStackTrace();
        }

        return msg;
    }    

}
