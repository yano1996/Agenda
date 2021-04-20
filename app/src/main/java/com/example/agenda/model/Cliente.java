package com.example.agenda.model;

import androidx.annotation.NonNull;

import java.io.Serializable;

public class Cliente implements Serializable {
    private int id = 0;
    private String nome;
    private String telefone;
    private String cpf;
    private String dataCadastro;
    private String horarioCadastro;
    private String dataDeNascimento;
    private String uf;

    public Cliente(String nome, String telefone, String cpf, String dataDeNascimento , String uf) {

        this.nome = nome;
        this.telefone = telefone;
        this.cpf = cpf;
        this.dataDeNascimento = dataDeNascimento;
        this.uf = uf;

    }

    public Cliente() {

    }


    //SET


    public void setUf(String uf) {
        this.uf = uf;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setDataCadastro(String dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public void setHorarioCadastro(String horarioCadastro) {
        this.horarioCadastro = horarioCadastro;
    }

    public void setDataDeNascimento(String dataDeNascimento) {
        this.dataDeNascimento = dataDeNascimento;
    }

    //GET


    public String getUf() {
        return uf;
    }

    public String getNome() {
        return nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getCpf() {
        return cpf;
    }

    public String getDataCadastro() {
        return dataCadastro;
    }

    public String getHorarioCadastro() {
        return horarioCadastro;
    }

    public String getDataDeNascimento() {
        return dataDeNascimento;
    }

    @NonNull
    @Override
    public String toString() {
        return  nome + " - " + telefone;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public boolean temIdValido() {
        return id>0;
    }

    public String ValidarSP(){
        return uf;
    }


}
