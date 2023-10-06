package br.unitins.topicos1.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Telefone extends DefalutEntity {

    private String CodigoArea;
    private String numero;


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

