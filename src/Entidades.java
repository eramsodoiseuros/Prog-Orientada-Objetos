import java.io.*;
import java.util.HashMap;
import java.util.Objects;

public class Entidades {

    private HashMap<String, Transportadora> dadosTrans;
    private HashMap<String, Utilizador> dadosUser;
    private HashMap<String, Voluntario> dadosVol;
    private HashMap<String, Loja> dadosLoja;
    private HashMap<String, Encomenda> dadosEnc;


    public Entidades() {
        this.dadosLoja = new HashMap<>();
        this.dadosTrans = new HashMap<>();
        this.dadosUser = new HashMap<>();
        this.dadosVol = new HashMap<>();
    }

    public HashMap<String, Voluntario> getDadosVol() {
        return dadosVol;
    }

    public HashMap<String, Utilizador> getDadosUser() {
        return dadosUser;
    }

    public HashMap<String, Transportadora> getDadosTrans() {
        return dadosTrans;
    }

    public HashMap<String, Loja> getDadosLoja() {
        return dadosLoja;
    }


    public HashMap<String, Voluntario> fileToVol() throws IOException {

        BufferedReader reader = null;
        reader = new BufferedReader(new FileReader("C:\\Users\\ramg2\\Documents\\GitHub\\POO\\logs_20200416.txt"));

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

                dadosVol.putIfAbsent(parts[0], voluntario);
            }
        }
        reader.close();
        return dadosVol;
    }


    public HashMap<String, Utilizador> fileToUser() throws IOException {

        BufferedReader reader = null;
        reader = new BufferedReader(new FileReader("C:\\Users\\ramg2\\Documents\\GitHub\\POO\\logs_20200416.txt"));

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


                dadosUser.putIfAbsent(parts[0], utilizador);
            }
        }
        reader.close();


        return dadosUser;
    }

    public HashMap<String, Transportadora> fileToTrans() throws IOException {

        BufferedReader reader = null;
        reader = new BufferedReader(new FileReader("C:\\Users\\ramg2\\Documents\\GitHub\\POO\\logs_20200416.txt"));

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

                dadosTrans.putIfAbsent(parts[0], transportadora);
            }
        }
        reader.close();

        return dadosTrans;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Entidades entidades = (Entidades) o;
        return Objects.equals(dadosTrans, entidades.dadosTrans) &&
                Objects.equals(dadosUser, entidades.dadosUser) &&
                Objects.equals(dadosVol, entidades.dadosVol) &&
                Objects.equals(dadosLoja, entidades.dadosLoja);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dadosTrans, dadosUser, dadosVol, dadosLoja);
    }


    public HashMap<String, Loja> filetoLoja() throws IOException {

        BufferedReader reader = null;
        reader = new BufferedReader(new FileReader("C:\\Users\\ramg2\\Documents\\GitHub\\POO\\logs_20200416.txt"));

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


                dadosLoja.putIfAbsent(parts[0], loja);
            }
        }
        reader.close();

        return dadosLoja;
    }

    public HashMap<String, Encomenda> fileToEnc() throws IOException {

        BufferedReader reader = null;
        reader = new BufferedReader(new FileReader("C:\\Users\\ramg2\\Documents\\GitHub\\POO\\logs_20200416.txt"));
        int i = 4;
        int r = 0;

        HashMap<String,Encomenda> enc = new HashMap<>();

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
                        le.setQuantidade(Double.parseDouble(parts2[i+2]));
                        le.setPreco(Double.parseDouble(parts2[i+3]));

                        encomenda.addProdutos(le);


                    }

                enc.putIfAbsent(parts[0], encomenda);
            }
        }
        reader.close();

        return enc;
    }



}
