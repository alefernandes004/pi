/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classes;
/*id_endereco int unsigned not null auto_increment,
id_cliente int unsigned not null,
endereco varchar(100) not null,
numero int unsigned not null,
cep varchar(8) not null,
bairro varchar(100) not null,
cidade varchar(100) not null,
complemento varchar(100) not null,
uf*/
public class Endereco{
    
    private int id_endereco;
    private int id_cliente;
    private String endereco;
    private int numero;
    private String cep;
    private String bairro;
    private String cidade;
    private String complemento;
    private String uf;

    public Endereco(String endereco, int numero, String cep, String bairro, String cidade, String complemento, String uf) {
        this.endereco = endereco;
        this.numero = numero;
        this.cep = cep;
        this.bairro = bairro;
        this.cidade = cidade;
        this.complemento = complemento;
        this.uf = uf;
    }
    

    public Endereco() {
    }

    public Endereco(int id_endereco, String endereco, int numero, String cep, String bairro, String cidade, String complemento, String uf) {
        this.id_endereco = id_endereco;
        this.endereco = endereco;
        this.numero = numero;
        this.cep = cep;
        this.bairro = bairro;
        this.cidade = cidade;
        this.complemento = complemento;
        this.uf = uf;
    }

    public int getId_endereco() {
        return id_endereco;
    }

    public void setId_endereco(int id_endereco) {
        this.id_endereco = id_endereco;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }
}
