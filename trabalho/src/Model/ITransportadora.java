package Model;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public interface ITransportadora extends Serializable {

    public String getNif();

    public String getNome();

    public ArrayList<Integer> getRating();

    public String getTipo();

    public double getRange();

    public int getN_encomendas();

    public double getLocalizacaoX();

    public double getLocalizacaoY();

    public void setLocalizacaoY(double localizacaoY);

    public void setLocalizacaoX(double localizacaoX);

    public String getId();

    public double getPreco_km();

    public int getN_max();

    public Set<Encomenda> getHistorico();

    public List<Double> getFaturacao();

    public void setTipo(String tipo);

    public double getPreco_transporte();

    public void setPreco_transporte(double preco_transporte);

    public void setRating(ArrayList<Integer> rating);

    public void setRange(double range);

    public void setN_encomendas(int n_encomendas) ;

    public double getDistancia();

    public void setDistancia(double distancia);


    public void setId(String id) ;

    public void setDisponivel(boolean disponivel) ;

    public void setFaturacao(List<Double> faturacao);

    public void setN_max(int n_max);

    public void setPreco_km(double preco_km);

    public void setAtivas(Set<Encomenda> ativas);

    public void setNif(String nif);

    public void setNome(String nome);

    public boolean valida(String cod);

    public Set<Encomenda> getAtivas();

    public void setHistorico(Set<Encomenda> historico);

    public int compareTo(ITransportadora t);
}
