/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.fasb;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Andeson
 */
public class CalculaEmprestimo {

    private double valor_emprestimo;
    private double taxa_juros;
    private int duracao;
    private Sistemas sistema;
    
    private double total_prestacao;
    private double total_juros;
    private double total_amortizacao;

    public void setValor_emprestimo(double valor_emprestimo) {
        this.valor_emprestimo = valor_emprestimo;
    }

    public void setTaxa_juros(double taxa_juros) {
        this.taxa_juros = taxa_juros;
    }

    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }

    public void setSistema(Sistemas sistema) {
        this.sistema = sistema;
    }

    /**
     * Essa método vai calcular o juros conforme sua base de calculo, que será
     * passada por parâmetro.
     *
     * @param base_calculo
     * @return
     */
    private double getValorJuros(double base_calculo) {
        Calcularjuros j = new Calcularjuros(TipoDeJuros.SIMPLES);

        j.setTaxa(this.taxa_juros);
        j.setTempo(1);
        j.setValor(base_calculo);

        return j.getValorJuros();
    }

    /**
     * Esse método vai calcular o valor da amortização
     *
     * @return
     */
    private double getAmortizacao() {
        return this.valor_emprestimo / this.duracao;
    }

    /**
     * Calcula o valor da prestação do sistema PRICE
     *
     * @param valor_juros valor do juros calculado
     * @param tempo valor da parcela atual
     * @return
     */
    private double getPrestacao(double valor_juros, int tempo) {

        double baseTaxa = (1 + (this.taxa_juros / 100));

        double basepotencia = Math.pow(baseTaxa, (this.duracao - tempo));
        double baseFator = 1 - (1 / basepotencia);

        return valor_juros / baseFator;
    }
    
    /**
     * Calcular o valor da prestação do Sistema Gauss
     * @return retorna o valor da prestação
     */
    private double getPrestacao(){
        double taxa  = (this.taxa_juros/100) ;
        double base1 = ( this.valor_emprestimo * ( taxa * this.duracao ) ) + this.valor_emprestimo; 
        double base2 = (((taxa * (this.duracao-1))/2)+1)* this.duracao;
        
        return base1/base2;
    }
    
    private double getIndiceGauss(double prestacao) {
        double base1 = (prestacao*this.duracao)-this.valor_emprestimo;
        double base2 = (this.duracao+1)*(this.duracao/2);
        return base1/base2;
    }

    /**
     * Método que irá calcular e devolver a lista com os resultados de cada
     * parcela do sistema de amortização.
     *
     * @return
     */
    public List<Tabela> getResultado() {
        
        //zerando os totalizadores temporário. 
        this.total_amortizacao = 0;
        this.total_juros = 0;
        this.total_prestacao = 0;

        List<Tabela> tab = new ArrayList();

        /* primeiro exemplo método consrtutor padrão
        Tabela reg = new Tabela();
        reg.setAmortizacao(0);
        reg.setJuros(0);
        reg.setPrestacao(0);
        reg.setSaldoDevedor(this.valor_emprestimo);
        reg.setTempo(0);
         */
        Tabela reg = new Tabela(this.valor_emprestimo);

        tab.add(reg);

        //inicia a base de calculo 
        double base_calc = this.valor_emprestimo;
        

        //vamos calcular agora todo o tempo
        for (int i = 1; i <= this.duracao; i++) {
            double prestacao=0;
            double juros=0;
            double amortizacao=0;
            
            if (this.sistema == Sistemas.GAUSS) {
                prestacao = getPrestacao();
                double indice = getIndiceGauss( prestacao );
                juros = ( this.duracao - (i-1))*indice;
                amortizacao = prestacao - juros;
                
                tab.add( new Tabela(prestacao, i, juros, base_calc - amortizacao ) );
                
                base_calc -= amortizacao;
            }

            if (this.sistema == Sistemas.SAC) {
                //vamos calular o sistema SAC :) 
                prestacao = this.getAmortizacao() + this.getValorJuros(base_calc);
                juros = this.getValorJuros(base_calc);
                amortizacao = this.getAmortizacao();
                tab.add(new Tabela(i,
                        this.getAmortizacao(),
                        this.getValorJuros(base_calc),
                        (base_calc - this.getAmortizacao())));

                base_calc -= this.getAmortizacao();
            }

            if (this.sistema == Sistemas.PRICE) {
                //vamos calular o sistema PRICE :) 

                juros = this.getValorJuros(base_calc);
                prestacao = this.getPrestacao(juros, i - 1);
                amortizacao = prestacao - juros;

                tab.add(new Tabela(prestacao, i,
                        juros,
                        (base_calc - amortizacao)));

                base_calc -= amortizacao;
            }
            
           this.total_amortizacao += amortizacao;
           this.total_juros += juros;
           this.total_prestacao += prestacao;
        }
        
        Tabela totais = new Tabela();
        totais.setAmortizacao(total_amortizacao);
        totais.setJuros(total_juros);
        totais.setPrestacao(total_prestacao);
        
        tab.add( totais );
        return tab;
    }

}
