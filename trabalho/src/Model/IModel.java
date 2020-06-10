package Model;
import java.io.*;
import java.util.ArrayList;
import java.util.*;

/**
 * Interface do Model
 * */
public interface IModel {
    /**
     * @return Mapa de encomendas com o seu ID como key
     */
    HashMap<String, IEncomenda> getEncMap();

    /**
     *
     * @param encMap Mapa de encomendas com o seu ID como key
     */
    void setEncMap(HashMap<String, IEncomenda> encMap);

    /**
     *
     * */
    String toString();

    /**
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

    /**
     *
     * @return Mapa das Transportadoras
     * */
    HashMap<String, ITransportadora> getTransMap();

    /**
     *
     * @return Mapa das Lojas
     * */
    HashMap<String, ILoja> getLojaMap();

    /**
     *
     * @return Mapa dos utilizadores
     * */
    TreeMap<String, IUtilizador> getUserMap();

    /**
     *
     * @return Mapa dos Voluntarios
     * */
    HashMap<String, IVoluntario> getVolMap();

    /**
     *
     * @return Mapa dos Voluntarios
     * */
    void registaEncomenda(String id, String userId, String lojaId, double peso, ArrayList<LinhaEncomenda> produtos);

    /**
     * Metodo provavelmente temporario que adiciona um inventario as lojas existentes fazendo load de um ficheiro txt
     * @throws IOException
     */
    void loadInventLoja() throws IOException;

    /**
     * Metodo provavelmente temporario que adiciona as transporadoras existentes fazendo load de um ficheiro txt
     * @throws IOException
     */
    void fileToTrans() throws IOException;

    /**
     * Metodo provavelmente temporario que adiciona as lojas existentes fazendo load de um ficheiro txt
     * @throws IOException
     */
    void filetoLoja() throws IOException;

    /**
     * Metodo provavelmente temporario que adiciona os Utilizadores existentes fazendo load de um ficheiro txt
     * @throws IOException
     */
    void fileToUser() throws IOException;

    /**
     * Metodo provavelmente temporario que adiciona os Voluntarios existentes fazendo load de um ficheiro txt
     * @throws IOException
     */
    void fileToVol() throws IOException;

    /**
     * Metodo provavelmente temporario que adiciona as Encomendas existentes fazendo load de um ficheiro txt
     * @throws IOException
     */
    void fileToEnc() throws IOException;
}