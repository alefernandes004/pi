
package DAO;

import classes.Cliente;
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
public class ClienteDAO {
    public static String URL = "jdbc:mysql://localhost:3306/loja2";
    //Professor, add login e senha do seu banco de dados
    public static String login = "root";
    public static String senha = "P@$$w0rd";
    
    public static boolean salvar(Cliente obj){
        boolean retorno = false;
        Connection conexao = null;
        try {
            //Passo 1 - Carregar o Driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            //Passo 2 - Abrir a conexao com o banco
            conexao = DriverManager.getConnection(URL, login, senha);
            
            //Passo 3 - Preparar o comando SQL
            PreparedStatement comandoSQL = 
            conexao.prepareStatement("INSERT INTO cliente (nome,cpf, telefone, email, estadoCivil, dataDeNascimento, logradouro, endereco, numero) VALUES(?,?, ?, ?, ?, ?, ?, ?, ?)");
            
            //Passo 4 - Passar os parâmetros para o comandoSQL
            comandoSQL.setString(1, obj.getNome());
            comandoSQL.setString(2, obj.getCPF());
            comandoSQL.setString(3, obj.getTelefone());
            comandoSQL.setString(4, obj.getEmail());
            comandoSQL.setString(5, obj.getEstadoCivil());
            comandoSQL.setString(6, obj.getDataDeNascimento());
            comandoSQL.setString(7, obj.getLogradouro());
            comandoSQL.setString(8, obj.getEndereco());
            comandoSQL.setString(9, obj.getNumero());
            
            //Passo 5 - Executar o comando SQL
            int linhasAfetadas = comandoSQL.executeUpdate();
            
            if(linhasAfetadas >0){
                retorno = true;
            }
            
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return retorno;
    }//Fim do metodo salvar
    
    public static ArrayList<Cliente> listar(){
        
        //Variavel de retorno
        ArrayList<Cliente> listaClientes = new ArrayList<>();
        Connection conexao = null;
        
        try {
            //Passo 1 - Carregar o Driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            //Passo 2 - Abrir a conexao com o banco
            conexao = DriverManager.getConnection(URL, login, senha);
            
            //Passo 3 - Preparar o comando SQL
            PreparedStatement comandoSQL = 
            conexao.prepareStatement("SELECT * from cliente");
            
            
            //Passo 4 - Executar o comando SQL
            ResultSet rs = comandoSQL.executeQuery();
            

            //Enquanto houver linhas
            while(rs.next() || rs.next()){
                /*onexao.prepareStatement("INSERT INTO cliente (nome,cpf, telefone, email, sexo, estadoCivil, dataDeNascimento);*/
                //Para cada linha do rs, crio um objeto e jogo na lista
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
                Cliente novoCliente = new Cliente(id, nome, cpf, telefone, email, estadoCivil, dataDeNascimento, logradouro, endereco, numero);
                
            
                //Adicionar o objeto à lista de retorno
                listaClientes.add(novoCliente);
                
            }
            
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return listaClientes;
    }
    
    public static boolean alterar(Cliente obj){
        boolean retorno = false;
        Connection conexao = null;
        
        try {
            //Passo 1 - Carregar o Driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            //Passo 2 - Abrir a conexao com o banco
            conexao = DriverManager.getConnection(URL, login, senha);
            
            //Passo 3 - Preparar o comando SQL
            PreparedStatement comandoSQL = 
            
             conexao.prepareStatement("UPDATE cliente SET nome = ?,cpf = ?, telefone = ?, email = ?, estadoCivil = ?, dataDeNascimento = ?, logradouro = ?, endereco = ?, numero = ? WHERE id_cliente = ?");
            
            //Passo 4 - Passar os parâmetros para o comandoSQL
             comandoSQL.setString(1, obj.getNome());
            comandoSQL.setString(2, obj.getCPF());
            comandoSQL.setString(3, obj.getTelefone());
            comandoSQL.setString(4, obj.getEmail());
            comandoSQL.setString(5, obj.getEstadoCivil());
            comandoSQL.setString(6, obj.getDataDeNascimento());
            comandoSQL.setString(7, obj.getLogradouro());
            comandoSQL.setString(8, obj.getEndereco());
            comandoSQL.setString(9, obj.getNumero());
            comandoSQL.setInt(10, obj.getId_cliente());
            
            //Passo 5 - Executar o comando SQL
            int linhasAfetadas = comandoSQL.executeUpdate();
            
            if(linhasAfetadas >0){
                retorno = true;
            }
            
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return retorno;
    }//Fim do metodo salvar
    
    public static ArrayList<Cliente> buscarPorNome(String nome) {
        ArrayList<Cliente> list = new ArrayList<>();

        Connection conexao = null;

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            conexao = DriverManager.getConnection(URL, login, senha);

            PreparedStatement comandoSQL = conexao.prepareStatement("SELECT * FROM cliente WHERE nome = ?");
            
            comandoSQL.setString(1, nome);
//            comandoSQL.setDouble(2, a.getValorNota());
            ResultSet rs = comandoSQL.executeQuery();

            while(rs.next()){
                int id = rs.getInt("id_cliente");
                String nome1 = rs.getString("nome");
                String cpf = rs.getString("cpf");
                String telefone = rs.getString("telefone");
                String email = rs.getString("email");
                String estadoCivil = rs.getString("estadoCivil");
                String dataDeNascimento = rs.getString("dataDeNascimento");
                String logradouro = rs.getString("logradouro");
                String endereco = rs.getString("endereco");
                String numero = rs.getString("numero");
                Cliente novoCliente = new Cliente(id, nome1, cpf, telefone, email, estadoCivil, dataDeNascimento, logradouro, endereco, numero);
                
                list.add(novoCliente);
            }
            
            
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
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
            conexao.prepareStatement("DELETE FROM cliente WHERE id_cliente = ?");
            
            //Passo 4 - Passar os parâmetros para o comandoSQL
            comandoSQL.setInt(1, idExcluir);
            
            
            //Passo 5 - Executar o comando SQL
            int linhasAfetadas = comandoSQL.executeUpdate();
            
            if(linhasAfetadas >0){
                retorno = true;
            }
            
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return retorno;
    }//Fim do metodo salvar
}
