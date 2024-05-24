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
<<<<<<< HEAD
public class Cliente{
    
    private int id_cliente;
=======
public class Cliente {

>>>>>>> fae33251b8e83deb7a816c4f27953750e48fc07c
    private String nome;
    private String CPF;
    private String endereco;
    private String telefone;
    private String email;
    private String sexo; // ComboBox
    private String estadoCivil; // ComboBox
    private String dataDeNascimento;
    private String logradouro;
    private String endereco;
    private String numero;

<<<<<<< HEAD
    public Cliente() {
    }

    public Cliente(String nome, String CPF, String telefone, String email, String estadoCivil, String dataDeNascimento, String logradouro, String endereco, String numero) {
        this.nome = nome;
        this.CPF = CPF;
        this.telefone = telefone;
        this.email = email;
        this.estadoCivil = estadoCivil;
        this.dataDeNascimento = dataDeNascimento;
        this.logradouro = logradouro;
        this.endereco = endereco;
        this.numero = numero;
    }

    public Cliente(int id_cliente, String nome, String CPF, String telefone, String email, String estadoCivil, String dataDeNascimento, String logradouro, String endereco, String numero) {
        this.id_cliente = id_cliente;
        this.nome = nome;
        this.CPF = CPF;
        this.telefone = telefone;
        this.email = email;
        this.estadoCivil = estadoCivil;
        this.dataDeNascimento = dataDeNascimento;
        this.logradouro = logradouro;
        this.endereco = endereco;
        this.numero = numero;
    }

=======
>>>>>>> fae33251b8e83deb7a816c4f27953750e48fc07c
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
    public String getEndereco() {
        return endereco;
    }

    /**
     * @param endereco the endereco to set
     */
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

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
     * @return the sexo
     */
    public String getSexo() {
        return sexo;
    }

    /**
     * @param sexo the sexo to set
     */
    public void setSexo(String sexo) {
        this.sexo = sexo;
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

<<<<<<< HEAD
    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

=======
>>>>>>> fae33251b8e83deb7a816c4f27953750e48fc07c
}
