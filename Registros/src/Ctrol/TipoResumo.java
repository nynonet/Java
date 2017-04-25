/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ctrol;

/**
 *
 * @author Andeson
 */
public enum TipoResumo {
    VL_MIN(1), VL_MAX(1), VL_AVG(1), DT_MIN(2), DT_MAX(2);
    private int tipo;

    private TipoResumo(int tipo) {
        this.tipo = tipo;
    }

    public int gettipo() {
        return tipo;
    }    
    
}
