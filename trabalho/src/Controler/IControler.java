package Controler;

import java.io.IOException;
import Model.*;
import View.IView;
import javafx.event.ActionEvent;

public interface IControler {

    public void setModel(IModel model);
    public IView getView();

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
     */

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
     */
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
     *
     * @apiNote tambem a adiciona ao Map de Utilizadores do Model
     * @throws IOException exceção a ser tratada
     */
    public void registaUtilizador(String id, String nome, String email, String pwd) throws IOException;


    /**
     * Verifica todos os emails registados pelos utilizadores e ve se e possivel registar este novo
     * @param email email do utilizador a ser validado
     */
    public void validaRegUser (String email, String pwd, String nome);

    /**
     * Verifica todos os emails registados pelos transportadoras e ve se e possivel registar este novo
     * @param email email do transportadora a ser validado
     */
    public void validaRegTrans (String email, String pwd, String nome, String nif, String range, String precokm);

    /**
     * Verifica todos os emails registados pelos voluntario e ve se e possivel registar este novo
     * @param email email do voluntario a ser validado
     */
    public void validaRegVol (String email, String pwd, String nome, String range);

    /**
     * Verifica todos os emails registados pelos loja e ve se e possivel registar este novo
     * @param email email do loja a ser validado
     */
    public void validaRegLoja (String email, String pwd, String nome);

    /**
     *
     * @param email Email do user
     * @param pwd Pwd do user
     */
    public void validaLogInUser (String email, String pwd);

    /**
     *
     * @param email Email do trans
     * @param pwd Pwd do trans
     */
    public void validaLogInTrans (String email, String pwd);

    /**
     *
     * @param email Email do voluntario
     * @param pwd Pwd do voluntario
     */
    public void validaLogInVol (String email, String pwd);

    /**
     *
     * @param email Email do loja
     * @param pwd Pwd do loja
     */
    public void validaLogInLoja (String email, String pwd);

    /**
     *
     * @param produto produto escolhido pelo user
     * @param idLoja loja de onde o produto é
     * @param userId id do user
     * @return uma encomenda efetuado por um utilizador
     * @throws IOException exceção a ser tratada
     */
    public Encomenda pedidoUser (LinhaEncomenda produto, String idLoja, String userId) throws IOException;

    /**
     *
     * @param userid Id do user
     * @param lojaid Id da loja
     * @param transid Id da transportadora
     * @return se a trans esta ou n dentr de range para fazer a entrga
     */
    public boolean dentroRange (String userid, String lojaid, String transid);

    /**
     *
     * @param userid id do user
     * @param lojaid id da loja
     * @param transid id da trans
     * @return a distancia total a ser percorrida
     */
    public double distancia (String userid, String lojaid, String transid);


    void save();

    void end_scene(ActionEvent e);

    IModel getModel();

    void update_user(Utilizador u);
    void update_transportadora(Transportadora t);
    void update_voluntario(Voluntario v);
    void update_loja(Loja l);

    void loja_selecionada(Transportadora t, String nome);
    void loja_selecionada(Voluntario v, String nome);
    void loja_selecionada(Utilizador u, String value);

    void pedir_recolha(Transportadora t, String value);

    void finalizar_encomenda(Utilizador u, String value, char type);

    void rating(Utilizador u, String s, char type);
}
