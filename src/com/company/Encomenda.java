package com.company;

import javax.xml.stream.Location;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.PrimitiveIterator;

public class Encomenda implements Serializable {
    private String id;
    private String loja;
    private String userId;
    private Location destino;

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    private double peso;
    private String estafeta;
    private double preco;
    private ArrayList<LinhaEncomenda> produtos;


    public Encomenda(String id, String loja, String userId, double preco, Location destino, double peso, String estafeta, ArrayList<LinhaEncomenda> produtos) {
        this.id = id;
        this.loja = loja;
        this.userId = userId;
        this.peso = peso;
        this.destino = destino;
        this.estafeta = estafeta;
        this.produtos = produtos;
        this.preco = preco;

    }
    public Encomenda() {
        this.id = null;
        this.loja = null;
        this.userId = null;
        this.peso = 0;
        this.destino = null;
        this.estafeta = null;
        this.produtos = new ArrayList<>();
        this.preco = 0;

    }



    public String getId() {
        return id;
    }

    public String getLoja() {
        return loja;
    }

    public String getUserId() {
        return userId;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getPeso() {
        return peso;
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

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Encomenda encomenda = (Encomenda) o;
        return Double.compare(encomenda.peso, peso) == 0 &&
                Objects.equals(id, encomenda.id) &&
                Objects.equals(loja, encomenda.loja) &&
                Objects.equals(userId, encomenda.userId) &&
                Objects.equals(destino, encomenda.destino) &&
                Objects.equals(estafeta, encomenda.estafeta) &&
                Objects.equals(produtos, encomenda.produtos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, loja, userId, destino, peso, estafeta, produtos);
    }

    @Override
    public String toString() {
        return "Encomenda{" +
                "id='" + id + '\'' +
                ", loja='" + loja + '\'' +
                ", userId='" + userId + '\'' +
                ", destino=" + destino +
                ", peso=" + peso +
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

    public ArrayList<LinhaEncomenda> addProdutosFromString (String s){


        ArrayList<LinhaEncomenda> l = new ArrayList<>();
        int i =0;
        int r = 0;
        String[] parts = s.split(",", 20);
        while (r<20) {

         LinhaEncomenda le = new LinhaEncomenda();

         le.setCodProd(parts[r]);
         le.setDescricao(parts[r+1]);
         le.setQuantidade(Integer.parseInt(parts[r+2]));
         le.setPreco(Double.parseDouble(parts[r+3]));

         l.add(le);

            r++;
        }
        return l;
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
           i += f.precoTot();

        }

        return i;
    }

    public double getPesoTot () {
        double i = 0;
        for (LinhaEncomenda f : produtos) {
            i += f.pesoTot();

        }

        return i;
    }


}

class LinhaEncomenda implements  Serializable {

    private String codProd;
    private String descricao;
    private double quantidade;
    private double preco;
    private  double peso;
    private String tipo;

    public LinhaEncomenda(String codProd, String discricao, double quantidade, double preco, double peso, String tipo){

        this.codProd = codProd;
        this.descricao = discricao;
        this.quantidade = quantidade;
        this.preco = preco;
        this.peso = peso;
        this.tipo = tipo;
    }

    public LinhaEncomenda(){

        this.codProd = null;
        this.descricao = null;
        this.quantidade = 0;
        this.preco = 0;
        this.peso = 0;
        this.tipo = null;
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

    public double getQuantidade() {
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

    public void setQuantidade(double quantidade) {
        this.quantidade = quantidade;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public double precoTot(){

        return (this.preco*this.quantidade);
    }

    public double pesoTot(){

        return (this.peso*this.quantidade);
    }
}
