/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package telas;

import DAO.ClienteDAO;
import DAO.EnderecoDAO;
import DAO.ProdutoDAO;
import classes.Cliente;
import classes.Endereco;
import classes.Produto;
import java.awt.Color;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Vector;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import telas.TelaRelatorioAnalitico;

/**
 *
 * @author juan.adsantos
 */
public class TelaInicial extends javax.swing.JFrame {
      public Cliente objAlterar = null;
      public Endereco objAlterar2 = null;
      
  private void atualizarTabelaCliente() {
        ArrayList<Cliente> list = ClienteDAO.listar();
        DefaultTableModel model = (DefaultTableModel) tblConsultarCliente.getModel();
        model.setRowCount(0);
        for (Cliente cliente : list) {
            model.addRow(new String[]{
                String.valueOf(cliente.getId_cliente()),
                cliente.getNome(),
                cliente.getCPF(),
                cliente.getTelefone(),
                cliente.getEmail(),
                cliente.getEstadoCivil(),
                cliente.getDataDeNascimento(),
                cliente.getEndereco(),
                String.valueOf(cliente.getNumero()),
                cliente.getCep(),
                cliente.getBairro(),
                cliente.getCidade(),
                cliente.getComplemento(),
                cliente.getUf()
                
            });

        }
    }
  private void atualizarTabelaProduto() {
        ArrayList<Produto> list = ProdutoDAO.listar();
        DefaultTableModel model = (DefaultTableModel) tblConsultarProduto.getModel();
        model.setRowCount(0);
        for (Produto product : list) {
            model.addRow(new String[]{
                String.valueOf(product.getID()),
                product.getNomeProduto(),
                String.valueOf(product.getValor()),
                String.valueOf(product.getQtdParcelas())
                
            });

        }
    }

    public void verificaCamposCliente(){
         if(!(txtCPF.getText().length() < 11 || txtNomeCliente.getText().length() == 0 || cmbEstadoCivil.getSelectedIndex() == 0 || txtBairro.getText().length() == 0 || txtCEP.getText().length() < 8 || txtEndereco.getText().length() == 0 || txtCidade.getText().length() == 0 || !txtEmail.getText().contains("@") || !txtEmail.getText().contains(".com") || txtNumEndereco.getText().length() == 0 || txtCelular.getText().length() > 20)){
             int a = cmbEstadoCivil.getSelectedIndex();
             String estadoCivil = cmbEstadoCivil.getItemAt(a);
             int b = cmbEstado.getSelectedIndex();
             String estado = cmbEstado.getItemAt(b);
             String dataNascimento = txtDataDeNascimento.getText();
             String dia = dataNascimento.substring(0, 2);
             String mes = dataNascimento.substring(2, 4);
             String ano = dataNascimento.substring(4, 8);
             String diaCerto = ano + "-"+ mes + "-" + dia;
             JOptionPane.showMessageDialog(rootPane, diaCerto);
             Cliente c1 = new Cliente(txtNomeCliente.getText(), txtCPF.getText(), txtCelular.getText(), txtEmail.getText(), estadoCivil, diaCerto);
             ClienteDAO dao1 = new ClienteDAO();
             EnderecoDAO dao2 = new EnderecoDAO();
             
             Cliente e1 = new Cliente(txtEndereco.getText(), Integer.parseInt(txtNumEndereco.getText()), txtCEP.getText(), txtBairro.getText(), txtCidade.getText(), txtComplemento.getText(), estado);
             boolean retornoCliente = ClienteDAO.salvar(c1);
             boolean retornoEndereco = EnderecoDAO.salvar(e1);
             
             if(retornoCliente && retornoEndereco){
             JOptionPane.showMessageDialog(rootPane, "Cliente salvo");
            limparCamposCliente();
           
             } else {
                 JOptionPane.showMessageDialog(rootPane, "Erro ao salvar no Banco de Dados");
             }
             
        } else {
            JOptionPane.showMessageDialog(rootPane, "Há informações incorretas");
        }
    }
    
    public void limparCamposCliente(){
         txtCPF.setText("");
            txtCPF.setBackground(Color.white);
            txtNomeCliente.setText("");
            txtNomeCliente.setBackground(Color.white);
            txtBairro.setText("");
            txtBairro.setBackground(Color.white);
            txtCEP.setText("");
            txtCEP.setBackground(Color.white);
            txtEndereco.setText("");
            txtEndereco.setBackground(Color.white);
            txtCidade.setText("");
            txtCidade.setBackground(Color.white);
            txtEmail.setText("");
            txtEmail.setBackground(Color.white);
            txtNumEndereco.setText("");
            txtNumEndereco.setBackground(Color.white);
            txtComplemento.setText("");
            txtComplemento.setBackground(Color.white);
            txtCelular.setText("");
            txtCelular.setBackground(Color.white);
            txtDataDeNascimento.setText("");
            txtDataDeNascimento.setBackground(Color.white);
            cmbEstado.setSelectedIndex(0);
            cmbEstado.setBackground(Color.white);
            cmbEstadoCivil.setSelectedIndex(0);
            cmbEstadoCivil.setBackground(Color.white);
    }
    public void verificaNumeroMinimo(JTextField a, int b, String c){
        
        if (a.getText().length() < b || a.getText().isEmpty()){
            a.setBackground(Color.red);
                      
        }
    }
    public void verificaVazio(JTextField a, String b){
        if(a.getText().isEmpty()){
            a.setBackground(Color.red);
            
        }
    }
    
    public void verificaComboBox(JComboBox a, String b){
        if(a.getSelectedIndex() == 0){
            a.setBackground(Color.red);
            JOptionPane.showMessageDialog(rootPane, "Escolha o " + b);
        }
    }
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

        tbbPnlTela = new javax.swing.JTabbedPane();
        pnlTelaInicial = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        pnlCadastroProduto = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        lblValor = new javax.swing.JLabel();
        lblFormaPagamento = new javax.swing.JLabel();
        cboPagamento = new javax.swing.JComboBox<>();
        lblParcelas = new javax.swing.JLabel();
        jSpinner1 = new javax.swing.JSpinner();
        txtValor = new javax.swing.JTextField();
        lblNomeProduto = new javax.swing.JLabel();
        lblTamanho = new javax.swing.JLabel();
        txtTamanho = new javax.swing.JTextField();
        lblMarca = new javax.swing.JLabel();
        lblCor = new javax.swing.JLabel();
        lblCategoria = new javax.swing.JLabel();
        cboCor = new javax.swing.JComboBox<>();
        cboCategoria = new javax.swing.JComboBox<>();
        jSeparator1 = new javax.swing.JSeparator();
        btnConfirmar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        txtNomeProduto = new javax.swing.JTextField();
        txtMarca = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        pnlVendas = new javax.swing.JPanel();
        lblVendas1 = new javax.swing.JLabel();
        pnlDadosDoProduto1 = new javax.swing.JPanel();
        lblCodigo1 = new javax.swing.JLabel();
        lblNome1 = new javax.swing.JLabel();
        lblValor1 = new javax.swing.JLabel();
        lblQuantidade1 = new javax.swing.JLabel();
        txtCodigo1 = new javax.swing.JTextField();
        txtNome1 = new javax.swing.JTextField();
        txtValor1 = new javax.swing.JTextField();
        btnBuscar1 = new javax.swing.JButton();
        txtQuantidade1 = new javax.swing.JTextField();
        btnAdicionar1 = new javax.swing.JButton();
        pnlCarrinho1 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblCarrinho1 = new javax.swing.JTable();
        btnExcluirVenda = new javax.swing.JButton();
        pnlTotalDeVendas6 = new javax.swing.JPanel();
        lblTotalDeVendas6 = new javax.swing.JLabel();
        lblTotalDeVendasVendas = new javax.swing.JLabel();
        btnCancelarVenda1 = new javax.swing.JButton();
        btnConfirmarVenda1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        lblCPFVendas = new javax.swing.JLabel();
        txtCPFVendas = new javax.swing.JTextField();
        lblDataVendas = new javax.swing.JLabel();
        calendarioVendas = new com.toedter.calendar.JDateChooser();
        btnLimpar = new javax.swing.JButton();
        btnPesquisar = new javax.swing.JButton();
        pnlRelatorio = new javax.swing.JPanel();
        jblDataInicial = new javax.swing.JLabel();
        lblDataFinal = new javax.swing.JLabel();
        btnImprimir = new javax.swing.JButton();
        btnFechar = new javax.swing.JButton();
        jblRelatorio = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        btnDetalhesRelatorio = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        calendarioDataInicial = new com.toedter.calendar.JDateChooser();
        calendarioDataFinal = new com.toedter.calendar.JDateChooser();
        pnlCadastroCliente = new javax.swing.JPanel();
        lblNomeCliente = new javax.swing.JLabel();
        lblEmail = new javax.swing.JLabel();
        lblCEP = new javax.swing.JLabel();
        lblBairro = new javax.swing.JLabel();
        lblRG = new javax.swing.JLabel();
        txtNomeCliente = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        txtBairro = new javax.swing.JTextField();
        lblCelular = new javax.swing.JLabel();
        lblTelefone = new javax.swing.JLabel();
        lblEndereco = new javax.swing.JLabel();
        txtEndereco = new javax.swing.JTextField();
        lblNumEndereco = new javax.swing.JLabel();
        lblCidade = new javax.swing.JLabel();
        txtCidade = new javax.swing.JTextField();
        lblComplemento = new javax.swing.JLabel();
        txtComplemento = new javax.swing.JTextField();
        lblCPF = new javax.swing.JLabel();
        lblUF = new javax.swing.JLabel();
        cmbEstado = new javax.swing.JComboBox<>();
        btnSalvar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnCancelarCadastroCliente = new javax.swing.JButton();
        cmbEstadoCivil = new javax.swing.JComboBox<>();
        txtCelular = new javax.swing.JFormattedTextField();
        txtCEP = new javax.swing.JFormattedTextField();
        txtNumEndereco = new javax.swing.JFormattedTextField();
        txtCPF = new javax.swing.JFormattedTextField();
        txtDataDeNascimento = new javax.swing.JFormattedTextField();
        jButton1 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        pnlTProduto = new javax.swing.JPanel();
        lblCodigo = new javax.swing.JLabel();
        btnConsultarProduto = new javax.swing.JButton();
        btnAlterarProduto = new javax.swing.JButton();
        btnExcluirProduto = new javax.swing.JButton();
        txtNomeConsultaProduto = new javax.swing.JTextField();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblConsultarProduto = new javax.swing.JTable();
        pnlConsultaCliente = new javax.swing.JPanel();
        pnlTCliente = new javax.swing.JPanel();
        lblNome = new javax.swing.JLabel();
        txtNomeCliente1 = new javax.swing.JTextField();
        btnConsultarCliente = new javax.swing.JButton();
        btnAlterarCliente = new javax.swing.JButton();
        btnExcluirCliente = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblConsultarCliente = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1000, 600));
        setSize(new java.awt.Dimension(1000, 600));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel2.setText("Bem-vindo");

        javax.swing.GroupLayout pnlTelaInicialLayout = new javax.swing.GroupLayout(pnlTelaInicial);
        pnlTelaInicial.setLayout(pnlTelaInicialLayout);
        pnlTelaInicialLayout.setHorizontalGroup(
            pnlTelaInicialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlTelaInicialLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 498, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1113, 1113, 1113))
            .addGroup(pnlTelaInicialLayout.createSequentialGroup()
                .addGap(412, 412, 412)
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlTelaInicialLayout.setVerticalGroup(
            pnlTelaInicialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTelaInicialLayout.createSequentialGroup()
                .addGap(84, 84, 84)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 311, Short.MAX_VALUE)
                .addGap(105, 105, 105))
        );

        tbbPnlTela.addTab("Tela Inicial", pnlTelaInicial);

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lblValor.setText("Valor:*");

        lblFormaPagamento.setText("Forma de Pagamento:");

        cboPagamento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pix", "Dinheiro", "Débito", "Crédito" }));
        cboPagamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboPagamentoActionPerformed(evt);
            }
        });

        lblParcelas.setText("QTD Estoque:");

        txtValor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtValorKeyTyped(evt);
            }
        });

        lblNomeProduto.setText("Nome Produto:*");

        lblTamanho.setText("Tamanho:*");

        txtTamanho.setText(" ");
        txtTamanho.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTamanhoActionPerformed(evt);
            }
        });

        lblMarca.setText("Marca:*");

        lblCor.setText("Cor:");

        lblCategoria.setText("Categoria: ");

        cboCor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Preto", "Branco", "Marrom", "Azul", "Verde" }));

        cboCategoria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tenis", "Blusa", "Camiseta", "Shorts", "Calça" }));

        btnConfirmar.setBackground(new java.awt.Color(0, 204, 0));
        btnConfirmar.setText("Confirmar");
        btnConfirmar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnConfirmarMouseClicked(evt);
            }
        });
        btnConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmarActionPerformed(evt);
            }
        });

        btnCancelar.setBackground(new java.awt.Color(255, 0, 0));
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        jButton2.setText("Consulta");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator1)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lblTamanho)
                                    .addComponent(lblCor)
                                    .addComponent(lblCategoria))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(cboCor, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(cboCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(txtTamanho, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblMarca, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lblNomeProduto, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(txtNomeProduto)
                                        .addComponent(txtMarca, javax.swing.GroupLayout.DEFAULT_SIZE, 191, Short.MAX_VALUE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(48, 48, 48)))))
                        .addContainerGap())
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                .addComponent(lblValor)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtValor, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(167, 167, 167)
                                .addComponent(lblFormaPagamento)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cboPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                .addComponent(lblParcelas)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                .addGap(101, 101, 101)
                                .addComponent(btnConfirmar, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(107, 107, 107)
                                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 101, Short.MAX_VALUE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblNomeProduto)
                            .addComponent(txtNomeProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(25, 25, 25)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblMarca)
                            .addComponent(txtMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(34, 34, 34)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblTamanho)
                            .addComponent(txtTamanho, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(25, 25, 25)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cboCor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblCor))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblCategoria)
                            .addComponent(cboCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(33, 33, 33)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblValor)
                    .addComponent(txtValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblFormaPagamento)
                    .addComponent(cboPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblParcelas)
                    .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnConfirmar, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(57, 57, 57))
        );

        javax.swing.GroupLayout pnlCadastroProdutoLayout = new javax.swing.GroupLayout(pnlCadastroProduto);
        pnlCadastroProduto.setLayout(pnlCadastroProdutoLayout);
        pnlCadastroProdutoLayout.setHorizontalGroup(
            pnlCadastroProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCadastroProdutoLayout.createSequentialGroup()
                .addGap(143, 143, 143)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(180, Short.MAX_VALUE))
        );
        pnlCadastroProdutoLayout.setVerticalGroup(
            pnlCadastroProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlCadastroProdutoLayout.createSequentialGroup()
                .addContainerGap(51, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36))
        );

        tbbPnlTela.addTab("Cadastro Produto", pnlCadastroProduto);

        lblVendas1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lblVendas1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblVendas1.setText("Vendas");

        pnlDadosDoProduto1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(null, "Dados do Cliente", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION), "Dados do Produto"));

        lblCodigo1.setText("Código:");

        lblNome1.setText("Nome:");

        lblValor1.setText("Valor:");

        lblQuantidade1.setText("Quantidade:");

        txtCodigo1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodigo1ActionPerformed(evt);
            }
        });
        txtCodigo1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCodigo1KeyTyped(evt);
            }
        });

        txtNome1.setText("Bola de Boliche");
        txtNome1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNome1ActionPerformed(evt);
            }
        });

        txtValor1.setText("250.0");
        txtValor1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtValor1ActionPerformed(evt);
            }
        });
        txtValor1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtValor1KeyTyped(evt);
            }
        });

        btnBuscar1.setText("Buscar");
        btnBuscar1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnBuscar1MouseClicked(evt);
            }
        });
        btnBuscar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscar1ActionPerformed(evt);
            }
        });

        txtQuantidade1.setText("1");
        txtQuantidade1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtQuantidade1ActionPerformed(evt);
            }
        });
        txtQuantidade1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtQuantidade1KeyTyped(evt);
            }
        });

        btnAdicionar1.setText("Adicionar no carrinho >>");
        btnAdicionar1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAdicionar1MouseClicked(evt);
            }
        });
        btnAdicionar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionar1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlDadosDoProduto1Layout = new javax.swing.GroupLayout(pnlDadosDoProduto1);
        pnlDadosDoProduto1.setLayout(pnlDadosDoProduto1Layout);
        pnlDadosDoProduto1Layout.setHorizontalGroup(
            pnlDadosDoProduto1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDadosDoProduto1Layout.createSequentialGroup()
                .addGroup(pnlDadosDoProduto1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlDadosDoProduto1Layout.createSequentialGroup()
                        .addComponent(lblCodigo1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCodigo1, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnBuscar1))
                    .addGroup(pnlDadosDoProduto1Layout.createSequentialGroup()
                        .addComponent(lblNome1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtNome1, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlDadosDoProduto1Layout.createSequentialGroup()
                        .addComponent(lblValor1)
                        .addGap(18, 18, 18)
                        .addComponent(txtValor1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33)
                        .addComponent(lblQuantidade1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtQuantidade1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 90, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlDadosDoProduto1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnAdicionar1, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        pnlDadosDoProduto1Layout.setVerticalGroup(
            pnlDadosDoProduto1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDadosDoProduto1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlDadosDoProduto1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCodigo1)
                    .addComponent(txtCodigo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlDadosDoProduto1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNome1)
                    .addComponent(txtNome1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlDadosDoProduto1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblValor1)
                    .addComponent(lblQuantidade1)
                    .addComponent(txtValor1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtQuantidade1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 69, Short.MAX_VALUE)
                .addComponent(btnAdicionar1, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pnlCarrinho1.setBorder(javax.swing.BorderFactory.createTitledBorder("Carrinho"));

        tblCarrinho1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nome", "Código", "Qtd", "Preço", "Subtotal"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tblCarrinho1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblCarrinho1MouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblCarrinho1);

        btnExcluirVenda.setText("Excluir");
        btnExcluirVenda.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnExcluirVendaMouseClicked(evt);
            }
        });
        btnExcluirVenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirVendaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlCarrinho1Layout = new javax.swing.GroupLayout(pnlCarrinho1);
        pnlCarrinho1.setLayout(pnlCarrinho1Layout);
        pnlCarrinho1Layout.setHorizontalGroup(
            pnlCarrinho1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 545, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlCarrinho1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnExcluirVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        pnlCarrinho1Layout.setVerticalGroup(
            pnlCarrinho1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCarrinho1Layout.createSequentialGroup()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnExcluirVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pnlTotalDeVendas6.setBorder(javax.swing.BorderFactory.createTitledBorder("Total de Vendas"));

        lblTotalDeVendas6.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblTotalDeVendas6.setText("Total de Vendas:");

        lblTotalDeVendasVendas.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        lblTotalDeVendasVendas.setText("R$ 0");

        javax.swing.GroupLayout pnlTotalDeVendas6Layout = new javax.swing.GroupLayout(pnlTotalDeVendas6);
        pnlTotalDeVendas6.setLayout(pnlTotalDeVendas6Layout);
        pnlTotalDeVendas6Layout.setHorizontalGroup(
            pnlTotalDeVendas6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTotalDeVendas6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTotalDeVendas6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTotalDeVendasVendas)
                .addContainerGap(364, Short.MAX_VALUE))
        );
        pnlTotalDeVendas6Layout.setVerticalGroup(
            pnlTotalDeVendas6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTotalDeVendas6Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(pnlTotalDeVendas6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTotalDeVendas6, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTotalDeVendasVendas))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnCancelarVenda1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnCancelarVenda1.setText("Cancelar Venda");
        btnCancelarVenda1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCancelarVenda1MouseClicked(evt);
            }
        });
        btnCancelarVenda1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarVenda1ActionPerformed(evt);
            }
        });

        btnConfirmarVenda1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnConfirmarVenda1.setText("Confirmar Venda");
        btnConfirmarVenda1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmarVenda1ActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Dados do Cliente"));

        lblCPFVendas.setText("CPF:");

        txtCPFVendas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCPFVendasActionPerformed(evt);
            }
        });
        txtCPFVendas.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCPFVendasKeyTyped(evt);
            }
        });

        lblDataVendas.setText("Data:");

        btnLimpar.setText("Limpar");

        btnPesquisar.setText("Pesquisar");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblCPFVendas)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCPFVendas, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblDataVendas)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(calendarioVendas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnLimpar)
                        .addGap(18, 18, 18)
                        .addComponent(btnPesquisar)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(calendarioVendas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblCPFVendas)
                        .addComponent(txtCPFVendas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblDataVendas)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLimpar)
                    .addComponent(btnPesquisar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnlVendasLayout = new javax.swing.GroupLayout(pnlVendas);
        pnlVendas.setLayout(pnlVendasLayout);
        pnlVendasLayout.setHorizontalGroup(
            pnlVendasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlVendasLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlVendasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblVendas1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlVendasLayout.createSequentialGroup()
                        .addGroup(pnlVendasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(pnlDadosDoProduto1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlVendasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pnlCarrinho1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(pnlTotalDeVendas6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(pnlVendasLayout.createSequentialGroup()
                                .addComponent(btnConfirmarVenda1, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnCancelarVenda1, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(22, 22, 22))
        );
        pnlVendasLayout.setVerticalGroup(
            pnlVendasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlVendasLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblVendas1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlVendasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(pnlVendasLayout.createSequentialGroup()
                        .addComponent(pnlCarrinho1, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pnlTotalDeVendas6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlVendasLayout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pnlDadosDoProduto1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(pnlVendasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnConfirmarVenda1, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancelarVenda1, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(50, Short.MAX_VALUE))
        );

        tbbPnlTela.addTab("Vendas", pnlVendas);

        jblDataInicial.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jblDataInicial.setText("Data Inicial");

        lblDataFinal.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblDataFinal.setText("Data Final");

        btnImprimir.setText("Imprimir");

        btnFechar.setText("Fechar");

        jblRelatorio.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jblRelatorio.setText("Relatório - Vendas");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"16/04/2024", "José", "650"},
                {"16/04/2024", "Josemires", "800"}
            },
            new String [] {
                "Data de Compra", "Nome", "Valor total de Vendas"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        btnDetalhesRelatorio.setText("Detalhes");
        btnDetalhesRelatorio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnDetalhesRelatorioMouseClicked(evt);
            }
        });
        btnDetalhesRelatorio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDetalhesRelatorioActionPerformed(evt);
            }
        });

        jLabel3.setText("Total Vendas: ");

        jLabel4.setText("R$ 1450");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 61, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnlRelatorioLayout = new javax.swing.GroupLayout(pnlRelatorio);
        pnlRelatorio.setLayout(pnlRelatorioLayout);
        pnlRelatorioLayout.setHorizontalGroup(
            pnlRelatorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlRelatorioLayout.createSequentialGroup()
                .addGroup(pnlRelatorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlRelatorioLayout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(jblRelatorio, javax.swing.GroupLayout.PREFERRED_SIZE, 542, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlRelatorioLayout.createSequentialGroup()
                        .addGroup(pnlRelatorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlRelatorioLayout.createSequentialGroup()
                                .addGap(256, 256, 256)
                                .addComponent(jblDataInicial))
                            .addGroup(pnlRelatorioLayout.createSequentialGroup()
                                .addGap(231, 231, 231)
                                .addComponent(calendarioDataInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(pnlRelatorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlRelatorioLayout.createSequentialGroup()
                                .addGap(238, 238, 238)
                                .addComponent(lblDataFinal))
                            .addGroup(pnlRelatorioLayout.createSequentialGroup()
                                .addGap(228, 228, 228)
                                .addComponent(calendarioDataFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(pnlRelatorioLayout.createSequentialGroup()
                        .addGap(348, 348, 348)
                        .addComponent(btnImprimir, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(68, 68, 68)
                        .addComponent(btnFechar, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlRelatorioLayout.createSequentialGroup()
                        .addGap(219, 219, 219)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 549, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDetalhesRelatorio))
                    .addGroup(pnlRelatorioLayout.createSequentialGroup()
                        .addGap(408, 408, 408)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(124, Short.MAX_VALUE))
        );
        pnlRelatorioLayout.setVerticalGroup(
            pnlRelatorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlRelatorioLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jblRelatorio)
                .addGap(7, 7, 7)
                .addGroup(pnlRelatorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnlRelatorioLayout.createSequentialGroup()
                        .addComponent(jblDataInicial)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(calendarioDataInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlRelatorioLayout.createSequentialGroup()
                        .addComponent(lblDataFinal)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(calendarioDataFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(pnlRelatorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlRelatorioLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDetalhesRelatorio))
                    .addGroup(pnlRelatorioLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(12, 12, 12)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(pnlRelatorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnImprimir)
                    .addComponent(btnFechar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tbbPnlTela.addTab("Relatório", pnlRelatorio);

        pnlCadastroCliente.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lblNomeCliente.setText("Nome:*");

        lblEmail.setText("E-mail:*");

        lblCEP.setText("CEP:*");

        lblBairro.setText("Bairro:");

        lblRG.setText("Data de Nascimento:*");

        lblCelular.setText("Celular:*");

        lblTelefone.setText("Estado Civil:");

        lblEndereco.setText("Endereço:*");

        lblNumEndereco.setText("Número:");

        lblCidade.setText("Cidade:");

        lblComplemento.setText("Complemento:");

        txtComplemento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtComplementoActionPerformed(evt);
            }
        });

        lblCPF.setText("CPF:*");

        lblUF.setText("UF:");

        cmbEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Escolher", "AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PA", "PB", "PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO", " " }));
        cmbEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbEstadoActionPerformed(evt);
            }
        });

        btnSalvar.setText("Salvar");
        btnSalvar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSalvarMouseClicked(evt);
            }
        });
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnCancelarCadastroCliente.setText("Cancelar");
        btnCancelarCadastroCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarCadastroClienteActionPerformed(evt);
            }
        });

        cmbEstadoCivil.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Escolher", "Solteiro", "Casado", "Viuvo", "Divorciado", "União Estável" }));

        txtNumEndereco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNumEnderecoActionPerformed(evt);
            }
        });

        txtCPF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCPFActionPerformed(evt);
            }
        });

        txtDataDeNascimento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDataDeNascimentoActionPerformed(evt);
            }
        });

        jButton1.setText("Consulta");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlCadastroClienteLayout = new javax.swing.GroupLayout(pnlCadastroCliente);
        pnlCadastroCliente.setLayout(pnlCadastroClienteLayout);
        pnlCadastroClienteLayout.setHorizontalGroup(
            pnlCadastroClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCadastroClienteLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(pnlCadastroClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlCadastroClienteLayout.createSequentialGroup()
                        .addGroup(pnlCadastroClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(pnlCadastroClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(pnlCadastroClienteLayout.createSequentialGroup()
                                    .addGroup(pnlCadastroClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(pnlCadastroClienteLayout.createSequentialGroup()
                                            .addComponent(lblNomeCliente)
                                            .addGap(19, 19, 19)
                                            .addComponent(txtNomeCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlCadastroClienteLayout.createSequentialGroup()
                                            .addComponent(lblRG)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(txtDataDeNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGap(18, 18, 18)
                                    .addGroup(pnlCadastroClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(lblCelular)
                                        .addComponent(lblCPF)))
                                .addGroup(pnlCadastroClienteLayout.createSequentialGroup()
                                    .addComponent(lblEmail)
                                    .addGap(18, 18, 18)
                                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(lblTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(pnlCadastroClienteLayout.createSequentialGroup()
                                .addComponent(lblEndereco)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblNumEndereco)))
                        .addGroup(pnlCadastroClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlCadastroClienteLayout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addGroup(pnlCadastroClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtCPF, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtCelular, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(pnlCadastroClienteLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtNumEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnlCadastroClienteLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmbEstadoCivil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(pnlCadastroClienteLayout.createSequentialGroup()
                        .addComponent(lblBairro)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtBairro, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblCidade)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnlCadastroClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtCidade, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnSalvar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(pnlCadastroClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlCadastroClienteLayout.createSequentialGroup()
                                .addGap(58, 58, 58)
                                .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(61, 61, 61))
                            .addGroup(pnlCadastroClienteLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(pnlCadastroClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lblCEP, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblComplemento))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(pnlCadastroClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtComplemento, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtCEP, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)))
                        .addGroup(pnlCadastroClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnCancelarCadastroCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(pnlCadastroClienteLayout.createSequentialGroup()
                                .addComponent(lblUF)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cmbEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(205, Short.MAX_VALUE))
        );
        pnlCadastroClienteLayout.setVerticalGroup(
            pnlCadastroClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCadastroClienteLayout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(pnlCadastroClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNomeCliente)
                    .addComponent(txtNomeCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCelular)
                    .addComponent(txtCelular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlCadastroClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblRG)
                    .addComponent(txtDataDeNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCPF)
                    .addComponent(txtCPF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(pnlCadastroClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTelefone)
                    .addComponent(cmbEstadoCivil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblEmail))
                .addGap(24, 24, 24)
                .addGroup(pnlCadastroClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblEndereco)
                    .addComponent(lblNumEndereco)
                    .addComponent(txtNumEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCEP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCEP))
                .addGap(18, 18, 18)
                .addGroup(pnlCadastroClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblBairro)
                    .addComponent(txtBairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCidade)
                    .addComponent(txtCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblComplemento)
                    .addComponent(txtComplemento, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblUF)
                    .addComponent(cmbEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 74, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addGroup(pnlCadastroClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancelarCadastroCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(141, 141, 141))
        );

        tbbPnlTela.addTab("Cadastro Cliente", pnlCadastroCliente);

        pnlTProduto.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        pnlTProduto.setPreferredSize(new java.awt.Dimension(568, 380));

        lblCodigo.setText("Código:");

        btnConsultarProduto.setText("Consultar");
        btnConsultarProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultarProdutoActionPerformed(evt);
            }
        });

        btnAlterarProduto.setText("Alterar");
        btnAlterarProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarProdutoActionPerformed(evt);
            }
        });

        btnExcluirProduto.setText("Excluir");
        btnExcluirProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirProdutoActionPerformed(evt);
            }
        });

        tblConsultarProduto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "Nome", "Valor", "QTD"
            }
        ));
        jScrollPane4.setViewportView(tblConsultarProduto);

        javax.swing.GroupLayout pnlTProdutoLayout = new javax.swing.GroupLayout(pnlTProduto);
        pnlTProduto.setLayout(pnlTProdutoLayout);
        pnlTProdutoLayout.setHorizontalGroup(
            pnlTProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlTProdutoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlTProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtNomeConsultaProduto)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 357, Short.MAX_VALUE))
                .addGroup(pnlTProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlTProdutoLayout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(btnConsultarProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlTProdutoLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(pnlTProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnAlterarProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnExcluirProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(20, 20, 20))
        );
        pnlTProdutoLayout.setVerticalGroup(
            pnlTProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTProdutoLayout.createSequentialGroup()
                .addGroup(pnlTProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlTProdutoLayout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(pnlTProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblCodigo)
                            .addComponent(txtNomeConsultaProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(pnlTProdutoLayout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(btnConsultarProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlTProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlTProdutoLayout.createSequentialGroup()
                        .addComponent(btnAlterarProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 195, Short.MAX_VALUE)
                        .addComponent(btnExcluirProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(24, 24, 24))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(185, 185, 185)
                .addComponent(pnlTProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 556, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(232, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(pnlTProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 367, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(145, Short.MAX_VALUE))
        );

        tbbPnlTela.addTab("Consulta Produto", jPanel4);

        pnlTCliente.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        pnlTCliente.setPreferredSize(new java.awt.Dimension(568, 380));

        lblNome.setText("Nome:");

        btnConsultarCliente.setText("Consultar");
        btnConsultarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultarClienteActionPerformed(evt);
            }
        });

        btnAlterarCliente.setText("Alterar");
        btnAlterarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarClienteActionPerformed(evt);
            }
        });

        btnExcluirCliente.setText("Excluir");
        btnExcluirCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirClienteActionPerformed(evt);
            }
        });

        jScrollPane2.setPreferredSize(new java.awt.Dimension(300, 402));

        tblConsultarCliente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nome", "CPF", "Telefone", "Email", "Estado Civil", "Data Nascimento", "Endereço", "Numero", "CEP", "Bairro", "Cidade", "Complemento", "UF"
            }
        ));
        tblConsultarCliente.setPreferredSize(new java.awt.Dimension(200, 56));
        jScrollPane2.setViewportView(tblConsultarCliente);

        javax.swing.GroupLayout pnlTClienteLayout = new javax.swing.GroupLayout(pnlTCliente);
        pnlTCliente.setLayout(pnlTClienteLayout);
        pnlTClienteLayout.setHorizontalGroup(
            pnlTClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTClienteLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlTClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlTClienteLayout.createSequentialGroup()
                        .addComponent(lblNome, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNomeCliente1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 426, Short.MAX_VALUE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlTClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnConsultarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlTClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(btnExcluirCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnAlterarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        pnlTClienteLayout.setVerticalGroup(
            pnlTClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTClienteLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(pnlTClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnConsultarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlTClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtNomeCliente1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblNome)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlTClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlTClienteLayout.createSequentialGroup()
                        .addComponent(btnAlterarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnExcluirCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlTClienteLayout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 475, Short.MAX_VALUE)
                        .addGap(3, 3, 3)))
                .addContainerGap())
        );

        javax.swing.GroupLayout pnlConsultaClienteLayout = new javax.swing.GroupLayout(pnlConsultaCliente);
        pnlConsultaCliente.setLayout(pnlConsultaClienteLayout);
        pnlConsultaClienteLayout.setHorizontalGroup(
            pnlConsultaClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlConsultaClienteLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlTCliente, javax.swing.GroupLayout.DEFAULT_SIZE, 961, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnlConsultaClienteLayout.setVerticalGroup(
            pnlConsultaClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlConsultaClienteLayout.createSequentialGroup()
                .addComponent(pnlTCliente, javax.swing.GroupLayout.DEFAULT_SIZE, 554, Short.MAX_VALUE)
                .addContainerGap())
        );

        tbbPnlTela.addTab("Consulta Cliente", pnlConsultaCliente);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(tbbPnlTela, javax.swing.GroupLayout.PREFERRED_SIZE, 973, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 27, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(tbbPnlTela, javax.swing.GroupLayout.PREFERRED_SIZE, 595, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtCodigo1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodigo1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodigo1ActionPerformed

    private void txtNome1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNome1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNome1ActionPerformed

    private void txtValor1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtValor1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtValor1ActionPerformed

    private void txtQuantidade1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtQuantidade1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtQuantidade1ActionPerformed

    private void btnAdicionar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionar1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAdicionar1ActionPerformed

    private void btnCancelarVenda1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarVenda1ActionPerformed
        tblCarrinho1.removeAll();
    }//GEN-LAST:event_btnCancelarVenda1ActionPerformed

    private void btnConfirmarVenda1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmarVenda1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnConfirmarVenda1ActionPerformed

    private void txtCodigo1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodigo1KeyTyped
        char a = evt.getKeyChar();
        if (a < '0' || a > '9') {
            evt.consume();

        }
    }//GEN-LAST:event_txtCodigo1KeyTyped

    private void txtQuantidade1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtQuantidade1KeyTyped
        char a = evt.getKeyChar();
        if (a < '0' || a > '9') {
            evt.consume();

        }
    }//GEN-LAST:event_txtQuantidade1KeyTyped

    private void btnCancelarVenda1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCancelarVenda1MouseClicked
        DefaultTableModel model = (DefaultTableModel) tblCarrinho1.getModel();
        model.setRowCount(0);
        model.fireTableDataChanged(); // nao estou certo se essa linha eh realmente necessaria
        tblCarrinho1.updateUI();

        double valorTotal = 0;
        for (int i = 0; i < tblCarrinho1.getRowCount(); i++) {
            Object a = tblCarrinho1.getValueAt(i, 4);
            String b = String.valueOf(a);
            Double c = Double.parseDouble(b);
            valorTotal += c;
        }
        String valor = String.valueOf(valorTotal);

        lblTotalDeVendasVendas.setText("R$ " + valor);
    }//GEN-LAST:event_btnCancelarVenda1MouseClicked

    private void btnAdicionar1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAdicionar1MouseClicked
        String codigo = "1";
        if (!txtCodigo1.getText().equals(codigo)) {
            JOptionPane.showMessageDialog(rootPane, "Código Não Encontrado");
            return;
        }
        DefaultTableModel model = (DefaultTableModel) tblCarrinho1.getModel();
        //model.addRow(new Object[] {txtNome1.getText(), txtCodigo1.getText(), txtValor1.getText(), txtQuantidade1.getText(), String.valueOf(Double.parseDouble(txtQuantidade1.getText(). * txtValor1.getText()))});
        Vector row = new Vector();
        String subtotal = String.valueOf(Double.parseDouble(txtQuantidade1.getText()) * Double.parseDouble(txtValor1.getText()));
        row.add(txtNome1.getText());
        row.add(txtCodigo1.getText());
        row.add(txtQuantidade1.getText());
        row.add(txtValor1.getText());
        row.add(subtotal);
        model.addRow(row);
        model.fireTableDataChanged(); // nao estou certo se essa linha eh realmente necessaria
        tblCarrinho1.updateUI();
        txtCodigo1.setText("");
        txtNome1.setText("");
        txtQuantidade1.setText("");
        txtValor1.setText("");


        double valorTotal = 0;
        for (int i = 0; i < tblCarrinho1.getRowCount(); i++) {
            Object a = tblCarrinho1.getValueAt(i, 4);
            String b = String.valueOf(a);
            Double c = Double.parseDouble(b);
            valorTotal += c;
        }
        String valor = String.valueOf(valorTotal);

        lblTotalDeVendasVendas.setText("R$ " + valor);
    }//GEN-LAST:event_btnAdicionar1MouseClicked

    private void txtValor1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtValor1KeyTyped
        char a = evt.getKeyChar();
        if (a == ',') {
            evt.setKeyChar('.');
        }
    }//GEN-LAST:event_txtValor1KeyTyped

    private void btnBuscar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscar1ActionPerformed

    }//GEN-LAST:event_btnBuscar1ActionPerformed

    private void btnBuscar1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBuscar1MouseClicked
        String codigo = "1";
        if (txtCodigo1.getText().equals(codigo)) {
            txtValor1.setText("250");
            txtNome1.setText("Bola de Boliche");
        } else {
            JOptionPane.showMessageDialog(rootPane, "Código Não Encontrado");
        }
    }//GEN-LAST:event_btnBuscar1MouseClicked

    private void txtComplementoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtComplementoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtComplementoActionPerformed

    private void txtTamanhoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTamanhoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTamanhoActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        
    }//GEN-LAST:event_jTable1MouseClicked

    private void txtValorKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtValorKeyTyped
char a = evt.getKeyChar();
        if (a < '0' || a > '9') {
            evt.consume();

        }        // TODO add your handling code here:
    }//GEN-LAST:event_txtValorKeyTyped

    private void tblCarrinho1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblCarrinho1MouseClicked
        
    }//GEN-LAST:event_tblCarrinho1MouseClicked

    private void btnExcluirVendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirVendaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnExcluirVendaActionPerformed

    private void btnExcluirVendaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnExcluirVendaMouseClicked
        int a = tblCarrinho1.getSelectedRow();
        DefaultTableModel model = (DefaultTableModel) tblCarrinho1.getModel();
        model.removeRow(a);
        model.fireTableDataChanged(); // nao estou certo se essa linha eh realmente necessaria
        tblCarrinho1.updateUI();
        
        double valorTotal = 0;
        for (int i = 0; i < tblCarrinho1.getRowCount(); i++) {
            Object d = tblCarrinho1.getValueAt(i, 4);
            String b = String.valueOf(a);
            Double c = Double.parseDouble(b);
            valorTotal += c;
        }
        String valor = String.valueOf(valorTotal);

        lblTotalDeVendasVendas.setText("R$ " + valor);
        
        
    }//GEN-LAST:event_btnExcluirVendaMouseClicked

    private void btnDetalhesRelatorioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDetalhesRelatorioMouseClicked
        TelaRelatorioAnalitico t1 = new TelaRelatorioAnalitico();
        t1.setVisible(true);
        
    }//GEN-LAST:event_btnDetalhesRelatorioMouseClicked

    private void btnSalvarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSalvarMouseClicked
         verificaCamposCliente();
         verificaNumeroMinimo(txtCPF, 11, "CPF");
         verificaVazio(txtNomeCliente, "Cliente");
         verificaVazio(txtBairro, "Bairro");
         verificaVazio(txtCEP, "CEP");
         verificaNumeroMinimo(txtCEP,9,  "CEP");
         verificaVazio(txtEndereco, "Endereço");
         verificaVazio(txtCidade, "Cidade");
         verificaVazio(txtNumEndereco, "Numero");
         verificaVazio(txtComplemento, "Complemento");
         verificaVazio(txtCelular, "Celular");
         verificaVazio(txtDataDeNascimento, "Data de Nascimento");
         
        if(!txtEmail.getText().contains("@") || !txtEmail.getText().contains(".com")){
            txtEmail.setBackground(Color.red); 
        }
        verificaComboBox(cmbEstado, "Estado");
        verificaComboBox(cmbEstadoCivil, "Estado Civil");
        
    }//GEN-LAST:event_btnSalvarMouseClicked

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmarActionPerformed
        // TODO add your handling code here:
        if (txtNomeProduto.getText().isEmpty()) {
            JOptionPane.showMessageDialog(rootPane, "O Nome do produto não pode estar vazio!");
            return;
        }else if (txtMarca.getText().isEmpty()) {
            JOptionPane.showMessageDialog(rootPane, "A marca do produto não pode estar vazio!");
            return;
        }else if (txtValor.getText().isEmpty()) {
            JOptionPane.showMessageDialog(rootPane, "O valor não pode estar vazio!");
            return;
        }

    }//GEN-LAST:event_btnConfirmarActionPerformed

    private void btnConfirmarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnConfirmarMouseClicked
        // TODO add your handling code here:
        if (txtNomeProduto.getText().isEmpty()) {
            JOptionPane.showMessageDialog(rootPane, "O Nome do produto não pode estar vazio!");
            return;
        }else if (txtMarca.getText().isEmpty()) {
            JOptionPane.showMessageDialog(rootPane, "A marca do produto não pode estar vazio!");
            return;
        }else if (txtValor.getText().isEmpty()) {
            JOptionPane.showMessageDialog(rootPane, "O valor não pode estar vazio!");
            return;
        }
    }//GEN-LAST:event_btnConfirmarMouseClicked

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void cboPagamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboPagamentoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboPagamentoActionPerformed

    private void txtNumEnderecoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNumEnderecoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNumEnderecoActionPerformed

    private void txtDataDeNascimentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDataDeNascimentoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDataDeNascimentoActionPerformed

    private void cmbEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbEstadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbEstadoActionPerformed

    private void txtCPFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCPFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCPFActionPerformed

    private void btnDetalhesRelatorioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDetalhesRelatorioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnDetalhesRelatorioActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEditarActionPerformed

    private void txtCPFVendasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCPFVendasActionPerformed
        
    }//GEN-LAST:event_txtCPFVendasActionPerformed

    private void txtCPFVendasKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCPFVendasKeyTyped
        char a = evt.getKeyChar();
        if (a < '0' || a > '9') {
            evt.consume();

        }
        if (txtCPFVendas.getText().length() >= 11){
            evt.consume();
        }
    }//GEN-LAST:event_txtCPFVendasKeyTyped

    private void btnCancelarCadastroClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarCadastroClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCancelarCadastroClienteActionPerformed

    private void btnConsultarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultarClienteActionPerformed

        if (txtNomeCliente1.getText().strip().equals("")) {
            atualizarTabelaCliente();
        } else {
            String cliente = txtNomeCliente1.getText();

            ArrayList<Cliente> list = ClienteDAO.buscarPorNome(cliente);
            DefaultTableModel model = (DefaultTableModel) tblConsultarCliente.getModel();
            model.setRowCount(0);
         for (Cliente client : list) {
            model.addRow(new String[]{
                String.valueOf(client.getId_cliente()),
                client.getNome(),
                client.getCPF(),
                client.getTelefone(),
                client.getEmail(),
                client.getEstadoCivil(),
                client.getDataDeNascimento(),
                client.getEndereco(),
                String.valueOf(client.getNumero()),
                client.getCep(),
                client.getBairro(),
                client.getCidade(),
                client.getComplemento(),
                client.getUf()
                
            });

            }
        }
    }//GEN-LAST:event_btnConsultarClienteActionPerformed

    private void btnAlterarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarClienteActionPerformed
        if(tblConsultarCliente.getSelectedRow() >= 0){
            
            txtNomeCliente.setText(tblConsultarCliente.getValueAt(tblConsultarCliente.getSelectedRow(), 1).toString());
            txtCPF.setText(tblConsultarCliente.getValueAt(tblConsultarCliente.getSelectedRow(), 2).toString());
            txtCelular.setText(tblConsultarCliente.getValueAt(tblConsultarCliente.getSelectedRow(), 3).toString());
            txtEmail.setText(tblConsultarCliente.getValueAt(tblConsultarCliente.getSelectedRow(), 4).toString());
            txtDataDeNascimento.setText(tblConsultarCliente.getValueAt(tblConsultarCliente.getSelectedRow(), 6).toString());
            txtEndereco.setText(tblConsultarCliente.getValueAt(tblConsultarCliente.getSelectedRow(), 7).toString());
            txtNumEndereco.setText(tblConsultarCliente.getValueAt(tblConsultarCliente.getSelectedRow(), 8).toString());
            txtCEP.setText(tblConsultarCliente.getValueAt(tblConsultarCliente.getSelectedRow(), 9).toString());
            txtBairro.setText(tblConsultarCliente.getValueAt(tblConsultarCliente.getSelectedRow(), 10).toString());
            txtCidade.setText(tblConsultarCliente.getValueAt(tblConsultarCliente.getSelectedRow(), 11).toString());
            txtComplemento.setText(tblConsultarCliente.getValueAt(tblConsultarCliente.getSelectedRow(), 12).toString());
            
            String nome = tblConsultarCliente.getValueAt(tblConsultarCliente.getSelectedRow(), 1).toString();
            String cpf = tblConsultarCliente.getValueAt(tblConsultarCliente.getSelectedRow(), 2).toString();
            String telefone = tblConsultarCliente.getValueAt(tblConsultarCliente.getSelectedRow(), 3).toString();
            String email = tblConsultarCliente.getValueAt(tblConsultarCliente.getSelectedRow(), 4).toString();
            String estadoCivil = tblConsultarCliente.getValueAt(tblConsultarCliente.getSelectedRow(), 5).toString();
            String dataNascimento = tblConsultarCliente.getValueAt(tblConsultarCliente.getSelectedRow(), 6).toString();
            
            String endereco = tblConsultarCliente.getValueAt(tblConsultarCliente.getSelectedRow(), 7).toString();
            String numEndereco = tblConsultarCliente.getValueAt(tblConsultarCliente.getSelectedRow(), 8).toString();
            String CEP = tblConsultarCliente.getValueAt(tblConsultarCliente.getSelectedRow(), 9).toString();
            String bairro = tblConsultarCliente.getValueAt(tblConsultarCliente.getSelectedRow(), 10).toString();
            String cidade = tblConsultarCliente.getValueAt(tblConsultarCliente.getSelectedRow(), 11).toString();
            String complemento = tblConsultarCliente.getValueAt(tblConsultarCliente.getSelectedRow(), 12).toString();
            String uf = tblConsultarCliente.getValueAt(tblConsultarCliente.getSelectedRow(), 13).toString();
            objAlterar = new Cliente(nome, cpf, telefone, email, estadoCivil, dataNascimento);
            objAlterar2 = new Endereco(endereco, Integer.parseInt(numEndereco), CEP, bairro, cidade, complemento, uf);
            tbbPnlTela.setSelectedIndex(4);
        }else{
            JOptionPane.showMessageDialog(rootPane, "Selecione uma linha");
        }
    }//GEN-LAST:event_btnAlterarClienteActionPerformed

    private void btnConsultarProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultarProdutoActionPerformed
         if (txtNomeConsultaProduto.getText().strip().equals("")) {
            atualizarTabelaProduto();
        } else {
            String cliente = txtNomeCliente1.getText();
 
            ArrayList<Produto> list = ProdutoDAO.buscarPorNome(cliente);
            DefaultTableModel model = (DefaultTableModel) tblConsultarProduto.getModel();
            model.setRowCount(0);
         for (Produto product : list) {
            model.addRow(new String[]{
                String.valueOf(product.getID()),
                product.getNomeProduto(),
                String.valueOf(product.getValor()),
                String.valueOf(product.getQtdParcelas())
                
            });
         }
         }
    }//GEN-LAST:event_btnConsultarProdutoActionPerformed

    private void btnAlterarProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarProdutoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAlterarProdutoActionPerformed

    private void btnExcluirProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirProdutoActionPerformed
        // TODO add your handling code here:
        if(tblConsultarProduto.getSelectedRow() < 0){
            JOptionPane.showMessageDialog(rootPane, "Selecione uma linha");
        }else {
            boolean retorno = ProdutoDAO.excluir(Integer.parseInt((String) tblConsultarProduto.getValueAt(tblConsultarProduto.getSelectedRow(), 0)));
            if(retorno){
                JOptionPane.showMessageDialog(rootPane, "Sucesso");
                atualizarTabelaCliente();
            }else{
                JOptionPane.showMessageDialog(rootPane, "Falha");
            }
        }
    }//GEN-LAST:event_btnExcluirProdutoActionPerformed

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        TelaConsultas t1 = new TelaConsultas();
        t1.setVisible(true);

    }//GEN-LAST:event_jButton1MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        tbbPnlTela.setSelectedIndex(5);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnExcluirClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirClienteActionPerformed
        if(tblConsultarCliente.getSelectedRow() < 0){
            JOptionPane.showMessageDialog(rootPane, "Selecione uma linha");
        }else {
            boolean retorno = ClienteDAO.excluir(Integer.parseInt((String) tblConsultarCliente.getValueAt(tblConsultarCliente.getSelectedRow(), 0)));
            if(retorno){
                JOptionPane.showMessageDialog(rootPane, "Sucesso");
                atualizarTabelaCliente();
            }else{
                JOptionPane.showMessageDialog(rootPane, "Falha");
            }
    }//GEN-LAST:event_btnExcluirClienteActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        tbbPnlTela.setSelectedIndex(6);
    }//GEN-LAST:event_jButton2ActionPerformed
    }
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
                if ("Windows".equals(info.getName())) {
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
    private javax.swing.JButton btnAdicionar1;
    private javax.swing.JButton btnAlterarCliente;
    private javax.swing.JButton btnAlterarProduto;
    private javax.swing.JButton btnBuscar1;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnCancelarCadastroCliente;
    private javax.swing.JButton btnCancelarVenda1;
    private javax.swing.JButton btnConfirmar;
    private javax.swing.JButton btnConfirmarVenda1;
    private javax.swing.JButton btnConsultarCliente;
    private javax.swing.JButton btnConsultarProduto;
    private javax.swing.JButton btnDetalhesRelatorio;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnExcluirCliente;
    private javax.swing.JButton btnExcluirProduto;
    private javax.swing.JButton btnExcluirVenda;
    private javax.swing.JButton btnFechar;
    private javax.swing.JButton btnImprimir;
    private javax.swing.JButton btnLimpar;
    private javax.swing.JButton btnPesquisar;
    private javax.swing.JButton btnSalvar;
    private com.toedter.calendar.JDateChooser calendarioDataFinal;
    private com.toedter.calendar.JDateChooser calendarioDataInicial;
    private com.toedter.calendar.JDateChooser calendarioVendas;
    private javax.swing.JComboBox<String> cboCategoria;
    private javax.swing.JComboBox<String> cboCor;
    private javax.swing.JComboBox<String> cboPagamento;
    private javax.swing.JComboBox<String> cmbEstado;
    private javax.swing.JComboBox<String> cmbEstadoCivil;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel jblDataInicial;
    private javax.swing.JLabel jblRelatorio;
    private javax.swing.JLabel lblBairro;
    private javax.swing.JLabel lblCEP;
    private javax.swing.JLabel lblCPF;
    private javax.swing.JLabel lblCPFVendas;
    private javax.swing.JLabel lblCategoria;
    private javax.swing.JLabel lblCelular;
    private javax.swing.JLabel lblCidade;
    private javax.swing.JLabel lblCodigo;
    private javax.swing.JLabel lblCodigo1;
    private javax.swing.JLabel lblComplemento;
    private javax.swing.JLabel lblCor;
    private javax.swing.JLabel lblDataFinal;
    private javax.swing.JLabel lblDataVendas;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblEndereco;
    private javax.swing.JLabel lblFormaPagamento;
    private javax.swing.JLabel lblMarca;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblNome1;
    private javax.swing.JLabel lblNomeCliente;
    private javax.swing.JLabel lblNomeProduto;
    private javax.swing.JLabel lblNumEndereco;
    private javax.swing.JLabel lblParcelas;
    private javax.swing.JLabel lblQuantidade1;
    private javax.swing.JLabel lblRG;
    private javax.swing.JLabel lblTamanho;
    private javax.swing.JLabel lblTelefone;
    private javax.swing.JLabel lblTotalDeVendas6;
    private javax.swing.JLabel lblTotalDeVendasVendas;
    private javax.swing.JLabel lblUF;
    private javax.swing.JLabel lblValor;
    private javax.swing.JLabel lblValor1;
    private javax.swing.JLabel lblVendas1;
    private javax.swing.JPanel pnlCadastroCliente;
    private javax.swing.JPanel pnlCadastroProduto;
    private javax.swing.JPanel pnlCarrinho1;
    private javax.swing.JPanel pnlConsultaCliente;
    private javax.swing.JPanel pnlDadosDoProduto1;
    private javax.swing.JPanel pnlRelatorio;
    private javax.swing.JPanel pnlTCliente;
    private javax.swing.JPanel pnlTProduto;
    private javax.swing.JPanel pnlTelaInicial;
    private javax.swing.JPanel pnlTotalDeVendas6;
    private javax.swing.JPanel pnlVendas;
    private javax.swing.JTabbedPane tbbPnlTela;
    private javax.swing.JTable tblCarrinho1;
    private javax.swing.JTable tblConsultarCliente;
    private javax.swing.JTable tblConsultarProduto;
    private javax.swing.JTextField txtBairro;
    private javax.swing.JFormattedTextField txtCEP;
    private javax.swing.JFormattedTextField txtCPF;
    private javax.swing.JTextField txtCPFVendas;
    private javax.swing.JFormattedTextField txtCelular;
    private javax.swing.JTextField txtCidade;
    private javax.swing.JTextField txtCodigo1;
    private javax.swing.JTextField txtComplemento;
    private javax.swing.JFormattedTextField txtDataDeNascimento;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtEndereco;
    private javax.swing.JTextField txtMarca;
    private javax.swing.JTextField txtNome1;
    private javax.swing.JTextField txtNomeCliente;
    private javax.swing.JTextField txtNomeCliente1;
    private javax.swing.JTextField txtNomeConsultaProduto;
    private javax.swing.JTextField txtNomeProduto;
    private javax.swing.JFormattedTextField txtNumEndereco;
    private javax.swing.JTextField txtQuantidade1;
    private javax.swing.JTextField txtTamanho;
    private javax.swing.JTextField txtValor;
    private javax.swing.JTextField txtValor1;
    // End of variables declaration//GEN-END:variables
}
