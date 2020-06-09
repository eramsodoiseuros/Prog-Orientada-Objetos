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
     *
     * */
    void alert(String titulo, String mensagem);

    /**
     *
     * */
    Scene menu();

    /**
     *
     * */
    Scene registar_user();

    /**
     *
     * */
    Scene registar_transportadora();

    /**
     *
     * */
    Scene registar_voluntario();

    /**
     *
     * */
    Scene registar_loja();

    /**
     *
     * */
    Scene login_user();

    /**
     *
     * */
    Scene login_voluntario();

    /**
     *
     * */
    Scene login_transportadora();

    /**
     *
     * */
    Scene login_loja();

    /**
     *
     * */
    Scene menu_user(IUtilizador u, List<String> lojas, List<String> historico, IEncomenda encomenda);

    /**
     *
     * */
    Scene menu_transportadora(ITransportadora t, List<String> lojas, List<String> faturacao  );

    /**
     *
     * */
    Scene menu_voluntario(IVoluntario v, List<String> lojas);

    /**
     *
     * */
    Scene menu_loja(ILoja l);

    /**
     *
     * */
    Scene select_produtos(IUtilizador u, ILoja l, List<String> produtos);

    /**
     *
     * */
    void make_window(String title, Scene s);

    /**
     *
     * */
    Scene encomendas_ativas(ITransportadora t, List<String> recolha);

    /**
     *
     * */
    Scene encomendas_ativas(IVoluntario v, List<String> recolha);

    /**
     *
     * */
    Scene encomendas_ativas(List<String> encomendas);
}
