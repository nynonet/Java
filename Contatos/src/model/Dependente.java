/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 * Classe representativa de uma agenda de contatos os dependentes dele.
 * @author Andeson
 */
public class Dependente {
    private int id; //código sequencial
    private Contato contato; //Relação com contato
    private String nome; //nome do dependente;
    private String telefone; //número do telefone do dependente

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Contato getContato() {
        return contato;
    }

    public void setContato(Contato contato) {
        this.contato = contato;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    
    /**
     * Sobreescrevendo o método toString
     * @return irá devolver sempre que chamar a classe dependente o Nome e o Telefone
     * 
     */
    @Override
    public String toString() {
        return this.nome + "  " + this.telefone;
    }
    
    
    
}
