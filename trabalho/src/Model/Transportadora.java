package Model;

import java.io.Serializable;
import java.util.*;

public class Transportadora implements Serializable, ITransportadora {
    private String id;
    private ArrayList<Integer> rating;
    private int n_encomendas;
    private double range;
    private double localizacaoX;
    private double localizacaoY;
    private double distancia;
    private boolean disponivel;

    private String nif;
    private String email;
    private String pwd;

    private String tipo;
    private String nome;

    private double preco_km;
    private double preco_transporte;
    private int n_max;

    private Set<Encomenda> ativas;
    private Set<Encomenda> historico;
    private List<Double> faturacao;

    public boolean isDisponivel() {
        return disponivel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public double getDistancia() {
        return distancia;
    }

    public void setDistancia(double distancia) {
        this.distancia = distancia;
    }

    public Transportadora (){
        this.id = null;
        this.disponivel = true;
        this.n_encomendas = 0;
        this.range = 0;
        this.distancia = 0;
        this.rating = new ArrayList<>();

        this.nif = null;
        this.tipo= null;
        this.preco_km = 0;
        this.n_max = 0;
        this.nome = null;
        this.localizacaoX =0;
        this.localizacaoY = 0;
        this.faturacao = new ArrayList<>();
        this.ativas = new HashSet<Encomenda>();
        this.historico = new HashSet<Encomenda>();
        this.pwd = null;
        this.email = null;
        this.preco_transporte = 0;
    }

    public  Transportadora (String id, ArrayList<Integer> rating, double distancia, int n_encomendas, int range, double localizacaoX, double localizacaoY, String nif, boolean disponivel, String tipo, String nome, double preco_km, int n_max, Set<Encomenda> historico, Set<Encomenda> ativas, List<Double> faturacao){
        this.id = id;
        this.disponivel = disponivel;
        this.localizacaoX = localizacaoX;
        this.localizacaoY = localizacaoY;
        this.n_encomendas = n_encomendas;
        this.distancia = distancia;
        this.range = range;
        this.rating = rating;
        this.tipo= tipo;
        this.nome = nome;
        this.nif = nif;
        this.preco_km = preco_km;
        this.n_max = n_max;
        this.faturacao = faturacao;
        this.historico = historico;
        this.ativas = ativas;

    }

    public String getNif() {
        return nif;
    }

    public String getNome() {
        return nome;
    }

    public ArrayList<Integer> getRating() {
        return rating;
    }

    public String getTipo() {
        return tipo;
    }

    public double getRange() {
        return range;
    }

    public int getN_encomendas() {
        return n_encomendas;
    }

    public double getLocalizacaoX() {
        return localizacaoX;
    }

    public double getLocalizacaoY() {
        return localizacaoY;
    }

    public void setLocalizacaoY(double localizacaoY) {
        this.localizacaoY = localizacaoY;
    }

    public void setLocalizacaoX(double localizacaoX) {
        this.localizacaoX = localizacaoX;
    }

    public String getId() {
        return id;
    }

    public double getPreco_km() {
        return preco_km;
    }

    public int getN_max() {
        return n_max;
    }

    public Set<Encomenda> getHistorico() {
        return historico;
    }

    public List<Double> getFaturacao() {
        return faturacao;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getPreco_transporte() {
        return preco_transporte;
    }

    public void setPreco_transporte(double preco_transporte) {
        this.preco_transporte = preco_transporte;
    }

    public void setRating(ArrayList<Integer> rating) {
        this.rating = rating;
    }

    public void setRange(double range) {
        this.range = range;
    }

    public void setN_encomendas(int n_encomendas) {
        this.n_encomendas = n_encomendas;
    }


    public void setId(String id) {
        this.id = id;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    public void setFaturacao(List<Double> faturacao) {
        this.faturacao = faturacao;
    }

    public void setN_max(int n_max) {
        this.n_max = n_max;
    }

    public void setPreco_km(double preco_km) {
        this.preco_km = preco_km;
    }

    public void setAtivas(Set<Encomenda> ativas) {
        this.ativas = ativas;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public boolean valida(String cod){
        return cod.startsWith("t");
    }

    public Set<Encomenda> getAtivas() {
        return ativas;
    }

    public void setHistorico(Set<Encomenda> historico) {
        this.historico = historico;
    }

    @Override
    public String toString() {
        return "Transportadora{" +
                "id='" + id + '\'' +
                ", rating=" + rating +
                ", n_encomendas=" + n_encomendas +
                ", range=" + range +
                ", localizacaoX=" + localizacaoX +
                ", localizacaoY=" + localizacaoY +
                ", disponivel=" + disponivel +
                ", nif='" + nif + '\'' +
                ", tipo='" + tipo + '\'' +
                ", nome='" + nome + '\'' +
                ", preco_km=" + preco_km +
                ", n_max=" + n_max +
                ", historico=" + historico +
                ", Ativas=" + ativas +
                ", faturacao=" + faturacao +
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
        Transportadora that = (Transportadora) o;
        return rating == that.rating &&
                n_encomendas == that.n_encomendas &&
                Double.compare(that.range, range) == 0 &&
                Double.compare(that.localizacaoX, localizacaoX) == 0 &&
                Double.compare(that.localizacaoY, localizacaoY) == 0 &&
                disponivel == that.disponivel &&
                Double.compare(that.preco_km, preco_km) == 0 &&
                n_max == that.n_max &&
                Objects.equals(id, that.id) &&
                Objects.equals(nif, that.nif) &&
                Objects.equals(tipo, that.tipo) &&
                Objects.equals(nome, that.nome) &&
                Objects.equals(historico, that.historico) &&
                Objects.equals(ativas, that.ativas) &&
                faturacao == faturacao;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, rating, n_encomendas, range, localizacaoX, localizacaoY, disponivel, nif, email, pwd, tipo, nome, preco_km, n_max, ativas, historico, faturacao);
    }

    public double estrela(){
        double sum = 0;
        if(!this.rating.isEmpty()) {
            for (double mark : this.rating) {
                sum += mark;
            }
            return sum / this.rating.size();
        }
        return sum;
    }

/*
    public double fazFat(){
        double r;
        double p;
        double peso;

        for (Encomenda e: this.ativas) {

            p=+e.getPreco();
            peso = e.getPesoTot()
        }

        r=this.faturacao + p + this.getPreco_transporte() * this.distancia + 0.2*peso;

        return r;
    }*/
}
