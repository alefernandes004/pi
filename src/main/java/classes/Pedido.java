/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classes;

import java.sql.Date;
import java.util.ArrayList;
/*
 *
 * @author juans
 */
public class Pedido {
    private int id_venda;
    private double valorTotal;
    private String dataVenda;
    private ArrayList<ItemPedido> listaItemPedido = new ArrayList<>();
    private int id_cliente;

    public Pedido() {
    }

    public Pedido(int id_venda, double valorTotal, String dataVenda) {
        this.id_venda = id_venda;
        this.valorTotal = valorTotal;
        this.dataVenda = dataVenda;
    }

    public Pedido(double valorTotal, String dataVenda) {
        this.valorTotal = valorTotal;
        this.dataVenda = dataVenda;
    }

    public int getId_venda() {
        return id_venda;
    }

    public void setId_venda(int id_venda) {
        this.id_venda = id_venda;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public String getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(String dataVenda) {
        this.dataVenda = dataVenda;
    }

    public ArrayList<ItemPedido> getListaItemPedido() {
        return listaItemPedido;
    }

    public void setListaItemPedido(ArrayList<ItemPedido> listaItemPedido) {
        this.listaItemPedido = listaItemPedido;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }
}
