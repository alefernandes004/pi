/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package telas;

import DAO.ClienteDAO;
import DAO.ProdutoDAO;
import DAO.PedidoDAO;
import classes.Cliente;
import classes.ItemPedido;
import classes.Pedido;
import classes.Produto;
import java.awt.Color;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Vector;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author juan.adsantos
 */
public class TelaInicial extends javax.swing.JFrame {

    public Cliente objAlterar = null;
    public Pedido objPedido = new Pedido();
    private void atualizarPaginaVendas(){
        txtCPF2.setText("");
        txtCodigo1.setText("");
        txtQuantidade1.setText("");
        DefaultTableModel model = (DefaultTableModel) tblCarrinho1.getModel();
        model.setRowCount(0);
                double valorTotal = 0;
        for (int i = 0; i < tblCarrinho1.getRowCount(); i++) {
            Object d = tblCarrinho1.getValueAt(i, 4);
            String b = String.valueOf(d);
            Double c = Double.parseDouble(b);
            valorTotal += c;
        }
        String valor = String.valueOf(valorTotal);

        lblTotalDeVendasVendas.setText(valor);
        
    }
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
                cliente.getLogradouro(),
                cliente.getEndereco(),
                cliente.getNumero()
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
                String.valueOf(product.getTamanho()),
                product.getMarca(),
                product.getCor(),
                product.getCategoria(),
                String.valueOf(product.getValor()),
                product.getFormaDePagamento(),
                String.valueOf(product.getQtdProduto())

            });

        }
    }

    public void verificaCamposCliente() {
        if (objAlterar != null) {
            String nome = txtNomeCliente.getText();
            String cpf = txtCPF.getText();
            String telefone = txtCelular.getText();
            String email = txtEmail.getText();
            String estadoCivil1 = cmbEstadoCivil.getSelectedItem().toString();

            String dataNascimento = txtDataDeNascimento.getText();
            String dia = dataNascimento.substring(0, 2);
            String mes = dataNascimento.substring(2, 4);
            String ano = dataNascimento.substring(4, 8);
            String diaCerto = ano + "-" + mes + "-" + dia;

            String logradouro = cmbLogradouro.getSelectedItem().toString();
            String endereco = txtEndereco.getText();
            String num = txtNumEndereco.getText();

            String id = tblConsultarCliente.getValueAt(tblConsultarCliente.getSelectedRow(), 0).toString();
            int idCerto = Integer.parseInt(id);
            objAlterar.setId_cliente(idCerto);
            objAlterar.setNome(nome);
            objAlterar.setCPF(cpf);
            objAlterar.setTelefone(telefone);
            objAlterar.setEmail(email);
            objAlterar.setEstadoCivil(estadoCivil1);
            objAlterar.setDataDeNascimento(diaCerto);
            objAlterar.setLogradouro(logradouro);
            objAlterar.setEndereco(endereco);
            objAlterar.setNumero(num);
            boolean retorno = ClienteDAO.alterar(objAlterar);

            if (retorno) {
                JOptionPane.showMessageDialog(rootPane, "Alteração concluida");
                limparCamposCliente();
                objAlterar = null;
            } else {
                JOptionPane.showMessageDialog(rootPane, "Alteração falhou");
            }
        } else {
            if (!(txtCPF.getText().length() < 11 || txtNomeCliente.getText().length() == 0 || cmbEstadoCivil.getSelectedIndex() == 0 || txtEndereco.getText().length() == 0 || txtNumEndereco.getText().length() < 0 || txtEndereco.getText().length() == 0 || !txtEmail.getText().contains("@") || !txtEmail.getText().contains(".com") || txtCelular.getText().length() > 20)) {
                int a = cmbEstadoCivil.getSelectedIndex();
                String estadoCivil = cmbEstadoCivil.getItemAt(a);
                int b = cmbLogradouro.getSelectedIndex();
                String estado = cmbLogradouro.getItemAt(b);
                String dataNascimento = txtDataDeNascimento.getText();
                String dia = dataNascimento.substring(0, 2);
                String mes = dataNascimento.substring(2, 4);
                String ano = dataNascimento.substring(4, 8);
                String diaCerto = ano + "-" + mes + "-" + dia;

                Cliente c1 = new Cliente(txtNomeCliente.getText(), txtCPF.getText(), txtCelular.getText(), txtEmail.getText(), estadoCivil, diaCerto, estado, txtEndereco.getText(), txtNumEndereco.getText());
                boolean retornoCliente = ClienteDAO.salvar(c1);

                if (retornoCliente) {
                    JOptionPane.showMessageDialog(rootPane, "Cliente salvo");
                    limparCamposCliente();
                    return;

                } else {
                    JOptionPane.showMessageDialog(rootPane, "Erro ao salvar no Banco de Dados");
                }

            } else {
                JOptionPane.showMessageDialog(rootPane, "Há informações incorretas");
            }
        }

    }

    public void limparCamposCliente() {
        txtCPF.setText("");
        txtCPF.setBackground(Color.white);
        txtNomeCliente.setText("");
        txtNomeCliente.setBackground(Color.white);
        txtEndereco.setText("");
        txtEndereco.setBackground(Color.white);
        txtEmail.setText("");
        txtEmail.setBackground(Color.white);
        txtNumEndereco.setText("");
        txtNumEndereco.setBackground(Color.white);
        txtCelular.setText("");
        txtCelular.setBackground(Color.white);
        txtDataDeNascimento.setText("");
        txtDataDeNascimento.setBackground(Color.white);
        cmbLogradouro.setSelectedIndex(0);
        cmbLogradouro.setBackground(Color.white);
        cmbEstadoCivil.setSelectedIndex(0);
        cmbEstadoCivil.setBackground(Color.white);
        return;
    }

    public void limparCamposProduto() {
        txtID.setText("");
        txtNomeProduto.setText("");
        txtTamanho.setText("");
        txtMarca.setText("");
        txtValor.setText("");
        jSpinner1.setValue(0);
    }

    public void verificaNumeroMinimo(JTextField a, int b, String c) {

        if (a.getText().length() < b || a.getText().isEmpty()) {
            a.setBackground(Color.red);

        }
    }

    public void verificaVazio(JTextField a, String b) {
        if (a.getText().isEmpty()) {
            a.setBackground(Color.red);

        }
    }

    public void verificaComboBox(JComboBox a, String b) {
        if (a.getSelectedIndex() == 0) {
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
        pnlVendas = new javax.swing.JPanel();
        lblVendas1 = new javax.swing.JLabel();
        pnlDadosDoCliente2 = new javax.swing.JPanel();
        lblCPF2 = new javax.swing.JLabel();
        txtCPF2 = new javax.swing.JTextField();
        lblData2 = new javax.swing.JLabel();
        btnPesquisar2 = new javax.swing.JButton();
        btnLimpar2 = new javax.swing.JButton();
        txtDataAtual = new javax.swing.JTextField();
        lblProcurarCliente = new javax.swing.JLabel();
        pnlDadosDoProduto1 = new javax.swing.JPanel();
        lblCodigo1 = new javax.swing.JLabel();
        lblNome1 = new javax.swing.JLabel();
        lblValor1 = new javax.swing.JLabel();
        lblQuantidade1 = new javax.swing.JLabel();
        txtCodigo1 = new javax.swing.JTextField();
        btnBuscar1 = new javax.swing.JButton();
        txtQuantidade1 = new javax.swing.JTextField();
        btnAdicionar1 = new javax.swing.JButton();
        lblMostrarValor = new javax.swing.JLabel();
        lblMostrarNome = new javax.swing.JLabel();
        pnlCarrinho1 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblCarrinho1 = new javax.swing.JTable();
        btnExcluirVenda = new javax.swing.JButton();
        pnlTotalDeVendas6 = new javax.swing.JPanel();
        lblTotalDeVendas6 = new javax.swing.JLabel();
        lblTotalDeVendasVendas = new javax.swing.JLabel();
        btnCancelarVenda1 = new javax.swing.JButton();
        btnConfirmarVenda1 = new javax.swing.JButton();
        pnlRelatorio = new javax.swing.JPanel();
        jblDataInicial = new javax.swing.JLabel();
        lblDataFinal = new javax.swing.JLabel();
        btnImprimir = new javax.swing.JButton();
        btnFechar = new javax.swing.JButton();
        jblRelatorio = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jFormattedTextField1 = new javax.swing.JFormattedTextField();
        jFormattedTextField2 = new javax.swing.JFormattedTextField();
        btnExcluirRelatorio = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        pnlCadastroCliente = new javax.swing.JPanel();
        lblEmail = new javax.swing.JLabel();
        lblRG = new javax.swing.JLabel();
        txtNomeCliente = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        lblCelular = new javax.swing.JLabel();
        txtCelular = new javax.swing.JTextField();
        lblEstadoCivil = new javax.swing.JLabel();
        lblNumEndereco = new javax.swing.JLabel();
        txtNumEndereco = new javax.swing.JTextField();
        lblCPF = new javax.swing.JLabel();
        txtCPF = new javax.swing.JTextField();
        btnSalvar = new javax.swing.JButton();
        btnLimpar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        cmbEstadoCivil = new javax.swing.JComboBox<>();
        txtDataDeNascimento = new javax.swing.JFormattedTextField();
        btnConsulta = new javax.swing.JButton();
        lblLogradouro = new javax.swing.JLabel();
        cmbLogradouro = new javax.swing.JComboBox<>();
        lblEndereco1 = new javax.swing.JLabel();
        txtEndereco = new javax.swing.JTextField();
        lblNomeCliente = new javax.swing.JLabel();
        pnlCadastroProduto = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        lblID = new javax.swing.JLabel();
        lblNomeProduto = new javax.swing.JLabel();
        txtNomeProduto = new javax.swing.JTextField();
        lblTamanho = new javax.swing.JLabel();
        txtTamanho = new javax.swing.JTextField();
        lblMarca = new javax.swing.JLabel();
        txtMarca = new javax.swing.JTextField();
        lblCor = new javax.swing.JLabel();
        lblCategoria = new javax.swing.JLabel();
        cboCor = new javax.swing.JComboBox<>();
        cboCategoria = new javax.swing.JComboBox<>();
        txtID = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        lblValor = new javax.swing.JLabel();
        lblFormaPagamento = new javax.swing.JLabel();
        cboPagamento = new javax.swing.JComboBox<>();
        lblParcelas = new javax.swing.JLabel();
        jSpinner1 = new javax.swing.JSpinner();
        txtValor = new javax.swing.JTextField();
        btnConfirmar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        pnlConsultarCliente = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblConsultarCliente = new javax.swing.JTable();
        btnListar = new javax.swing.JButton();
        btnExcluir1 = new javax.swing.JButton();
        btnAlterar = new javax.swing.JButton();
        lblNomeConsultaCliente = new javax.swing.JLabel();
        txtNomeConsultaCliente = new javax.swing.JTextField();
        pnlConsultarProduto = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblConsultarProduto = new javax.swing.JTable();
        lblNomeConsultaProduto = new javax.swing.JLabel();
        btnConsultarProduto = new javax.swing.JButton();
        btnExcluirProduto = new javax.swing.JButton();
        txtNomeConsultaProduto = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setSize(new java.awt.Dimension(1000, 600));

        tbbPnlTela.setMinimumSize(new java.awt.Dimension(900, 68));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel2.setText("Bem-vinde todes");

        javax.swing.GroupLayout pnlTelaInicialLayout = new javax.swing.GroupLayout(pnlTelaInicial);
        pnlTelaInicial.setLayout(pnlTelaInicialLayout);
        pnlTelaInicialLayout.setHorizontalGroup(
            pnlTelaInicialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTelaInicialLayout.createSequentialGroup()
                .addGap(388, 388, 388)
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlTelaInicialLayout.createSequentialGroup()
                .addContainerGap(1950, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 498, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(291, 291, 291))
        );
        pnlTelaInicialLayout.setVerticalGroup(
            pnlTelaInicialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTelaInicialLayout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 340, Short.MAX_VALUE)
                .addGap(105, 105, 105))
        );

        tbbPnlTela.addTab("Tela Inicial", pnlTelaInicial);

        lblVendas1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lblVendas1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblVendas1.setText("Vendas");

        pnlDadosDoCliente2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(null, "Dados do Cliente", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION)));

        lblCPF2.setText("CPF:");

        txtCPF2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCPF2ActionPerformed(evt);
            }
        });
        txtCPF2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCPF2KeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCPF2KeyTyped(evt);
            }
        });

        lblData2.setText("Data:");

        btnPesquisar2.setText("Pesquisar");
        btnPesquisar2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnPesquisar2MouseClicked(evt);
            }
        });
        btnPesquisar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisar2ActionPerformed(evt);
            }
        });

        btnLimpar2.setText("Limpar");
        btnLimpar2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnLimpar2MouseClicked(evt);
            }
        });
        btnLimpar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpar2ActionPerformed(evt);
            }
        });

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
        SimpleDateFormat sdf2 = new SimpleDateFormat("MM");
        SimpleDateFormat sdf3 = new SimpleDateFormat("dd");
        String dia =sdf3.format(new Date());
        String mes = sdf2.format(new Date());
        String ano = sdf.format(new Date());
        txtDataAtual.setText(dia + "/" + mes + "/" + ano);
        txtDataAtual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDataAtualActionPerformed(evt);
            }
        });

        lblProcurarCliente.setText("Digite o CPF do cliente no campo acima e veja se encontra o Cliente");

        javax.swing.GroupLayout pnlDadosDoCliente2Layout = new javax.swing.GroupLayout(pnlDadosDoCliente2);
        pnlDadosDoCliente2.setLayout(pnlDadosDoCliente2Layout);
        pnlDadosDoCliente2Layout.setHorizontalGroup(
            pnlDadosDoCliente2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDadosDoCliente2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlDadosDoCliente2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlDadosDoCliente2Layout.createSequentialGroup()
                        .addComponent(lblCPF2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCPF2, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33)
                        .addComponent(lblData2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtDataAtual, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlDadosDoCliente2Layout.createSequentialGroup()
                        .addComponent(btnPesquisar2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnLimpar2))
                    .addComponent(lblProcurarCliente))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlDadosDoCliente2Layout.setVerticalGroup(
            pnlDadosDoCliente2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDadosDoCliente2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlDadosDoCliente2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCPF2)
                    .addComponent(txtCPF2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblData2)
                    .addComponent(txtDataAtual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                .addComponent(lblProcurarCliente)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlDadosDoCliente2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLimpar2)
                    .addComponent(btnPesquisar2))
                .addContainerGap())
        );

        pnlDadosDoProduto1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(null, "Dados do Cliente", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION), "Dados do Produto"));

        lblCodigo1.setText("Código:");

        lblNome1.setText("Nome:");

        lblValor1.setText("Valor:");

        lblQuantidade1.setText("Quantidade:");

        txtCodigo1.setText("1");
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
                        .addComponent(txtCodigo1, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBuscar1))
                    .addGroup(pnlDadosDoProduto1Layout.createSequentialGroup()
                        .addGroup(pnlDadosDoProduto1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlDadosDoProduto1Layout.createSequentialGroup()
                                .addComponent(lblNome1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblMostrarNome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlDadosDoProduto1Layout.createSequentialGroup()
                                .addComponent(lblValor1)
                                .addGap(18, 18, 18)
                                .addComponent(lblMostrarValor, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblQuantidade1)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtQuantidade1, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlDadosDoProduto1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnAdicionar1, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                .addGroup(pnlDadosDoProduto1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblNome1)
                    .addComponent(lblMostrarNome, javax.swing.GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlDadosDoProduto1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblValor1)
                    .addComponent(lblQuantidade1)
                    .addComponent(txtQuantidade1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblMostrarValor, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnAdicionar1, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
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
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 2314, Short.MAX_VALUE)
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
        lblTotalDeVendas6.setText("Total de Vendas: R$");

        lblTotalDeVendasVendas.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        lblTotalDeVendasVendas.setText("0");

        javax.swing.GroupLayout pnlTotalDeVendas6Layout = new javax.swing.GroupLayout(pnlTotalDeVendas6);
        pnlTotalDeVendas6.setLayout(pnlTotalDeVendas6Layout);
        pnlTotalDeVendas6Layout.setHorizontalGroup(
            pnlTotalDeVendas6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTotalDeVendas6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTotalDeVendas6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTotalDeVendasVendas)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                            .addComponent(pnlDadosDoCliente2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(pnlDadosDoProduto1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlVendasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pnlCarrinho1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(pnlTotalDeVendas6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(pnlVendasLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(btnConfirmarVenda1, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnCancelarVenda1, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(22, 22, 22))
        );
        pnlVendasLayout.setVerticalGroup(
            pnlVendasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlVendasLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblVendas1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlVendasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlVendasLayout.createSequentialGroup()
                        .addComponent(pnlCarrinho1, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pnlTotalDeVendas6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlVendasLayout.createSequentialGroup()
                        .addComponent(pnlDadosDoCliente2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pnlDadosDoProduto1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(pnlVendasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnConfirmarVenda1, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancelarVenda1, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(55, Short.MAX_VALUE))
        );

        tbbPnlTela.addTab("Vendas", pnlVendas);

        pnlRelatorio.setPreferredSize(new java.awt.Dimension(1000, 661));

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
                {"16/04/2024", "Josemires", "800"},
                {null, null, null},
                {null, null, null}
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

        jFormattedTextField1.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(java.text.DateFormat.getDateInstance(java.text.DateFormat.SHORT))));

        jFormattedTextField2.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(java.text.DateFormat.getDateInstance(java.text.DateFormat.SHORT))));
        jFormattedTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jFormattedTextField2ActionPerformed(evt);
            }
        });

        btnExcluirRelatorio.setText("Detalhes");
        btnExcluirRelatorio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnExcluirRelatorioMouseClicked(evt);
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
                        .addGap(256, 256, 256)
                        .addGroup(pnlRelatorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jblDataInicial)
                            .addComponent(jFormattedTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(238, 238, 238)
                        .addGroup(pnlRelatorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblDataFinal)
                            .addComponent(jFormattedTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(pnlRelatorioLayout.createSequentialGroup()
                        .addGap(348, 348, 348)
                        .addComponent(btnImprimir, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(68, 68, 68)
                        .addComponent(btnFechar, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlRelatorioLayout.createSequentialGroup()
                        .addGap(219, 219, 219)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 549, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnExcluirRelatorio))
                    .addGroup(pnlRelatorioLayout.createSequentialGroup()
                        .addGap(408, 408, 408)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(1890, Short.MAX_VALUE))
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
                        .addComponent(jFormattedTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlRelatorioLayout.createSequentialGroup()
                        .addComponent(lblDataFinal)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jFormattedTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(pnlRelatorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlRelatorioLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnExcluirRelatorio))
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

        lblEmail.setText("E-mail:");

        lblRG.setText("Data de Nascimento: ");

        txtEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEmailActionPerformed(evt);
            }
        });

        lblCelular.setText("Celular:");

        txtCelular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCelularActionPerformed(evt);
            }
        });
        txtCelular.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCelularKeyTyped(evt);
            }
        });

        lblEstadoCivil.setText("Estado Civil:*");

        lblNumEndereco.setText("Número:");

        txtNumEndereco.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNumEnderecoKeyTyped(evt);
            }
        });

        lblCPF.setText("CPF:");

        txtCPF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCPFActionPerformed(evt);
            }
        });
        txtCPF.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCPFKeyTyped(evt);
            }
        });

        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        btnLimpar.setText("Limpar");
        btnLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparActionPerformed(evt);
            }
        });

        btnExcluir.setText("Excluir");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        cmbEstadoCivil.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Escolher", "Solteiro", "Casado", "Divorciado", "Viuvo", "Uniao Estavel" }));

        txtDataDeNascimento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDataDeNascimentoActionPerformed(evt);
            }
        });

        btnConsulta.setText("Consulta");
        btnConsulta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultaActionPerformed(evt);
            }
        });

        lblLogradouro.setText("Logradouro:*");

        cmbLogradouro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Escolher", "Rua", "Avenida ", "Condominio", "Outro " }));

        lblEndereco1.setText("Endereço:*");

        lblNomeCliente.setText("Nome:");

        javax.swing.GroupLayout pnlCadastroClienteLayout = new javax.swing.GroupLayout(pnlCadastroCliente);
        pnlCadastroCliente.setLayout(pnlCadastroClienteLayout);
        pnlCadastroClienteLayout.setHorizontalGroup(
            pnlCadastroClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCadastroClienteLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlCadastroClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlCadastroClienteLayout.createSequentialGroup()
                        .addGroup(pnlCadastroClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(pnlCadastroClienteLayout.createSequentialGroup()
                                .addComponent(lblRG)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtDataDeNascimento)
                                .addGap(455, 455, 455))
                            .addGroup(pnlCadastroClienteLayout.createSequentialGroup()
                                .addGroup(pnlCadastroClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlCadastroClienteLayout.createSequentialGroup()
                                        .addComponent(lblCelular)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtCelular)
                                        .addGap(22, 22, 22))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlCadastroClienteLayout.createSequentialGroup()
                                        .addComponent(lblLogradouro)
                                        .addGap(5, 5, 5)
                                        .addComponent(cmbLogradouro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(lblEndereco1)))
                                .addGap(5, 5, 5)
                                .addComponent(txtEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lblNumEndereco)
                                .addGap(5, 5, 5)
                                .addComponent(txtNumEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnlCadastroClienteLayout.createSequentialGroup()
                                .addGap(77, 77, 77)
                                .addComponent(btnSalvar)
                                .addGap(5, 5, 5)
                                .addComponent(btnLimpar)
                                .addGap(5, 5, 5)
                                .addComponent(btnExcluir)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnConsulta))
                            .addGroup(pnlCadastroClienteLayout.createSequentialGroup()
                                .addComponent(lblCPF)
                                .addGap(5, 5, 5)
                                .addComponent(txtCPF, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(pnlCadastroClienteLayout.createSequentialGroup()
                        .addGroup(pnlCadastroClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlCadastroClienteLayout.createSequentialGroup()
                                .addComponent(lblNomeCliente)
                                .addGap(18, 18, 18)
                                .addComponent(txtNomeCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lblEstadoCivil)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmbEstadoCivil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnlCadastroClienteLayout.createSequentialGroup()
                                .addComponent(lblEmail)
                                .addGap(18, 18, 18)
                                .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        pnlCadastroClienteLayout.setVerticalGroup(
            pnlCadastroClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCadastroClienteLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlCadastroClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtCPF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlCadastroClienteLayout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(lblCPF)))
                .addGap(23, 23, 23)
                .addGroup(pnlCadastroClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNomeCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNomeCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblEstadoCivil)
                    .addComponent(cmbEstadoCivil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlCadastroClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEmail)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlCadastroClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblRG)
                    .addComponent(txtDataDeNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlCadastroClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCelular)
                    .addComponent(txtCelular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlCadastroClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtNumEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlCadastroClienteLayout.createSequentialGroup()
                        .addGroup(pnlCadastroClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cmbLogradouro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(pnlCadastroClienteLayout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addGroup(pnlCadastroClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblLogradouro)
                                    .addComponent(lblNumEndereco)
                                    .addComponent(lblEndereco1))))
                        .addGap(18, 18, 18)
                        .addGroup(pnlCadastroClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnSalvar)
                            .addComponent(btnLimpar)
                            .addGroup(pnlCadastroClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(btnExcluir)
                                .addComponent(btnConsulta)))))
                .addGap(103, 103, 103))
        );

        tbbPnlTela.addTab("Cadastro Cliente", pnlCadastroCliente);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setForeground(new java.awt.Color(153, 153, 153));

        lblID.setText("ID:");

        lblNomeProduto.setText("Nome Produto:");

        txtNomeProduto.setText(" ");
        txtNomeProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNomeProdutoActionPerformed(evt);
            }
        });

        lblTamanho.setText("Tamanho:");

        txtTamanho.setText(" ");
        txtTamanho.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTamanhoActionPerformed(evt);
            }
        });

        lblMarca.setText("Marca:");

        txtMarca.setText(" ");

        lblCor.setText("Cor:");

        lblCategoria.setText("Categoria: ");

        cboCor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Preto", "Branco", "Marrom", "Azul", "Verde" }));

        cboCategoria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tenis", "Blusa", "Camiseta", "Shorts", "Calça" }));

        txtID.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtIDKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblTamanho)
                    .addComponent(lblID)
                    .addComponent(lblCor)
                    .addComponent(lblCategoria))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cboCor, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cboCategoria, 0, 105, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtID)
                            .addComponent(txtTamanho, javax.swing.GroupLayout.DEFAULT_SIZE, 184, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 154, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblMarca, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblNomeProduto, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtNomeProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblID)
                    .addComponent(lblNomeProduto)
                    .addComponent(txtNomeProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTamanho)
                    .addComponent(txtTamanho, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblMarca)
                    .addComponent(txtMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboCor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCor))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCategoria)
                    .addComponent(cboCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(44, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lblValor.setText("Valor:");

        lblFormaPagamento.setText("Forma de Pagamento:");

        cboPagamento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pix", "Dinheiro", "Débito", "Crédito" }));

        lblParcelas.setText("QTD Estoque:");

        txtValor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtValorKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(lblParcelas)
                        .addGap(18, 18, 18)
                        .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(lblValor)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtValor)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblFormaPagamento)
                .addGap(18, 18, 18)
                .addComponent(cboPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(87, 87, 87))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblValor)
                    .addComponent(lblFormaPagamento)
                    .addComponent(cboPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblParcelas)
                    .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        btnConfirmar.setBackground(new java.awt.Color(0, 204, 0));
        btnConfirmar.setText("Confirmar");
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

        javax.swing.GroupLayout pnlCadastroProdutoLayout = new javax.swing.GroupLayout(pnlCadastroProduto);
        pnlCadastroProduto.setLayout(pnlCadastroProdutoLayout);
        pnlCadastroProdutoLayout.setHorizontalGroup(
            pnlCadastroProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCadastroProdutoLayout.createSequentialGroup()
                .addGap(78, 78, 78)
                .addGroup(pnlCadastroProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnlCadastroProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlCadastroProdutoLayout.createSequentialGroup()
                        .addGap(135, 135, 135)
                        .addComponent(btnConfirmar, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(84, 84, 84)
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlCadastroProdutoLayout.setVerticalGroup(
            pnlCadastroProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCadastroProdutoLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnlCadastroProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnConfirmar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(105, 105, 105))
        );

        tbbPnlTela.addTab("Cadastro Produto", pnlCadastroProduto);

        tblConsultarCliente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nome", "CPF", "Telefone", "Email", "Estado Civil", "Data de Nascimento", "Endereco", "Numero", "Logradouro"
            }
        ));
        jScrollPane2.setViewportView(tblConsultarCliente);

        btnListar.setText("Listar");
        btnListar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListarActionPerformed(evt);
            }
        });

        btnExcluir1.setText("Excluir");
        btnExcluir1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluir1ActionPerformed(evt);
            }
        });

        btnAlterar.setText("Alterar");
        btnAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarActionPerformed(evt);
            }
        });

        lblNomeConsultaCliente.setText("Nome:");

        txtNomeConsultaCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNumeroActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlConsultarClienteLayout = new javax.swing.GroupLayout(pnlConsultarCliente);
        pnlConsultarCliente.setLayout(pnlConsultarClienteLayout);
        pnlConsultarClienteLayout.setHorizontalGroup(
            pnlConsultarClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlConsultarClienteLayout.createSequentialGroup()
                .addGroup(pnlConsultarClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlConsultarClienteLayout.createSequentialGroup()
                        .addGap(314, 314, 314)
                        .addComponent(lblNomeConsultaCliente)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNomeConsultaCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlConsultarClienteLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 711, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlConsultarClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAlterar)
                    .addComponent(btnListar)
                    .addComponent(btnExcluir1))
                .addContainerGap())
        );
        pnlConsultarClienteLayout.setVerticalGroup(
            pnlConsultarClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlConsultarClienteLayout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addGroup(pnlConsultarClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNomeConsultaCliente)
                    .addComponent(txtNomeConsultaCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlConsultarClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlConsultarClienteLayout.createSequentialGroup()
                        .addComponent(btnListar)
                        .addGap(18, 18, 18)
                        .addComponent(btnAlterar)
                        .addGap(18, 18, 18)
                        .addComponent(btnExcluir1))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(103, Short.MAX_VALUE))
        );

        tbbPnlTela.addTab("Consultar Cliente", pnlConsultarCliente);

        tblConsultarProduto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Nome", "Tamanho", "Marca", "Cor", "Categoria", "Valor", "Forma de Pagamento", "Qtd Produto"
            }
        ));
        jScrollPane4.setViewportView(tblConsultarProduto);

        lblNomeConsultaProduto.setText("Nome:");

        btnConsultarProduto.setText("Consultar");
        btnConsultarProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultarProdutoActionPerformed(evt);
            }
        });

        btnExcluirProduto.setText("Excluir");
        btnExcluirProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirProdutoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlConsultarProdutoLayout = new javax.swing.GroupLayout(pnlConsultarProduto);
        pnlConsultarProduto.setLayout(pnlConsultarProdutoLayout);
        pnlConsultarProdutoLayout.setHorizontalGroup(
            pnlConsultarProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlConsultarProdutoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblNomeConsultaProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlConsultarProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtNomeConsultaProduto)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 805, Short.MAX_VALUE))
                .addGroup(pnlConsultarProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlConsultarProdutoLayout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(btnConsultarProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlConsultarProdutoLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(btnExcluirProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(20, 20, 20))
        );
        pnlConsultarProdutoLayout.setVerticalGroup(
            pnlConsultarProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlConsultarProdutoLayout.createSequentialGroup()
                .addGroup(pnlConsultarProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlConsultarProdutoLayout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(pnlConsultarProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblNomeConsultaProduto)
                            .addComponent(txtNomeConsultaProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(pnlConsultarProdutoLayout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(btnConsultarProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlConsultarProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlConsultarProdutoLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnExcluirProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 473, Short.MAX_VALUE))
                .addGap(24, 24, 24))
        );

        tbbPnlTela.addTab("Consultar Produto", pnlConsultarProduto);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(tbbPnlTela, javax.swing.GroupLayout.PREFERRED_SIZE, 1000, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tbbPnlTela, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtCPF2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCPF2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCPF2ActionPerformed

    private void btnLimpar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpar2ActionPerformed

    }//GEN-LAST:event_btnLimpar2ActionPerformed

    private void txtCodigo1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodigo1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodigo1ActionPerformed

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
        Cliente clienteVenda = PedidoDAO.buscarPorCPF(txtCPF2.getText().toString());
        if(clienteVenda == null){
            JOptionPane.showMessageDialog(rootPane, "Procure um cliente cadastrado");
        }else{
        DefaultTableModel model = (DefaultTableModel) tblCarrinho1.getModel();
        for (int i = 0; i < model.getRowCount(); i++) {
            ItemPedido novoItem = null;
            
            
            int idProduto = Integer.parseInt(model.getValueAt(i, 1).toString());
            int quantidade = Integer.parseInt(model.getValueAt(i, 2).toString());
            double valor = Double.parseDouble(model.getValueAt(i, 3 ).toString());
            
            novoItem = new ItemPedido(idProduto, quantidade, valor);
            objPedido.getListaItemPedido().add(novoItem);
        }
            objPedido.setValorTotal(Double.parseDouble(lblTotalDeVendasVendas.getText()));
            
            String[] datacerta = txtDataAtual.getText().split("/");
            String dataCorreta = datacerta[2] + "-" + datacerta[1] + "-" + datacerta[0];
            
            objPedido.setDataVenda(dataCorreta);
            objPedido.setId_cliente(clienteVenda.getId_cliente());
            boolean retorno = PedidoDAO.salvar(objPedido);
            if(retorno){
                JOptionPane.showMessageDialog(rootPane, "Venda Concluída");
                atualizarPaginaVendas();
            }else{
                JOptionPane.showMessageDialog(rootPane, "Venda não concluída");
            }
        }
    }//GEN-LAST:event_btnConfirmarVenda1ActionPerformed

    private void txtCPF2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCPF2KeyPressed

    }//GEN-LAST:event_txtCPF2KeyPressed

    private void txtCPF2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCPF2KeyTyped
        if (txtCPF2.getText().length() >= 11) {
            evt.consume();

        }
        char a = evt.getKeyChar();
        if (a < '0' || a > '9') {
            evt.consume();

        }

    }//GEN-LAST:event_txtCPF2KeyTyped

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

        lblTotalDeVendasVendas.setText(valor);
    }//GEN-LAST:event_btnCancelarVenda1MouseClicked

    private void btnAdicionar1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAdicionar1MouseClicked

        DefaultTableModel model = (DefaultTableModel) tblCarrinho1.getModel();
        //model.addRow(new Object[] {txtNome1.getText(), txtCodigo1.getText(), txtValor1.getText(), txtQuantidade1.getText(), String.valueOf(Double.parseDouble(txtQuantidade1.getText(). * txtValor1.getText()))});
        Vector row = new Vector();
        String subtotal = String.valueOf(Double.parseDouble(txtQuantidade1.getText()) * Double.parseDouble(lblMostrarValor.getText()));
        row.add(lblMostrarNome.getText());
        row.add(txtCodigo1.getText());
        row.add(txtQuantidade1.getText());
        row.add(lblMostrarValor.getText());
        row.add(subtotal);
        model.addRow(row);
        model.fireTableDataChanged(); // nao estou certo se essa linha eh realmente necessaria
        tblCarrinho1.updateUI();
        txtCodigo1.setText("");
        lblMostrarNome.setText("");
        txtQuantidade1.setText("");
        lblMostrarValor.setText("");

        double valorTotal = 0;
        for (int i = 0; i < tblCarrinho1.getRowCount(); i++) {
            String a = tblCarrinho1.getValueAt(i, 4).toString();
            Double c = Double.valueOf(a);
            valorTotal += c;
        }
        String valor = String.valueOf(valorTotal);

        lblTotalDeVendasVendas.setText(valor);
    }//GEN-LAST:event_btnAdicionar1MouseClicked

    private void txtDataAtualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDataAtualActionPerformed

    }//GEN-LAST:event_txtDataAtualActionPerformed

    private void btnPesquisar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisar2ActionPerformed

    }//GEN-LAST:event_btnPesquisar2ActionPerformed

    private void btnPesquisar2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPesquisar2MouseClicked
        
        if (txtCPF2.getText().strip().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Digite o CPF do cliente: ");
        } else {
            Cliente clienteVenda = PedidoDAO.buscarPorCPF(txtCPF2.getText().toString());
            if (clienteVenda != null) {
                JOptionPane.showMessageDialog(rootPane, "Cliente encontrado");
            } else {
                JOptionPane.showMessageDialog(rootPane, "Cliente não encontrado");
            }
        }

//        String CPF = "12345678910";
//        if (txtCPF2.getText().length() == 0) {
//            JOptionPane.showMessageDialog(rootPane, "Campo CPF vazio");
//            return;
//        }
//        if (txtCPF2.getText().equals(CPF)) {
//            JOptionPane.showMessageDialog(rootPane, "Usuário Encontrado");
//
//        } else {
//            JOptionPane.showMessageDialog(rootPane, "Usuário Não Encontrado");
//        }
    }//GEN-LAST:event_btnPesquisar2MouseClicked

    private void btnBuscar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscar1ActionPerformed

    }//GEN-LAST:event_btnBuscar1ActionPerformed

    private void btnLimpar2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLimpar2MouseClicked
        txtCPF2.setText("");
        lblProcurarCliente.setText("Digite o CPF do cliente no campo acima e veja se encontra o Cliente");        // TODO add your handling code here:
    }//GEN-LAST:event_btnLimpar2MouseClicked

    private void btnBuscar1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBuscar1MouseClicked
        if (txtCodigo1.getText().strip().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Digite o código do produto:");
        } else {

            String[] resultado = PedidoDAO.buscarCodigoProduto(txtCodigo1.getText());
                lblMostrarValor.setText(resultado[1]);
                lblMostrarNome.setText(resultado[0]);
                if(lblMostrarValor.getText().isEmpty() && lblMostrarNome.getText().isEmpty()){
                    JOptionPane.showMessageDialog(rootPane, "Código não encontrado");
                }
        }
    }//GEN-LAST:event_btnBuscar1MouseClicked


    private void txtNomeProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNomeProdutoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNomeProdutoActionPerformed


    private void txtTamanhoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTamanhoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTamanhoActionPerformed

    private void btnConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmarActionPerformed
        if (txtNomeProduto.getText().isEmpty() || txtTamanho.getText().isEmpty() || txtMarca.getText().isEmpty() || txtValor.getText().isEmpty() || "0".equals(jSpinner1.getValue().toString())) {
            JOptionPane.showMessageDialog(rootPane, "Informações inválidas");
        } else {
            String nome = txtNomeProduto.getText();
            String tamanho = txtTamanho.getText();
            String marca = txtMarca.getText();
            String cor = cboCor.getSelectedItem().toString();
            String categoria = cboCategoria.getSelectedItem().toString();
            double valor = Double.parseDouble(txtValor.getText());
            String formaDePagamento = cboPagamento.getSelectedItem().toString();
            int qtd = Integer.parseInt(jSpinner1.getValue().toString());

            Produto p1 = new Produto(tamanho, cor, nome, marca, categoria, valor, formaDePagamento, qtd);
            boolean retorno = ProdutoDAO.salvar(p1);
            if (retorno) {
                JOptionPane.showMessageDialog(rootPane, "Salvo com sucesso");
                limparCamposProduto();
            } else {
                JOptionPane.showMessageDialog(rootPane, "Não salvo");
            }
        }
    }//GEN-LAST:event_btnConfirmarActionPerformed


    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked

    }//GEN-LAST:event_jTable1MouseClicked

    private void jFormattedTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jFormattedTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jFormattedTextField2ActionPerformed

    private void txtValorKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtValorKeyTyped
        char a = evt.getKeyChar();
        if (a < '0' || a > '9') {
            evt.consume();

        }        // TODO add your handling code here:
    }//GEN-LAST:event_txtValorKeyTyped

    private void txtIDKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIDKeyTyped
        char a = evt.getKeyChar();
        if (a < '0' || a > '9') {
            evt.consume();

        }// TODO add your handling code here:
    }//GEN-LAST:event_txtIDKeyTyped

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
            String b = String.valueOf(d);
            Double c = Double.parseDouble(b);
            valorTotal += c;
        }
        String valor = String.valueOf(valorTotal);

        lblTotalDeVendasVendas.setText(valor);


    }//GEN-LAST:event_btnExcluirVendaMouseClicked

    private void btnExcluirRelatorioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnExcluirRelatorioMouseClicked
        TelaRelatorioAnalitico t1 = new TelaRelatorioAnalitico();
        t1.setVisible(true);

    }//GEN-LAST:event_btnExcluirRelatorioMouseClicked

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed

        // TODO add your handling code here:
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void btnConfirmarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnConfirmarMouseClicked
        // TODO add your handling code here:
        if (txtNomeProduto.getText().isEmpty()) {
            JOptionPane.showMessageDialog(rootPane, "O Nome do produto não pode estar vazio!");
            return;
        } else if (txtMarca.getText().isEmpty()) {
            JOptionPane.showMessageDialog(rootPane, "A marca do produto não pode estar vazio!");
            return;
        } else if (txtValor.getText().isEmpty()) {
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

    private void txtDataDeNascimentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDataDeNascimentoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDataDeNascimentoActionPerformed

    private void txtCPFActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void btnDetalhesRelatorioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDetalhesRelatorioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnDetalhesRelatorioActionPerformed

    private void txtCPFVendasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCPFVendasActionPerformed

    }//GEN-LAST:event_txtCPFVendasActionPerformed

    private void txtCPFVendasKeyTyped(java.awt.event.KeyEvent evt) {

    }

    private void txtCPFKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCPFKeyTyped

        char a = evt.getKeyChar();
        if (a < '0' || a > '9') {
            evt.consume();

        }
        if (txtCPF.getText().length() == 11)
            evt.consume();// TODO add your handling code here:
    }//GEN-LAST:event_txtCPFKeyTyped

    private void txtNumEnderecoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNumEnderecoKeyTyped
        char a = evt.getKeyChar();
        if (a < '0' || a > '9') {
            evt.consume();

        }        // TODO add your handling code here:
    }//GEN-LAST:event_txtNumEnderecoKeyTyped

    private void txtCelularKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCelularKeyTyped
        char a = evt.getKeyChar();
        if (a < '0' || a > '9') {
            evt.consume();

        }        // TODO add your handling code here:
    }//GEN-LAST:event_txtCelularKeyTyped

    private void txtCelularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCelularActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCelularActionPerformed

    private void txtCodigoClienteKeyTyped(java.awt.event.KeyEvent evt) {
        char a = evt.getKeyChar();
        if (a < '0' || a > '9') {
            evt.consume();

            if (txtNomeCliente.getText().strip().equals("")) {
                atualizarTabelaCliente();
            } else {
                String cliente = txtNomeCliente.getText();

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
                        client.getLogradouro(),
                        client.getEndereco(),
                        client.getNumero()

                    });

                }
            }
        }
    }

    private void btnConsultarProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultarProdutoActionPerformed
        if (txtNomeConsultaProduto.getText().strip().equals("")) {
            atualizarTabelaProduto();
        } else {
            int nomeBuscar = Integer.parseInt(txtNomeConsultaProduto.getText());
            ArrayList<Produto> list = ProdutoDAO.buscarPorNome(nomeBuscar);

            DefaultTableModel model = (DefaultTableModel) tblConsultarCliente.getModel();
            model.setRowCount(0);

            for (Produto product : list) {
                model.addRow(new String[]{
                    String.valueOf(product.getID()),
                    product.getNomeProduto(),
                    product.getTamanho(),
                    product.getMarca(),
                    product.getCor(),
                    product.getCategoria(),
                    String.valueOf(product.getValor()),
                    product.getFormaDePagamento(),
                    String.valueOf(product.getQtdProduto())

                });

            }
        }

    }//GEN-LAST:event_btnConsultarProdutoActionPerformed

    private void btnAlterarProdutoActionPerformed(java.awt.event.ActionEvent evt) {

    }

    private void btnListarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListarActionPerformed
        if (txtNomeConsultaCliente.getText().strip().equals("")) {
            atualizarTabelaCliente();
        } else {
            String nomeBuscar = txtNomeConsultaCliente.getText();
            ArrayList<Cliente> list = ClienteDAO.buscarPorNome(nomeBuscar);

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
                    client.getLogradouro(),
                    client.getEndereco(),
                    client.getNumero()

                });

            }

        }

    }//GEN-LAST:event_btnListarActionPerformed

    private void btnExcluir1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluir1ActionPerformed
//        // TODO add your handling code here:
//        int linhaSelecionada = tblNotas.getSelectedRow();
//        if (linhaSelecionada >= 0) {
//            DefaultTableModel model = (DefaultTableModel) tblNotas.getModel();
//            int excluir = Integer.parseInt(model.getValueAt(linhaSelecionada, 0).toString());
//        } else {
//            JOptionPane.showMessageDialog(rootPane, "Selecione uma linha");
//        }
        if (tblConsultarCliente.getSelectedRow() < 0) {
            JOptionPane.showMessageDialog(rootPane, "Selecione uma linha");
        } else {
            boolean retorno = ClienteDAO.excluir(Integer.parseInt((String) tblConsultarCliente.getValueAt(tblConsultarCliente.getSelectedRow(), 0)));
            if (retorno) {
                JOptionPane.showMessageDialog(rootPane, "Sucesso");
                atualizarTabelaCliente();
            } else {
                JOptionPane.showMessageDialog(rootPane, "Falha");
            }
        }
    }//GEN-LAST:event_btnExcluir1ActionPerformed

    private void txtNumeroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNumeroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNumeroActionPerformed

    private void btnConsultaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultaActionPerformed
        tbbPnlTela.setSelectedIndex(5);
    }//GEN-LAST:event_btnConsultaActionPerformed

    private void btnExcluirClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirClienteActionPerformed
        if (tblConsultarCliente.getSelectedRow() < 0) {
            JOptionPane.showMessageDialog(rootPane, "Selecione uma linha");
        } else {
            boolean retorno = ClienteDAO.excluir(Integer.parseInt((String) tblConsultarCliente.getValueAt(tblConsultarCliente.getSelectedRow(), 0)));
            if (retorno) {
                JOptionPane.showMessageDialog(rootPane, "Sucesso");
                atualizarTabelaCliente();
            } else {
                JOptionPane.showMessageDialog(rootPane, "Falha");
            }
        }
    }//GEN-LAST:event_btnExcluirClienteActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        tbbPnlTela.setSelectedIndex(6);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void txtEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEmailActionPerformed

    private void btnExcluirProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirProdutoActionPerformed
        if (tblConsultarProduto.getSelectedRow() >= 0) {
            boolean retorno = ProdutoDAO.excluir(tblConsultarProduto.getSelectedRow());
            if (retorno) {
                JOptionPane.showMessageDialog(rootPane, "Excluido com sucesso");
                atualizarTabelaProduto();
            } else {
                JOptionPane.showMessageDialog(rootPane, "Falha em excluir");
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Selecione uma linha");
        }
    }//GEN-LAST:event_btnExcluirProdutoActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        verificaCamposCliente();
        verificaNumeroMinimo(txtCPF, 11, "CPF");
        verificaVazio(txtCodigo1, "Código");
        verificaVazio(txtNomeCliente, "Cliente");
        verificaVazio(txtEndereco, "Endereço");
        verificaVazio(txtNumEndereco, "Numero");
        verificaVazio(txtCelular, "Celular");
        verificaVazio(txtDataDeNascimento, "Data de Nascimento");

        if (!txtEmail.getText().contains("@") || !txtEmail.getText().contains(".com")) {
            txtEmail.setBackground(Color.red);
        }
        verificaComboBox(cmbLogradouro, "Logradouro");
        verificaComboBox(cmbEstadoCivil, "Estado Civil");

    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarActionPerformed
        if (tblConsultarCliente.getSelectedRow() >= 0) {

            txtNomeCliente.setText(tblConsultarCliente.getValueAt(tblConsultarCliente.getSelectedRow(), 1).toString());
            txtCPF.setText(tblConsultarCliente.getValueAt(tblConsultarCliente.getSelectedRow(), 2).toString());
            txtCelular.setText(tblConsultarCliente.getValueAt(tblConsultarCliente.getSelectedRow(), 3).toString());
            txtEmail.setText(tblConsultarCliente.getValueAt(tblConsultarCliente.getSelectedRow(), 4).toString());
            txtDataDeNascimento.setText(tblConsultarCliente.getValueAt(tblConsultarCliente.getSelectedRow(), 6).toString());
            String data = txtDataDeNascimento.getText();
            String[] ano = txtDataDeNascimento.getText().split("-");
            String diaCerto = ano[2];
            String mesCerto = ano[1];
            String anoCerto = ano[0];
            String dataCerta = diaCerto + mesCerto + anoCerto;
            txtDataDeNascimento.setText(dataCerta);

            txtEndereco.setText(tblConsultarCliente.getValueAt(tblConsultarCliente.getSelectedRow(), 7).toString());
            txtNumEndereco.setText(tblConsultarCliente.getValueAt(tblConsultarCliente.getSelectedRow(), 8).toString());
            String id = tblConsultarCliente.getValueAt(tblConsultarCliente.getSelectedRow(), 0).toString();
            int idCerto = Integer.parseInt(id);
            String nome = tblConsultarCliente.getValueAt(tblConsultarCliente.getSelectedRow(), 1).toString();
            String cpf = tblConsultarCliente.getValueAt(tblConsultarCliente.getSelectedRow(), 2).toString();
            String telefone = tblConsultarCliente.getValueAt(tblConsultarCliente.getSelectedRow(), 3).toString();
            String email = tblConsultarCliente.getValueAt(tblConsultarCliente.getSelectedRow(), 4).toString();
            String estadoCivil = tblConsultarCliente.getValueAt(tblConsultarCliente.getSelectedRow(), 5).toString();
            String dataNascimento = tblConsultarCliente.getValueAt(tblConsultarCliente.getSelectedRow(), 6).toString();

            String logradouro = tblConsultarCliente.getValueAt(tblConsultarCliente.getSelectedRow(), 7).toString();
            String endereco = tblConsultarCliente.getValueAt(tblConsultarCliente.getSelectedRow(), 8).toString();
            String num = tblConsultarCliente.getValueAt(tblConsultarCliente.getSelectedRow(), 9).toString();

            objAlterar = new Cliente(idCerto, nome, cpf, telefone, email, estadoCivil, dataNascimento, logradouro, endereco, num);
            tbbPnlTela.setSelectedIndex(3);
        } else {
            JOptionPane.showMessageDialog(rootPane, "Selecione uma linha");
        }
    }//GEN-LAST:event_btnAlterarActionPerformed

    private void btnLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparActionPerformed
        limparCamposCliente();
    }//GEN-LAST:event_btnLimparActionPerformed

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
    private javax.swing.JButton btnAlterar;
    private javax.swing.JButton btnBuscar1;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnCancelarVenda1;
    private javax.swing.JButton btnConfirmar;
    private javax.swing.JButton btnConfirmarVenda1;
    private javax.swing.JButton btnConsulta;
    private javax.swing.JButton btnConsultarProduto;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnExcluir1;
    private javax.swing.JButton btnExcluirProduto;
    private javax.swing.JButton btnExcluirRelatorio;
    private javax.swing.JButton btnExcluirVenda;
    private javax.swing.JButton btnFechar;
    private javax.swing.JButton btnImprimir;
    private javax.swing.JButton btnLimpar;
    private javax.swing.JButton btnLimpar2;
    private javax.swing.JButton btnListar;
    private javax.swing.JButton btnPesquisar2;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JComboBox<String> cboCategoria;
    private javax.swing.JComboBox<String> cboCor;
    private javax.swing.JComboBox<String> cboPagamento;
    private javax.swing.JComboBox<String> cmbEstadoCivil;
    private javax.swing.JComboBox<String> cmbLogradouro;
    private javax.swing.JFormattedTextField jFormattedTextField1;
    private javax.swing.JFormattedTextField jFormattedTextField2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel jblDataInicial;
    private javax.swing.JLabel jblRelatorio;
    private javax.swing.JLabel lblCPF;
    private javax.swing.JLabel lblCPF2;
    private javax.swing.JLabel lblCategoria;
    private javax.swing.JLabel lblCelular;
    private javax.swing.JLabel lblCodigo1;
    private javax.swing.JLabel lblCor;
    private javax.swing.JLabel lblData2;
    private javax.swing.JLabel lblDataFinal;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblEndereco1;
    private javax.swing.JLabel lblEstadoCivil;
    private javax.swing.JLabel lblFormaPagamento;
    private javax.swing.JLabel lblID;
    private javax.swing.JLabel lblLogradouro;
    private javax.swing.JLabel lblMarca;
    private javax.swing.JLabel lblMostrarNome;
    private javax.swing.JLabel lblMostrarValor;
    private javax.swing.JLabel lblNome1;
    private javax.swing.JLabel lblNomeCliente;
    private javax.swing.JLabel lblNomeConsultaCliente;
    private javax.swing.JLabel lblNomeConsultaProduto;
    private javax.swing.JLabel lblNomeProduto;
    private javax.swing.JLabel lblNumEndereco;
    private javax.swing.JLabel lblParcelas;
    private javax.swing.JLabel lblProcurarCliente;
    private javax.swing.JLabel lblQuantidade1;
    private javax.swing.JLabel lblRG;
    private javax.swing.JLabel lblTamanho;
    private javax.swing.JLabel lblTotalDeVendas6;
    private javax.swing.JLabel lblTotalDeVendasVendas;
    private javax.swing.JLabel lblValor;
    private javax.swing.JLabel lblValor1;
    private javax.swing.JLabel lblVendas1;
    private javax.swing.JPanel pnlCadastroCliente;
    private javax.swing.JPanel pnlCadastroProduto;
    private javax.swing.JPanel pnlCarrinho1;
    private javax.swing.JPanel pnlConsultarCliente;
    private javax.swing.JPanel pnlConsultarProduto;
    private javax.swing.JPanel pnlDadosDoCliente2;
    private javax.swing.JPanel pnlDadosDoProduto1;
    private javax.swing.JPanel pnlRelatorio;
    private javax.swing.JPanel pnlTelaInicial;
    private javax.swing.JPanel pnlTotalDeVendas6;
    private javax.swing.JPanel pnlVendas;
    private javax.swing.JTabbedPane tbbPnlTela;
    private javax.swing.JTable tblCarrinho1;
    private javax.swing.JTable tblConsultarCliente;
    private javax.swing.JTable tblConsultarProduto;
    private javax.swing.JTextField txtCPF;
    private javax.swing.JTextField txtCPF2;
    private javax.swing.JTextField txtCelular;
    private javax.swing.JTextField txtCodigo1;
    private javax.swing.JTextField txtDataAtual;
    private javax.swing.JFormattedTextField txtDataDeNascimento;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtEndereco;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtMarca;
    private javax.swing.JTextField txtNomeCliente;
    private javax.swing.JTextField txtNomeConsultaCliente;
    private javax.swing.JTextField txtNomeConsultaProduto;
    private javax.swing.JTextField txtNomeProduto;
    private javax.swing.JTextField txtNumEndereco;
    private javax.swing.JTextField txtQuantidade1;
    private javax.swing.JTextField txtTamanho;
    private javax.swing.JTextField txtValor;
    // End of variables declaration//GEN-END:variables
}
