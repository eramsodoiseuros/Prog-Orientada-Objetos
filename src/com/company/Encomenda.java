package com.company;

import javax.xml.stream.Location;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.PrimitiveIterator;

public class Encomenda {
    private String id;
    private String loja;
    private Location destino;
    private String estafeta;
    private ArrayList<LinhaEncomenda> produtos;


    public Encomenda(String id, String loja, Location destino, String estafeta, ArrayList<LinhaEncomenda> produtos) {
        this.id = id;
        this.loja = loja;
        this.destino = destino;
        this.estafeta = estafeta;
        this.produtos = produtos;

    }

    public String getId() {
        return id;
    }

    public String getLoja() {
        return loja;
    }

    public Location getDestino() {
        return destino;
    }

    public String getEstafeta() {
        return estafeta;
    }

    public ArrayList<LinhaEncomenda> getProdutos() {
        return produtos;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setLoja(String loja) {
        this.loja = loja;
    }

    public void setDestino(Location destino) {
        this.destino = destino;
    }

    public void setEstafeta(String estafeta) {
        this.estafeta = estafeta;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Encomenda encomenda = (Encomenda) o;
        return  Objects.equals(id, encomenda.id) &&
                Objects.equals(loja, encomenda.loja) &&
                Objects.equals(destino, encomenda.destino) &&
                Objects.equals(estafeta, encomenda.estafeta) &&
                Objects.equals(produtos, encomenda.produtos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, loja, destino, estafeta, produtos);
    }

    @Override
    public String toString() {
        return "Encomenda{" +
                "id='" + id + '\'' +
                ", loja='" + loja + '\'' +
                ", destino=" + destino +
                ", estafeta='" + estafeta + '\'' +
                ", produtos=" + produtos +
                '}';
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public void setProdutos(ArrayList<LinhaEncomenda> produtos) {
        this.produtos = produtos;
    }

    public ArrayList<LinhaEncomenda> addProdutos(LinhaEncomenda p) {

        produtos.add(p);
        return produtos;
    }

    public boolean existeProduto(String codProd) {

        for (LinhaEncomenda f : produtos) {
            if (f.getCodProd().equals(codProd)) return true;

        }

        return false;
    }

    public double getPrecoTot () {
        double i = 0;
        for (LinhaEncomenda f : produtos) {
           i += f.precoTot(f);

        }

        return i;
    }

    public double getPesoTot () {
        double i = 0;
        for (LinhaEncomenda f : produtos) {
            i += f.pesoTot(f);

        }

        return i;
    }


}

class LinhaEncomenda {

    private String codProd;
    private String descricao;
    private int quantidade;
    private double preco;
    private  double peso;
    private String tipo;

    public LinhaEncomenda(String codProd, String discricao, int quantidade, double preco, double peso, String tipo){

        this.codProd = codProd;
        this.descricao = discricao;
        this.quantidade = quantidade;
        this.preco = preco;
        this.peso = peso;
        this.tipo = tipo;
    }


    public String getCodProd() {
        return codProd;
    }

    public double getPeso() {
        return peso;
    }

    public String getDescricao() {
        return descricao;
    }

    @Override
    public String toString() {
        return "LinhaEncomenda{" +
                "codProd='" + codProd + '\'' +
                ", descricao='" + descricao + '\'' +
                ", quantidade=" + quantidade +
                ", preco=" + preco +
                ", peso=" + peso +
                ", tipo=" + tipo +
                '}';
    }

    public int getQuantidade() {
        return quantidade;
    }

    public double getPreco() {
        return preco;
    }

    public String getTipo() {
        return tipo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LinhaEncomenda that = (LinhaEncomenda) o;
        return quantidade == that.quantidade &&
                Double.compare(that.preco, preco) == 0 &&
                Double.compare(that.peso, peso) == 0 &&
                Objects.equals(codProd, that.codProd) &&
                Objects.equals(descricao, that.descricao) &&
                Objects.equals(tipo, that.tipo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codProd, descricao, quantidade, preco, tipo);
    }

    public void setCodProd(String codProd) {
        this.codProd = codProd;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public double precoTot(LinhaEncomenda e){

        return (e.getPreco()*e.getQuantidade());
    }

    public double pesoTot(LinhaEncomenda e){

        return (e.getPeso()*e.getQuantidade());
    }
}
