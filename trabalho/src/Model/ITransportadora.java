package Model;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Interface de uma Transportadora
 * */
public interface ITransportadora extends Serializable{
    /**
     *
     * @return String com o Nome da Transportadora
     * */
    String getNome();

    /**
     *
     * @return List com as avaliações da Transportadora
     * */
    ArrayList<Integer> getRating();

    /**
     *
     * @return Double com o range
     * */
    double getRange();

    /**
     *
     * @return Double com a localização X
     * */
    double getLocalizacaoX();

    /**
     *
     * @return Double com a localização Y
     * */
    double getLocalizacaoY();

    /**
     *
     *  Double com a localização Y
     * */
    void setLocalizacaoY(double localizacaoY);

    /**
     *
     *  Double com a localização X
     * */
    void setLocalizacaoX(double localizacaoX);

    /**
     *
     * @return String com o ID da Transportadora
     * */
    String getId();

    /**
     *
     * @return List com o historico da Transportadora
     * */
    List<String> getHistorico();

    /**
     *
     * @return List com a faturação da Transportadora
     * */
    List<Double> getFaturacao();

    /**
     *
     * @return Double com o preço total do transporte
     * */
    double getPreco_transporte();

    /**
     *
     *  String com o range da Transportadora
     * */
    void setRange(double range);

    /**
     *
     *  String com o ID da Transportadora
     * */
    void setId(String id) ;

    /**
     *
     *  Double com o preço por km da Transportadora
     * */
    void setPreco_km(double preco_km);

    /**
     *
     *  String com o NIF da Transportadora
     * */
    void setNif(String nif);

    /**
     *
     * String com o Nome da Transportadora
     * */
    void setNome(String nome);

    /**
     *
     * @return Media de ratings
     * */
    Double estrela();

    /**
     *
     * @return String com o Email da Transportadora
     * */
    String getEmail();

    /**
     *
     * @return String com a password da Transportadora
     * */
    String getPwd();

    /**
     *
     *  String com a password da Transportadora
     * */
    void setPwd(String s);

    /**
     *
     *  String com o email da Transportadora
     * */
    void setEmail(String s);

    /**
     *
     *
     * Double com o preço de transporte da Transportadora
     * */
    void setPreco_transporte(double preco_transporte);

    /**
     *
     * @return Double com o preço por km da Transportadora
     * */
    double getPreco_km();

    /**
     * @return True ou false consoante a disponibilidade da transportadora para entregar
     * */
    boolean check_available();

    /**
     * Torna a transportadora disponivel para entrgas
     * */
    void available();

    /**
     * @return Double com o total percorrido pela transportadora da Transportadora
     * */
    double getDistancia();

    /**
     * Double com o total percorrido pela transportadora da Transportadora
     * */
    void setDistancia(Double d);

    List<String> faturacao();
}
