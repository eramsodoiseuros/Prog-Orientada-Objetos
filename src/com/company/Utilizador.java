package com.company;

public class Utilizador {
    private int id;
    private int rating;
    private int localizacao;

    private int historico;

    public Utilizador(int id, int rating, int localizacao, int historico) {
        this.id = id;
        this.rating = rating;
        this.localizacao = localizacao;
        this.historico = historico;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public int getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(int localizacao) {
        this.localizacao = localizacao;
    }

    public int getHistorico() {
        return historico;
    }

    public void setHistorico(int historico) {
        this.historico = historico;
    }
}
