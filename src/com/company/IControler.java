package com.company;

import java.io.IOException;

public interface IControler {



    public void setModel(Model model);

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
     * @return Uma transportadora para ser usada mais tarde
     * @throws IOException
     */

    public Transportadora registaTransportadora(String id, String nome, String email, String pwd, String nif, double range, double preco ) throws IOException;

    /**
     *
     * @param id ID do Voluntario
     * @param nome Nome do Voluntario
     * @param email email do Voluntario
     * @param pwd pwd do Voluntario
     * @param range range do Voluntario
     * @apiNote tambem a adiciona ao Map de Voluntarios do Model
     * @return Um voluntario para ser usada mais tarde
     * @throws IOException
     */



    public void registaVoluntario(String id , String nome, String email, String pwd,  double range ) throws IOException;

    /**
     *
     * @param id ID da Loja
     * @param nome Nome da Loja
     * @param email email da Loja
     * @param pwd pwd da Loja
     * @apiNote tambem a adiciona ao Map de Lojas do Model
     * @return Uma loja para ser usada mais tarde
     * @throws IOException
     */

    public void registaLoja(String id,String nome, String email, String pwd) throws IOException;

    /**
     *
     *
     * @param nome Nome do Utilizador
     * @param email email do Utilizador
     * @param pwd pwd do Utilizador
     *
     * @apiNote tambem a adiciona ao Map de Utilizadores do Model
     * @return Um Utilizador para ser usada mais tarde
     * @throws IOException
     */


    public void registaUtilizador(String nome, String email, String pwd) throws IOException;


    /**
     * Verifica todos os emails registados pelos utilizadores e ve se e possivel registar este novo
     * @param email email do utilizador a ser validado
     * @return true ou false consoante ja existe um utilizador registado com esse email
     */
    public boolean validaRegUser (String email);

    /**
     * Verifica todos os emails registados pelos transportadoras e ve se e possivel registar este novo
     * @param email email do transportadora a ser validado
     * @return true ou false consoante ja existe um transportadora registado com esse email
     */

    public boolean validaRegTrans (String email);

    /**
     * Verifica todos os emails registados pelos voluntario e ve se e possivel registar este novo
     * @param email email do voluntario a ser validado
     * @return true ou false consoante ja existe um voluntario registado com esse email
     */

    public boolean validaRegVol (String email);

    /**
     * Verifica todos os emails registados pelos loja e ve se e possivel registar este novo
     * @param email email do loja a ser validado
     * @return true ou false consoante ja existe um loja registado com esse email
     */

    public boolean validaRegLoja (String email);

    /**
     *
     * @param email Email do user
     * @param pwd Pwd do user
     * @return true ou false conseoante se as credenciais sao compativeis ou nao
     */

    public boolean validaLogInUser (String email, String pwd);

    /**
     *
     * @param email Email do trans
     * @param pwd Pwd do trans
     * @return true ou false conseoante se as credenciais sao compativeis ou nao
     */

    public boolean validaLogInTrans (String email, String pwd);

    /**
     *
     * @param email Email do voluntario
     * @param pwd Pwd do voluntario
     * @return true ou false conseoante se as credenciais sao compativeis ou nao
     */

    public boolean validaLogInVol (String email, String pwd);

    /**
     *
     * @param email Email do loja
     * @param pwd Pwd do loja
     * @return true ou false conseoante se as credenciais sao compativeis ou nao
     */
    public boolean validaLogInLoja (String email, String pwd);

    /**
     *
     * @param produto produto escolhido pelo user
     * @param idLoja loja de onde o produto é
     * @param userId id do user
     * @return uma encomenda efetuado por um utilizador
     * @throws IOException
     */

    public Encomenda pedidoUser (LinhaEncomenda produto, String idLoja, String userId) throws IOException;

    /**
     *
     * @param idEnc
     */

    public void infoEnc(String idEnc);

    /**
     * adiciona mail e pwd a todas a entidades q n possuam ao ser carregadas pelo file do professor
     */


    public void escreveMail ();

    /**
     *
     * @param e
     * @param estafetaid
     */

    public void avisaEstafeta (Encomenda e, String estafetaid);

    /**
     *
     * @param email do user
     * @param pwd do user
     * @return o ID do user a q essas credenciais pertencem
     */

    public String getUserid (String email, String pwd);

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

    /**
     *
     * @param email do trans
     * @param pwd do trasn
     * @return o ID do trans a q essas credenciais pertencem
     */


    public String getTransId (String email, String pwd);
}
