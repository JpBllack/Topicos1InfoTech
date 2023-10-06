package br.unitins.topicos1.model;

import jakarta.persistence.Entity;

@Entity
public class Categoria extends DefalutEntity {

    private String nome;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

}
