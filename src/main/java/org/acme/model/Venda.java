package org.acme.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Venda extends DefaultyEntity {

    private Double valorTotal;

    private Double desconto;

    @OneToMany
    @JoinColumn(name = "venda_itemvenda")
    private List<ItemVenda> itemVendaList;

    @OneToOne
    @JoinColumn(name = "venda_pagamento")
    private Pagamento pagamento;

    @ManyToOne
    @JoinColumn(name = "usuario_venda")
    private Usuario usuario;

    public Pagamento getPagamento() {
        return pagamento;
    }

    public void setPagamento(Pagamento pagamento) {
        this.pagamento = pagamento;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Double getDesconto() {
        return desconto;
    }

    public void setDesconto(Double desconto) {
        this.desconto = desconto;
    }

    public List<ItemVenda> getItemVendaList() {
        return itemVendaList;
    }

    public void setItemVendaList(List<ItemVenda> itemVendaList) {
        this.itemVendaList = itemVendaList;
    }
}
