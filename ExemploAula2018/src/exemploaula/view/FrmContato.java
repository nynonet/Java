package exemploaula.view;

import exemploaula.grids.ContatoGrid;
import exemploaula.model.dao.ConexaoDB;
import exemploaula.model.dao.ContatoDao;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author macbook
 */
public class FrmContato extends javax.swing.JFrame {
    
    //cria um conector para o banco de dados.
    private ConexaoDB conexaoDB;
    //cria uma variável para controle de dados na tabela
    private ContatoGrid contatoGrid;
    
    public FrmContato() {
        initComponents();
        
        //inicia com uma lista vazia dos contatos.
        this.contatoGrid = new ContatoGrid( new ArrayList<>() );
        TabelaContatos.setModel( this.contatoGrid );
        
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        TabelaContatos = new javax.swing.JTable();
        btnConectar = new javax.swing.JButton();
        btnListar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        TabelaContatos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Nome", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(TabelaContatos);

        btnConectar.setText("Conectar");
        btnConectar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConectarActionPerformed(evt);
            }
        });

        btnListar.setText("Listar");
        btnListar.setEnabled(false);
        btnListar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 397, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(btnConectar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnListar)
                .addGap(35, 212, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnConectar)
                    .addComponent(btnListar))
                .addGap(0, 6, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnConectarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConectarActionPerformed
        // TODO add your handling code here:
        
        try {
            // criando o objeto conexaoDB utilizando o 1º método construtor
            conexaoDB = new ConexaoDB();
            // chamando a conexão para realizar o teste junto ao DB
            conexaoDB.getConexao();
            // Caso sucesso! habilita o botão de listar. 
            btnListar.setEnabled(true);
            // Desabilita o botão de conectar
            btnConectar.setEnabled(false);
        } catch (SQLException ex) {
            //caso erro! desabilita o botão listar
            btnListar.setEnabled(false);
            //Habilita o botão de conectar.
            btnConectar.setEnabled(true);
            //Mostra o erro ao Usuário
            JOptionPane.showMessageDialog(rootPane, "Erro apresentado:\n"+
                    ex.getMessage());
        }
        
    }//GEN-LAST:event_btnConectarActionPerformed

    private void btnListarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListarActionPerformed
        // TODO add your handling code here:    
        
        try {
            ContatoDao contatoDB = new ContatoDao(conexaoDB);
            contatoGrid = new ContatoGrid(contatoDB.getRegistros(""));
            TabelaContatos.setModel(contatoGrid);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
    }//GEN-LAST:event_btnListarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmContato.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmContato.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmContato.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmContato.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmContato().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TabelaContatos;
    private javax.swing.JButton btnConectar;
    private javax.swing.JButton btnListar;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
