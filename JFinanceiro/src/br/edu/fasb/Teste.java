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
public class Teste {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        CalculaEmprestimo sac = new CalculaEmprestimo();
        
        sac.setDuracao(4); //meses
        sac.setSistema(Sistemas.GAUSS); //sistema sac
        sac.setTaxa_juros(3); //taxa de juros
        sac.setValor_emprestimo(1000);//valor do emprestimo.
        
        System.out.println( sac.getResultado() );
        
    }
    
}
