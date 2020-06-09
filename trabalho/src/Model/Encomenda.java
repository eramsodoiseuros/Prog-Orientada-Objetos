package Model;

import javax.xml.stream.Location;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Vector;

public class Encomenda implements Serializable, IEncomenda {
    private String id;
    private String loja;
    private String userId;
    private Location destino;
    private double peso;
    private List<String> estafeta;
    private double preco;
    private ArrayList<LinhaEncomenda> produtos;
    private String tipo;

    public Encomenda(String id, String loja, String userId, String tipo, double preco, Location destino, double peso, List<String> estafeta, ArrayList<LinhaEncomenda> produtos) {
        this.id = id;
        this.loja = loja;
        this.userId = userId;
        this.peso = peso;
        this.destino = destino;
        this.estafeta = estafeta;
        this.produtos = produtos;
        this.preco = preco;
        this.tipo = tipo;

    }

    public Encomenda() {
        this.id = null;
        this.loja = null;
        this.userId = null;
        this.peso = 0;
        this.destino = null;
        this.estafeta = new Vector<>();
        this.tipo = null;
        this.produtos = new ArrayList<>();
        this.preco = 0;

    }
    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
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

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getPeso() {
        return peso;
    }

    public Location getDestino() {
        return destino;
    }

    public List<String> getEstafeta() {
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

    public void setEstafeta(List<String> estafeta) {
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
                Objects.equals(tipo, encomenda.tipo) &&
                Objects.equals(loja, encomenda.loja) &&
                Objects.equals(userId, encomenda.userId) &&
                Objects.equals(destino, encomenda.destino) &&
                Objects.equals(estafeta, encomenda.estafeta) &&
                Objects.equals(produtos, encomenda.produtos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, loja, userId, destino, peso, estafeta, produtos, tipo);
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
                ", tipo=" + tipo +
                '}';
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public void setProdutos(ArrayList<LinhaEncomenda> produtos) {
        this.produtos = produtos;
    }

    public void addProdutos(LinhaEncomenda p) {
        produtos.add(p);
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

