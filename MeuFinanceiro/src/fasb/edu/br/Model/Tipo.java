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
public enum Tipo {
    CREDITO(1), DEBITO(2);
    int id;

    private Tipo(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
