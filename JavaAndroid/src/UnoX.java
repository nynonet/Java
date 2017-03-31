/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Andeson
 */
public class UnoX extends Uno{
    private boolean ArCondicionado;
    private boolean VidroEletrico;
    private boolean Alarme;

    public boolean isArCondicionado() {
        return ArCondicionado;
    }

    public void setArCondicionado(boolean ArCondicionado) {
        this.ArCondicionado = ArCondicionado;
    }

    public boolean isVidroEletrico() {
        return VidroEletrico;
    }

    public void setVidroEletrico(boolean VidroEletrico) {
        this.VidroEletrico = VidroEletrico;
    }

    public boolean isAlarme() {
        return Alarme;
    }

    public void setAlarme(boolean Alarme) {
        this.Alarme = Alarme;
    }
}
