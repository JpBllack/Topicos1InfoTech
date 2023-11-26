package org.acme.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Estado extends DefaultyEntity {
    
    @Column(length = 60)
    private String nome;

    @Column(length = 2)
    private String sigla;


    public String getnome() {
        return nome;
    }

    public void setnome(String nome) {
        this.nome = nome;
    }

    public String getsigla() {
        return sigla;
    }

    public void setsigla(String sigla) {
        this.sigla = sigla;
    }


    
}
