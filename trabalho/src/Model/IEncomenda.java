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
     * @return Double com um preço
     * */
    void setPreco(double preco);

    /**
     * @return String com o Id de Encomenda
     * */
    String getId();

    /**
     * @return String com o Id de Loja
     * */
    String getLoja();

    /**
     * @return String com o Id de Utilizador
     * */
    String getUserId();

    /**
     * @return Double com um peso
     * */
    void setPeso(double peso);

    /**
     * @return Set com os Ids dos Estafetas que aceitaram a encomenda
     * */
    Set<String> getEstafeta();

    /**
     * @return List com os Produtos
     * */
    ArrayList<LinhaEncomenda> getProdutos();

    /**
     * @return String com o ID da encomenda
     * */
    void setId(String id);

    /**
     * @return String com o ID da loja
     * */
    void setLoja(String loja);

    /**
     * @return String com o ID do Utilizador
     * */
    void setUserId(String userId);

    /**
     * @return List com os produtos
     * */
    void setProdutos(ArrayList<LinhaEncomenda> produtos);

    /**
     * Adiciona um novo produto aos produtos da encomenda
     *
     * */
    void addProdutos(LinhaEncomenda p);

}
