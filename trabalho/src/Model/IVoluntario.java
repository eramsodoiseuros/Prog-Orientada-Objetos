package Model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Set;

public interface IVoluntario extends Serializable {

    public String getId();

    public double getLocalizacaoX();

    public double getLocalizacaoY();

    public String getPwd();

    public void setPwd(String pwd);

    public String getEmail();

    public void setEmail(String email);

    public String getNome();

    public int getN_encomendas();

    public double getRange();

    public String getTipo();

    public ArrayList<Integer> getRating();

    public boolean isDisponivel();

    public Set<Encomenda> getRegistos();

    public void setDisponivel(boolean disponivel);

    public void setId(String id);

    public void setNome(String nome);

    public void setLocalizacaoX(double localizacaoX);

    public void setLocalizacaoY(double localizacaoY);

    public void setN_encomendas(int n_encomendas);

    public Encomenda getAtiva();

    public void setAtiva(Encomenda ativa);

    public void setRange(double range);

    public void setRating(ArrayList<Integer> rating);

    public void setTipo(String tipo);

    public void setRegistos(Set<Encomenda> registos);

    public double estrela();
}
