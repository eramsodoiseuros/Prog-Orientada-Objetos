package com.company;

public class Empresa {
    private int id;
    private int rating;
    private int n_encomendas;
    private int range;
    private int localizacao;
    private boolean disponivel;

    private int tipo;

    private double preco_transporte;
    private int n_max;

    private int registos;
    private double faturacao[];


    public boolean aceitoTransporteMedicamentos(){

        return false;
    }

    public void aceitaMedicamentos(boolean state){

    }
}
