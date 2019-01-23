/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fasb.edu.br.Controller;

import fasb.edu.br.Model.Grupo;

/**
 *
 * @author andesonjesusdemenezes
 */
public class GrupoCtrl {
    private Grupo g;
    private String msg;

    public GrupoCtrl(Grupo g) {
        this.g = g;
    }
    
    public boolean isValid(){
        
        if (g.getNome().trim().length() == 0) {            
            this.msg = "Você deve informar o nome do grupo!";
            return false;
        }
        
        return true;
    }

    public String getMsg() {
        return msg;
    }
    
}
