package Model;
import java.io.Serializable;
import java.util.Set;
import java.util.TreeSet;

/**
 * Interface de um Utilizador
 * */
public interface IUtilizador extends Serializable{
    /**
     *
     * */
    String getId();

    /**
     *
     * */
    void setNome(String nome);

    /**
     *
     * */
    String getNome();

    /**
     *
     * */
    void setId(String id);

    /**
     *
     * */
    int getAcessos();

    /**
     *
     * */
    int getEstado();

    /**
     *
     * */
    void setEstado(int estado);

    /**
     *
     * */
    void setHistorico(Set<IEncomenda> historico);

    /**
     *
     * */
    void setAcessos(int acessos);

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
    void setLocalizacaoX(double localizacaoX);

    /**
     *
     * */
    void setLocalizacaoY(double localizacaoY);

    /**
     *
     *
     * */
    Set<IEncomenda> getHistorico();

    /**
     *
     * */
    void setHistorico(TreeSet<IEncomenda> historico);

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
}
