package Controler;

import Model.*;
import View.*;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;
import java.util.stream.Collectors;

import static jdk.nashorn.internal.objects.NativeMath.round;

/*
*       NEED FIX
*
* PEDIR PREÇOS NO MENU LOJA
*       DAR POSSIBILIDADE DE ADD PRODUTOS
*
* TIME
*
* FIX RATING
*
* USAR TOP10
*
* MUDAR A CONTAGEM DOS ACESSOS
*
* gerar JDOC
*
* */


public class Controler implements IControler {
    private IModel model;
    private IView view;

    public Controler() {
        model = new Model();
        try {
            inicia(); // TO BE RUNNED IF S* HITS THE FAN
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
        view.make_window("Menu de Transportadora " + t.getNome(), view.menu_transportadora(t, lojas(), t.getHistorico()));
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
    public void finalizar_encomenda(IUtilizador u, String estafeta, String value){
        for(IEncomenda enc : model.getEncMap().values()){
            System.out.println(enc.getEstafeta());
            if(enc.getEstafeta().contains(estafeta)){
                u.getHistorico().add(enc);
                model.getLojaMap().get(enc.getLoja()).addHistorico(enc);
                model.getLojaMap().get(enc.getLoja()).getLista_encomendas().remove(enc);
                model.getUserMap().get(u.getId()).getHistorico().add(enc);
                if(value.startsWith("t")){
                    ITransportadora t = model.getTransMap().get(value);
                    double t1 = t.getPreco_transporte();
                    t.getHistorico().add("Encomenda: " + enc.getId() + " | Preço: " + t1);
                    t.getFaturacao().add(t1);
                }
                if(value.startsWith("v")){
                    model.getVolMap().get(value).getRegistos().add(enc);
                }
                model.getEncMap().remove(enc.getId());
                return;
            }
        }
    } //done
    public void pedir_recolha(ITransportadora t, String value){
        String userid = model.getEncMap().get(value).getUserId();
        String lojaid = model.getEncMap().get(value).getLoja();
        if(dentro_range_t(model.getUserMap().get(userid), model.getLojaMap().get(lojaid), t)){
            t.setPreco_transporte(t.getPreco_km()*distancia(userid, lojaid, value));
            model.getEncMap().get(value).getEstafeta().add("Transportadora: " + t.getId() + " - Nome: " + t.getNome() + " - " + t.getPreco_transporte() + "€ - Rating: " + t.estrela());
        } else view.alert("Encomenda fora de alcance", "O range da sua transportadora não permite realizar esta recolha.");
    }
    public void pedir_recolha(IVoluntario v, String value){
        String userid = model.getEncMap().get(value).getUserId();
        String lojaid = model.getEncMap().get(value).getLoja();
        if(dentro_range_v(model.getUserMap().get(userid), model.getLojaMap().get(lojaid), v)){
            model.getEncMap().get(value).getEstafeta().add("Voluntário: " + v.getId() + " - Nome: " + v.getNome() + " - Rating: " + v.estrela());
        } else view.alert("Encomenda fora de alcance", "O seu range não permite realizar esta recolha.");
    }
    public void rating(IUtilizador u, String s, char type){
        if(type == 't'){
            model.getTransMap().get(s).getRating().add(5);
        }
        if(type == 'v'){
            model.getVolMap().get(s).getRating().add(5);
        }
    } // not done, add prompt
    public void listar_on_going(){
        view.make_window("Encomendas Ativas", view.encomendas_ativas(encomendas_ativas()));
    }

    // done
    public void registaTransportadora(String id, String nome, String email, String pwd, String nif, double range, double preco) throws IOException {

        ITransportadora transportadora = new Transportadora();

        Double[] loc = localizacao();

        transportadora.setId(id);
        transportadora.setPreco_km(preco);
        transportadora.setRange(range);
        transportadora.setNif(nif);
        transportadora.setNome(nome);
        transportadora.setEmail(email);
        transportadora.setPwd(pwd);
        transportadora.setLocalizacaoX(loc[0]);
        transportadora.setLocalizacaoY(loc[1]);

        model.getTransMap().putIfAbsent(id, transportadora);
        model.guardaEstado();
    }
    public void registaVoluntario(String id, String nome, String email, String pwd, double range) throws IOException {

        IVoluntario voluntario = new Voluntario();

        Double[] loc = localizacao();

        voluntario.setId(id);
        voluntario.setRange(range);
        voluntario.setNome(nome);
        voluntario.setEmail(email);
        voluntario.setPwd(pwd);
        voluntario.setLocalizacaoX(loc[0]);
        voluntario.setLocalizacaoY(loc[1]);


        model.getVolMap().putIfAbsent(email, voluntario);
        model.guardaEstado();

    }
    public void registaLoja(String id, String nome, String email, String pwd) throws IOException {
        ILoja loja = new Loja();

        Double[] loc = localizacao();

        loja.setId(id);
        loja.setNome(nome);
        loja.setEmail(email);
        loja.setPwd(pwd);
        loja.setLocalizacaoX(loc[0]);
        loja.setLocalizacaoY(loc[1]);

        model.getLojaMap().putIfAbsent(email, loja);
        model.guardaEstado();
    }
    public void registaUtilizador(String id, String nome, String email, String pwd) throws IOException {
        IUtilizador utilizador = new Utilizador();

        Double[] loc = localizacao();

        utilizador.setId(id);
        utilizador.setEmail(email);
        utilizador.setId(id);
        utilizador.setPwd(pwd);
        utilizador.setNome(nome);
        utilizador.setEstado(0);
        utilizador.setAcessos(0);
        utilizador.setLocalizacaoX(loc[0]);
        utilizador.setLocalizacaoY(loc[1]);

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
            registaTransportadora("t" + model.contaNCodTrans(), nome, email, pwd, nif, Double.parseDouble(range), Double.parseDouble(precokm));
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
            registaVoluntario("v" + model.contaNCodVol(), nome, email, pwd, Double.parseDouble(range));
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
            registaLoja("l" + model.contaNCodLoja(), nome, email, pwd);
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

    // done
    public IEncomenda pedidoUser(LinhaEncomenda produto, String idLoja, String userId) throws IOException {

        ILoja loja = model.getLojaMap().get(idLoja);
        IEncomenda encomenda = new Encomenda();

        String id = "e" + model.contaNCodEnc();

        encomenda.setId(id);
        encomenda.setLoja(idLoja);
        encomenda.setUserId(userId);
        encomenda.addProdutos(produto);
        encomenda.setPeso(produto.getPeso());
        encomenda.setPreco(produto.getPreco());

        model.getEncMap().putIfAbsent(id, encomenda);
        loja.getLista_encomendas().add(encomenda);
        return encomenda;
    }
    public boolean dentro_range_t(IUtilizador user, ILoja loja, ITransportadora t) {
        return Math.sqrt(Math.pow((loja.getLocalizacaoX() - t.getLocalizacaoX()), 2) + Math.pow((loja.getLocalizacaoY() - t.getLocalizacaoY()), 2)) < t.getRange() && Math.sqrt(Math.pow((user.getLocalizacaoX() - t.getLocalizacaoX()), 2) + Math.pow((user.getLocalizacaoY() - t.getLocalizacaoY()), 2)) < t.getRange();
    }
    public boolean dentro_range_v(IUtilizador user, ILoja loja, IVoluntario v) {
        return Math.sqrt(Math.pow((loja.getLocalizacaoX() - v.getLocalizacaoX()), 2) + Math.pow((loja.getLocalizacaoY() - v.getLocalizacaoY()), 2)) < v.getRange() && Math.sqrt(Math.pow((user.getLocalizacaoX() - v.getLocalizacaoX()), 2) + Math.pow((user.getLocalizacaoY() - v.getLocalizacaoY()), 2)) < v.getRange();
    }
    public double distancia(String userid, String lojaid, String transid) {
        IUtilizador user = this.model.getUserMap().get(userid);
        ILoja loja = this.model.getLojaMap().get(lojaid);
        return Math.sqrt(Math.pow(Math.abs(loja.getLocalizacaoX() - user.getLocalizacaoX()), 2) + Math.pow((loja.getLocalizacaoY() - user.getLocalizacaoY()), 2));
    }
    public Double[] localizacao (){
        Double [] loc = new Double[2];

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
            s.add("" + d.toString());
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
    private List<String> encomendas_ativas(){
        List<String> s = new Vector<>();
        for(IEncomenda enc : model.getEncMap().values()){
            s.add("Utilizador " + model.getUserMap().get(enc.getUserId()).getNome() + " encomendou " + enc.getId() + " com os produtos : " + enc.getProdutos());
        }
        return s;
    }

    public  List<IUtilizador> top10Acessos ()  {

        List<IUtilizador> l = new ArrayList<>();

        l.addAll(model.getUserMap().values());

        return l.stream().sorted().collect(Collectors.toList());

    }
    public  List<ITransportadora> top10Distancias ()  {

        List<ITransportadora> l = new ArrayList<>();

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







