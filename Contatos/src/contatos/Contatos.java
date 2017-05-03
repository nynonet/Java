/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contatos;

import Dao.Conexao;
import javax.swing.JFrame;


/**
 *
 * @author Andeson
 */
public class Contatos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Conexao c1 = new Conexao();
        
        c1.FechaConexao();
        
    }
    
}
