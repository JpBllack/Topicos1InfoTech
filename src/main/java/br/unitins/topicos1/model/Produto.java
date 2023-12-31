package br.unitins.topicos1.model;


import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.*;

@Entity
public class Produto extends DefaultEntity{

    @NotBlank
    @Size(max = 100)
    private String nome;
    private String descricao;
    @NotNull
    private Double preco;

    @ManyToOne
    private Categoria categoria;

    public Produto() {
        // Construtor padrão
    }

    public Produto(String nome, String descricao, Double preco, Categoria categoria) {
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.categoria = categoria;
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }
}
