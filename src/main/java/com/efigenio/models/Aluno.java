package com.efigenio.models;

import java.io.Serializable;

public class Aluno implements Serializable {
    private String nome;
    private String nascimento;
    private String cpf;
    private String email;
    private Notas notas;

    public Aluno(String nome, String nascimento, String cpf, String email) {
        this.nome = nome;
        this.nascimento = nascimento;
        this.cpf = cpf;
        this.email = email;
        this.notas = new Notas();
    }

    public String getNome() {
        return nome;
    }

    public String getNascimento() {
        return nascimento;
    }

    public String getCpf() {
        return cpf;
    }

    public String getEmail() {
        return email;
    }

    public Notas getNotas() {
        return notas;
    }

    public void setNotas(Notas notas) {
        this.notas = notas;
    }

    public double calcularNotaFinal() {
        return (notas.getNota1() + notas.getNota2() + notas.getNota3() + notas.getNota4()) / 4.0;
    }

    @Override
    public String toString() {
        return nome + " - Nota Final: " + calcularNotaFinal();
    }
}
