package Model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Set;

/**
 * Interface de um Voluntário
 * */
public interface IVoluntario extends Serializable {
    /* *
     *
     * */
    String getId();

    /* *
     *
     * */
    String getPwd();

    /* *
     *
     * */
    void setPwd(String pwd);

    /* *
     *
     * */
    String getEmail();

    /* *
     *
     * */
    void setEmail(String email);

    /* *
     *
     * */
    String getNome();

    /* *
     *
     * */
    ArrayList<Integer> getRating();

    /* *
     *
     * */
    Set<IEncomenda> getRegistos();

    /* *
     *
     * */
    void setId(String id);

    /* *
     *
     * */
    void setNome(String nome);

    /* *
     *
     * */
    void setLocalizacaoX(double localizacaoX);

    /* *
     *
     * */
    void setLocalizacaoY(double localizacaoY);

    /* *
     *
     * */
    void setRange(double range);

    /* *
     *
     * */
    double estrela();
}
