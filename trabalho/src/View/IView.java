package View;

import Controler.IControler;
import javafx.scene.Scene;
import Model.*;
import java.util.List;

public interface IView {

    void alert(String titulo, String mensagem);

    Scene menu();

    Scene registar_user();
    Scene registar_transportadora();
    Scene registar_voluntario();
    Scene registar_loja();

    Scene login_user();
    Scene login_voluntario();
    Scene login_transportadora();
    Scene login_loja();

    Scene menu_user(Utilizador u, List<String> lojas, List<String> historico, Encomenda encomenda);
    Scene menu_transportadora(Transportadora t, List<String> lojas, List<String> faturacao  );
    Scene menu_voluntario(Voluntario v, List<String> lojas);
    Scene menu_loja(Loja l);

    Scene select_produtos(Utilizador u, Loja l, List<String> produtos);

    void make_window(String title, Scene s);

    void setControler(IControler controler);

    Scene encomendas_ativas(Transportadora t, List<String> recolha);
    Scene encomendas_ativas(Voluntario v, List<String> recolha);
}
