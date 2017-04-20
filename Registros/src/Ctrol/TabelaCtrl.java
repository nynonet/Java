/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ctrol;

import dao.Conexao;
import dao.TabelaDao;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;
import javax.swing.JSpinner;

/**
 *
 * @author Andeson
 */
public class TabelaCtrl {

    private TabelaDao tabelaDao;
    private Conexao con;

    public TabelaCtrl(Conexao conexao) {
        tabelaDao = new TabelaDao(conexao.getCon());
        con = conexao;
    }

    public void gerarRegistros(JSpinner sequencia, JProgressBar progresso, JButton btnClick) {
        
        int qtd_vezes = (int) sequencia.getValue();

        if (qtd_vezes <= 0) {
            JOptionPane.showMessageDialog(sequencia.getParent(), "Informe a quantidade válida!");
            return;
        }
        
        if ( ! con.isConectado()) {
            JOptionPane.showMessageDialog(sequencia.getParent(), "Sem conexão com o banco de dados!");
            return;
        }
        

        progresso.setMaximum(qtd_vezes);

        new Thread() {
            @Override
            public void run() {
                try {
                    sequencia.setEnabled(false);
                    btnClick.setEnabled(false);

                    for (int i = 1; i <= qtd_vezes; i++) {
                        System.out.println("aaaa > "+ i);
                        progresso.setValue( i );
                        
                    }

                } finally {
                    sequencia.setEnabled(true);
                    btnClick.setEnabled(true);
                }
            }
        }.start();
    }

}
