/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fasb.edu.br.Model;

import java.io.Serializable;

/**
 *
 * @author andesonjesusdemenezes
 */
public class Grupo implements Serializable, TypeGrid {
    
    private int id;
    private String nome;
    private boolean fixo;

    public Grupo() {
        this.id = 0;
    }

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

    public boolean isFixo() {
        return fixo;
    }

    public void setFixo(boolean fixo) {
        this.fixo = fixo;
    }
    
    public String getValueCol( String colname ){
//        System.out.println("Coluna: "+ colname);
        String value = "";
        if (colname == "nome"){
            value = this.nome;
        }
        
        if (colname == "fixo"){
            value = (this.fixo? "Sim":"Não");
        }
        
        if (colname == "id"){
            value = Integer.toString(this.id);
        }
        return value;
    }
    
    
    
}
