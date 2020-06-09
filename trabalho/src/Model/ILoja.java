package Model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * Interface de uma Loja
 * */
public interface ILoja extends Serializable {
    /**
     *
     * */
    Set<LinhaEncomenda> getInventario();

    /**
     *
     * */
    String getId();

    /**
     *
     * */
    String getNome();

    /**
     *
     * */
    String getPwd();

    /**
     *
     * */
    void setPwd(String pwd);

    /**
     *
     * */
    String getEmail();

    /**
     *
     * */
    void setEmail(String email);

    /**
     *
     * */
    void setNome(String nome);

    /**
     *
     * */
    double getLocalizacaoY();

    /**
     *
     * */
    double getLocalizacaoX();

    /**
     *
     * */
    HashSet<IEncomenda> getLista_encomendas();

    /**
     *
     * */
    void setId(String id);

    /**
     *
     * */
    void setLocalizacaoX(double localizacaoX);

    /**
     *
     * */
    void setLocalizacaoY(double localizacaoY);

    /**
     *
     * */
    void addHistorico (IEncomenda e);

    String fila();
}
