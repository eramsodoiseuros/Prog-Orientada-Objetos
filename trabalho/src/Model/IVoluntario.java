package Model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Set;

/**
 * Interface de um Voluntário
 * */
public interface IVoluntario extends Serializable {
    /**
     * @return String com o ID do Voluntario
     * */
    String getId();

    /**
     * @return String com a password do Voluntario
     * */
    String getPwd();

    /**
     *  String com a password do Voluntario
     * */
    void setPwd(String pwd);

    /**
     * @return String com o email do Voluntario
     * */
    String getEmail();

    /**
     *  String com o email do Voluntario
     * */
    void setEmail(String email);

    /**
     * @return String com o nome do Voluntario
     * */
    String getNome();

    /**
     * @return List com as avaliações do Voluntario
     * */
    ArrayList<Integer> getRating();

    /**
     * @return Set com os registos das encomendas realizadas pelo Voluntario
     * */
    Set<IEncomenda> getRegistos();

    /**
     *  String com o ID do Voluntario
     * */
    void setId(String id);

    /**
     *  String com o nome do Voluntario
     * */
    void setNome(String nome);

    /**
     * Double com a Localização X do Voluntario
     * */
    void setLocalizacaoX(double localizacaoX);

    /**
     * Double com a Localização Y do Voluntario
     * */
    void setLocalizacaoY(double localizacaoY);

    /**
     * Double com o range do Voluntario
     * */
    void setRange(double range);

    /**
     * @return Double com a media das avaliações
     * */
    double estrela();

    /* *
     *
     * */
    double getLocalizacaoX();

    /* *
     *
     * */
    double getLocalizacaoY();

    /* *
     *
     * */
    double getRange();
}
