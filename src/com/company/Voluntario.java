package com.company;

import javax.xml.stream.Location;
import java.io.*;
import java.util.*;

public class Voluntario implements Serializable, IVoluntario {
    private String id;
    private String pwd;
    private String email;
    private ArrayList<Integer> rating;
    private int n_encomendas;
    private double range;
    private double localizacaoX;
    private double localizacaoY;
    private boolean disponivel;


    private String tipo;
    private String nome;
    private Set<Encomenda> registos;
    private Encomenda ativa;

    public Voluntario(String id, String email, String pwd, ArrayList<Integer> rating, int n_encomendas, int range, double localizacaoX, double localizacaoY, boolean disponivel, String tipo, String nome, Set<Encomenda> registos, Encomenda ativa) {
        this.id = id;
        this.tipo = tipo;
        this.nome = nome;
        this.nome = nome;
        this.email = email;
        this.rating = rating;
        this.n_encomendas = n_encomendas;
        this.range = range;
        this.localizacaoX = localizacaoX;
        this.localizacaoY = localizacaoY;
        this.disponivel = disponivel;
        this.registos = registos;
        this.ativa = ativa;
    }

    public Voluntario() {
        this.id = null;
        this.tipo = null;
        this.nome = null;
        this.rating = new ArrayList<>();
        this.nome = null;
        this.email = null;
        this.n_encomendas = 0;
        this.disponivel = true;
        this.range = 0;
        this.localizacaoX = 0;
        this.localizacaoY = 0;
        this.n_encomendas = 0;
        this.disponivel = false;
        this.registos = new HashSet<Encomenda>();
        this.ativa = new Encomenda();
    }

    public String getId() {
        return id;
    }

    public double getLocalizacaoX() {
        return localizacaoX;
    }

    public double getLocalizacaoY() {
        return localizacaoY;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNome() {
        return nome;
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

    public ArrayList<Integer> getRating() {
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

    public void setLocalizacaoX(double localizacaoX) {
        this.localizacaoX = localizacaoX;
    }

    public void setLocalizacaoY(double localizacaoY) {
        this.localizacaoY = localizacaoY;
    }

    public void setN_encomendas(int n_encomendas) {
        this.n_encomendas = n_encomendas;
    }

    public Encomenda getAtiva() {
        return ativa;
    }

    public void setAtiva(Encomenda ativa) {
        this.ativa = ativa;
    }

    public void setRange(double range) {
        this.range = range;
    }

    public void setRating(ArrayList<Integer> rating) {
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
                .append(", X = ").append(localizacaoX)
                .append(", Y = ").append(localizacaoY)
                .append(", disponivel = ").append(disponivel)
                .append(", tipo = ").append(tipo)
                .append(", registos = ").append(registos)
                .append(", Ativa = ").append(ativa)
                .append("}; \n");
        return sb.toString();
    }


    public double estrela(){
        double sum = 0;
        if(!this.rating.isEmpty()) {
            for (int mark : this.rating) {
                sum += mark;
            }
            return sum / this.rating.size();
        }
        return sum;
    }


    public void aceitaMedicamentos(boolean state) {

        state = true;
    }

    public boolean aceitoTransporteMedicamentos(){
        return this.tipo.equals("M");
    }


}
