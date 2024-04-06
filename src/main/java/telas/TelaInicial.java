/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package telas;

/**
 *
 * @author juan.adsantos
 */
public class TelaInicial extends javax.swing.JFrame {

    /**
     * Creates new form TelaInicial
     */
    public TelaInicial() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        mnuCadastroCliente = new javax.swing.JMenu();
        mnuCadastroProduto = new javax.swing.JMenu();
        mnuVenda = new javax.swing.JMenu();
        mnuRelatorio = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1000, 575));
        setSize(new java.awt.Dimension(1000, 575));

        mnuCadastroCliente.setIcon(new javax.swing.ImageIcon("C:\\Users\\juans\\OneDrive\\Documentos\\NetBeansProjects\\piprimeiraentrega\\piprimeiraentrega\\src\\main\\resources\\images\\iconCliente.png")); // NOI18N
        mnuCadastroCliente.setText("Cadastro Cliente");
        mnuCadastroCliente.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        jMenuBar1.add(mnuCadastroCliente);

        mnuCadastroProduto.setIcon(new javax.swing.ImageIcon("C:\\Users\\juans\\OneDrive\\Documentos\\NetBeansProjects\\piprimeiraentrega\\piprimeiraentrega\\src\\main\\resources\\images\\iconProduto.png")); // NOI18N
        mnuCadastroProduto.setText("Cadastro Produto");
        mnuCadastroProduto.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        jMenuBar1.add(mnuCadastroProduto);

        mnuVenda.setIcon(new javax.swing.ImageIcon("C:\\Users\\juans\\OneDrive\\Documentos\\NetBeansProjects\\piprimeiraentrega\\piprimeiraentrega\\src\\main\\resources\\images\\iconVendas.png")); // NOI18N
        mnuVenda.setText("Venda");
        mnuVenda.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        mnuVenda.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mnuVendaMouseClicked(evt);
            }
        });
        jMenuBar1.add(mnuVenda);

        mnuRelatorio.setIcon(new javax.swing.ImageIcon("C:\\Users\\juans\\OneDrive\\Documentos\\NetBeansProjects\\piprimeiraentrega\\piprimeiraentrega\\src\\main\\resources\\images\\iconRelatorio.png")); // NOI18N
        mnuRelatorio.setText("Relatório");
        mnuRelatorio.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        jMenuBar1.add(mnuRelatorio);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(623, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap(624, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(900, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mnuVendaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mnuVendaMouseClicked
        TelaVendas t1 = new TelaVendas();
        t1.setVisible(true);
        t1.setDefaultCloseOperation(t1.DISPOSE_ON_CLOSE);
    }//GEN-LAST:event_mnuVendaMouseClicked

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
            java.util.logging.Logger.getLogger(TelaInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaInicial().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu mnuCadastroCliente;
    private javax.swing.JMenu mnuCadastroProduto;
    private javax.swing.JMenu mnuRelatorio;
    private javax.swing.JMenu mnuVenda;
    // End of variables declaration//GEN-END:variables
}
