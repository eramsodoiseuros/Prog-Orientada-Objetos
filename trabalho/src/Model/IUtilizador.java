package Model;
import java.io.Serializable;
import java.util.Set;
import java.util.TreeSet;

public interface IUtilizador extends Serializable{

    public String getId();

    public void setNome(String nome);

    public String getNome();

    public void setId(String id);

    public int getAcessos();

    public int getEstado();

    public void setEstado(int estado);

    public void setHistorico(Set<Encomenda> historico);

    public void setAcessos(int acessos);

    public double getLocalizacaoX();

    public double getLocalizacaoY();

    public void setLocalizacaoX(double localizacaoX);

    public void setLocalizacaoY(double localizacaoY);

    public Set<Encomenda> getHistorico();

    public void setHistorico(TreeSet<Encomenda> historico);

    public int compareTo(IUtilizador u);

}
