import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Loja implements Serializable, ILoja {
    private String id;
    private String nome;
    private String pwd;
    private String email;
    private double localizacaoX;
    private double localizacaoY;
    private Fila fila;
    private HashSet<Encomenda> lista_encomendas;
    private HashSet<Encomenda> historico;
    private Set<LinhaEncomenda> inventario;

    public Set<LinhaEncomenda> getInventario() {
        return inventario;
    }

    public void setInventario(Set<LinhaEncomenda> inventario) {
        this.inventario = inventario;
    }

    public Loja(String id, String nome, String email, String pwd, double localizacaoX, double localizacaoY, Fila fila, HashSet<Encomenda> lista_encomendas, HashSet<Encomenda> historico, Set<LinhaEncomenda> inventario) {
        this.id = id;
        this.nome = nome;
        this.pwd = pwd;
        this.email = email;
        this.localizacaoX = localizacaoX;
        this.localizacaoY = localizacaoY;
        this.fila = fila;
        this.lista_encomendas = lista_encomendas;
        this.historico = historico;
        this.inventario = inventario;
    }

    public Loja() {
        this.id = null;
        this.localizacaoX = 0;
        this.localizacaoY = 0;
        this.fila = null;
        this.pwd = null;
        this.email = null;
        this.lista_encomendas = new HashSet<>();
        this.historico = new HashSet<>();
        this.nome = null;
        this.inventario = new HashSet<>();
    }

    public String getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getLocalizacaoY() {
        return localizacaoY;
    }

    public double getLocalizacaoX() {
        return localizacaoX;
    }

    public Fila getFila() {
        return fila;
    }

    public HashSet<Encomenda> getLista_encomendas() {
        return lista_encomendas;
    }

    public HashSet<Encomenda> getHistorico() {
        return historico;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setLocalizacaoX(double localizacaoX) {
        this.localizacaoX = localizacaoX;
    }

    public void setLocalizacaoY(double localizacaoY) {
        this.localizacaoY = localizacaoY;
    }

    public void setFila(Fila fila) {
        this.fila = fila;
    }

    public void setLista_encomendas(HashSet<Encomenda> lista_encomendas) {
        this.lista_encomendas = lista_encomendas;
    }

    public void setHistorico(HashSet<Encomenda> historico) {
        this.historico = historico;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Loja loja = (Loja) o;
        return Double.compare(loja.localizacaoX, localizacaoX) == 0 &&
                Double.compare(loja.localizacaoY, localizacaoY) == 0 &&
                Objects.equals(id, loja.id) &&
                Objects.equals(nome, loja.nome) &&
                Objects.equals(fila, loja.fila) &&
                Objects.equals(lista_encomendas, loja.lista_encomendas) &&
                Objects.equals(historico, loja.historico);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, localizacaoX, localizacaoY, fila, lista_encomendas, historico);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return "Loja{" +
                "id='" + id + '\'' +
                ", nome='" + nome + '\'' +
                ", pwd='" + pwd + '\'' +
                ", email='" + email + '\'' +
                ", localizacaoX=" + localizacaoX +
                ", localizacaoY=" + localizacaoY +
                ", fila=" + fila +
                ", lista_encomendas=" + lista_encomendas +
                ", historico=" + historico +
                ", inventario=" + inventario +
                '}';
    }

    public void addLista (Encomenda e){
        lista_encomendas.add(e);
    }

    public void addHistorico (Encomenda e){
        historico.add(e);
    }


}

class Fila{
    private int n_max;
    private int em_fila;
    private int tempo_medio;
    private boolean disponivel;

    public Fila(int n_max, int em_fila, int tempo_medio, boolean disponivel) {
        this.n_max = n_max;
        this.em_fila = em_fila;
        this.tempo_medio = tempo_medio;
        this.disponivel = disponivel;
    }

    public int getN_max() {
        return n_max;
    }

    public int getEm_fila() {
        return em_fila;
    }

    public int getTempo_medio() {
        return tempo_medio;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setN_max(int n_max) {
        this.n_max = n_max;
    }

    public void setEm_fila(int em_fila) {
        this.em_fila = em_fila;
    }

    public void setTempo_medio(int tempo_medio) {
        this.tempo_medio = tempo_medio;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Fila fila = (Fila) o;
        return n_max == fila.n_max &&
                em_fila == fila.em_fila &&
                tempo_medio == fila.tempo_medio &&
                disponivel == fila.disponivel;
    }

    @Override
    public int hashCode() {
        return Objects.hash(n_max, em_fila, tempo_medio, disponivel);
    }
}
