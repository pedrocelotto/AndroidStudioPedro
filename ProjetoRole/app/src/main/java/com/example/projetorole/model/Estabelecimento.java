package com.example.projetorole.model;

import java.io.Serializable;

public class Estabelecimento implements Serializable {

    private Integer id_estabelecimento;
    private String nome;
    private String cnpj;
    private String endereco;
    private Integer status;
    private String categoria;
    private String atracao;
    private String promocoes;

    String statusFim;

    public Estabelecimento(String nome, String cnpj,Integer status, String endereco, String categoria, String atracao, String promocoes) {
        this.nome = nome;
        this.cnpj = cnpj;
        this.endereco = endereco;
        this.status = status;
        this.categoria = categoria;
        this.atracao = atracao;
        this.promocoes = promocoes;
    }

    @Override
    public String toString() {
        if (getStatus() == 1){
            statusFim = "Aberto";
        }else if (getStatus() == 0){
            statusFim = "Fechado";
        }
        return getNome() + " - Endereço: " + getEndereco() + " - Status: " + statusFim;
    }

    public void setId_estabelecimento(Integer id_estabelecimento) {
        this.id_estabelecimento = id_estabelecimento;
    }

    public Integer getId_estabelecimento() {
        return id_estabelecimento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getAtracao() {
        return atracao;
    }

    public void setAtracao(String atracao) {
        this.atracao = atracao;
    }

    public String getPromocoes() {
        return promocoes;
    }

    public void setPromocoes(String promocoes) {
        this.promocoes = promocoes;
    }
}
