package Model;

import java.io.Serializable;
import java.util.Objects;

public class LinhaEncomenda implements Serializable {

    private String codProd;
    private String descricao;
    private double quantidade;
    private double preco;
    private double peso;
    private String tipo;

    public LinhaEncomenda(String codProd, String discricao, double quantidade, double preco, double peso, String tipo) {
        this.codProd = codProd;
        this.descricao = discricao;
        this.quantidade = quantidade;
        this.preco = preco;
        this.peso = peso;
        this.tipo = tipo;
    }

    public LinhaEncomenda() {
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

    public double precoTot() {
        return (this.preco * this.quantidade);
    }

    public double pesoTot() {
        return (this.peso * this.quantidade);
    }
}