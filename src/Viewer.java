import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;
import java.util.TreeSet;

import static java.lang.System.*;

public class Viewer {

    private Controler controler;
    private Entidades e;

    public Controler getControler() {
        return controler;
    }

    public void setControler(Controler controler) {
        this.controler = controler;
    }

    public Entidades getE() {
        return e;
    }

    public void setE(Entidades e) {
        this.e = e;
    }

    public void menu() throws IOException, ClassNotFoundException, CloneNotSupportedException {
        int escolha = 0, entidade,navega;

        String p ;
        String email;
        String e;
        String nome;
        double range;

        Scanner scanner = new Scanner(System.in);
        this.controler.setModel(this.controler.getModel().loadEstado());
        this.controler.escreveMail();


        System.out.println("Selecione uma opção:\n");

        System.out.println("1. Registar\n");
        System.out.println("2. Log In\n");
        System.out.println("0. Sair\n");

        escolha = scanner.nextInt();
        scanner.nextLine();
        while (escolha!=0) {
            switch (escolha) {
                case 1:
                    regista();
                    menu();
                    break;


                case 2:
                    log_In();
                    menu();
                    break;
            }
        }
    }





    public void imprimeLoja(){
        int i =1;
        for (Loja loja:this.controler.getModel().getLojaMap().values()) {
            System.out.println(i+". "+loja.getNome()+"\n");
            i++;
        }

    }

    public String selecionaLoja(int r){
        int i = 1;
        int k = 1;
        String s = null;
        for (Loja loja:this.controler.getModel().getLojaMap().values()) {
            if(i==r){
                s =loja.getId();
                for (LinhaEncomenda le: loja.getInventario()) {
                    System.out.println(k+". "+le.getDescricao()+"\n");
                    k++;
                }
            }
            i++;
        }
        return s;
    }


    public LinhaEncomenda selecionaProd(int r, int p){
        int i = 1;
        int k = 1;
        LinhaEncomenda prod = new LinhaEncomenda();
        for (Loja loja:this.controler.getModel().getLojaMap().values()) {
            if(i==r){
                for (LinhaEncomenda le: loja.getInventario()) {
                    if(p==k) prod= le;
                    k++;
                }
            }
            i++;
        }
        return prod;
    }

    public void inicia () throws IOException {
        this.controler=new Controler();
        this.e= new Entidades();
        controler.getModel().setTransMap(e.fileToTrans());
        controler.getModel().setLojaMap(e.filetoLoja());
        controler.getModel().setUserMap(e.fileToUser());
        controler.getModel().setVolMap(e.fileToVol());
        controler.getModel().setEncMap(e.fileToEnc());
        controler.getModel().loadInventLoja();
        controler.getModel().guardaEstado();
    }

    public void regista() throws IOException {
        Scanner scanner = new Scanner(System.in);
        int entidade;
        String email;
        String p;
        String nome;
        double range;

        System.out.println("Selecione a entidade que quer registar:\n");

        System.out.println("1. Utilizador\n");
        System.out.println("2. Transportadora\n");
        System.out.println("3. Voluntario\n");
        System.out.println("4. Loja\n");
        System.out.println("0. Anterior\n");

        entidade = scanner.nextInt();
        scanner.nextLine();
        switch (entidade){
            case 1:
                System.out.println("Email:");
                email = scanner.nextLine();

                System.out.println("Password:");
                p = scanner.nextLine();

                System.out.println("Nome:");
                nome = scanner.nextLine();

                if (this.controler.validaRegUser(email)) {
                    this.controler.registaUtilizador("u"+controler.getModel().contaNCodUser(), nome, email, p);
                }
                else System.out.println("Email já em uso. Tente novamente com um novo email.");
                break;
            case 2:
                System.out.println("Email:");
                email = scanner.nextLine();
                System.out.println("Password:");
                p = scanner.nextLine();

                System.out.println("Nome:");
                nome = scanner.nextLine();
                System.out.println("NIF:");
                String nif = scanner.nextLine();
                System.out.println("Range:");
                range = scanner.nextDouble();
                System.out.println("Preço por km:");
                double preco = scanner.nextDouble();

                if (this.controler.validaRegTrans(email))
                    this.controler.registaTransportadora("t" + controler.getModel().contaNCodTrans(), nome, email, p, nif, range, preco);
                else System.out.println("Email já em uso. Tente novamente com um novo email.");
                break;
            case 3:
                System.out.println("Email:");
                email = scanner.nextLine();
                System.out.println("Password:");
                p = scanner.nextLine();

                System.out.println("Nome:");
                nome = scanner.nextLine();

                System.out.println("Range:");
                range = scanner.nextDouble();
                if (this.controler.validaRegVol(email))
                    this.controler.registaVoluntario("v" + controler.getModel().contaNCodVol(), nome, email, p, range);
                else System.out.println("Email já em uso. Tente novamente com um novo email.");
                break;
            case 4:
                System.out.println("Email:");
                email = scanner.nextLine();
                System.out.println("Password:");
                p = scanner.nextLine();

                System.out.println("Nome:");
                nome = scanner.nextLine();

                if (this.controler.validaRegLoja(email))
                    this.controler.registaLoja("l" + controler.getModel().contaNCodLoja(), nome, email, p);
                else System.out.println("Email já em uso. Tente novamente com um novo email.");
                break;
        }
    }

    public void log_In() throws IOException, CloneNotSupportedException {

        Scanner scanner = new Scanner(System.in);
        int entidade, navega,prod;
        String e;
        String p;
        String nome;
        double range;
        String lojaid;
        String userid ;

        System.out.println("Selecione a sua entidade:\n");


        System.out.println("1. Utilizador\n");
        System.out.println("2. Transportadora\n");
        System.out.println("3. Voluntario\n");
        System.out.println("4. Loja\n");
        System.out.println("0. Sair\n");

        entidade = scanner.nextInt();
        scanner.nextLine();
        //while (entidade!=0) {
            switch (entidade) {
                case 1:
                    System.out.println("Email:");
                    e = scanner.nextLine();
                    System.out.println("Password:");
                    p = scanner.nextLine();
                    if (this.controler.validaLogInUser(e, p)) {
                        System.out.println("Log in bem sucedido\n");
                        Utilizador u = this.controler.getUser(controler.getUserid(e, p));
                        int a = u.getAcessos()+1;
                        u.setAcessos(a);
                        int estado = verificaEstado(e, p);
                        if (estado == 0) {
                            encomendar(e, p);
                            out.println("Encomenda feita");

                        }
                        if (estado == 1){
                            imprimeTrans(controler.getUserid(e,p));
                            navega=scanner.nextInt();
                            confirmaEnc(controler.getUserid(e,p),navega);
                        }
                    } else {
                        System.out.println("Credenciais erradas ou não existentes");
                        log_In();
                    }
                    break;
                case 2:
                    System.out.println("Email:");
                    e = scanner.nextLine();
                    System.out.println("Password:");
                    p = scanner.nextLine();
                    if (this.controler.validaLogInTrans(e, p)) {
                        System.out.println("Log in bem sucedido");
                        //int i = 0;
                        int i = transEscolheLoja(e, p);
                        Loja loja = selecionaLojaTrans(i);
                        navega = scanner.nextInt();
                        transEscolheEnc(i, e, p, loja);
                        System.out.println("A esperar resposta do utilizador");

                    } else {
                        System.out.println("Credenciais erradas ou não existentes");
                        log_In();
                    }
                    break;
                case 3:
                    System.out.println("Email:");
                    e = scanner.nextLine();
                    System.out.println("Password:");
                    p = scanner.nextLine();
                    if (this.controler.validaLogInVol(e, p)) System.out.println("Log in bem sucedido");
                    else System.out.println("Credenciais erradas ou não existentes");
                    break;
            case 4:
                System.out.println("Email:");
                e = scanner.nextLine();
                System.out.println("Password:");
                p = scanner.nextLine();
                if (this.controler.validaLogInLoja(e, p)) System.out.println("Log in bem sucedido");
                else System.out.println("Credenciais erradas ou não existentes");
                break;
        }
    }


    public void imprimeTrans (String userId){
        int i = 1;
        System.out.println("Selecione uma empresa transportadora:");
        for (Transportadora t:this.controler.getModel().getTransMap().values()) {
            for (Encomenda enc: t.getAtivas()) {

                if(t.isDisponivel() && enc.getUserId().equals(userId)){
                    System.out.println(i+ ". " + t.getNome() + " ----> " + t.getPreco_transporte()+ "€   " + t.getRating() + " Estrelas");
                }
            }
            i++;
        }
    }

    public void encomendar(String e, String p) throws IOException {

        Scanner scanner = new Scanner(System.in);
        int entidade, navega,prod;
        String userid = controler.getUserid(e,p);


        String lojaid;

        System.out.println("Selecione a Loja da qual pertende encomendar:");
        imprimeLoja();
        navega=scanner.nextInt();
        System.out.println("Selecione um produto:");
        lojaid=selecionaLoja(navega);
        prod=scanner.nextInt();
        this.controler.pedidoUser(selecionaProd(navega,prod),lojaid,userid);

        Utilizador user = this.controler.getModel().getUserMap().get(userid);
        user.setEstado(1);
        this.controler.getModel().guardaEstado();
    }

    public int verificaEstado(String e, String p){
       String userid = this.controler.getUserid(e,p);

       Utilizador user = this.controler.getModel().getUserMap().get(userid);

       return  user.getEstado();
    }

    public int transEscolheLoja (String e, String p){

     Scanner scanner = new Scanner(System.in);
     int i;
     int k = 1;
     Loja loja;
     String userid;
     String transid = this.controler.getTransId(e,p);
     Transportadora trans = controler.getModel().getTransMap().get(transid);

     System.out.println("Selecione uma loja para verificar as encomendas disponiveis para entrega:");
     imprimeLoja();
     i = scanner.nextInt();
     //scanner.nextLine();

     loja = selecionaLojaTrans(i);
     System.out.println("Selecione uma encomenda disponivel para entrega:");
        for (Encomenda enc: loja.getLista_encomendas()) {
            userid = enc.getUserId();



                if(this.controler.dentroRange(userid,loja.getId(),transid)  ){
                    out.println(k+ ". " + enc.getId() + " ----> " + enc.getProdutos().toString());

            }
            //else out.println("Não existem encomendas disponiveis para o alcance da empresa");
        k++;
        }


        return i;

    }

    public void transEscolheEnc(int r, String e ,String p, Loja loja) throws IOException {

        Scanner scanner = new Scanner(System.in);
        int i;
        int k = 1;

        String userid;
        String transid = this.controler.getTransId(e, p);

        for (Encomenda enc : loja.getLista_encomendas()) {
            userid = enc.getUserId();


            if (this.controler.dentroRange(userid, loja.getId(), transid)) {
              if(k==r){
                  out.println("Encomenda aceite");
                  Transportadora t = this.controler.getModel().getTransMap().get(transid);
                  t.getAtivas().add(enc);
                  t.setDistancia(controler.distancia(userid,loja.getId(),transid)+t.getDistancia());
                  t.setPreco_transporte(t.getPreco_km()*this.controler.distancia(userid,loja.getId(),transid)+(0.2*t.getPreco_transporte()*enc.getPesoTot()) + enc.getPrecoTot());
                  controler.getModel().guardaEstado();
              }
            }

        k++;
        }
    }


    public Loja selecionaLojaTrans(int r){
        int i =1;
        Loja s = new Loja();
        for (Loja loja:this.controler.getModel().getLojaMap().values()) {
            if(i==r){
                s = loja;

            }
            i++;
        }
        return s;
    }


    public void confirmaEnc (String userId, int r){
        int i = 1;

        for (Transportadora t:this.controler.getModel().getTransMap().values()) {
            for (Encomenda enc: t.getAtivas()) {

                if(t.isDisponivel() && enc.getUserId().equals(userId)){
                    if(i==r){
                        t.getHistorico().add(enc);
                        t.getAtivas().remove(enc);
                    };
                }
            }
            i++;
        }
        controler.getModel().getUserMap().get(userId).setEstado(2);
        System.out.println("Encomenda vai ser processada e enviada.");
    }


    public void classifica(){


    }

    void menuUser(){

        out.println("1. Encomendar");
        out.println("2. Verificar historico de encomendas");

    }

    void menuUserEnc(){

        out.println("Escolha uma loja:");
        imprimeLoja();

    }

    void menuTrans(){

        out.println("1. Encontrar uma encomenda:");
        out.println("2. Verificar historico/faturação");
    }

    void menuTransEnc(){

        out.println("Escolha uma loja:");
        imprimeLoja();

    }


    void menuVol(){

        out.println("1. Encontrar uma encomenda:");
        out.println("2. Verificar historico");
    }

    void menuVolEnc(){

        out.println("Escolha uma loja:");
        imprimeLoja();

    }

    void menuLoja(){ //not sure

        out.println("1. Verificar Inventario");
        out.println("2. Verificar Encomendas");

    }





}



