package com.example.projetorole.model;

import android.media.ImageReader;

public class Estabelecimento {

    private String nome;
    private String endereco;
    private Boolean status;
    private String categoria;
    private String atracao;
    private String promocoes;

    public Estabelecimento(String nomeEst, String enderecoEst, Boolean statusEst, String categoriaEst, String atracaoEst, String promoEst){
        this.nome = nomeEst;
        this.endereco = enderecoEst;
        this.status = statusEst;
        this.categoria = categoriaEst;
        this.atracao = atracaoEst;
        this.promocoes = promoEst;
    }

    @Override
    public String toString() {
        return "Nome: " + getNome() + " - Endereço: " + getEndereco() + " - Status: " + getStatus() + " - Categoria: " + getCategoria() + "Atrações: " + getAtracao() + "Promoções: " + getPromocoes();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
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
