/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sabadao;

/**
 *
 * @author Andeson
 */
public class Animal {

    private boolean racional;
    private Cabeca cabeca;
    private Corpo corpo;
    private String sangue;

    public Animal() {
        corpo = new Corpo();
        cabeca = new Cabeca();
    }

    void Comer() {
    }

    void Mover() {
    }

    void Descanca() {
    }

    /**
     * @return the racional
     */
    public boolean isRacional() {
        return racional;
    }

    /**
     * @param racional the racional to set
     */
    public void setRacional(boolean racional) {
        this.racional = racional;
    }

    /**
     * @return the cabeca
     */
    public Cabeca getCabeca() {
        return cabeca;
    }

    /**
     * @param cabeca the cabeca to set
     */
    public void setCabeca(Cabeca cabeca) {
        this.cabeca = cabeca;
    }

    /**
     * @return the corpo
     */
    public Corpo getCorpo() {
        return corpo;
    }

    /**
     * @param corpo the corpo to set
     */
    public void setCorpo(Corpo corpo) {
        this.corpo = corpo;
    }

    /**
     * @return the sangue
     */
    public String getSangue() {
        return sangue;
    }

    /**
     * @param sangue the sangue to set
     */
    public void setSangue(String sangue) {
        this.sangue = sangue;
    }

}
