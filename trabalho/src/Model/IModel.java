package Model;
import java.io.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Set;

public interface IModel {

    /**
     * @return Mapa de encomendas com o seu ID como key
     */
    HashMap<String, Encomenda> getEncMap();

    /**
     *
     * @param encMap Mapa de encomendas com o seu ID como key
     */
    void setEncMap(HashMap<String, Encomenda> encMap);

    @Override
    String toString();


    /**
     *
     * Guarda o estado do model ou seja de todas as classes de entidades num ficheiro usando o ObjectOutputStream
     * @throws IOException
     */
    void guardaEstado () throws IOException;

    /**
     *
     * Carrega o estado do model ou seja de todas as classes de entidades num ficheiro usando o ObjectInputStream
     * @throws IOException
     */
    Model loadEstado () throws IOException, ClassNotFoundException;

    /**
     *
     * @return o numero para acrescentar no cod da encomenda para q nunca se repitam
     */
    int contaNCodEnc ();

    /**
     *
     * @return o numero para acrescentar no cod da encomenda para q nunca se repitam
     */
    int contaNCodProd ();

    /**
     *
     * @return o numero para acrescentar no cod do produto para q nunca se repitam
     */
    int contaNCodUser ();

    /**
     *
     * @return o numero para acrescentar no cod da transportadora para q nunca se repitam
     */
    int contaNCodTrans ();

    /**
     *
     * @return o numero para acrescentar no cod da loja para q nunca se repitam
     */
    int contaNCodLoja ();

    /**
     *
     * @return o numero para acrescentar no cod do voluntario para q nunca se repitam
     */
    int contaNCodVol ();

    HashMap<String, Transportadora> getTransMap();

    HashMap<String, Loja> getLojaMap();

    HashMap<String, Utilizador> getUserMap();

    HashMap<String, Voluntario> getVolMap();

    void setTransMap(HashMap<String, Transportadora> transMap);

    void setVolMap(HashMap<String, Voluntario> volMap);

    void setUserMap(HashMap<String, Utilizador> userMap);

    void setLojaMap(HashMap<String, Loja> lojaMap);

    void registaEncomenda(String id, String userId, String lojaId, double peso, ArrayList<LinhaEncomenda> produtos);

    /**
     * Metodo provavelmente temporario que adiciona um inventario as lojas existentes fazendo load de um ficheiro txt
     * @throws IOException
     */
    void loadInventLoja() throws IOException;

    void fileToTrans() throws IOException;

    void filetoLoja() throws IOException;

    void fileToUser() throws IOException;

    void fileToVol() throws IOException;

    void fileToEnc() throws IOException;
}