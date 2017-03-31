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
public class Tabela {
    
    private int tempo;
    private double prestacao;
    private double juros;
    private double amortizacao;
    private double saldoDevedor;

    /**
     * método construtor padrão
     */
    public Tabela() {
    }
    
    /**
     * método construtor para tempo ZERO (0) 
     * onde será informado o saldo devedor inicial.
     * @param saldodevedor 
     */
    public Tabela(double saldodevedor) {
        this.tempo = 0;
        this.saldoDevedor = saldodevedor;
        this.juros = 0;
        this.prestacao = 0;
        this.amortizacao = 0;
    }
    
    /**
     * método construtor para o sistema SAC
     * @param tempo indicação do período
     * @param amortizacao valor amortizado
     * @param juros valor do juros
     * @param saldodevedor Saldo Devedor
     */
    public Tabela( int tempo, double amortizacao,
            double juros, double saldodevedor ){
        this.tempo = tempo;
        this.amortizacao = amortizacao;
        this.juros = juros;
        this.saldoDevedor = saldodevedor;
        this.prestacao = (juros+amortizacao);
    }
    
    /**
     * Método construtor para o Sistema PRICE/GAUSS
     * @param prestacao
     * @param tempo
     * @param juros
     * @param saldodevedor 
     */
    public Tabela(double prestacao, int tempo, 
            double juros, double saldodevedor ) {
        this.tempo = tempo;
        this.amortizacao = (prestacao - juros);
        this.juros = juros;
        this.saldoDevedor = saldodevedor;
        this.prestacao = prestacao;
        
    }

    public int getTempo() {
        return tempo ;
    }

    public void setTempo(int tempo) {
        this.tempo = tempo;
    }

    public double getPrestacao() {
        return valorTratado(prestacao);
    }

    public void setPrestacao(double prestacao) {
        this.prestacao = prestacao;
    }

    public double getJuros() {
        return valorTratado(juros);
    }

    public void setJuros(double juros) {
        this.juros = juros;
    }

    public double getAmortizacao() {
        return valorTratado(amortizacao);
    }

    public void setAmortizacao(double amortizacao) {
        this.amortizacao = amortizacao;
    }

    public double getSaldoDevedor() {
        return valorTratado( Math.abs(saldoDevedor) );
    }

    public void setSaldoDevedor(double saldoDevedor) {
        this.saldoDevedor = saldoDevedor;
    }

    @Override
    public String toString() {
        return " |" + getTempo() + " | " + getPrestacao() +
               " | " + getJuros() + " | "+ getAmortizacao() +
               " | " + getSaldoDevedor() + "|\n";
    }
    
    /**
     * Função para realizar o tratamento de casas
     * decimais.
     * @param valor valor que será passado
     * @return retorna o valor com 2 casa decimais
     */
    private double valorTratado(double valor) {
        String sValor = String.format("%.2f", valor);
        return Double.parseDouble(sValor.replace(",", "."));
    }
    

    
}
