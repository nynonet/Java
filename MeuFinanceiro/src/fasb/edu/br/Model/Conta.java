/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fasb.edu.br.Model;


/**
 *
 * @author andesonjesusdemenezes
 */
public class Conta {
    private int id;
    private String nome;
    private boolean banco;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public boolean isBanco() {
        return banco;
    }

    public void setBanco(boolean banco) {
        this.banco = banco;
    }
    
    
}
