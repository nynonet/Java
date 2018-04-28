package exemploaula.view;

import exemploaula.Controller.ContatoController;
import exemploaula.grids.ContatoGrid;
import exemploaula.model.Contato;
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
        this.contatoGrid = new ContatoGrid(new ArrayList<>());
        TabelaContatos.setModel(this.contatoGrid);
    }

    /**
     * Procedimento para tratar do controle de botões da Tela
     *
     * @param ativo parametro para identificar se está ativo ou não
     */
    private void ControleBotoes(boolean ativo) {
        // Caso sucesso! habilita/desabilia os botões. 
        btnListar.setEnabled(ativo);
        btnAdicionar.setEnabled(ativo);
        btnAlterar.setEnabled(ativo);
        //inverte o status do parametro ativo. 
        // se for true muda para false
        // se for false muda para true 
        btnConectar.setEnabled(!ativo);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        TabelaContatos = new javax.swing.JTable();
        btnConectar = new javax.swing.JButton();
        btnListar = new javax.swing.JButton();
        btnAdicionar = new javax.swing.JButton();
        btnAlterar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        TabelaContatos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "Nome", "Telefone", "Sexo"
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

        btnAdicionar.setText("Adicionar");
        btnAdicionar.setEnabled(false);
        btnAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionarActionPerformed(evt);
            }
        });

        btnAlterar.setText("Alterar");
        btnAlterar.setEnabled(false);
        btnAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(btnConectar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnListar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAdicionar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAlterar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnConectar)
                    .addComponent(btnListar)
                    .addComponent(btnAdicionar)
                    .addComponent(btnAlterar))
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

            //controla os botões da tela.
            ControleBotoes(true);

        } catch (SQLException ex) {
            //caso erro! desabilita o botão listar
            ControleBotoes(false);

            //Mostra o erro ao Usuário
            JOptionPane.showMessageDialog(rootPane, "Erro apresentado:\n"
                    + ex.getMessage());
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

    private void btnAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarActionPerformed
        //Peço ao usuário para entrar com um Nome
        String nome = JOptionPane.showInputDialog("Informe o Nome:");
        //System.out.println("Nome informado é: "+nome);

        //se cancelou..
        if (nome == null) {
            return; //isso é igual a abortar operação
        }
        
        Contato c = new Contato();
        c.setNome(nome);
        
        String valido = new ContatoController( c ).ValidaContato();

        //Verifica se o resultado é diferente de OK, sendo mostra a mensagem
        if ( ! valido.equals("OK") ) {
            JOptionPane.showMessageDialog(rootPane, valido );
            return;
        }

        try {
            ContatoDao contatoDao = new ContatoDao(conexaoDB);
            contatoDao.Inserir(c);

            btnListar.doClick();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }//GEN-LAST:event_btnAdicionarActionPerformed

    private void btnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarActionPerformed
        // Vamos aqui alterar um registro

        //pega a quantidade de registros na nossa tabela "grid"
        int qtd = TabelaContatos.getRowCount();

        if (qtd == 0) { //checa a qtde de registro é igual a zero.
            JOptionPane.showMessageDialog(rootPane, "Não há registros!");
            return;
        }

        qtd = TabelaContatos.getSelectedRowCount();
        if (qtd == 0) { //checa a qtde de registro selecionados é igual a zero.
            JOptionPane.showMessageDialog(rootPane, "Você não selecionou "
                    + "nenhum registro!");
            return;
        }

        //capturando o modelo de grid da tabela
        ContatoGrid alt = (ContatoGrid) TabelaContatos.getModel();

        //captura o item selecionado 
        Contato c = alt.getItem(TabelaContatos.getSelectedRow());

        String nome = JOptionPane.showInputDialog(rootPane,
                "Nome do Contato:", c.getNome());

        if (nome == null) {
            return;
        }

        if (nome.equals(c.getNome())) {
            return;
        }
        
        c.setNome(nome);
        
        String valido = new ContatoController( c ).ValidaContato();
        
        if (! valido.equals("OK")) {
            JOptionPane.showMessageDialog(rootPane, valido);
            return;
        }

        try {
            ContatoDao contatoDao = new ContatoDao(conexaoDB);
            System.out.println("Id Contato = "+ c.getId());
            
            contatoDao.Gravar(c);

            btnListar.doClick();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }//GEN-LAST:event_btnAlterarActionPerformed

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
    private javax.swing.JButton btnAdicionar;
    private javax.swing.JButton btnAlterar;
    private javax.swing.JButton btnConectar;
    private javax.swing.JButton btnListar;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
