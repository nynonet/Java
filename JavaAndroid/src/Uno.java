/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Andeson
 */
public class Uno {
    
    private String Motor;
    private String Chassis;
    private String Carcaca;
    private String Estofado;

    public String getMotor() {
        return Motor;
    }

    public void setMotor(String Motor) {
        this.Motor = Motor;
    }

    public String getChassis() {
        return Chassis;
    }

    public void setChassis(String Chassis) {
        this.Chassis = Chassis;
    }

    public String getCarcaca() {
        return Carcaca;
    }

    public void setCarcaca(String Carcaca) {
        this.Carcaca = Carcaca;
    }

    public String getEstofado() {
        return Estofado;
    }

    public void setEstofado(String Estofado) {
        this.Estofado = Estofado;
    }

    @Override
    public String toString() {
        return "Uno " + Motor + " "+ Chassis;
    }
    
}
