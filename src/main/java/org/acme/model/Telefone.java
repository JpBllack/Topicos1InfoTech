package org.acme.model;

import jakarta.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Telefone extends DefaultyEntity {

    @OneToOne
    @JoinColumn(name = "telefone_usuario")
    private Usuario usuario;
    private String CodigoArea;
    private String numero;

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getNumero() {
        return numero;
    }
    public void setNumero(String numero) {
        this.numero = numero;
    }
    public String getCodigoArea() {
        return CodigoArea;
    }
    public void setCodigoArea(String codigoArea) {
        CodigoArea = codigoArea;
    }
  
}
