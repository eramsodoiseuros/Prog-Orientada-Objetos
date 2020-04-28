package com.company;

import javax.xml.stream.Location;
import java.util.PrimitiveIterator;

public class Encomenda {
    private String id;
    private int rating;

    private double peso;
    private int produtos;
    private String tipo;

    private String loja;
    private Location destino;
    private String estafeta;

    private double preco_encomenda;

    public Encomenda(String id, int rating, double peso, int produtos, String tipo, String loja, Location destino, String estafeta, double preco_encomenda) {
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

    public String getId() {
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

    public String getTipo() {
        return tipo;
    }

    public String getLoja() {
        return loja;
    }

    public Location getDestino() {
        return destino;
    }

    public String getEstafeta() {
        return estafeta;
    }

    public double getPreco_encomenda() {
        return preco_encomenda;
    }

    public void setId(String id) {
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

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setLoja(String loja) {
        this.loja = loja;
    }

    public void setDestino(Location destino) {
        this.destino = destino;
    }

    public void setEstafeta(String estafeta) {
        this.estafeta = estafeta;
    }

    public void setPreco_encomenda(double preco_encomenda) {
        this.preco_encomenda = preco_encomenda;
    }

}
