package com.company;

import javax.xml.stream.Location;
import java.io.*;
import java.util.*;

public class Voluntario {
    private String id;
    private int rating;
    private int n_encomendas;
    private double range;
    private Location localizacao;
    private boolean disponivel;

    private String tipo;
    private String nome;
    private Set<Encomenda> registos;

    public Voluntario(String id, int rating, int n_encomendas, int range, Location localizacao, boolean disponivel, String tipo, String nome, Set<Encomenda> registos) {
        this.id = id;
        this.tipo = tipo;
        this.nome = nome;
        this.rating = rating;
        this.n_encomendas = n_encomendas;
        this.range = range;
        this.localizacao = localizacao;
        this.disponivel = disponivel;
        this.registos = registos;
    }

    public Voluntario() {
        this.id = "";
        this.tipo = "";
        this.nome = "";
        this.rating = 0;
        this.n_encomendas = 0;
        this.disponivel = true;
        this.range = 0;
        this.localizacao = null;
        this.n_encomendas = 0;
        this.disponivel = false;
        this.rating = 0;
        this.registos = new HashSet<Encomenda>();
    }

    public String getId() {
        return id;
    }

    public Location getLocalizacao() {
        return localizacao;
    }

    public int getN_encomendas() {
        return n_encomendas;
    }

    public double getRange() {
        return range;
    }

    public String getTipo() {
        return tipo;
    }

    public int getRating() {
        return rating;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public Set<Encomenda> getRegistos() {
        return registos;
    }


    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setLocalizacao(Location localizacao) {
        this.localizacao = localizacao;
    }

    public void setN_encomendas(int n_encomendas) {
        this.n_encomendas = n_encomendas;
    }

    public void setRange(double range) {
        this.range = range;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setRegistos(Set<Encomenda> registos) {
        this.registos = registos;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Voluntario that = (Voluntario) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Voluntario{").append("id =").append(id)
                .append(", nome = ").append(nome)
                .append(", rating = ").append(rating)
                .append(", número encomendas = ").append(n_encomendas)
                .append(", range = ").append(range)
                .append(", localização = ").append(localizacao)
                .append(", disponivel = ").append(disponivel)
                .append(", tipo = ").append(tipo)
                .append(", registos = ").append(registos)
                .append("}; \n");
        return sb.toString();
    }


    public void aceitaMedicamentos(boolean state) {
        setTipo("Med");
    }

    public boolean valida(String cod){
        return cod.startsWith("v");
    }

    public boolean aceitoTransporteMedicamentos(){
        return this.tipo.equals("Med");
    }


}
