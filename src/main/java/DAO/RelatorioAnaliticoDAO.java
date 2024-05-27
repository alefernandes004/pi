
package DAO;

import static DAO.ClienteDAO.URL;
import static DAO.ClienteDAO.login;
import static DAO.ClienteDAO.senha;
import classes.RelatorioAnalitico;
import classes.RelatorioSintetico;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author alessandra.fernandes
 */
public class RelatorioAnaliticoDAO {
    public static String URL = "jdbc:mysql://localhost:3306/loja2";
    //Professor, add login e senha do seu banco de dados
    public static String login = "root";
    public static String senha = "P@$$w0rd";
    
    
        public static ArrayList<RelatorioAnalitico> listarPorVenda(int idVenda){
        Connection conexao = null;
        ResultSet rs = null;
        ArrayList<RelatorioAnalitico> listaRetorno = new ArrayList<>();

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexao = DriverManager.getConnection(URL, login, senha);

         String sql = "SELECT ItemPedido.id_produto, Produto.nome, ItemPedido.valorUnitario, ItemPedido.qtd " +
             "FROM ItemPedido " +
             "INNER JOIN Produto ON ItemPedido.id_produto = Produto.id_produto " +
             "WHERE id_pedido = ?";


            PreparedStatement comandoSQL = conexao.prepareStatement(sql);
            comandoSQL.setInt(1, idVenda);
            

            rs = comandoSQL.executeQuery();

            while (rs.next()) {
                RelatorioAnalitico item = null;
                
                int id_produto = rs.getInt("id_produto");
                String nomeProduto = rs.getString("nome");
                float valorUnitario = rs.getFloat("valorUnitario");
                int qtdProduto = rs.getInt("qtd");

                item = new RelatorioAnalitico(nomeProduto, qtdProduto, valorUnitario);
                listaRetorno.add(item);
            }
        } catch (Exception e){
            listaRetorno = null; 
        } finally {
            try {
                if (rs != null) rs.close();
                if (conexao != null) conexao.close();
            } catch (Exception e) {
                e.printStackTrace(); 
            }
        }

        return listaRetorno;
    }

}
