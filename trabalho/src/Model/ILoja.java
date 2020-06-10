package Model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

/**
 * Interface de uma Loja
 * */
public interface ILoja extends Serializable {
    /**
     * @return Set com uma estrutura Linha de Encomenda
     * */
    Set<LinhaEncomenda> getInventario();

    /**
     * @return String com o Id de Loja
     * */
    String getId();

    /**
     *
     * */
    void setId(String id);

    /**
     * @return String com o Nome de Loja
     * */
    String getNome();

    /**
     * @param nome String com o Nome da Loja
     * */
    void setNome(String nome);

    /**
     * @return String com a palavra-passe da Loja
     * */
    String getPwd();

    /**
     * @param pwd String com a palavra-passe da Loja
     * */
    void setPwd(String pwd);

    /**
     * @return String com o email da Loja
     * */
    String getEmail();

    /**
     * @param email String com o email da Loja
     * */
    void setEmail(String email);

    /**
     * @return Double com a localização de coordenada Y da Loja
     * */
    double getLocalizacaoY();

    /**
     * @return Double com a localização de coordenada X da Loja
     * */
    double getLocalizacaoX();

    /**
     * @param localizacaoX Double com a localização de coordenada X da Loja
     * */
    void setLocalizacaoX(double localizacaoX);

    /**
     * @param localizacaoY Double com a localização de coordenada Y da Loja
     * */
    void setLocalizacaoY(double localizacaoY);

    /**
     * @param e Encomenda a adicionar ao Histórico da Loja
     * */
    void addHistorico (IEncomenda e);

    /**
     * @return String que representa o número de pessoas numa fila
     * */
    String fila();

    /**
     *
     * */
    void add_fila();

    /**
     *
     * */
    void remove_fila();

    /**
     *
     * */
    void addLista(IEncomenda e);

    /**
     *
     * */
    void removeLista(String e);

    /**
     *
     * */
    List<String> precisa_recolha(ILoja l);

    int f_time();
}
