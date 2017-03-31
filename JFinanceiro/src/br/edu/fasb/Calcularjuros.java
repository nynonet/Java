/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.fasb;

/**
 *
 * @author Andeson
 */
public class Calcularjuros {

    private double valor;
    private double taxa;
    private double tempo;
    private TipoDeJuros calculo;

    public Calcularjuros(TipoDeJuros tipo) {
        this.calculo = tipo;
    }

    public double getTotalDevedor() {
        double Total = this.valor;

        if (calculo == TipoDeJuros.COMPOSTO) {
            for (int x = 1; x <= tempo; x++) {
                Total += Total * (taxa / 100);
            }
        } else {
            Total = valor + (valor * (taxa / 100)) * tempo;
        }
        return Total;
    }

    public double getValorJuros() {

        if (calculo == TipoDeJuros.SIMPLES) {
            return (valor * (taxa / 100)) * tempo;
        } else {
            return getTotalDevedor() - (valor);
        }
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public double getTaxa() {
        return taxa;
    }

    public void setTaxa(double taxa) {
        this.taxa = taxa;
    }

    public double getTempo() {
        return tempo;
    }

    public void setTempo(double tempo) {
        this.tempo = tempo;
    }

    public TipoDeJuros getCalculo() {
        return calculo;
    }

    public void setCalculo(TipoDeJuros calculo) {
        this.calculo = calculo;
    }

    public double tratavirgula(String valor) {
        return Double.parseDouble(valor.replace(",", "."));
    }

}
