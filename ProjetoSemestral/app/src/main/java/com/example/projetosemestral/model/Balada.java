package com.example.projetosemestral.model;

public class Balada {
    private String nomeBalada;
    private Boolean status;
    private String endereco;

    public Balada(String nomeBalada, boolean status, String endereco){
        this.nomeBalada = nomeBalada;
        this.status = status;
        this.endereco = endereco;
    }

    public String toString(){
        return "Nome: " + getNomeBalada() + " - " + getStatus() + " - Endereço: " + getEndereco();
    }

    public String getNomeBalada(){
        return nomeBalada;
    }
    public void setNomeBalada(String nomeBalada) {
        this.nomeBalada = nomeBalada;
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
}