/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exemplo;

import javax.swing.JOptionPane;

/**
 *
 * @author Andeson
 */
public class BatePapo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String p1; //pessoa 1
        String p2; //Pessoa 2
        //nome da primeira pessoa/

        p1 = JOptionPane.showInputDialog("Informe o nome da 1º Pessoa!");
        p2 = JOptionPane.showInputDialog("Informe o nome da 2º Pessoa!");

        System.out.println("Pessoa 1 > " + p1);
        System.out.println("Pessoa 2 > " + p2);

        String msg;
        boolean sair = true;
        boolean segunda_pessoa = false;
        
        while (sair) {
            String pergunta;  //Pessoa que irá fazer a pergunta
            String resposta;  //Pessoa que irá responder
            if (segunda_pessoa == true) {
                pergunta = p2 ;
                resposta = p1 ;
            } else {
                pergunta = p1 ;
                resposta = p2 ;
            }
            msg = JOptionPane.showInputDialog(pergunta + ", escreva sua pergunta");
            System.out.println(pergunta + " > " + msg);
            if (msg.equals("")) {
                sair = false;
                break;
            }

            msg = JOptionPane.showInputDialog(resposta + ", escreva sua resposta");
            System.out.println(resposta + " > " + msg);
            
            segunda_pessoa = !segunda_pessoa;
            
//            if (segunda_pessoa == true) {
//                segunda_pessoa = false;
//            } else {
//                segunda_pessoa = true;
//            }
            
        }

    }

}
