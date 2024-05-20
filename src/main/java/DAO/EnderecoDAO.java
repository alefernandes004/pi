/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import classes.Cliente;
import classes.Endereco;
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
public class EnderecoDAO {
    public static int aux = 1;
    public static String URL = "jdbc:mysql://localhost:3306/loja1";
    //Professor, add login e senha do seu banco de dados
    public static String login = "root";
    public static String senha = "adminadmin";
    
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
            conexao.prepareStatement("INSERT INTO endereco (endereco,numero, cep, bairro, cidade, complemento, uf, id_cliente) VALUES (?,?,?, ?, ?, ?, ?, ?)");
            
            //Passo 4 - Passar os parâmetros para o comandoSQL
            comandoSQL.setString(1, obj.getEndereco());
            comandoSQL.setInt(2, obj.getNumero());
            comandoSQL.setString(3, obj.getCep());
            comandoSQL.setString(4, obj.getBairro());
            comandoSQL.setString(5, obj.getCidade());
            comandoSQL.setString(6, obj.getComplemento());
            comandoSQL.setString(7, obj.getUf());
            comandoSQL.setInt(8, obj.getId_cliente());
           
           
            
            //Passo 5 - Executar o comando SQL
            int linhasAfetadas = comandoSQL.executeUpdate();
            
            if(linhasAfetadas >0){
                aux++;
                retorno = true;
            }
            
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(EnderecoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(EnderecoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return retorno;
    }//Fim do metodo salvar
    
    public static ArrayList<Endereco> listar(){
        
        //Variavel de retorno
        ArrayList<Endereco> listaEndereco = new ArrayList<>();
        Connection conexao = null;
        
        try {
            //Passo 1 - Carregar o Driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            //Passo 2 - Abrir a conexao com o banco
            conexao = DriverManager.getConnection(URL, login, senha);
            
            //Passo 3 - Preparar o comando SQL
            PreparedStatement comandoSQL = 
            conexao.prepareStatement("SELECT * FROM endereco");
            
            //Passo 4 - Executar o comando SQL
            ResultSet rs = comandoSQL.executeQuery();

            //Enquanto houver linhas
            while(rs.next()){
                /*endereco,numero, cep, bairro, cidade, complemento, uf*/
                //Para cada linha do rs, crio um objeto e jogo na lista
                int id = rs.getInt("id_endereco");
                String endereco = rs.getString("endereco");
                int numero = rs.getInt("numero");
                String cep = rs.getString("cep");
                String bairro = rs.getString("bairro");
                String cidade = rs.getString("cidade");
                String complemento = rs.getString("complemento");
                String uf = rs.getString("uf");
               
                
                Endereco novoEndereco = new Endereco(id, endereco, numero, cep, bairro, cidade, complemento, uf);
                
                //Adicionar o objeto à lista de retorno
                listaEndereco.add(novoEndereco);
                
            }
            
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(EnderecoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(EnderecoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return listaEndereco;
    }
    
    public static boolean alterar(Endereco obj){
        boolean retorno = false;
        Connection conexao = null;
        
        try {
            //Passo 1 - Carregar o Driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            //Passo 2 - Abrir a conexao com o banco
            conexao = DriverManager.getConnection(URL, login, senha);
            
            //Passo 3 - Preparar o comando SQL
            PreparedStatement comandoSQL = 
            /*endereco,numero, cep, bairro, cidade, complemento, uf*/
             conexao.prepareStatement("UPDATE endereco SET endereco = ?,numero = ?, cep = ?, bairro = ?, cidade = ?, complemento = ?, uf = ? WHERE id_endereco = ?");
            
            //Passo 4 - Passar os parâmetros para o comandoSQL
           comandoSQL.setString(1, obj.getEndereco());
            comandoSQL.setInt(2, obj.getNumero());
            comandoSQL.setString(3, obj.getCep());
            comandoSQL.setString(4, obj.getBairro());
            comandoSQL.setString(5, obj.getCidade());
            comandoSQL.setString(6, obj.getComplemento());
            comandoSQL.setString(7, obj.getUf());
            
            //Passo 5 - Executar o comando SQL
            int linhasAfetadas = comandoSQL.executeUpdate();
            
            if(linhasAfetadas >0){
                retorno = true;
            }
            
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(EnderecoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(EnderecoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return retorno;
    }//Fim do metodo salvar
    
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
            conexao.prepareStatement("DELETE FROM endereco WHERE id_endereco = ?");
            
            //Passo 4 - Passar os parâmetros para o comandoSQL
            comandoSQL.setInt(1, idExcluir);
            
            
            //Passo 5 - Executar o comando SQL
            int linhasAfetadas = comandoSQL.executeUpdate();
            
            if(linhasAfetadas >0){
                retorno = true;
            }
            
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(EnderecoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(EnderecoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return retorno;
    }//Fim do metodo salvar
}
