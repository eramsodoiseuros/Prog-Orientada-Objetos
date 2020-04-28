package com.company;

import java.sql.Array;
import java.util.*;

public class Empresa {
    private int id;
    private int rating;
    private int n_encomendas;
    private int range;
    private double localizacao;
    private boolean disponivel;
    private int nif;

    private String tipo;
    private String nome;

    private double preco_transporte;
    private int n_max;

    private ArrayList<String> registos;
    private double faturacao[];

    public Empresa (){
        this.id = 0;
        this.disponivel = true;
        this.localizacao = 0;
        this.n_encomendas = 0;
        this.range = 0;
        this.rating = 0;
        this.nif = 0;
        this.tipo= "";
        this.preco_transporte = 0;
        this.n_max = 0;
        this.nome = "";
        this.faturacao = new  double[12];
        this.registos = new ArrayList<>();

    }

    public  Empresa (int id, int rating, int n_encomendas, int range, int localizacao, int nif, boolean disponivel, String tipo, String nome, double preco_transporte, int n_max, ArrayList<String> registos, double faturacao[]){
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

    public int getNif() {
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

    public int getRange() {
        return range;
    }

    public int getN_encomendas() {
        return n_encomendas;
    }

    public double getLocalizacao() {
        return localizacao;
    }

    public int getId() {
        return id;
    }

    public double getPreco_transporte() {
        return preco_transporte;
    }

    public int getN_max() {
        return n_max;
    }

    public ArrayList<String> getRegistos() {
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

    public void setRange(int range) {
        this.range = range;
    }

    public void setN_encomendas(int n_encomendas) {
        this.n_encomendas = n_encomendas;
    }

    public void setLocalizacao(double localizacao) {
        this.localizacao = localizacao;
    }

    public void setId(int id) {
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

    public void setRegistos(ArrayList<String> registos) {
        this.registos = registos;
    }

    public void setNif(int nif) {
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
        return "Empresa{" +
                "id=" + id +
                ", rating=" + rating +
                ", n_encomendas=" + n_encomendas +
                ", range=" + range +
                ", localizacao=" + localizacao +
                ", disponivel=" + disponivel +
                ", tipo='" + tipo + '\'' +
                ", preco_transporte=" + preco_transporte +
                ", n_max=" + n_max +
                ", registos=" + registos +
                ", faturacao=" + Arrays.toString(faturacao) +
                '}';
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Empresa empresa = (Empresa) o;
        return id == empresa.id &&
                rating == empresa.rating &&
                n_encomendas == empresa.n_encomendas &&
                range == empresa.range &&
                Double.compare(empresa.localizacao, localizacao) == 0 &&
                disponivel == empresa.disponivel &&
                Double.compare(empresa.preco_transporte, preco_transporte) == 0 &&
                nif == empresa.nif &&
                n_max == empresa.n_max &&
                Objects.equals(tipo, empresa.tipo) &&
                Objects.equals(nome, empresa.nome) &&
                Objects.equals(registos, empresa.registos) &&
                Arrays.equals(faturacao, empresa.faturacao);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(id, rating, n_encomendas, range, localizacao, disponivel, nif, tipo, nome, preco_transporte, n_max, registos);
        result = 31 * result + Arrays.hashCode(faturacao);
        return result;
    }


}
