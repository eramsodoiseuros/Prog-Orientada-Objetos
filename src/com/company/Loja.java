package com.company;

import javax.xml.stream.Location;
import java.util.Set;

public class Loja {
    private String id;
    private Location localizacao;
    private Fila fila;
    private Set<Encomenda> lista_encomendas;
    private Set<Encomenda> historico;

    public Loja(String id, Location localizacao, Fila fila, Set<Encomenda> lista_encomendas, Set<Encomenda> historico) {
        this.id = id;
        this.localizacao = localizacao;
        this.fila = fila;
        this.lista_encomendas = lista_encomendas;
        this.historico = historico;
    }

    public String getId() {
        return id;
    }

    public Location getLocalizacao() {
        return localizacao;
    }

    public Fila getFila() {
        return fila;
    }

    public Set<Encomenda> getLista_encomendas() {
        return lista_encomendas;
    }

    public Set<Encomenda> getHistorico() {
        return historico;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setLocalizacao(Location localizacao) {
        this.localizacao = localizacao;
    }

    public void setFila(Fila fila) {
        this.fila = fila;
    }

    public void setLista_encomendas(Set<Encomenda> lista_encomendas) {
        this.lista_encomendas = lista_encomendas;
    }

    public void setHistorico(Set<Encomenda> historico) {
        this.historico = historico;
    }
}

class Fila{
    private int n_max;
    private int em_fila;
    private int tempo_medio;
    private boolean disponivel;

    public Fila(int n_max, int em_fila, int tempo_medio, boolean disponivel) {
        this.n_max = n_max;
        this.em_fila = em_fila;
        this.tempo_medio = tempo_medio;
        this.disponivel = disponivel;
    }

    public int getN_max() {
        return n_max;
    }

    public int getEm_fila() {
        return em_fila;
    }

    public int getTempo_medio() {
        return tempo_medio;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setN_max(int n_max) {
        this.n_max = n_max;
    }

    public void setEm_fila(int em_fila) {
        this.em_fila = em_fila;
    }

    public void setTempo_medio(int tempo_medio) {
        this.tempo_medio = tempo_medio;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }
}
