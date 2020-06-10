package Model;
import java.io.*;
import java.util.*;

public class Model implements Serializable, IModel {


    private File root = new File(getClass().getProtectionDomain().getCodeSource().getLocation().getPath());
    private File inventario = new File(root, "Files\\Inventario.txt");
    private File logsO = new File(root, "Files\\logsO.obj");
    private File logs_stor = new File(root, "Files\\logs_20200416.txt");
    private HashMap<String,ITransportadora> transMap;
    private HashMap<String,IVoluntario> volMap;
    private TreeMap<String,IUtilizador> userMap;
    private HashMap<String,ILoja> lojaMap;
    private HashMap<String,IEncomenda> encMap;

    public Model(){
        this.transMap = new HashMap<>();
        this.volMap = new HashMap<>();
        this.userMap = new TreeMap<>();
        this.lojaMap = new HashMap<>();
        this.encMap = new HashMap<>();
    }

    @Override
    public String toString(){
        return "Model{" +
                "transMap=" + transMap + "\n"+
                ", volMap=" + volMap + "\n"+
                ", userMap=" + userMap + "\n"+
                ", lojaMap=" + lojaMap + "\n"+
                ", EncMap=" + encMap +
                '}';
    }

    public void guardaEstado() throws IOException{
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(logsO));

        oos.writeObject(this);
        oos.flush();
    }
    public Model loadEstado() throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(logsO));
        return (Model) ois.readObject();
    }

    public  int contaNCodEnc(){
        Set<String> set  = this.encMap.keySet();

        Random r = new Random();
        int i = r.nextInt((10000 - 3) + 1) + 3;

        if(set.contains("e" + i)) i++;
        return i;
    }
    public  int contaNCodProd(){
        Collection<IEncomenda> set  = this.encMap.values();

        Random r = new Random();
        int i = r.nextInt((10000 - 3) + 1) + 3;

        if(set.contains("p" + i)) i++;
        return i;
    }
    public  int contaNCodUser () {
        Set<String> set  = this.userMap.keySet();

        Random r = new Random();
        int i = r.nextInt((10000 - 3) + 1) + 3;

        if(set.contains("u" + i)) i++;
        return i;
    }
    public  int contaNCodTrans () {
        Set<String> set  = this.transMap.keySet();

        Random r = new Random();
        int i = r.nextInt((10000 - 3) + 1) + 3;

        if(set.contains("t" + i)) i++;
        return i;
    }
    public  int contaNCodLoja () {
        Set<String> set  = this.lojaMap.keySet();

        Random r = new Random();
        int i = r.nextInt((10000 - 3) + 1) + 3;

        if(set.contains("l" + i)) i++;
        return i;
    }
    public  int contaNCodVol () {
        Set<String> set  = this.volMap.keySet();

        Random r = new Random();
        int i = r.nextInt((10000 - 3) + 1) + 3;

        if(set.contains("v" + i)) i++;
        return i;
    }

    public HashMap<String, ITransportadora> getTransMap() {
        return transMap;
    }
    public HashMap<String, ILoja> getLojaMap() {
        return lojaMap;
    }
    public TreeMap<String, IUtilizador> getUserMap() {
        return userMap;
    }
    public HashMap<String, IVoluntario> getVolMap() {
        return volMap;
    }
    public HashMap<String, IEncomenda> getEncMap() {
        return encMap;
    }

    public void registaEncomenda(String id, String userId, String lojaId, double peso,ArrayList<LinhaEncomenda> produtos){
        Encomenda encomenda = new Encomenda();

        encomenda.setId(id);
        encomenda.setUserId(userId);
        encomenda.setPeso(peso);
        encomenda.setLoja(lojaId);
        encomenda.setProdutos(produtos);

        this.encMap.putIfAbsent(id,encomenda);
    }

    public void addEncomenda(IEncomenda e){
        encMap.put(e.getId(), e);
    }
    public void removeEncomenda(String id){
        encMap.remove(id);
    }
    public void addVoluntario(IVoluntario v){
        volMap.put(v.getId(), v);
    }
    public void addUtilizador(IUtilizador u){
        userMap.put(u.getId(), u);
    }
    public void addLoja(ILoja l){
        lojaMap.put(l.getId(), l);
    }
    public void addTransportadora(ITransportadora t){
        transMap.put(t.getId(), t);
    }

    public List<String> precisa_recolha(ILoja l){
        List<String> lista = l.precisa_recolha(l);
        for(String s : lista){
            if(!this.getEncMap().containsKey(s)){
                lista.remove(s);
                l.removeLista(s);
            }
        }
        return lista;
    }
    public ILoja loja_nome(String nome){
        ILoja loja = new Loja();
        for (ILoja l: lojaMap.values()) {
            if(l.getNome().equals(nome))
                return l;
        }
        return loja;
    }
    public ILoja loja(String id){
        if(lojaMap.containsKey(id))
            return lojaMap.get(id);
        else return new Loja();
    }
    public IEncomenda encomendas_u(IUtilizador u) {
        IEncomenda e = new Encomenda();
        for(IEncomenda enc : encMap.values()){
            if(enc.getUserId().equals(u.getId())){
                return enc;
            }
        }
        return e;
    }

    public boolean validaLogInUser(String email, String pwd) {
        for (IUtilizador u : userMap.values()) {
            if (u.getEmail().equals(email) && u.getPwd().equals(pwd)) {
                return true;
            }
        }
        return false;
    }
    public boolean validaLogInVol(String email, String pwd) {
        for (IVoluntario u : volMap.values()) {
            if (u.getEmail().equals(email) && u.getPwd().equals(pwd)) {
                return true;
            }
        }
        return false;
    }
    public boolean validaLogInTrans(String email, String pwd) {
        for (ITransportadora u : transMap.values()) {
            if (u.getEmail().equals(email) && u.getPwd().equals(pwd)) {
                return true;
            }
        }
        return false;
    }
    public boolean validaLogInLoja(String email, String pwd) {
        for (ILoja u : lojaMap.values()) {
            if (u.getEmail().equals(email) && u.getPwd().equals(pwd)) {
                return true;
            }
        }
        return false;
    }

    public IUtilizador getUser(String email){
        IUtilizador user = new Utilizador();
        for (IUtilizador u : userMap.values()) {
            if (u.getEmail().equals(email)) {
                return u;
            }
        }
        return user;
    }
    public IVoluntario getVol(String email) {
        IVoluntario v = new Voluntario();
        for (IVoluntario vol : volMap.values()) {
            if (vol.getEmail().equals(email)) {
                return vol;
            }
        }
        return v;
    }
    public ITransportadora getTrans(String email) {
        ITransportadora t = new Transportadora();
        for (ITransportadora trans : transMap.values()) {
            if (trans.getEmail().equals(email)) {
                return trans;
            }
        }
        return t;
    }
    public ILoja getLoja(String email) {
        ILoja l = new Loja();
        for (ILoja loja : lojaMap.values()) {
            if (loja.getEmail().equals(email)) {
                return loja;
            }
        }
        return l;
    }

    public boolean validaRegistoUser(String email) {
        for (IUtilizador u : userMap.values()) {
            if (u.getEmail().equals(email)) {
                return false;
            }
        }
        return true;
    }
    public boolean validaRegistoVol(String email) {
        for (IVoluntario u : volMap.values()) {
            if (u.getEmail().equals(email)) {
                return false;
            }
        }
        return true;
    }
    public boolean validaRegistoTrans(String email) {
        for (ITransportadora u : transMap.values()) {
            if (u.getEmail().equals(email)) {
                return false;
            }
        }
        return true;
    }
    public boolean validaRegistoLoja(String email) {
        for (ILoja u : lojaMap.values()) {
            if (u.getEmail().equals(email)) {
                return false;
            }
        }
        return true;
    }

    public void loadInventLoja() throws IOException {
        BufferedReader reader = null;
        reader = new BufferedReader(new FileReader(inventario));

        while (reader != null) {
            String line;
            if (!((line = reader.readLine()) != null)) break;

            String[] parts = line.split(",", 5);

            ILoja loja = this.lojaMap.get(parts[0]);

            LinhaEncomenda le = new LinhaEncomenda();
            le.setCodProd("p"+contaNCodProd());
            le.setDescricao(parts[1]);
            le.setPreco(Double.parseDouble(parts[2]));
            le.setPeso(Double.parseDouble(parts[3]));

            loja.getInventario().add(le);
        }
        reader.close();
    }
    public void fileToVol() throws IOException {

        BufferedReader reader = null;
        reader = new BufferedReader(new FileReader(logs_stor));

        while (reader != null) {
            String line;
            if (!((line = reader.readLine()) != null)) break;
            if (line.startsWith("v")) {

                String[] parts = line.split(",", 5);

                Voluntario voluntario = new Voluntario();

                voluntario.setId(parts[0]);
                voluntario.setNome(parts[1]);
                voluntario.setLocalizacaoX(Double.parseDouble(parts[2]));
                voluntario.setLocalizacaoY(Double.parseDouble(parts[3]));
                voluntario.setRange(Double.parseDouble(parts[4]));

                volMap.putIfAbsent(parts[0], voluntario);
            }
        }
        reader.close();
    }
    public void fileToUser() throws IOException {

        BufferedReader reader = null;
        reader = new BufferedReader(new FileReader(logs_stor));

        while (reader != null) {
            String line;
            if (!((line = reader.readLine()) != null)) break;
            if (line.startsWith("u")) {

                String[] parts = line.split(",", 4);

                Utilizador utilizador = new Utilizador();
                utilizador.setEstado(0);
                utilizador.setAcessos(0);
                utilizador.setId(parts[0]);
                utilizador.setNome(parts[1]);
                utilizador.setLocalizacaoX(Double.parseDouble(parts[2]));
                utilizador.setLocalizacaoY(Double.parseDouble(parts[3]));


                userMap.putIfAbsent(parts[0], utilizador);
            }
        }
        reader.close();
    }
    public void fileToTrans() throws IOException {

        BufferedReader reader = null;
        reader = new BufferedReader(new FileReader(logs_stor));

        while (reader != null) {
            String line;
            if (!((line = reader.readLine()) != null)) break;
            if (line.startsWith("t")) {

                String[] parts = line.split(",", 7);

                Transportadora transportadora = new Transportadora();

                transportadora.setId(parts[0]);
                transportadora.setNome(parts[1]);
                transportadora.setLocalizacaoX(Double.parseDouble(parts[2]));
                transportadora.setLocalizacaoY(Double.parseDouble(parts[3]));
                transportadora.setNif(parts[4]);
                transportadora.setRange(Double.parseDouble(parts[5]));
                transportadora.setPreco_km(Double.parseDouble(parts[6]));

                transMap.putIfAbsent(parts[0], transportadora);
            }
        }
        reader.close();
    }
    public void filetoLoja() throws IOException {

        BufferedReader reader = null;
        reader = new BufferedReader(new FileReader(logs_stor));

        while (reader != null) {
            String line;
            if (!((line = reader.readLine()) != null)) break;
            if (line.startsWith("l")) {

                String[] parts = line.split(",", 4);

                Loja loja = new Loja();

                loja.setId(parts[0]);
                loja.setNome(parts[1]);
                loja.setLocalizacaoX(Double.parseDouble(parts[2]));
                loja.setLocalizacaoY(Double.parseDouble(parts[3]));


                lojaMap.putIfAbsent(parts[0], loja);
            }
        }
        reader.close();
    }
    public void fileToEnc() throws IOException {
        BufferedReader reader = null;
        reader = new BufferedReader(new FileReader(logs_stor));
        int i = 4;
        int r = 0;

        while (reader != null) {
            String line;
            if (!((line = reader.readLine()) != null)) break;
            if (line.startsWith("e")) {

                String[] parts = line.split(",", 5);

                Encomenda encomenda = new Encomenda();

                encomenda.setId(parts[0]);
                encomenda.setUserId(parts[1]);
                encomenda.setLoja(parts[2]);
                encomenda.setPeso(Double.parseDouble(parts[3]));

                String[] parts2 = parts[4].split(",", 100);

                for (i = 4; i<parts2.length ; i += 4) {
                    LinhaEncomenda le = new LinhaEncomenda();
                    le.setCodProd(parts2[i]);
                    le.setDescricao(parts2[i+1]);
                    le.setPreco(Double.parseDouble(parts2[i+2]));

                    encomenda.addProdutos(le);
                }
                encMap.putIfAbsent(parts[0], encomenda);
                for (ILoja l: lojaMap.values()) {
                    if(l.getId().equals(encomenda.getLoja())){
                        l.addLista(encomenda);
                    }
                }
            }
        }
        reader.close();
    }
}
