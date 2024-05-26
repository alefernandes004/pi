/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classes;

import java.util.ArrayList;

/*
 *
 * @author juans
 */
public class ItemPedido {
    private int id_itemPedido;
    private int id_pedido;
    private int id_produto;
    private int quantidade;
    private double valorUnitario;
    
    public ItemPedido(int quantidade, double valorUnitario) {
        this.quantidade = quantidade;
        this.valorUnitario = valorUnitario;
    }

    public ItemPedido(int id_produto, int quantidade, double valorUnitario) {
        this.id_produto = id_produto;
        this.quantidade = quantidade;
        this.valorUnitario = valorUnitario;
    }


    public int getId_itemPedido() {
        return id_itemPedido;
    }

    public void setId_itemPedido(int id_itemPedido) {
        this.id_itemPedido = id_itemPedido;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(double valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public int getId_pedido() {
        return id_pedido;
    }

    public void setId_pedido(int id_pedido) {
        this.id_pedido = id_pedido;
    }

    public int getId_produto() {
        return id_produto;
    }

    public void setId_produto(int id_produto) {
        this.id_produto = id_produto;
    }

}
