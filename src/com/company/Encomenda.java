package com.company;

import java.util.PrimitiveIterator;

public class Encomenda {
    private int id;
    private int rating;

    private double peso;
    private int produtos;
    private int tipo;

    private int loja;
    private int destino;
    private int estafeta;

    private int preco_encomenda;

    public Encomenda(int id, int rating, double peso, int produtos, int tipo, int loja, int destino, int estafeta, int preco_encomenda) {
        this.id = id;
        this.rating = rating;
        this.peso = peso;
        this.produtos = produtos;
        this.tipo = tipo;
        this.loja = loja;
        this.destino = destino;
        this.estafeta = estafeta;
        this.preco_encomenda = preco_encomenda;
    }

    public int getId() {
        return id;
    }

    public int getRating() {
        return rating;
    }

    public double getPeso() {
        return peso;
    }

    public int getProdutos() {
        return produtos;
    }

    public int getTipo() {
        return tipo;
    }

    public int getLoja() {
        return loja;
    }

    public int getDestino() {
        return destino;
    }

    public int getEstafeta() {
        return estafeta;
    }

    public int getPreco_encomenda() {
        return preco_encomenda;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public void setProdutos(int produtos) {
        this.produtos = produtos;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public void setLoja(int loja) {
        this.loja = loja;
    }

    public void setDestino(int destino) {
        this.destino = destino;
    }

    public void setEstafeta(int estafeta) {
        this.estafeta = estafeta;
    }

    public void setPreco_encomenda(int preco_encomenda) {
        this.preco_encomenda = preco_encomenda;
    }


}
