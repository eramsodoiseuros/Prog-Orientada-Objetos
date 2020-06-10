package Model;
import javax.xml.stream.Location;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Interface de uma Encomenda
 * */
public interface IEncomenda extends Serializable {
    /**
     *
     * */
    void setPreco(double preco);

    /**
     *
     * */
    String getId();

    /**
     *
     * */
    String getLoja();

    /**
     *
     * */
    String getUserId();

    /**
     *
     * */
    void setPeso(double peso);

    /**
     *
     * */
    Set<String> getEstafeta();

    /**
     *
     * */
    ArrayList<LinhaEncomenda> getProdutos();

    /**
     *
     * */
    void setId(String id);

    /**
     *
     * */
    void setLoja(String loja);

    /**
     *
     * */
    void setUserId(String userId);

    /**
     *
     * */
    void setProdutos(ArrayList<LinhaEncomenda> produtos);

    /**
     *
     * */
    void addProdutos(LinhaEncomenda p);

}
