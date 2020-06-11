
public interface IUtilizador extends Serializable{
    /**
     *
     * @return String com o ID do Utilizador
     * */
    String getId();

    /**
     *
     * String com o nome do Utilizador
     * */
    void setNome(String nome);

    /**
     *
     * @return String com o nome do Utilizador
     * */
    String getNome();

    /**
     *
     *  String com o ID do Utilizador
     * */
    void setId(String id);

    /**
     *
     * @return Numero de encomendas realizadas do Utilizador
     * */
    int getAcessos();

    /**
     *
     * */
    int getEstado();

    /**
     *
     * */
    void setEstado(int estado);

    /**
     *
     *  Set de encomendas realizadas pelo Utilizador
     * */
    void setHistorico(Set<IEncomenda> historico);

    /**
     *
     *  Numero de encomendas realizadas do Utilizador
     * */
    void setAcessos(int acessos);

    /**
     *
     * @return Localização X do Utilizador
     * */
    double getLocalizacaoX();

    /**
     *
     * @return Localização Y do Utilizador
     * */
    double getLocalizacaoY();

    /**
     *
     * Localização X do Utilizador
     * */
    void setLocalizacaoX(double localizacaoX);

    /**
     *
     * Localização Y do Utilizador
     * */
    void setLocalizacaoY(double localizacaoY);

    /**
     *
     *
     * @return Set de encomendas realizadas pelo Utilizador
     * */
    Set<IEncomenda> getHistorico();

    /**
     *
     * @return Set de encomendas realizadas pelo Utilizador
     * */
    void setHistorico(TreeSet<IEncomenda> historico);

    /**
     *
     * @return String email do Utilizador
     * */
    String getEmail();

    /**
     *
     * @return String password do Utilizador
     * */
    String getPwd();

    /**
     *
     * @return String password do Utilizador
     * */
    void setPwd(String s);

    /**
     *
     * @return String email do Utilizador
     * */
    void setEmail(String s);
}

//////////////////////////////////////////////////////////////////////////////////////////////////


public interface IVoluntario extends Serializable {
    /**
     * @return String com o ID do Voluntario
     * */
    String getId();


    /**
     * @return String com a password do Voluntario
     * */
    String getPwd();


    /**
     *  String com a password do Voluntario
     * */
    void setPwd(String pwd);


    /**
     * @return String com o email do Voluntario
     * */
    String getEmail();


    /**
     *  String com o email do Voluntario
     * */
    void setEmail(String email);


    /**
     * @return String com o nome do Voluntario
     * */
    String getNome();


    /**
     * @return List com as avaliações do Voluntario
     * */
    ArrayList<Integer> getRating();


    /**
     * @return Set com os registos das encomendas realizadas pelo Voluntario
     * */
    Set<IEncomenda> getRegistos();


    /**
     *  String com o ID do Voluntario
     * */
    void setId(String id);


    /**
     *  String com o nome do Voluntario
     * */
    void setNome(String nome);


    /**
     * Double com a Localização X do Voluntario
     * */
    void setLocalizacaoX(double localizacaoX);


    /**
     * Double com a Localização Y do Voluntario
     * */
    void setLocalizacaoY(double localizacaoY);


    /**
     * Double com o range do Voluntario
     * */
    void setRange(double range);


    /**
     * @return Double com a media das avaliações
     * */
    double estrela();

    /**
     * @return Double com a localozação em X
     * */
    double getLocalizacaoX();

    /**
     * @return Double com a localozação em Y
     * */
    double getLocalizacaoY();

    /**
     * @return Double com o alcance do voluntario
     * */
    double getRange();

    /**
     * Torna o Voluntario não disponivel
     * */
    void not_available();


    /**
     * Verifica se o Voluntari esta disponivel
     * */
    boolean check_available();

    /**
     * Torna o Voluntario disponivel
     * */
    void available();

    /**
     * Numero de encomendas realizadas pelo Voluntario
     * */
    void n_encomedas();
}


////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


public interface ITransportadora extends Serializable{
    /**
     *
     * @return String com o Nome da Transportadora
     * */
    String getNome();

    /**
     *
     * @return List com as avaliações da Transportadora
     * */
    ArrayList<Integer> getRating();

    /**
     *
     * @return Double com o range
     * */
    double getRange();

    /**
     *
     * @return Double com a localização X
     * */
    double getLocalizacaoX();

    /**
     *
     * @return Double com a localização Y
     * */
    double getLocalizacaoY();

    /**
     *
     *  Double com a localização Y
     * */
    void setLocalizacaoY(double localizacaoY);

    /**
     *
     *  Double com a localização X
     * */
    void setLocalizacaoX(double localizacaoX);

    /**
     *
     * @return String com o ID da Transportadora
     * */
    String getId();

    /**
     *
     * @return List com o historico da Transportadora
     * */
    List<String> getHistorico();

    /**
     *
     * @return List com a faturação da Transportadora
     * */
    List<Double> getFaturacao();

    /**
     *
     * @return Double com o preço total do transporte
     * */
    double getPreco_transporte();

    /**
     *
     *  String com o range da Transportadora
     * */
    void setRange(double range);

    /**
     *
     *  String com o ID da Transportadora
     * */
    void setId(String id) ;

    /**
     *
     *  Double com o preço por km da Transportadora
     * */
    void setPreco_km(double preco_km);

    /**
     *
     *  String com o NIF da Transportadora
     * */
    void setNif(String nif);

    /**
     *
     * String com o Nome da Transportadora
     * */
    void setNome(String nome);

    /**
     *
     * @return Media de ratings
     * */
    Double estrela();

    /**
     *
     * @return String com o Email da Transportadora
     * */
    String getEmail();

    /**
     *
     * @return String com a password da Transportadora
     * */
    String getPwd();

    /**
     *
     *  String com a password da Transportadora
     * */
    void setPwd(String s);

    /**
     *
     *  String com o email da Transportadora
     * */
    void setEmail(String s);

    /**
     *
     *
     * Double com o preço de transporte da Transportadora
     * */
    void setPreco_transporte(double preco_transporte);

    /**
     *
     * @return Double com o preço por km da Transportadora
     * */
    double getPreco_km();

    /**
     * @return True ou false consoante a disponibilidade da transportadora para entregar
     * */
    boolean check_available();

    /**
     * Torna a transportadora disponivel para entrgas
     * */
    void available();

    /**
     * @return Double com o total percorrido pela transportadora da Transportadora
     * */
    double getDistancia();

    /**
     * Double com o total percorrido pela transportadora da Transportadora
     * */
    void setDistancia(Double d);
}

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


public interface ILoja extends Serializable {
    /**
     * @return Set com uma estrutura Linha de Encomenda
     * */
    Set<LinhaEncomenda> getInventario();

    /**
     * @return String com o Id de Loja
     * */
    String getId();

    /**
     *
     * */
    void setId(String id);

    /**
     * @return String com o Nome de Loja
     * */
    String getNome();

    /**
     * @param nome String com o Nome da Loja
     * */
    void setNome(String nome);

    /**
     * @return String com a palavra-passe da Loja
     * */
    String getPwd();

    /**
     * @param pwd String com a palavra-passe da Loja
     * */
    void setPwd(String pwd);

    /**
     * @return String com o email da Loja
     * */
    String getEmail();

    /**
     * @param email String com o email da Loja
     * */
    void setEmail(String email);

    /**
     * @return Double com a localização de coordenada Y da Loja
     * */
    double getLocalizacaoY();

    /**
     * @return Double com a localização de coordenada X da Loja
     * */
    double getLocalizacaoX();

    /**
     * @param localizacaoX Double com a localização de coordenada X da Loja
     * */
    void setLocalizacaoX(double localizacaoX);

    /**
     * @param localizacaoY Double com a localização de coordenada Y da Loja
     * */
    void setLocalizacaoY(double localizacaoY);

    /**
     * @param e Encomenda a adicionar ao Histórico da Loja
     * */
    void addHistorico (IEncomenda e);

    /**
     * @return String que representa o número de pessoas numa fila
     * */
    String fila();

    /**
     * Adiciona um ao numero de encomendas na fila
     * */
    void add_fila();

    /**
     * Remove um ao numero de encomendas da fila
     * */
    void remove_fila();

    /**
     * Adiciona uma encomenda as encomendas ativas da loja
     * */
    void addLista(IEncomenda e);

    /**
     * Remove uma encomenda as encomendas ativas da loja
     * */
    void removeLista(String e);

    /**
     * Cria uma lista com os IDs das encomendas que estão ativas
     * */
    List<String> precisa_recolha(ILoja l);

    /**
     * @return O tempo medio de espera na loja
     * */
    int f_time();
}

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

public interface IEncomenda extends Serializable {
    /**
     *
     * @return Double com um preço
     * */
    void setPreco(double preco);

    /**
     *
     * @return String com o Id de Encomenda
     * */
    String getId();

    /**
     *
     * @return String com o Id de Loja
     * */
    String getLoja();

    /**
     *
     * @return String com o Id de Utilizador
     * */
    String getUserId();

    /**
     *
     * @return Double com um peso
     * */
    void setPeso(double peso);

    /**
     *
     * @return Set com os Ids dos Estafetas que aceitaram a encomenda
     * */
    Set<String> getEstafeta();

    /**
     *
     * @return List com os Produtos
     * */
    ArrayList<LinhaEncomenda> getProdutos();

    /**
     *
     * @return String com o ID da encomenda
     * */
    void setId(String id);

    /**
     *
     * @return String com o ID da loja
     * */
    void setLoja(String loja);

    /**
     *
     * @return String com o ID do Utilizador
     * */
    void setUserId(String userId);

    /**
     *
     * @return List com os produtos
     * */
    void setProdutos(ArrayList<LinhaEncomenda> produtos);

    /**
     * Adiciona um novo produto aos produtos da encomenda
     *
     * */
    void addProdutos(LinhaEncomenda p);

}

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

public interface IModel {

    /**
     *
     * */
    String toString();

    /**
     * Guarda o estado do model ou seja de todas as classes de entidades num ficheiro usando o ObjectOutputStream
     * @throws IOException
     */
    void guardaEstado () throws IOException;

    /**
     *
     * Carrega o estado do model ou seja de todas as classes de entidades num ficheiro usando o ObjectInputStream
     * @throws IOException
     */
    Model loadEstado () throws IOException, ClassNotFoundException;

    /**
     *
     * @return o numero para acrescentar no cod da encomenda para q nunca se repitam
     */
    int contaNCodEnc ();

    /**
     *
     * @return o numero para acrescentar no cod da encomenda para q nunca se repitam
     */
    int contaNCodProd ();

    /**
     *
     * @return o numero para acrescentar no cod do produto para q nunca se repitam
     */
    int contaNCodUser ();

    /**
     *
     * @return o numero para acrescentar no cod da transportadora para q nunca se repitam
     */
    int contaNCodTrans ();

    /**
     *
     * @return o numero para acrescentar no cod da loja para q nunca se repitam
     */
    int contaNCodLoja ();

    /**
     *
     * @return o numero para acrescentar no cod do voluntario para q nunca se repitam
     */
    int contaNCodVol ();

    /**
     *
     * @return Mapa das Transportadoras
     * */
    HashMap<String, ITransportadora> getTransMap();

    /**
     *
     * @return Mapa das Lojas
     * */
    HashMap<String, ILoja> getLojaMap();

    /**
     *
     * @return Mapa dos utilizadores
     * */
    HashMap<String, IUtilizador> getUserMap();

    /**
     *
     * @return Mapa dos Voluntarios
     * */
    HashMap<String, IVoluntario> getVolMap();

    /**
     * @return Mapa de encomendas com o seu ID como key
     */
    HashMap<String, IEncomenda> getEncMap();

    void registaEncomenda(String id, String userId, String lojaId, double peso, ArrayList<LinhaEncomenda> produtos);

    void addEncomenda(IEncomenda e);
    void addVoluntario(IVoluntario v);
    void addUtilizador(IUtilizador u);
    void addLoja(ILoja l);
    void addTransportadora(ITransportadora t);


    /**
     * Metodo provavelmente temporario que adiciona um inventario as lojas existentes fazendo load de um ficheiro txt
     * @throws IOException
     */
    void loadInventLoja() throws IOException;
    /**
     * Metodo provavelmente temporario que adiciona as transporadoras existentes fazendo load de um ficheiro txt
     *  @throws IOException
     */
    void fileToTrans() throws IOException;

    /**
     *
     *
     * Metodo provavelmente temporario que adiciona as lojas existentes fazendo load de um ficheiro txt
     * @throws IOException
     */
    void filetoLoja() throws IOException;

    /**
     *
     *
     * Metodo provavelmente temporario que adiciona os Utilizadores existentes fazendo load de um ficheiro txt
     * @throws IOException
     */
    void fileToUser() throws IOException;

    /**
     *
     *
     * Metodo provavelmente temporario que adiciona os Voluntarios existentes fazendo load de um ficheiro txt
     * @throws IOException
     */
    void fileToVol() throws IOException;

    /**
     *
     *
     * Metodo provavelmente temporario que adiciona as Encomendas existentes fazendo load de um ficheiro txt
     * @throws IOException
     */
    void fileToEnc() throws IOException;

    void removeEncomenda(String id);

    /**
     *
     * */
    List<String> precisa_recolha(ILoja l);

    /**
     *
     * */
    ILoja loja_nome(String nome);

    /**
     *
     * */
    IEncomenda encomendas_u(IUtilizador u);

    /**
     *
     * */
    boolean validaLogInUser(String email, String pwd);

    /**
     *
     * */
    boolean validaLogInVol(String email, String pwd);

    /**
     *
     * */
    boolean validaLogInTrans(String email, String pwd);

    /**
     *
     * */
    boolean validaLogInLoja(String email, String pwd);

    /**
     *
     * */
    IUtilizador getUser(String email);

    /**
     *
     * */
    IVoluntario getVol(String email);

    /**
     *
     * */
    ITransportadora getTrans(String email);

    /**
     *
     * */
    ILoja getLoja(String email);

    /**
     *
     * */
    ILoja loja(String id);

    /**
     *
     * */
    ITransportadora transportadora(String id);

    /**
     *
     * */
    IUtilizador user(String id);

    /**
     *
     * */
    IVoluntario voluntario(String id);

    /**
     *
     * */
    boolean validaRegistoUser(String email);

    /**
     *
     * */
    boolean validaRegistoVol(String email);

    /**
     *
     * */
    boolean validaRegistoTrans(String email);

    /**
     *
     * */
    boolean validaRegistoLoja(String email);

    /**
     *
     * */
    List<String> top10Acessos();

    /**
     *
     * */
    List<String> top10Distancias();
}
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////