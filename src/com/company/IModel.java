package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Set;

public interface IModel {

    /**
     * @return Mapa de encomendas com o seu ID como key
     */

    public HashMap<String, Encomenda> getEncMap();

    /**
     *
     * @param encMap Mapa de encomendas com o seu ID como key
     */

    public void setEncMap(HashMap<String, Encomenda> encMap);

    @Override
    public String toString();


    /**
     *
     * Guarda o estado do model ou seja de todas as classes de entidades num ficheiro usando o ObjectOutputStream
     * @throws IOException
     */
    public void guardaEstado () throws IOException;

    /**
     *
     * Carrega o estado do model ou seja de todas as classes de entidades num ficheiro usando o ObjectInputStream
     * @throws IOException
     */

    public Model loadEstado () throws IOException, ClassNotFoundException;

    /**
     *
     * @return o numero para acrescentar no cod da encomenda para q nunca se repitam
     */
    public  int contaNCodEnc ();

    /**
     *
     * @return o numero para acrescentar no cod da encomenda para q nunca se repitam
     */
    public  int contaNCodProd ();

    /**
     *
     * @return o numero para acrescentar no cod do produto para q nunca se repitam
     */
    public  int contaNCodUser ();

    /**
     *
     * @return o numero para acrescentar no cod da transportadora para q nunca se repitam
     */

    public  int contaNCodTrans ();

    /**
     *
     * @return o numero para acrescentar no cod da loja para q nunca se repitam
     */

    public  int contaNCodLoja ();

    /**
     *
     * @return o numero para acrescentar no cod do voluntario para q nunca se repitam
     */

    public  int contaNCodVol ();





    public HashMap<String, Transportadora> getTransMap();

    public HashMap<String, Loja> getLojaMap();

    public HashMap<String, Utilizador> getUserMap();

    public HashMap<String, Voluntario> getVolMap();

    public void setTransMap(HashMap<String, Transportadora> transMap);

    public void setVolMap(HashMap<String, Voluntario> volMap);

    public void setUserMap(HashMap<String, Utilizador> userMap);

    public void setLojaMap(HashMap<String, Loja> lojaMap);



    public void registaEncomenda(String id, String userId, String lojaId, double peso, ArrayList<LinhaEncomenda> produtos);

    /**
     * Metodo provavelmente temporario que adiciona um inventario as lojas existentes fazendo load de um ficheiro txt
     * @throws IOException
     */
    public void loadInventLoja() throws IOException;

}
