package com.company;

import com.sun.jdi.Location;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Controler implements IControler {

    private Model model;

    public Controler() {
        this.model = new Model();
    }

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }

    public Transportadora registaTransportadora(String id, String nome, String email, String pwd, String nif, double range, double preco) throws IOException {

        Transportadora transportadora = new Transportadora();

        transportadora.setId(id);
        transportadora.setPreco_km(preco);
        transportadora.setRange(range);
        transportadora.setNif(nif);
        transportadora.setNome(nome);
        transportadora.setEmail(email);
        transportadora.setPwd(pwd);

        model.getTransMap().putIfAbsent(id, transportadora);
        model.guardaEstado();

        return transportadora;
    }

    public void registaVoluntario(String id, String nome, String email, String pwd, double range) throws IOException {

        Voluntario voluntario = new Voluntario();

        voluntario.setId(id);
        voluntario.setRange(range);
        voluntario.setNome(nome);
        voluntario.setEmail(email);
        voluntario.setPwd(pwd);


        model.getVolMap().putIfAbsent(email, voluntario);
        model.guardaEstado();

    }

    public void registaLoja(String id, String nome, String email, String pwd) throws IOException {

        Loja loja = new Loja();

        loja.setId(id);
        loja.setNome(nome);
        loja.setEmail(email);
        loja.setPwd(pwd);

        model.getLojaMap().putIfAbsent(email, loja);
        model.guardaEstado();


    }


    public void registaUtilizador(String nome, String email, String pwd) throws IOException {

        Utilizador utilizador = new Utilizador();

        utilizador.setEmail(email);
        utilizador.setPwd(pwd);
        utilizador.setNome(nome);
        utilizador.setEstado(0);

        model.getUserMap().putIfAbsent(email, utilizador);
        model.guardaEstado();


    }

    public boolean validaRegUser(String email) {

        boolean r = false;
        for (Utilizador u : this.model.getUserMap().values()) {
            if (!u.getEmail().equals(email) || u.getEmail() == null) r = true;

            else r = false;

        }
        return r;

    }

    public boolean validaRegTrans(String email) {

        for (Transportadora u : model.getTransMap().values()) {
            if (u.getEmail().equals(email)) return false;


        }

        return true;

    }

    public boolean validaRegVol(String email) {

        for (Voluntario u : model.getVolMap().values()) {
            if (u.getEmail().equals(email)) return false;


        }

        return true;

    }

    public boolean validaRegLoja(String email) {

        for (Loja u : model.getLojaMap().values()) {
            if (u.getEmail().equals(email)) return false;


        }

        return true;

    }

    public boolean validaLogInUser(String email, String pwd) {

        for (Utilizador u : model.getUserMap().values()) {
            if (u.getEmail().equals(email) && u.getPwd().equals(pwd)) {

                return true;
            }


        }

        return false;

    }

    public boolean validaLogInTrans(String email, String pwd) {

        for (Transportadora u : model.getTransMap().values()) {
            if (u.getEmail().equals(email) && u.getPwd().equals(pwd)) return true;


        }

        return false;

    }

    public boolean validaLogInVol(String email, String pwd) {

        for (Voluntario u : model.getVolMap().values()) {
            if (u.getEmail().equals(email) && u.getPwd().equals(pwd)) return true;


        }

        return false;

    }

    public boolean validaLogInLoja(String email, String pwd) {

        for (Loja u : model.getLojaMap().values()) {
            if (u.getEmail().equals(email) && u.getPwd().equals(pwd)) return true;


        }

        return false;

    }


    public Encomenda pedidoUser(LinhaEncomenda produto, String idLoja, String userId) throws IOException {

        Loja loja = model.getLojaMap().get(idLoja);
        Encomenda encomenda = new Encomenda();

        String id = "e" + model.contaNCodEnc();

        encomenda.setId(id);
        encomenda.setLoja(idLoja);
        encomenda.setUserId(userId);
        encomenda.addProdutos(produto);
        //encomenda.setEstafeta(idEstafeta);
        encomenda.setPeso(produto.pesoTot());
        encomenda.setPreco(produto.precoTot());


        model.getEncMap().putIfAbsent(id, encomenda);
        loja.getLista_encomendas().add(encomenda);
        //model.guardaEstado();
        return encomenda;
    }

    public void infoEnc(String idEnc) {

        Encomenda e = this.model.getEncMap().get(idEnc);

        Utilizador u = this.model.getUserMap().get(e.getUserId());

        Loja l = this.model.getLojaMap().get(e.getLoja());

        u.getHistorico().add(e);
        l.getHistorico().add(e);

    }


    public void escreveMail() {

        int i = 1;
        for (Utilizador u : this.model.getUserMap().values()) {
            if (u.getEmail() == null) u.setEmail("user" + i + "@gmail.com");
            if (u.getPwd() == null) u.setPwd("123456");
            i++;
        }
        i = 1;
        for (Transportadora u : this.model.getTransMap().values()) {
            if (u.getEmail() == null) u.setEmail("trans" + i + "@gmail.com");
            if (u.getPwd() == null) u.setPwd("123456");
            i++;
        }
        i = 1;
        for (Voluntario u : this.model.getVolMap().values()) {
            if (u.getEmail() == null) u.setEmail("vol" + i + "@gmail.com");
            if (u.getPwd() == null) u.setPwd("123456");
            i++;
        }
        i = 1;
        for (Loja u : this.model.getLojaMap().values()) {
            if (u.getEmail() == null) u.setEmail("loja" + i + "@gmail.com");
            if (u.getPwd() == null) u.setPwd("123456");
            i++;
        }
    }

    public void avisaEstafeta(Encomenda e, String estafetaid) {

        for (Transportadora t : this.model.getTransMap().values()) {
            if (t.getId().equals(estafetaid)) t.getAtivas().add(e);

        }

        for (Voluntario v : this.model.getVolMap().values()) {
            if (v.getId().equals(estafetaid)) v.getRegistos().add(e);
        }

    }

    public String getUserid(String email, String pwd) {
        String userId = null;
        for (Utilizador u : model.getUserMap().values()) {
            if (u.getEmail().equals(email) && u.getPwd().equals(pwd)) {
                userId = u.getId();

            }


        }

        return userId;
    }

    public Utilizador getUser (String userID){
        return model.getUserMap().get(userID);

    }

    public boolean dentroRange(String userid, String lojaid, String transid) {
        Utilizador user = this.model.getUserMap().get(userid);
        Loja loja = this.model.getLojaMap().get(lojaid);
        Transportadora tras = this.model.getTransMap().get(transid);
        boolean r = true;

        if (Math.sqrt(Math.pow((loja.getLocalizacaoX() - tras.getLocalizacaoX()), 2) + Math.pow((loja.getLocalizacaoY() - tras.getLocalizacaoY()), 2)) < tras.getRange() && Math.sqrt(Math.pow((user.getLocalizacaoX() - tras.getLocalizacaoX()), 2) + Math.pow((user.getLocalizacaoY() - tras.getLocalizacaoY()), 2)) < tras.getRange()) {
            r = true;
        } else r = false;

        return r;
    }

    public double distancia(String userid, String lojaid, String transid) { //0-distancia tras-loja 1-user-trans
        Utilizador user = this.model.getUserMap().get(userid);
        Loja loja = this.model.getLojaMap().get(lojaid);
        Transportadora tras = this.model.getTransMap().get(transid);
        double r = 0;

        r = Math.sqrt(Math.pow((loja.getLocalizacaoX() - tras.getLocalizacaoX()), 2) + Math.pow((loja.getLocalizacaoY() - tras.getLocalizacaoY()), 2)) + Math.sqrt(Math.pow((user.getLocalizacaoX() - tras.getLocalizacaoX()), 2) + Math.pow((user.getLocalizacaoY() - tras.getLocalizacaoY()), 2));


        return r;
    }


    public String getTransId(String email, String pwd) {
        String transId = null;
        for (Transportadora u : model.getTransMap().values()) {
            if (u.getEmail().equals(email) && u.getPwd().equals(pwd)) {
                transId = u.getId();

            }


        }

        return transId;
    }
}







