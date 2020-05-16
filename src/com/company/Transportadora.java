package com.company;

import javax.xml.stream.Location;
import java.sql.Array;
import java.util.*;

public class Transportadora {
    private String id;
    private int rating;
    private int n_encomendas;
    private double range;
    private Location localizacao;
    private boolean disponivel;
    private String nif;

    private String tipo;
    private String nome;

    private double preco_transporte;
    private int n_max;

    private Set<Encomenda> registos;
    private double[] faturacao;

    public Transportadora (){
        this.id = "";
        this.disponivel = true;
        this.n_encomendas = 0;
        this.range = 0;
        this.rating = 0;
        this.nif = "";
        this.tipo= "";
        this.preco_transporte = 0;
        this.n_max = 0;
        this.nome = "";
        this.faturacao = new  double[12];
        this.registos = new HashSet<Encomenda>();
    }

    public  Transportadora (String id, int rating, int n_encomendas, int range, Location localizacao, String nif, boolean disponivel, String tipo, String nome, double preco_transporte, int n_max, Set<Encomenda> registos, double[] faturacao){
        this.id = id;
        this.disponivel = disponivel;
        this.localizacao = localizacao;
        this.n_encomendas = n_encomendas;
        this.range = range;
        this.rating = rating;
        this.tipo= tipo;
        this.nome = nome;
        this.nif = nif;
        this.preco_transporte = preco_transporte;
        this.n_max = n_max;
        this.faturacao = faturacao;
        this.registos = registos;

    }

    public String getNif() {
        return nif;
    }

    public String getNome() {
        return nome;
    }

    public int getRating() {
        return rating;
    }

    public String getTipo() {
        return tipo;
    }

    public double getRange() {
        return range;
    }

    public int getN_encomendas() {
        return n_encomendas;
    }

    public Location getLocalizacao() {
        return localizacao;
    }

    public String getId() {
        return id;
    }

    public double getPreco_transporte() {
        return preco_transporte;
    }

    public int getN_max() {
        return n_max;
    }

    public Set<Encomenda> getRegistos() {
        return registos;
    }

    public double[] getFaturacao() {
        return faturacao;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public void setRange(double range) {
        this.range = range;
    }

    public void setN_encomendas(int n_encomendas) {
        this.n_encomendas = n_encomendas;
    }

    public void setLocalizacao(Location localizacao) {
        this.localizacao = localizacao;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    public void setFaturacao(double[] faturacao) {
        this.faturacao = faturacao;
    }

    public void setN_max(int n_max) {
        this.n_max = n_max;
    }

    public void setPreco_transporte(double preco_transporte) {
        this.preco_transporte = preco_transporte;
    }

    public void setRegistos(Set<Encomenda> registos) {
        this.registos = registos;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public boolean valida(String cod){
        return cod.startsWith("t");
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Empresa{").append("id =").append(id)
                .append(", NIF =").append(nif)
                .append(", nome =").append(nome)
                .append(", rating = ").append(rating)
                .append(", número encomendas = ").append(n_encomendas)
                .append(", range = ").append(range)
                .append(", localização = ").append(localizacao)
                .append(", disponivel = ").append(disponivel)
                .append(", tipo = ").append(tipo)
                .append(", preço dos transportes = ").append(preco_transporte)
                .append(", número max = ").append(n_max)
                .append(", faturacao = ").append(Arrays.toString(faturacao))
                .append(", registos = ").append(registos)
                .append("}; \n");
        return sb.toString();
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transportadora empresa = (Transportadora) o;
        return Objects.equals(id, empresa.id);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(id, rating, n_encomendas, range, localizacao, disponivel, nif, tipo, nome, preco_transporte, n_max, registos);
        result = 31 * result + Arrays.hashCode(faturacao);
        return result;
    }


}
