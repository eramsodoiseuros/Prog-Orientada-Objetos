package com.company;

import javax.xml.stream.Location;
import java.util.*;

public class Utilizador {
    private String id;
    private String nome;
    private int rating;
    private Location localizacao;

    private Set<Encomenda> historico;

    public Utilizador(String id, String nome, int rating, Location localizacao, Set<Encomenda> historico) {
        this.id = id;
        this.nome = nome;
        this.rating = rating;
        this.localizacao = localizacao;
        this.historico = historico;
    }

    public Utilizador() {
        this.id = "";
        this.nome = "";
        this.rating = 0;
        this.localizacao = null;
        this.historico = null;
    }

    public String getId() {
        return id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public Location getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(Location localizacao) {
        this.localizacao = localizacao;
    }

    public Set<Encomenda> getHistorico() {
        return historico;
    }

    public void setHistorico(Set<Encomenda> historico) {
        this.historico = historico;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Utilizador that = (Utilizador) o;
        return rating == that.rating &&
                Objects.equals(id, that.id) &&
                Objects.equals(nome, that.nome) &&
                Objects.equals(localizacao, that.localizacao) &&
                Objects.equals(historico, that.historico);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, rating, localizacao, historico);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Utilizador{").append("id =").append(id)
                .append(", nome = ").append(nome)
                .append(", rating = ").append(rating)
                .append(", localização = ").append(localizacao)
                .append(", historico = ").append(historico)
                .append("}; \n");
        return sb.toString();
    }



}
