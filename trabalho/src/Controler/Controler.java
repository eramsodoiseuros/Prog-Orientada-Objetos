package Controler;

import Model.*;
import View.*;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

/*
*       NEED FIX
*
* LOAD ENCOMENDAS INICIAIS -> TO ATIVAS
*
* DAR PREÇOS
*
* PEDIR PREÇOS NO MENU LOJA
*
* MOSTRAR USERS NAS ENCOMENDAS ATIVAS
*
* TIME
*
* FIX RATING
*
* APLICAR FUNÇOES DE RANGE
*
* USAR TOP10
*
* */


public class Controler implements IControler {
    private IModel model;
    private IView view;

    public Controler() {
        model = new Model();
        try {
            //inicia(); // TO BE RUNNED IF S* HITS THE FAN
            this.model = model.loadEstado();
        } catch (IOException | ClassNotFoundException e) {
            view.alert("Erro", "O controler falhou a dar load do estado.");
        }
        view = new View(this);
    }
                
    public void setModel(IModel model) {
        this.model = model;
    }
    public void save() {
        try {
            model.guardaEstado();
        } catch (IOException e) {
            view.alert("Erro", "O controller falhou a guardar o estado.");
        }
    }
    public IView getView(){
        return view;
    }
    public IModel getModel(){
        return model;
    }
    public void end_scene(ActionEvent e) {
        final Node source = (Node) e.getSource();
        final Stage stage = (Stage) source.getScene().getWindow();
        stage.close();
    }

    public void update_user(IUtilizador u){
        view.make_window("Menu de Utilizador " + u.getNome(), view.menu_user(u, lojas(), historico(u), encomendas(u)));
    }
    public void update_transportadora(ITransportadora t){
        view.make_window("Menu de Transportadora " + t.getNome(), view.menu_transportadora(t, lojas(), faturacao(t)));
    }
    public void update_voluntario(IVoluntario v){
        view.make_window("Menu de Voluntário " + v.getNome(), view.menu_voluntario(v,lojas()));
    }
    public void update_loja(ILoja l){
        view.make_window("Menu de Loja " + l.getNome(), view.menu_loja(l));
    }

    public void loja_selecionada(IUtilizador u, String nome) {
        ILoja loja = new Loja();
        for (ILoja l: model.getLojaMap().values()) {
            if(l.getNome().equals(nome))
                loja = l;
        }
        view.make_window("Lista de produtos da Loja '" + loja.getNome() + "'", view.select_produtos(u, loja,produtos(loja)));
    }
    public void loja_selecionada(ITransportadora t, String nome) {
        ILoja loja = new Loja();
        for (ILoja l: model.getLojaMap().values()) {
            if(l.getNome().equals(nome))
                loja = l;
        }
        if(precisa_recolha(loja).size() > 0){
            view.make_window("Lista de produtos da Loja '" + loja.getNome() + "'", view.encomendas_ativas(t, precisa_recolha(loja)));
        } else view.alert("Não há mais encomendas.","A loja escolhida não têm encomendas ativas de momento");
    }
    public void loja_selecionada(IVoluntario v, String nome) {
        ILoja loja = new Loja();
        for (ILoja l: model.getLojaMap().values()) {
            if(l.getNome().equals(nome))
                loja = l;
        }
        view.make_window("Lista de produtos da Loja '" + loja.getNome() + "'", view.encomendas_ativas(v, precisa_recolha(loja)));
    }

    private IEncomenda encomendas(IUtilizador u) {
        IEncomenda e;
        for(IEncomenda enc : model.getEncMap().values()){
            if(enc.getUserId().equals(u.getId())){
                e = enc;
                return e;
            }
        }
        return null;
    }
    public void pedir_recolha(ITransportadora t, String value){
        model.getEncMap().get(value).getEstafeta().add("T " + t.getId() + " - " + t.getPreco_transporte() + "€ - " + t.estrela());
    }
    public void finalizar_encomenda(IUtilizador u, String value, char type){
        for(IEncomenda enc : model.getEncMap().values()){
            if(enc.getEstafeta().contains(value)){
                u.getHistorico().add(enc);
                model.getLojaMap().get(enc.getLoja()).addHistorico(enc);
                if(type == 'T'){
                    model.getTransMap().get(value).getHistorico().add(enc);
                }
                if(type == 'V'){
                    model.getVolMap().get(value).getRegistos().add(enc);
                }
                model.getEncMap().remove(enc.getId());
                return;
            }
        }
    } //done
    public void rating(IUtilizador u, String s, char type){
        if(type == 'T'){
            model.getTransMap().get(s).getRating().add(5);
        }
        if(type == 'V'){
            model.getVolMap().get(s).getRating().add(5);
        }
    } // not done, add prompt
    public void listar_on_going(){
        view.make_window("Encomendas Ativas", view.encomendas_ativas(encomendas()));
    }

    // done
    public void registaTransportadora(String id, String nome, String email, String pwd, String nif, double range, double preco) throws IOException {

        ITransportadora transportadora = new Transportadora();

        transportadora.setId(id);
        transportadora.setPreco_km(preco);
        transportadora.setRange(range);
        transportadora.setNif(nif);
        transportadora.setNome(nome);
        transportadora.setEmail(email);
        transportadora.setPwd(pwd);
        transportadora.setLocalizacaoX(localizacao()[0]);
        transportadora.setLocalizacaoY(localizacao()[1]);

        model.getTransMap().putIfAbsent(id, transportadora);
        model.guardaEstado();
    }
    public void registaVoluntario(String id, String nome, String email, String pwd, double range) throws IOException {

        IVoluntario voluntario = new Voluntario();

        voluntario.setId(id);
        voluntario.setRange(range);
        voluntario.setNome(nome);
        voluntario.setEmail(email);
        voluntario.setPwd(pwd);
        voluntario.setLocalizacaoX(localizacao()[0]);
        voluntario.setLocalizacaoY(localizacao()[1]);


        model.getVolMap().putIfAbsent(email, voluntario);
        model.guardaEstado();

    }
    public void registaLoja(String id, String nome, String email, String pwd) throws IOException {
        ILoja loja = new Loja();

        loja.setId(id);
        loja.setNome(nome);
        loja.setEmail(email);
        loja.setPwd(pwd);
        loja.setLocalizacaoX(localizacao()[0]);
        loja.setLocalizacaoY(localizacao()[1]);

        model.getLojaMap().putIfAbsent(email, loja);
        model.guardaEstado();
    }
    public void registaUtilizador(String id, String nome, String email, String pwd) throws IOException {
        IUtilizador utilizador = new Utilizador();

        utilizador.setId(id);
        utilizador.setEmail(email);
        utilizador.setId(id);
        utilizador.setPwd(pwd);
        utilizador.setNome(nome);
        utilizador.setEstado(0);
        utilizador.setAcessos(0);
        utilizador.setLocalizacaoX(localizacao()[0]);
        utilizador.setLocalizacaoY(localizacao()[1]);

        model.getUserMap().putIfAbsent(id, utilizador);
        model.guardaEstado();
    }

    // done
    public void validaRegUser(String email, String pwd, String nome) {
        if(email == null) return;
        if(pwd == null) return;
        if(nome == null) return;

        for (IUtilizador u : this.model.getUserMap().values()) {
            if (u.getEmail().equals(email) || u.getEmail() == null) {
                 view.alert("Erro.", "Email já em uso. Tente novamente com um novo email.");
                return;
            }
        }

        try {
            registaUtilizador("u" + model.contaNCodUser(), nome, email, pwd);
        } catch (IOException e) {
            view.alert("Erro.", "Programa falhou a registar um utilizador.");
        }
        System.out.println(model.getUserMap());
    }
    public void validaRegTrans(String email, String pwd, String nome, String nif, String range, String precokm) {
        if(email == null) return;
        if(pwd == null) return;
        if(nome == null) return;
        if(nif == null) return;
        if(range == null) return;
        if(precokm == null) return;

        for (ITransportadora u : this.model.getTransMap().values()) {
            if (u.getEmail().equals(email) || u.getEmail() == null) {
                view.alert("Erro.", "Email já em uso. Tente novamente com um novo email.");
                return;
            }
        }

        try {
            registaTransportadora("u" + model.contaNCodTrans(), nome, email, pwd, nif, Double.parseDouble(range), Double.parseDouble(precokm));
        } catch (IOException e) {
            view.alert("Erro.", "Programa falhou a registar uma transportadora.");
        }
    }
    public void validaRegVol(String email, String pwd, String nome, String range) {
        if(email == null) return;
        if(pwd == null) return;
        if(nome == null) return;
        if(range == null) return;

        for (IVoluntario u : this.model.getVolMap().values()) {
            if (u.getEmail().equals(email) || u.getEmail() == null) {
                view.alert("Erro.", "Email já em uso. Tente novamente com um novo email.");
                return;
            }
        }

        try {
            registaVoluntario("u" + model.contaNCodVol(), nome, email, pwd, Double.parseDouble(range));
        } catch (IOException e) {
            view.alert("Erro.", "Programa falhou a registar uma voluntário.");
        }
    }
    public void validaRegLoja(String email, String pwd, String nome) {
        if(email == null) return;
        if(pwd == null) return;
        if(nome == null) return;

        for (ILoja u : this.model.getLojaMap().values()) {
            if (u.getEmail().equals(email) || u.getEmail() == null) {
                view.alert("Erro.", "Email já em uso. Tente novamente com um novo email.");
                return;
            }
        }

        try {
            registaLoja("u" + model.contaNCodLoja(), nome, email, pwd);
        } catch (IOException e) {
            view.alert("Erro.", "Programa falhou a registar uma loja.");
        }
    }

    // done
    public void validaLogInUser(String email, String pwd) {
        for (IUtilizador u : model.getUserMap().values()) {
            if (u.getEmail().equals(email) && u.getPwd().equals(pwd)) {
                view.make_window("Menu de Utilizador " + u.getNome(), view.menu_user(u, lojas(), historico(u),encomendas(u)));
                u.setAcessos(u.getAcessos()+1);
                return;
            }
        }
        view.alert("Erro no login.","Credenciais erradas ou não existentes.");
    }
    public void validaLogInTrans(String email, String pwd) {
        for (ITransportadora t : model.getTransMap().values()) {
            if (t.getEmail().equals(email) && t.getPwd().equals(pwd)){
                view.make_window("Menu de Transportadora " + t.getNome(), view.menu_transportadora(t, lojas(), faturacao(t)));
                return;
            }
        }
        view.alert("Erro no login.","Credenciais erradas ou não existentes.");
    }
    public void validaLogInVol(String email, String pwd) {
        for (IVoluntario u : model.getVolMap().values()) {
            if (u.getEmail().equals(email) && u.getPwd().equals(pwd)) {
                view.make_window("Menu de Voluntário " + u.getNome(), view.menu_voluntario(u, lojas()));
                return;
            }
        }
        view.alert("Erro no login.","Credenciais erradas ou não existentes.");
    }
    public void validaLogInLoja(String email, String pwd) {
        for (ILoja u : model.getLojaMap().values()) {
            if (u.getEmail().equals(email) && u.getPwd().equals(pwd)) {
                view.make_window("Menu de Loja " + u.getNome(), view.menu_loja(u));
                return;
            }
        }
        view.alert("Erro no login.","Credenciais erradas ou não existentes.");
    }

    public IEncomenda pedidoUser(LinhaEncomenda produto, String idLoja, String userId) throws IOException {

        ILoja loja = model.getLojaMap().get(idLoja);
        IEncomenda encomenda = new Encomenda();

        String id = "e" + model.contaNCodEnc();

        encomenda.setId(id);
        encomenda.setLoja(idLoja);
        encomenda.setUserId(userId);
        encomenda.addProdutos(produto);
        encomenda.setPeso(produto.pesoTot());
        encomenda.setPreco(produto.precoTot());

        model.getEncMap().putIfAbsent(id, encomenda);
        loja.getLista_encomendas().add(encomenda);
        return encomenda;
    }
    public boolean dentroRange(String userid, String lojaid, String transid) {
        IUtilizador user = this.model.getUserMap().get(userid);
        ILoja loja = this.model.getLojaMap().get(lojaid);
        ITransportadora tras = this.model.getTransMap().get(transid);
        boolean r = true;

        if (Math.sqrt(Math.pow((loja.getLocalizacaoX() - tras.getLocalizacaoX()), 2) + Math.pow((loja.getLocalizacaoY() - tras.getLocalizacaoY()), 2)) < tras.getRange() && Math.sqrt(Math.pow((user.getLocalizacaoX() - tras.getLocalizacaoX()), 2) + Math.pow((user.getLocalizacaoY() - tras.getLocalizacaoY()), 2)) < tras.getRange()) {
            r = true;
        } else r = false;

        return r;
    } // NEEDS TO BE ADDED
    public double distancia(String userid, String lojaid, String transid) { //0-distancia tras-loja 1-user-trans
        IUtilizador user = this.model.getUserMap().get(userid);
        ILoja loja = this.model.getLojaMap().get(lojaid);
        ITransportadora tras = this.model.getTransMap().get(transid);
        double r = 0;

        r = Math.sqrt(Math.pow((loja.getLocalizacaoX() - tras.getLocalizacaoX()), 2) + Math.pow((loja.getLocalizacaoY() - tras.getLocalizacaoY()), 2)) + Math.sqrt(Math.pow((user.getLocalizacaoX() - tras.getLocalizacaoX()), 2) + Math.pow((user.getLocalizacaoY() - tras.getLocalizacaoY()), 2));

        return r;
    }
    public double[] localizacao (){
        double [] loc = new double[2];

        Random r = new Random();
        double low = -100;
        double high = 100;
        double resultX = r.nextDouble();
        loc[0] = low + (resultX * (high - low));
        double resultY = r.nextDouble();
        loc[1] = low + (resultY * (high - low));

        return loc;
    }

    public List<String> lojas() {
        List<String> s = new Vector<>();
        for (ILoja loja: model.getLojaMap().values()) {
            s.add(loja.getNome());
        }
        return s;
    }
    private List<String> historico(IUtilizador u) {
        List<String> s = new Vector<>();
        for (IEncomenda e: u.getHistorico()) {
            s.add(e.getId());
        }
        return s;
    }
    public List<String> produtos(ILoja loja) {
        List<String> s = new Vector<>();
        for (LinhaEncomenda e : loja.getInventario()) {
            s.add(e.getDescricao());
        }
        return s;
    }
    private List<String> faturacao(ITransportadora t) {
        List<String> s = new ArrayList<>();
        for (Double d: t.getFaturacao()) {
            s.add(d.toString());
        };
        return s;
    }
    private List<String> precisa_recolha(ILoja l){
        List<String> s = new ArrayList<>();
        for(IEncomenda enc : l.getLista_encomendas()){
            s.add(enc.getId());
        }
        return s;
    }
    private List<String> encomendas(){
        List<String> s = new Vector<>();
        for(IEncomenda enc : model.getEncMap().values()){
            s.add(enc.getId());
        }
        return s;
    }


    public  List<Utilizador> top10Acessos ()  {

        List<Utilizador> l = new ArrayList<>();

        l.addAll(model.getUserMap().values());

        return l.stream().sorted().collect(Collectors.toList());

    }


    public  List<Transportadora> top10Distancias ()  {

        List<Transportadora> l = new ArrayList<>();

        l.addAll(model.getTransMap().values());

        return l.stream().sorted().collect(Collectors.toList());

    }


    // not to be used ever again, emergencies only
    public void escreveMail() {

        int i = 1;
        for (IUtilizador u : this.model.getUserMap().values()) {
            if (u.getEmail() == null) u.setEmail("user" + i + "@gmail.com");
            if (u.getPwd() == null) u.setPwd("123456");
            i++;
        }
        i = 1;
        for (ITransportadora u : this.model.getTransMap().values()) {
            if (u.getEmail() == null) u.setEmail("trans" + i + "@gmail.com");
            if (u.getPwd() == null) u.setPwd("123456");
            i++;
        }
        i = 1;
        for (IVoluntario u : this.model.getVolMap().values()) {
            if (u.getEmail() == null) u.setEmail("vol" + i + "@gmail.com");
            if (u.getPwd() == null) u.setPwd("123456");
            i++;
        }
        i = 1;
        for (ILoja u : this.model.getLojaMap().values()) {
            if (u.getEmail() == null) u.setEmail("loja" + i + "@gmail.com");
            if (u.getPwd() == null) u.setPwd("123456");
            i++;
        }
    }
    public void inicia () throws IOException {
        model.fileToTrans();
        model.filetoLoja();
        model.fileToUser();
        model.fileToVol();
        model.fileToEnc();
        model.loadInventLoja();
        escreveMail();
        model.guardaEstado();
    }
}







