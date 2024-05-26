/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import static DAO.ClienteDAO.URL;
import static DAO.ClienteDAO.login;
import static DAO.ClienteDAO.senha;
import classes.Cliente;
import classes.ItemPedido;
import classes.Pedido;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author juans
 */
public class PedidoDAO {
    public static boolean salvar(Pedido obj){
        boolean retorno = false;
        Connection conexao = null;
        try {
            //Passo 1 - Carregar o Driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            //Passo 2 - Abrir a conexao com o banco
            conexao = DriverManager.getConnection(URL, login, senha);
            
            //Passo 3 - Preparar o comando SQL
  
            PreparedStatement comandoSQL = 
            conexao.prepareStatement("INSERT INTO pedido (id_cliente, valorTotal, dataVenda) VALUES(?, ?, ?)", PreparedStatement.RETURN_GENERATED_KEYS);
            
            //Passo 4 - Passar os parâmetros para o comandoSQL
            comandoSQL.setInt(1, obj.getId_cliente());
            comandoSQL.setDouble(2, obj.getValorTotal());
            comandoSQL.setString(3, obj.getDataVenda());
            
            //Passo 5 - Executar o comando SQL
            int linhasAfetadas = comandoSQL.executeUpdate();
            
            if(linhasAfetadas >0){
                ResultSet rs = comandoSQL.getGeneratedKeys();
                if(rs.next()){
                    int id = rs.getInt(1);
                    for (ItemPedido itemPedido : obj.getListaItemPedido()) {
                        PreparedStatement comandoSQL2 = conexao.prepareStatement("INSERT INTO itemPedido (id_pedido, id_produto, qtd, valorUnitario) VALUES (?, ?, ?, ?)");
                        comandoSQL2.setInt(1, id);
                        comandoSQL2.setInt(2, itemPedido.getId_produto());
                        comandoSQL2.setInt(3, itemPedido.getQuantidade());
                        comandoSQL2.setDouble(4, itemPedido.getValorUnitario());
                        
                        int linhas = comandoSQL2.executeUpdate();
                        if(linhas > 0){
                            retorno = true;
                        }
                    }
                }
            }
            
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return retorno;
    }//Fim do metodo salvar

    public static Cliente buscarPorCPF(String CPF) {
        Cliente retorno = null;
        Connection conexao = null;
        int linhasAfetadas = 0;

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            conexao = DriverManager.getConnection(URL, login, senha);

            PreparedStatement comandoSQL = conexao.prepareStatement("SELECT * FROM cliente WHERE cpf = ?");

            comandoSQL.setString(1, CPF);
            ResultSet rs = comandoSQL.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id_cliente");
                String nome = rs.getString("nome");
                String cpf = rs.getString("cpf");
                String telefone = rs.getString("telefone");
                String email = rs.getString("email");
                String estadoCivil = rs.getString("estadoCivil");
                String dataDeNascimento = rs.getString("dataDeNascimento");
                String logradouro = rs.getString("logradouro");
                String endereco = rs.getString("endereco");
                String numero = rs.getString("numero");
                retorno = new Cliente(id, nome, cpf, telefone, email, estadoCivil, dataDeNascimento, logradouro, endereco, numero);
                
            }
            
            return retorno;

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return retorno;
    }

    public static String[] buscarCodigoProduto(String idProduto) {
        String[] retorno = new String[2];
        Connection conexao = null;

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            conexao = DriverManager.getConnection(URL, login, senha);

            PreparedStatement comandoSQL = conexao.prepareStatement("SELECT * FROM produto WHERE id_produto = ?");

            comandoSQL.setString(1, idProduto);
            ResultSet rs = comandoSQL.executeQuery();
            while (rs.next()) {
                String nome = rs.getString("nome");
                double valor = rs.getDouble("valor");
                retorno[0] = nome;
                retorno[1] = String.valueOf(valor);
            }

            return retorno;

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return retorno;
    }
}
