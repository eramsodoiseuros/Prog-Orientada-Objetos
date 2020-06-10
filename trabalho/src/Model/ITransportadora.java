package Model;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Interface de uma Transportadora
 * */
public interface ITransportadora extends Serializable {
    /**
     *
     * */
    String getNome();

    /**
     *
     * */
    ArrayList<Integer> getRating();

    /**
     *
     * */
    double getRange();

    /**
     *
     * */
    double getLocalizacaoX();

    /**
     *
     * */
    double getLocalizacaoY();

    /**
     *
     * */
    void setLocalizacaoY(double localizacaoY);

    /**
     *
     * */
    void setLocalizacaoX(double localizacaoX);

    /**
     *
     * */
    String getId();

    /**
     *
     * */
    List<String> getHistorico();

    /**
     *
     * */
    List<Double> getFaturacao();

    /**
     *
     * */
    double getPreco_transporte();

    /**
     *
     * */
    void setRange(double range);

    /**
     *
     * */
    void setId(String id) ;

    /**
     *
     * */
    void setPreco_km(double preco_km);

    /**
     *
     * */
    void setNif(String nif);

    /**
     *
     * */
    void setNome(String nome);

    /**
     *
     * */
    Double estrela();

    /**
     *
     * */
    String getEmail();

    /**
     *
     * */
    String getPwd();

    /**
     *
     * */
    void setPwd(String s);

    /**
     *
     * */
    void setEmail(String s);

    /**
     *
     *
     * */
     void setPreco_transporte(double preco_transporte);
    
    /**
     *
     * */
    double getPreco_km();

    double getDistancia();

    void setDistancia(Double d);
}
