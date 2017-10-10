/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Agenda;

/**
 *
 * @author Andeson
 */
public class MeusContatos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int codigo = 10;
        Contato c = new Contato();
        c.setNome("fulano");
        c.setTelefone("77");
        c.getEndereco().rua = "A";
        
        System.out.println(c.getEndereco().rua);
        
        Fornecedor f = new Fornecedor();
        f.cnpj = "00.000.000/0000-00";
        f.setNome("EMPRESAS AABBCC");
        f.setTelefone("778899");
        
        f.setEndereco(c.getEndereco());
        
//        f.getEndereco().rua = "B";
        
        System.out.println(f.getEndereco().rua);
        
        
        
    }
    
}
