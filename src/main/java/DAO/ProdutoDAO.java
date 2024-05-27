    /*public static ArrayList<Produto> listar(){
        
        //Variavel de retorno
        ArrayList<Produto> listaProduto = new ArrayList<>();
        Connection conexao = null;
        
        try {
            //Passo 1 - Carregar o Driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            //Passo 2 - Abrir a conexao com o banco
            conexao = DriverManager.getConnection(URL, login, senha);
            
            //Passo 3 - Preparar o comando SQL
            PreparedStatement comandoSQL = 
            conexao.prepareStatement("select * from produto ");
            
            
            //Passo 4 - Executar o comando SQL
            ResultSet rs = comandoSQL.executeQuery();
            

            //Enquanto houver linhas
            while(rs.next()){
                nome,tamanho, cor, marca, valor, formaDePagamento, qtdParcelas
                onexao.prepareStatement("INSERT INTO cliente (nome,cpf, telefone, email, sexo, estadoCivil, dataDeNascimento);
                //Para cada linha do rs, crio um objeto e jogo na lista

                int id = rs.getInt("id_produto");
                String nome = rs.getString("nome");
                String tamanho = rs.getString("tamanho");
                String cor = rs.getString("cor");
                String marca = rs.getString("marca");
                double valor = rs.getDouble("valor");
                String formaDePagamento = rs.getString("formaDePagamento");
                Byte qtdParcelas = rs.getByte("qtdParcelas");
                int qtdProduto = rs.getInt("qtdProduto");
               
                
                Produto novoProduto = new Produto(id, tamanho, cor, nome, marca, marca, valor, formaDePagamento, qtdParcelas, qtdProduto);
                
                //Adicionar o objeto à lista de retorno
                listaProduto.add(novoProduto);
                
            }
            
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return listaProduto;
    }
    
    public static boolean alterar(Produto obj){
        boolean retorno = false;
        Connection conexao = null;
        
        try {
            //Passo 1 - Carregar o Driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            //Passo 2 - Abrir a conexao com o banco
            conexao = DriverManager.getConnection(URL, login, senha);
            
            //Passo 3 - Preparar o comando SQL
            PreparedStatement comandoSQL = 
            
             conexao.prepareStatement("UPDATE produto SET nome = ?,tamanho = ?, cor = ?, marca = ?, categoria = ?, valor = ?, formaDePagamento = ?, qtdParcelas = ?, qtdProduto WHERE id_produto = ?");
            
            //Passo 4 - Passar os parâmetros para o comandoSQL
             comandoSQL.setString(1, obj.getNomeProduto());
            comandoSQL.setString(2, obj.getTamanho());
            comandoSQL.setString(3, obj.getCor());
            comandoSQL.setString(4, obj.getMarca());
            comandoSQL.setString(5, obj.getCategoria());
            comandoSQL.setDouble(6, obj.getValor());
            comandoSQL.setString(7, obj.getFormaDePagamento());
            comandoSQL.setByte(8, obj.getQtdParcelas());
            comandoSQL.setInt(9, obj.getID());
            
            //Passo 5 - Executar o comando SQL
            int linhasAfetadas = comandoSQL.executeUpdate();
            
            if(linhasAfetadas >0){
                retorno = true;
            }
            
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return retorno;
    }
//Fim do metodo salvar
    
    /*public static ArrayList<Produto> buscarPorNome(String nome) {
        ArrayList<Produto> list = new ArrayList<>();

        Connection conexao = null;

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            conexao = DriverManager.getConnection(URL, login, senha);

            PreparedStatement comandoSQL = conexao.prepareStatement("SELECT * FROM produto WHERE nome = ?");
            
            
            comandoSQL.setString(1, nome);
//            comandoSQL.setDouble(2, a.getValorNota());
            ResultSet rs = comandoSQL.executeQuery();

            while(rs.next()){
                int id = rs.getInt("id_produto");
                String nome1 = rs.getString("nome");
                String tamanho = rs.getString("tamanho");
                String cor = rs.getString("cor");
                String marca = rs.getString("marca");
                double valor = rs.getDouble("valor");
                String formaDePagamento = rs.getString("formaDePagamento");
                Byte qtdParcelas = rs.getByte("qtdParcelas");
                int qtdProduto = rs.getInt("qtdProduto");
                String categoria = rs.getString("categoria");
               
                
                Produto novoProduto = new Produto(id, tamanho, cor, nome1, marca, categoria, valor, formaDePagamento, qtdParcelas, qtdProduto);
                
                //Adicionar o objeto à lista de retorno
                list.add(novoProduto);
            }
            
            
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return list;
    }
    
    public static boolean excluir(int idExcluir){
        boolean retorno = false;
        Connection conexao = null;
        
        try {
            //Passo 1 - Carregar o Driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            //Passo 2 - Abrir a conexao com o banco
            conexao = DriverManager.getConnection(URL, login, senha);
            
            //Passo 3 - Preparar o comando SQL
            PreparedStatement comandoSQL = 
            conexao.prepareStatement("DELETE FROM produto WHERE id_cliente = ?");
            
            //Passo 4 - Passar os parâmetros para o comandoSQL
            comandoSQL.setInt(1, idExcluir);
            
            
            //Passo 5 - Executar o comando SQL
            int linhasAfetadas = comandoSQL.executeUpdate();
            
            if(linhasAfetadas >0){
                retorno = true;
            }
            
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return retorno;
    }//Fim do metodo salvar
    */
package DAO;

import classes.Produto;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author juans
 */
public class ProdutoDAO {
    public static String URL = "jdbc:mysql://localhost:3306/loja2";
    //Professor, add login e senha do seu banco de dados
    public static String login = "root";
    public static String senha = "P@$$w0rd";
    
    public static boolean salvar(Produto obj){
        boolean retorno = false;
        Connection conexao = null;
        try {
            //Passo 1 - Carregar o Driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            //Passo 2 - Abrir a conexao com o banco
            conexao = DriverManager.getConnection(URL, login, senha);
            
            PreparedStatement comandoSQL = 
            conexao.prepareStatement("INSERT INTO produto (nome,tamanho, cor, marca, valor, formaDePagamento, categoria, qtdProduto) VALUES(?,?, ?, ?, ?, ?, ?, ?)");
            
            //Passo 4 - Passar os parâmetros para o comandoSQL
            comandoSQL.setString(1, obj.getNomeProduto());
            comandoSQL.setString(2, obj.getTamanho());
            comandoSQL.setString(3, obj.getCor());
            comandoSQL.setString(4, obj.getMarca());
            comandoSQL.setDouble(5, obj.getValor());
            comandoSQL.setString(6, obj.getFormaDePagamento());
            comandoSQL.setString(7, obj.getCategoria());
            comandoSQL.setInt(8, obj.getQtdProduto());
            
            //Passo 5 - Executar o comando SQL
            int linhasAfetadas = comandoSQL.executeUpdate();
            
            if(linhasAfetadas >0){
                retorno = true;
            }
            
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return retorno;
    }//Fim do metodo salvar
    
    public static boolean decrementar(int idProduto, int qtdUtilizada){
                boolean retorno = false;
        Connection conexao = null;
        
        try {
            //Passo 1 - Carregar o Driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            //Passo 2 - Abrir a conexao com o banco
            conexao = DriverManager.getConnection(URL, login, senha);
            
            //Passo 3 - Preparar o comando SQL
            PreparedStatement comandoSQL = 
            
             conexao.prepareStatement("UPDATE produto SET qtdProduto = qtdProduto - ? WHERE id_produto = ?");
            
            //Passo 4 - Passar os parâmetros para o comandoSQL
             comandoSQL.setInt(1, qtdUtilizada);
             comandoSQL.setInt(2, idProduto);
            
            //Passo 5 - Executar o comando SQL
            int linhasAfetadas = comandoSQL.executeUpdate();
            
            if(linhasAfetadas >0){
                retorno = true;
            }
            
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retorno;
    }
     public static ArrayList<Produto> listar(){
        
        //Variavel de retorno
        ArrayList<Produto> listaProduto = new ArrayList<>();
        Connection conexao = null;
        
        try {
            //Passo 1 - Carregar o Driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            //Passo 2 - Abrir a conexao com o banco
            conexao = DriverManager.getConnection(URL, login, senha);
            
            //Passo 3 - Preparar o comando SQL
            PreparedStatement comandoSQL = 
            conexao.prepareStatement("select * from produto");
            
            
            //Passo 4 - Executar o comando SQL
            ResultSet rs = comandoSQL.executeQuery();
            

            //Enquanto houver linhas
            while(rs.next()){
                

                int id = rs.getInt("id_produto");
                String nome = rs.getString("nome");
                String tamanho = rs.getString("tamanho");
                String cor = rs.getString("cor");
                String marca = rs.getString("marca");
                String categoria = rs.getString("categoria");
                double valor = rs.getDouble("valor");
                String formaDePagamento = rs.getString("formaDePagamento");
                int qtdProduto = rs.getInt("qtdProduto");
               
                
                Produto novoProduto = new Produto(id, tamanho, cor, nome, marca, categoria, valor, formaDePagamento, qtdProduto);
                
                //Adicionar o objeto à lista de retorno
                listaProduto.add(novoProduto);
                
            }
            
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return listaProduto;
    }
    
      public static ArrayList<Produto> buscarPorNome(int nome) {
        ArrayList<Produto> list = new ArrayList<>();

        
        
        Connection conexao = null;

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            conexao = DriverManager.getConnection(URL, login, senha);

            PreparedStatement comandoSQL = conexao.prepareStatement("SELECT * FROM produto WHERE id_produto = ?");
            
            
            comandoSQL.setInt(1, nome);
            ResultSet rs = comandoSQL.executeQuery();

            while(rs.next()){
                int id = rs.getInt("id_produto");
                String nome1 = rs.getString("nome");
                String tamanho = rs.getString("tamanho");
                String cor = rs.getString("cor");
                String marca = rs.getString("marca");
                double valor = rs.getDouble("valor");
                String formaDePagamento = rs.getString("formaDePagamento");
                int qtdProduto = rs.getInt("qtdProduto");
                String categoria = rs.getString("categoria");
               
                
                Produto novoProduto = new Produto(id, tamanho, cor, nome1, marca, categoria, valor, formaDePagamento, qtdProduto);
                
                //Adicionar o objeto à lista de retorno
                list.add(novoProduto);
            }
            
            
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return list;
    }
    
    public static boolean excluir(int idExcluir){
        boolean retorno = false;
        Connection conexao = null;
        
        try {
            //Passo 1 - Carregar o Driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            //Passo 2 - Abrir a conexao com o banco
            conexao = DriverManager.getConnection(URL, login, senha);
            
            //Passo 3 - Preparar o comando SQL
            PreparedStatement comandoSQL = 
            conexao.prepareStatement("DELETE FROM produto WHERE id_produto = ?");
            
            //Passo 4 - Passar os parâmetros para o comandoSQL
            comandoSQL.setInt(1, idExcluir);
            
            
            //Passo 5 - Executar o comando SQL
            int linhasAfetadas = comandoSQL.executeUpdate();
            
            if(linhasAfetadas >0){
                retorno = true;
            }
            
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return retorno;
    }
      public static boolean alterar(Produto obj){
        boolean retorno = false;
        Connection conexao = null;
        
        try {
            //Passo 1 - Carregar o Driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            //Passo 2 - Abrir a conexao com o banco
            conexao = DriverManager.getConnection(URL, login, senha);
            
            //Passo 3 - Preparar o comando SQL
            PreparedStatement comandoSQL = 
            
             conexao.prepareStatement("UPDATE produto SET nome = ?,tamanho = ?, cor = ?, marca = ?, categoria = ?, valor = ?, formaDePagamento = ?, qtdProduto = ? WHERE id_produto = ?");
            
            //Passo 4 - Passar os parâmetros para o comandoSQL
             comandoSQL.setString(1, obj.getNomeProduto());
            comandoSQL.setString(2, obj.getTamanho());
            comandoSQL.setString(3, obj.getCor());
            comandoSQL.setString(4, obj.getMarca());
            comandoSQL.setString(5, obj.getCategoria());
            comandoSQL.setDouble(6, obj.getValor());
            comandoSQL.setString(7, obj.getFormaDePagamento());
            comandoSQL.setInt(8, obj.getQtdProduto());
            comandoSQL.setInt(9, obj.getID());
            
            //Passo 5 - Executar o comando SQL
            int linhasAfetadas = comandoSQL.executeUpdate();
            
            if(linhasAfetadas >0){
                retorno = true;
            }
            
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return retorno;
    }
}
