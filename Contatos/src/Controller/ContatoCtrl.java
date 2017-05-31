/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Dao.Conexao;
import Dao.ContatoDAO;
import java.util.Calendar;
import model.Contato;

/**
 *
 * @author Andeson
 */
public class ContatoCtrl {

    //variável para receber a conexão ativa com o banco de dados
    private Conexao conexao;

    /**
     * Modificamos o construtor da classe para passar uma conexão existente.
     *
     * @param conexao hum conexão já estabelecida com o banco de dados.
     */
    public ContatoCtrl(Conexao conexao) {
        this.conexao = conexao;
    }

    //gerencia toda a parte de banco de dados do cadastro de contato 
    ContatoDAO contatoDAO = new ContatoDAO(conexao);

    public String Novo(String nome, String email, String telefone,
            Calendar nascimento) {
        String msg = "OK";
        
        if (nome.isEmpty()) {
            msg = "O nome do contato é obrigatório!";
//            return msg;
        }
        if (telefone.isEmpty()) {
            msg += "\nO número do telefone é obrigatório!"; 
        }
        
        if (msg.length()>2) {
            return msg;
        }
        
        Contato c = new Contato();
        c.setNome(nome);
        c.setEmail(email);
        c.setTelefone(telefone);
//        c.setNascimento(nascimento);

        try {
            contatoDAO.Inserir(c);
        } catch (Exception e) {
            msg = e.getMessage();
            e.printStackTrace();
        }

        return msg;
    }

}
