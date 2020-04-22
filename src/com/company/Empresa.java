package com.company;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;
import java.util.Objects;

public class Empresa {
    private int id;
    private int rating;
    private int n_encomendas;
    private int range;
    private double localizacao;
    private boolean disponivel;

    private String tipo;

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
        this.tipo= "";
        this.preco_transporte = 0;
        this.n_max = 0;

        for (int i = 0; i<(this.faturacao.length); i++)
            this.faturacao[i] = 0;

        this.registos = new ArrayList<>();

    }


    public  Empresa (int id, int rating, int n_encomendas, int range, int localizacao, boolean disponivel, String tipo, double preco_transporte, int n_max, ArrayList<String> registos, double faturacao[]){
        this.id = id;
        this.disponivel = disponivel;
        this.localizacao = localizacao;
        this.n_encomendas = n_encomendas;
        this.range = range;
        this.rating = rating;
        this.tipo= tipo;
        this.preco_transporte = preco_transporte;
        this.n_max = n_max;
        this.faturacao = faturacao;
        this.registos = registos;


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
                localizacao == empresa.localizacao &&
                disponivel == empresa.disponivel &&
                Double.compare(empresa.preco_transporte, preco_transporte) == 0 &&
                n_max == empresa.n_max &&
                tipo.equals(empresa.tipo) &&
                registos.equals(empresa.registos) &&
                Arrays.equals(faturacao, empresa.faturacao);
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



    public boolean aceitoTransporteMedicamentos(){

        return false;
    }

    public void aceitaMedicamentos(boolean state){

    }
}
