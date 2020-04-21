package com.company;

public class Loja {
    private int id;
    private int localizacao;
    private Fila fila;
    private int lista_encomendas;
    private int historico;
}

class Fila{
    private int n_max;
    private int em_fila;
    private int tempo_medio;
    private boolean disponivel;
}
