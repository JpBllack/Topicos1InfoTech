package org.acme.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@MappedSuperclass //Falta alguma anotação
public class DefaultyEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private LocalDateTime dataInclusao;


    @PrePersist // pre inclusao
    private void prePersisting() {
        this.dataInclusao = LocalDateTime.now();
    }

    public LocalDateTime getDataInclusao() {
        return dataInclusao;
    }

    public void setDataInclusao(LocalDateTime dataInclusao) {
        this.dataInclusao = dataInclusao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
