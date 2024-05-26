
package DAO;

import static DAO.ClienteDAO.URL;
import static DAO.ClienteDAO.login;
import static DAO.ClienteDAO.senha;
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
public class RelatorioSinteticoDAO {
    public static String URL = "jdbc:mysql://localhost:3306/loja2";
    //Professor, add login e senha do seu banco de dados
    public static String login = "root";
    public static String senha = "P@$$w0rd";
    
    
        public static ArrayList<RelatorioSintetico> listarPorPeriodo(Date dataInicio, Date dataTermino){
        Connection conexao = null;
        ResultSet rs = null;
        ArrayList<RelatorioSintetico> listaRetorno = new ArrayList<>();

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexao = DriverManager.getConnection(URL, login, senha);

            String sql = "SELECT  Pedido.id_venda, Pedido.id_cliente, Cliente.nome, Pedido.dataVenda, Pedido.valorTotal FROM Pedido INNER JOIN Cliente ON Pedido.id_cliente = Cliente.id_cliente WHERE dataVenda BETWEEN ? AND ?";
            PreparedStatement comandoSQL = conexao.prepareStatement(sql);
            comandoSQL.setDate(1, new java.sql.Date(dataInicio.getTime()));
            comandoSQL.setDate(2, new java.sql.Date(dataTermino.getTime()));

            rs = comandoSQL.executeQuery();

            while (rs.next()) {
                int id_venda = rs.getInt("id_venda");
                int id_cliente = rs.getInt("id_cliente");
                String nome = rs.getString("nome");
                Date dataVenda = rs.getDate("dataVenda");
                float valorTotal = rs.getFloat("valorTotal");

                RelatorioSintetico item = new RelatorioSintetico(id_venda, dataVenda, id_cliente, nome, valorTotal);
                listaRetorno.add(item);
            }
        } catch (Exception e){
            e.printStackTrace(); 
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
