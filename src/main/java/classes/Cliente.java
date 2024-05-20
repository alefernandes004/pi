/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classes;
//nome, cpf, endereço, telefone, e-mail, sexo, estado civil e data de nascimento deverão estar disponíveis na aplicação.

/**
 *
 * @author juan.adsantos
 */
public class Cliente extends Endereco {
    
    private int id_cliente;
    private String nome;
    private String CPF;
    private String telefone;

    public Cliente(String endereco, int numero, String cep, String bairro, String cidade, String complemento, String uf) {
        super(endereco, numero, cep, bairro, cidade, complemento, uf);
    }

    public Cliente(int id_cliente, String nome, String CPF, String telefone, String email, String estadoCivil, String dataDeNascimento, int id_endereco, String endereco, int numero, String cep, String bairro, String cidade, String complemento, String uf) {
        super(id_endereco, endereco, numero, cep, bairro, cidade, complemento, uf);
        this.id_cliente = id_cliente;
        this.nome = nome;
        this.CPF = CPF;
        this.telefone = telefone;
        this.email = email;
        this.estadoCivil = estadoCivil;
        this.dataDeNascimento = dataDeNascimento;
    }
    private String email;
    private String estadoCivil; // ComboBox
    private String dataDeNascimento;

    public Cliente() {
    }

    public Cliente(int id_cliente, String nome, String CPF, String telefone, String email, String estadoCivil, String dataDeNascimento) {
        this.id_cliente = id_cliente;
        this.nome = nome;
        this.CPF = CPF;
        this.telefone = telefone;
        this.email = email;
      
        this.estadoCivil = estadoCivil;
        this.dataDeNascimento = dataDeNascimento;
    }

    public Cliente( String nome, String CPF, String telefone, String email,  String estadoCivil, String dataDeNascimento) {
        
        this.nome = nome;
        this.CPF = CPF;
        this.telefone = telefone;
        this.email = email;
 
        this.estadoCivil = estadoCivil;
        this.dataDeNascimento = dataDeNascimento;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the CPF
     */
    public String getCPF() {
        return CPF;
    }

    /**
     * @param CPF the CPF to set
     */
    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    /**
     * @return the endereco
     */

    /**
     * @return the telefone
     */
    public String getTelefone() {
        return telefone;
    }

    /**
     * @param telefone the telefone to set
     */
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }


    /**
     * @return the estadoCivil
     */
    public String getEstadoCivil() {
        return estadoCivil;
    }

    /**
     * @param estadoCivil the estadoCivil to set
     */
    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    /**
     * @return the dataDeNascimento
     */
    public String getDataDeNascimento() {
        return dataDeNascimento;
    }

    /**
     * @param dataDeNascimento the dataDeNascimento to set
     */
    public void setDataDeNascimento(String dataDeNascimento) {
        this.dataDeNascimento = dataDeNascimento;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

}
