package br.unitins.topicos1.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.Column;

@Entity
public class Estado extends DefalutEntity {


    @Column(length = 60)
    private String nome;

    @Column(length = 2)
    private String sigla;

    private LocalDate dataCadastro;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }


    public LocalDate getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(LocalDate dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    

}
