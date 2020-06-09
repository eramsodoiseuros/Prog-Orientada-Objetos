package Controler;

import java.io.IOException;
import java.util.List;

import Model.*;
import View.IView;
import javafx.event.ActionEvent;
import javafx.scene.Scene;

/**
 * Interface do Controler
 * */
public interface IControler {
    /**
     * @param model Estrutura Model
     * */
    void setModel(IModel model);

    /**
     * @return Estrutura View
     * */
    IView getView();

    /**
     *
     * @param id ID da transportadora
     * @param nome Nome da transportadora
     * @param email email da transportadora
     * @param pwd pwd da transportadora
     * @param nif nif da transportadora
     * @param range range da transportadora
     * @param preco preco por km da transportadora
     * @apiNote tambem a adiciona ao Map de transportadoras do Model
     * @throws IOException exceção a ser tratada
     * */
    public void registaTransportadora(String id, String nome, String email, String pwd, String nif, double range, double preco ) throws IOException;

    /**
     *
     * @param id ID do Voluntario
     * @param nome Nome do Voluntario
     * @param email email do Voluntario
     * @param pwd pwd do Voluntario
     * @param range range do Voluntario
     * @apiNote tambem a adiciona ao Map de Voluntarios do Model
     * @throws IOException exceção a ser tratada
     * */
    public void registaVoluntario(String id , String nome, String email, String pwd,  double range ) throws IOException;

    /**
     *
     * @param id ID da Loja
     * @param nome Nome da Loja
     * @param email email da Loja
     * @param pwd pwd da Loja
     * @apiNote tambem a adiciona ao Map de Lojas do Model
     * @throws IOException exceção a ser tratada
     * */
    public void registaLoja(String id,String nome, String email, String pwd) throws IOException;

    /**
     *
     * @param id ID da Loja
     * @param nome Nome do Utilizador
     * @param email email do Utilizador
     * @param pwd pwd do Utilizador
     * @apiNote tambem a adiciona ao Map de Utilizadores do Model
     * @throws IOException exceção a ser tratada
     * */
    public void registaUtilizador(String id, String nome, String email, String pwd) throws IOException;


    /**
     * Verifica todos os emails registados pelos utilizadores e ve se e possivel registar este novo
     * @param email email do utilizador a ser validado
     * @param pwd palavra-passe do utilizador a ser validado
     * @param nome nome do utilizador a ser validado
     * */
    public void validaRegUser (String email, String pwd, String nome);

    /**
     * Verifica todos os emails registados pelos transportadoras e ve se e possivel registar este novo
     * @param email email da transportadora a ser validada
     * @param pwd palavra-passe da transportadora a ser validada
     * @param nome nome da transportadora a ser validada
     * @param nif nif da transportadora a ser validada
     * @param range range da transportadora a ser validada
     * @param precokm preço/km da transportadora a ser validada
     * */
    public void validaRegTrans (String email, String pwd, String nome, String nif, String range, String precokm);

    /**
     * Verifica todos os emails registados pelos voluntários e ve se e possivel registar este novo
     * @param email email do voluntário a ser validado
     * @param pwd palavra-passe do voluntário a ser validado
     * @param nome nome do voluntário a ser validado
     * @param range range do voluntário a ser validado
     * */
    public void validaRegVol (String email, String pwd, String nome, String range);

    /**
     * Verifica todos os emails registados pelas lojas e ve se e possivel registar este novo
     * @param email email da loja a ser validada
     * @param pwd palavra-passe da loja a ser validada
     * @param nome nome da loja a ser validada
     * */
    public void validaRegLoja (String email, String pwd, String nome);

    /**
     * Verifica as informações de Login de um Utilizador
     * @param email Email do user
     * @param pwd Pwd do user
     * */
    public void validaLogInUser (String email, String pwd);

    /**
     * Verifica as informações de Login de uma Transportadora
     * @param email Email do trans
     * @param pwd Pwd do trans
     * */
    public void validaLogInTrans (String email, String pwd);

    /**
     * Verifica as informações de Login de um Voluntário
     * @param email Email do voluntario
     * @param pwd Pwd do voluntario
     * */
    public void validaLogInVol (String email, String pwd);

    /**
     * Verifica as informações de Login de uma Loja
     * @param email Email do loja
     * @param pwd Pwd do loja
     * */
    public void validaLogInLoja (String email, String pwd);

    /**
     *
     * @param produto produto escolhido pelo user
     * @param idLoja loja de onde o produto é
     * @param userId id do user
     * @return uma encomenda efetuada por um utilizador
     * @throws IOException exceção a ser tratada
     * */
    public IEncomenda pedidoUser (LinhaEncomenda produto, String idLoja, String userId) throws IOException;

    /**
     *
     * @param userid Id do user
     * @param lojaid Id da loja
     * @param transid Id da transportadora
     * @return se a trans esta ou n dentr de range para fazer a entrga
     * */
    public boolean dentroRange (String userid, String lojaid, String transid);

    /**
     *
     * @param userid id do user
     * @param lojaid id da loja
     * @param transid id da trans
     * @return a distancia total a ser percorrida
     * */
    public double distancia (String userid, String lojaid, String transid);

    /* *
     * Guarda o estado do Programa num ficheiro
     * */
    void save();

    /* *
     * Fecha uma Scene do JavaFX
     * */
    void end_scene(ActionEvent e);

    /**
     * @return Estrutura Model
     * */
    IModel getModel();

    /**
     *  Dá Update a uma janela "Menu de Utilizador"
     * @param u Utilizador
     * */
    void update_user(IUtilizador u);

    /**
     *  Dá Update a uma janela "Menu de Transportadora"
     * @param t Transportadora
     * */
    void update_transportadora(ITransportadora t);

    /**
     *  Dá Update a uma janela "Menu de Voluntário"
     * @param v Voluntário
     * */
    void update_voluntario(IVoluntario v);

    /**
     *  Dá Update a uma janela "Menu de Loja"
     * @param l Loja
     * */
    void update_loja(ILoja l);

    /**
     *
     * */
    void loja_selecionada(ITransportadora t, String nome);

    /**
     *
     * */
    void loja_selecionada(IVoluntario v, String nome);

    /**
     *
     * */
    void loja_selecionada(IUtilizador u, String value);

    /**
     *
     * */
    void pedir_recolha(ITransportadora t, String value);

    /**
     *
     * */
    void finalizar_encomenda(IUtilizador u, String value, char type);

    /**
     *
     * */
    void rating(IUtilizador u, String s, char type);

    /**
     *
     * */
    void listar_on_going();
}
