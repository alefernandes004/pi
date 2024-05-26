
package classes;

/**
 *
 * @author juan.adsantos
 */
public class Produto {

    private int ID;
    private String tamanho;
    private String cor; //Combobox
    private String nomeProduto;
    private String marca;
    private String categoria; //Combobox
    private double valor; 
    private String formaDePagamento; //Combobox; // Spinner
    private int qtdProduto;

    public Produto(String tamanho, String cor, String nomeProduto, String marca, String categoria, double valor, String formaDePagamento, int qtdProduto) {
        this.tamanho = tamanho;
        this.cor = cor;
        this.nomeProduto = nomeProduto;
        this.marca = marca;
        this.categoria = categoria;
        this.valor = valor;
        this.formaDePagamento = formaDePagamento;
        this.qtdProduto = qtdProduto;
    }

    public Produto(int ID, String tamanho, String cor, String nomeProduto, String marca, String categoria, double valor, String formaDePagamento, int qtdProduto) {
        this.ID = ID;
        this.tamanho = tamanho;
        this.cor = cor;
        this.nomeProduto = nomeProduto;
        this.marca = marca;
        this.categoria = categoria;
        this.valor = valor;
        this.formaDePagamento = formaDePagamento;
        
        this.qtdProduto = qtdProduto;
    }

    /**
     * @return the ID
     */
    public int getID() {
        return ID;
    }

    /**
     * @param ID the ID to set
     */
    public void setID(int ID) {
        this.ID = ID;
    }

    /**
     * @return the tamanho
     */
    public String getTamanho() {
        return tamanho;
    }

    /**
     * @param tamanho the tamanho to set
     */
    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }

    /**
     * @return the cor
     */
    public String getCor() {
        return cor;
    }

    /**
     * @param cor the cor to set
     */
    public void setCor(String cor) {
        this.cor = cor;
    }

    /**
     * @return the nomeProduto
     */
    public String getNomeProduto() {
        return nomeProduto;
    }

    /**
     * @param nomeProduto the nomeProduto to set
     */
    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    /**
     * @return the marca
     */
    public String getMarca() {
        return marca;
    }

    /**
     * @param marca the marca to set
     */
    public void setMarca(String marca) {
        this.marca = marca;
    }

    /**
     * @return the categoria
     */
    public String getCategoria() {
        return categoria;
    }

    /**
     * @param categoria the categoria to set
     */
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    /**
     * @return the valor
     */
    public double getValor() {
        return valor;
    }

    /**
     * @param valor the valor to set
     */
    public void setValor(double valor) {
        this.valor = valor;
    }

    /**
     * @return the formaDePagamento
     */
    public String getFormaDePagamento() {
        return formaDePagamento;
    }

    /**
     * @param formaDePagamento the formaDePagamento to set
     */
    public void setFormaDePagamento(String formaDePagamento) {
        this.formaDePagamento = formaDePagamento;
    }

    public int getQtdProduto() {
        return qtdProduto;
    }

    public void setQtdProduto(int estoque) {
        this.qtdProduto = estoque;
    }

}
