import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public interface ILoja extends Serializable {

    public Set<LinhaEncomenda> getInventario();

    public void setInventario(Set<LinhaEncomenda> inventario);

    public String getId();

    public String getNome();

    public String getPwd();

    public void setPwd(String pwd);

    public String getEmail();

    public void setEmail(String email);

    public void setNome(String nome);

    public double getLocalizacaoY();

    public double getLocalizacaoX();

    public Fila getFila();

    public HashSet<Encomenda> getLista_encomendas();

    public HashSet<Encomenda> getHistorico();

    public void setId(String id);

    public void setLocalizacaoX(double localizacaoX);

    public void setLocalizacaoY(double localizacaoY);

    public void setFila(Fila fila);

    public void setLista_encomendas(HashSet<Encomenda> lista_encomendas);

    public void setHistorico(HashSet<Encomenda> historico);

    public void addLista (Encomenda e);

    public void addHistorico (Encomenda e);
}
