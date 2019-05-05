/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fasb.edu.br.Controller;

import fasb.edu.br.Model.Dao.GrupoDao;
import fasb.edu.br.Model.Grupo;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author andesonjesusdemenezes
 */
public class GrupoCtrl {

    private String msg;
    private GrupoDao db;

    public GrupoCtrl() {
        this.db = new GrupoDao();
    }

    public boolean isValid(Grupo g) {

        if (g.getNome().trim().length() == 0) {
            this.msg = "Você deve informar o nome do grupo!";
            return false;
        }

        return true;
    }

    public String getMsg() {
        return msg;
    }

    public boolean DBPost(Grupo g) {
        if (!isValid(g)) {
            return false;
        }

        try {
            
            if (g.getId() == 0) {
                //gravando... novo registro 
                db.insert(g);
                this.msg = "Registro inserido com sucesso!";
            } else {
                //gravando... alteração no registro 
                db.update(g);
                this.msg = "Registro atualizado com sucesso!";
            }
        } catch (SQLException e) {
            this.msg = e.getMessage();
            return false;
        }

        return true;
    }
    
    public boolean DBDelete(Grupo g) {
        try {
            db.delete(g);
            this.msg = "Registro deletado com sucesso!";
        } catch (SQLException e) {
            this.msg = e.getMessage();
            return false;
        }

        return true;
    }
    
    public Grupo DBSelectRow( int id ){
        Grupo r = new Grupo();
        try {
            r = db.getRow(id);
            this.msg = "Registro selecionado com sucesso!";
        } catch (SQLException e) {
            this.msg = e.getMessage();
        }
        return  r;
    }
    
    public List<Grupo> DBSelectRows(String where){
        List<Grupo> list = new ArrayList<>();
        try {
            list = db.getRows(where);
            this.msg = "Registros selecionados com sucesso!";
        } catch (SQLException e) {
            this.msg = e.getMessage();
        }
        return list;
    }

    public List<Grupo> DBSelectALL(){
        List<Grupo> list = new ArrayList<>();
        try {
            list = db.getFull();
            this.msg = "Registros selecionados com sucesso!";
        } catch (SQLException e) {
            this.msg = e.getMessage();
        }
        return list;
    }

}
