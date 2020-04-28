package com.company;

import java.util.ArrayList;



public class Voluntario {
    private String id;
    private int rating;
    private int n_encomendas;
    private double range;
    private double localizacao;
    private boolean disponivel;

    private String tipo;
    private String nome;

    private ArrayList<String> registos;


    public Voluntario (){
        this.id = "";
        this.disponivel = true;
        this.localizacao = 0;
        this.n_encomendas = 0;
        this.range = 0;
        this.rating = 0;
        this.tipo= "";
        this.nome = "";
        this.registos = new ArrayList<>();

    }

    public Voluntario (String id, int rating, int n_encomendas, double range, double localizacao, boolean disponivel, String tipo, String nome, ArrayList<String> registos){
        this.id = id;
        this.tipo = tipo;
        this.rating = rating;
        this.n_encomendas = n_encomendas;
        this.range = range;
        this.localizacao = localizacao;
        this.disponivel = disponivel;
        this.registos = registos;
        this.nome = nome;

    }





    public String getId() {
        return id;
    }

    public double getLocalizacao() {
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

    public String getNome() {
        return nome;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public ArrayList<String> getRegistos() {
        return registos;
    }

    public void setRegistos(ArrayList<String> registos) {
        this.registos = registos;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Voluntario that = (Voluntario) o;
        return id.equals(that.id) &&
                nome.equals(that.nome) &&
                rating == that.rating &&
                n_encomendas == that.n_encomendas &&
                range == that.range &&
                localizacao == that.localizacao &&
                disponivel == that.disponivel &&
                registos == that.registos &&
                tipo.equals(that.tipo);
    }

    @Override
    public String toString() {
        return "Voluntario{" +
                "id=" + id +
                ", nome=" + nome +
                ", rating=" + rating +
                ", n_encomendas=" + n_encomendas +
                ", range=" + range +
                ", localizacao=" + localizacao +
                ", disponivel=" + disponivel +
                ", tipo='" + tipo + '\'' +
                ", registos=" + registos +
                '}';
    }


    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setLocalizacao(double localizacao) {
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

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }



    public boolean valida(String cod){
        return cod.startsWith("v");
    }

    public boolean aceitoTransporteMedicamentos(){

        return this.tipo.equals("Med");
    }

    public void aceitaMedicamentos(boolean state){

        setTipo("Med");

    }







}
