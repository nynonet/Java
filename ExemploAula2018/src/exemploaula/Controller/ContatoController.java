/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exemploaula.Controller;

import exemploaula.model.Contato;

/**
 * Classe para controller de dados da classe Contato
 * @author macbook
 */
public class ContatoController {
    
    //Objeto Contato que será informado no método construtor
    Contato contato;

    /**
     * Método construtor 
     * @param contato contato que será validado
     */
    public ContatoController(Contato contato) {
        this.contato = contato;
    }
    
    /**
     * Valida se o contato tem os requisitos mínimos para 
     * ser valido.
     * @return 
     */
    public String ValidaContato(){
        
        // valida para saber se o contato está nulo.
        if (this.contato == null) {
            return "Informe um contato!";
        }
        
        // valida se preencheu o nome do contato.
        if (this.contato.getNome().trim().length()==0) {
            return "Você precisa preencher o nome do contato!";
        }
        
        // valida se nome do contato tem mais de 2 caracter
        if (this.contato.getNome().trim().length()<3) {
            return "O nome do contato deve possuir mais de 2 caracter!";
        }
        //retorna OK se tudo estiver valido. 
        return "OK";
    }
    
}
