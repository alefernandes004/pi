
package classes;

import java.util.Date;

/**
 *
 * @author alessandra.fernandes
 */
public class RelatorioSintetico {
    private int id_venda;
    private Date dataVenda;
    private int id_cliente;
    private String nome;
    private float valorTotal;

    public RelatorioSintetico(int id_venda, Date dataVenda, int id_cliente, String nome, float valorTotal) {
        this.id_venda = id_venda;
        this.dataVenda = dataVenda;
        this.id_cliente = id_cliente;
        this.nome = nome;
        this.valorTotal = valorTotal;
    }

    public int getId_venda() {
        return id_venda;
    }

    public void setId_venda(int id_venda) {
        this.id_venda = id_venda;
    }

    public Date getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(Date dataVenda) {
        this.dataVenda = dataVenda;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(float valorTotal) {
        this.valorTotal = valorTotal;
    }

    

    
}
