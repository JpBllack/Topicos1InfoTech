package br.unitins.topicos1.model;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.*;

@Entity
public class Categoria extends DefaultEntity {

    @NotNull
    private String nome;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

}
