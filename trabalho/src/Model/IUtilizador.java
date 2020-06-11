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
     * @return String com o ID do Utilizador
     * */
    String getId();

    /**
     *
     * String com o nome do Utilizador
     * */
    void setNome(String nome);

    /**
     *
     * @return String com o nome do Utilizador
     * */
    String getNome();

    /**
     *
     *  String com o ID do Utilizador
     * */
    void setId(String id);

    /**
     *
     * @return Numero de encomendas realizadas do Utilizador
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
     *  Set de encomendas realizadas pelo Utilizador
     * */
    void setHistorico(Set<IEncomenda> historico);

    /**
     *
     *  Numero de encomendas realizadas do Utilizador
     * */
    void setAcessos(int acessos);

    /**
     *
     * @return Localização X do Utilizador
     * */
    double getLocalizacaoX();

    /**
     *
     * @return Localização Y do Utilizador
     * */
    double getLocalizacaoY();

    /**
     *
     * Localização X do Utilizador
     * */
    void setLocalizacaoX(double localizacaoX);

    /**
     *
     * Localização Y do Utilizador
     * */
    void setLocalizacaoY(double localizacaoY);

    /**
     *
     *
     * @return Set de encomendas realizadas pelo Utilizador
     * */
    Set<IEncomenda> getHistorico();

    /**
     *
     * @return Set de encomendas realizadas pelo Utilizador
     * */
    void setHistorico(TreeSet<IEncomenda> historico);

    /**
     *
     * @return String email do Utilizador
     * */
    String getEmail();

    /**
     *
     * @return String password do Utilizador
     * */
    String getPwd();

    /**
     *
     * @return String password do Utilizador
     * */
    void setPwd(String s);

    /**
     *
     * @return String email do Utilizador
     * */
    void setEmail(String s);
}
