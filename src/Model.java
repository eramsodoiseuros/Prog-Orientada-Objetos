import java.io.*;
import java.util.*;

public class Model implements Serializable, IModel {


    private File root = new File(getClass().getProtectionDomain().getCodeSource().getLocation().getPath());
    private File inventario = new File(root, "Files\\Inventario.txt");
    private File logsO = new File(root, "Files\\logsO.obj");
    private HashMap<String, Transportadora> transMap;
    private HashMap<String,Voluntario> volMap;
    private HashMap<String,Utilizador> userMap;
    private HashMap<String,Loja> lojaMap;
    private HashMap<String,Encomenda> encMap;




    public Model(){
        this.transMap = new HashMap<>();
        this.volMap = new HashMap<>();
        this.userMap = new HashMap<>();
        this.lojaMap = new HashMap<>();
        this.encMap = new HashMap<>();
    }


    public HashMap<String, Encomenda> getEncMap() {
        return encMap;
    }

    public void setEncMap(HashMap<String, Encomenda> encMap) {
        this.encMap = encMap;
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
        FileOutputStream fos = new FileOutputStream(logsO);
        ObjectOutputStream oos = new ObjectOutputStream(fos);

        oos.writeObject(this);

        oos.close();
        fos.close();
    }

    public Model loadEstado() throws IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream(logsO);
        ObjectInputStream ois = new ObjectInputStream(fis);

        return (Model) ois.readObject();
    }

    public  int contaNCodEnc(){
        Set<String> set  = this.encMap.keySet();
        int i =1;

        for (String s: set){
            String[] parts = s.split("(?<=\\D)(?=\\d)",2);
            if(i == Integer.parseInt(parts[1])) i++;

        }
        return i;
    }


    public  int contaNCodProd(){
        Collection<Encomenda> set  = this.encMap.values();
        int i =1;

        for (Encomenda enc: set){
            for (LinhaEncomenda le: enc.getProdutos()){
                String[] parts = le.getCodProd().split("(?<=\\D)(?=\\d)",2);
                if(le.getCodProd()==null || i==Integer.parseInt(parts[1])) i++;
            }
        }
        return i;
    }

    public  int contaNCodUser () {
        Set<String> set  = this.userMap.keySet();
        int i =1;

        for (String s: set){
            String[] parts = s.split("(?<=\\D)(?=\\d)",2);
            if(i == Integer.parseInt(parts[1])) i++;
        }
        return i;
    }

    public  int contaNCodTrans () {


        Set<String> set  = this.transMap.keySet();
        int i =1;

        for (String s: set) {
            String[] parts = s.split("(?<=\\D)(?=\\d)",2);
            if(i == Integer.parseInt(parts[1])) i++;

        }
        return i;
    }

    public  int contaNCodLoja () {
        Set<String> set  = this.lojaMap.keySet();
        int i =1;

        for (String s: set) {
            String[] parts = s.split("(?<=\\D)(?=\\d)",2);
            if(i == Integer.parseInt(parts[1])) i++;

        }
        return i;
    }

    public  int contaNCodVol () {
        Set<String> set  = this.volMap.keySet();
        int i =1;

        for (String s: set) {
            String[] parts = s.split("(?<=\\D)(?=\\d)",2);
            if(i == Integer.parseInt(parts[1])) i++;
        }
        return i;
    }





    public HashMap<String, Transportadora> getTransMap() {
        return transMap;
    }

    public HashMap<String, Loja> getLojaMap() {
        return lojaMap;
    }

    public HashMap<String, Utilizador> getUserMap() {
        return userMap;
    }

    public HashMap<String, Voluntario> getVolMap() {
        return volMap;
    }

    public void setTransMap(HashMap<String, Transportadora> transMap) {
        this.transMap = transMap;
    }

    public void setVolMap(HashMap<String, Voluntario> volMap) {
        this.volMap = volMap;
    }

    public void setUserMap(HashMap<String, Utilizador> userMap) {
        this.userMap = userMap;
    }

    public void setLojaMap(HashMap<String, Loja> lojaMap) {
        this.lojaMap = lojaMap;
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


    public void loadInventLoja() throws IOException {
        BufferedReader reader = null;
        reader = new BufferedReader(new FileReader(inventario));

        while (reader != null) {
            String line;
            if (!((line = reader.readLine()) != null)) break;

                String[] parts = line.split(",", 5);

                Loja loja = this.lojaMap.get(parts[0]);

                LinhaEncomenda le = new LinhaEncomenda();
                le.setCodProd("p"+contaNCodProd());
                le.setDescricao(parts[1]);
                le.setQuantidade(Double.parseDouble(parts[2]));
                le.setPreco(Double.parseDouble(parts[3]));
                le.setPeso(Double.parseDouble(parts[4]));

                loja.getInventario().add(le);
        }
        reader.close();
    }
}
