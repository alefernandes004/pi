package classes;

import java.util.ArrayList;

public class Vendas {
    
    private int codigo;
    private ArrayList<Produto> p1 = new ArrayList<>();
    

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Vendas() {
    }

    public Vendas(int codigo) {
        this.codigo = codigo;
    }

    public ArrayList<Produto> getP1() {
        return p1;
    }

    public void setP1(ArrayList<Produto> p1) {
        this.p1 = p1;
    }
}

    