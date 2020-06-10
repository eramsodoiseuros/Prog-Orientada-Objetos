package View;

import Controler.IControler;
import javafx.scene.Scene;
import Model.*;
import java.util.List;

/**
 * Interface da View
 * */
public interface IView {
    /**
     * Cria um alert
     * @param titulo Titulo da Janela "Alert"
     * @param mensagem Mensagem a imprimir no "Alert"
     * */
    void alert(String titulo, String mensagem);

    /**
     * Função que gera a Scene JavaFX representativa do Menu Principal
     * @return Scene repesentativa do Menu Principal
     * */
    Scene menu();

    /**
     * Função que gera a Scene JavaFX representativa do Registo de Utilizador
     * @return Scene repesentativa do Registo de Utilizador
     * */
    Scene registar_user();

    /**
     * Função que gera a Scene JavaFX representativa do Registo de Transportadora
     * @return Scene repesentativa do Registo de Transportadora
     * */
    Scene registar_transportadora();

    /**
     * Função que gera a Scene JavaFX representativa do Registo de Voluntário
     * @return Scene repesentativa do Registo de Voluntário
     * */
    Scene registar_voluntario();

    /**
     * Função que gera a Scene JavaFX representativa do Registo de Loja
     * @return Scene repesentativa do Registo de Loja
     * */
    Scene registar_loja();

    /**
     * Função que gera a Scene JavaFX representativa do Login de User
     * @return Scene repesentativa do Login de User
     * */
    Scene login_user();

    /**
     * Função que gera a Scene JavaFX representativa do Login de Voluntário
     * @return Scene repesentativa do Login de Voluntário
     * */
    Scene login_voluntario();

    /**
     * Função que gera a Scene JavaFX representativa do Login de Transportadora
     * @return Scene repesentativa do Login de Transportadora
     * */
    Scene login_transportadora();

    /**
     * Função que gera a Scene JavaFX representativa do Login de Loja
     * @return Scene repesentativa do Login de Loja
     * */
    Scene login_loja();

    /**
     * Função que gera a Scene JavaFX representativa do Menu de Utilizador
     * @param u
     * @param lojas
     * @param historico
     * @param encomenda
     * @return Scene repesentativa do Menu de Utilizador
     * */
    Scene menu_user(IUtilizador u, List<String> lojas, List<String> historico, IEncomenda encomenda);

    /**
     * Função que gera a Scene JavaFX representativa do Menu de Transportadora
     * @param t
     * @param lojas
     * @param faturacao
     * @return Scene repesentativa do Menu de Transportadora
     * */
    Scene menu_transportadora(ITransportadora t, List<String> lojas, List<String> faturacao  );

    /**
     * Função que gera a Scene JavaFX representativa do Menu de Voluntário
     * @param v
     * @param lojas
     * @return Scene repesentativa do Menu de Voluntário
     * */
    Scene menu_voluntario(IVoluntario v, List<String> lojas);

    /**
     * Função que gera a Scene JavaFX representativa do Menu de Loja
     * @param l
     * @return Scene repesentativa do Menu de Loja
     * */
    Scene menu_loja(ILoja l);

    /**
     * Função que gera a Scene JavaFX representativa da Seleção de Produtos por parte do Utilizador
     * @param u
     * @param l
     * @param produtos
     * @return Scene repesentativa da Seleção de Produtos por parte do Utilizador
     * */
    Scene select_produtos(IUtilizador u, ILoja l, List<String> produtos);

    /**
     * Função que cria uma nova Janela
     * @param title Titulo da nova Janela
     * @param s Scene do JavaFX
     * */
    void make_window(String title, Scene s);

    /**
     * Função que gera a Scene JavaFX representativa da Lista de Encomendas Ativas a ler pela Transportadora
     * @param t
     * @param recolha
     * @return Scene repesentativa do Menu Principal
     * */
    Scene encomendas_ativas(ITransportadora t, List<String> recolha);

    /**
     * Função que gera a Scene JavaFX representativa da Lista de Encomendas Ativas a ler pelo Voluntário
     * @param v
     * @param recolha
     * @return Scene repesentativa do Menu Principal
     * */
    Scene encomendas_ativas(IVoluntario v, List<String> recolha);

    /**
     * Função que gera a Scene JavaFX representativa da Lista de Encomendas Ativas
     * @param encomendas
     * @return Scene repesentativa do Menu Principal
     * */
    Scene print_list(List<String> encomendas);
}
