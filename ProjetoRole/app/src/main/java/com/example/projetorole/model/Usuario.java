package com.example.projetorole.model;

public class Usuario{
    Integer id_usuario;
    String nome_usuario;
    String cpf_usuario;
    String senha_usuario;
    String data_usuario;

    public Usuario(String nome_usuario, String cpf_usuario, String senha_usuario, String data_usuario) {
        this.nome_usuario = nome_usuario;
        this.cpf_usuario = cpf_usuario;
        this.senha_usuario = senha_usuario;
        this.data_usuario = data_usuario;
    }

    public Integer getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(Integer id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getNome_usuario() {
        return nome_usuario;
    }

    public void setNome_usuario(String nome_usuario) {
        this.nome_usuario = nome_usuario;
    }

    public String getCpf_usuario() {
        return cpf_usuario;
    }

    public void setCpf_usuario(String cpf_usuario) {
        this.cpf_usuario = cpf_usuario;
    }

    public String getSenha_usuario() {
        return senha_usuario;
    }

    public void setSenha_usuario(String senha_usuario) {
        this.senha_usuario = senha_usuario;
    }

    public String getData_usuario() {
        return data_usuario;
    }

    public void setData_usuario(String data_usuario) {
        this.data_usuario = data_usuario;
    }
}
