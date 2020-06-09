package Model;
import javax.xml.stream.Location;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public interface IEncomenda extends Serializable {

    public double getPreco();

    public void setPreco(double preco);

    public String getId();

    public String getLoja();

    public String getUserId();

    public void setPeso(double peso);

    public double getPeso();

    public Location getDestino();

    public List<String> getEstafeta();

    public ArrayList<LinhaEncomenda> getProdutos();

    public void setId(String id);

    public void setLoja(String loja);

    public void setDestino(Location destino);

    public void setEstafeta(List<String> estafeta);

    public void setUserId(String userId);

    public void setProdutos(ArrayList<LinhaEncomenda> produtos);

    public ArrayList<LinhaEncomenda> addProdutos(LinhaEncomenda p);

    public ArrayList<LinhaEncomenda> addProdutosFromString (String s);

    public boolean existeProduto(String codProd);

    public double getPrecoTot ();

    public double getPesoTot ();
}
