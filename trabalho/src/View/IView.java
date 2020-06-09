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

    Scene menu_user(Utilizador u, List<String> lojas, List<String> historico);
    Scene menu_transportadora(Transportadora t);
    Scene menu_voluntario(Voluntario v);
    Scene menu_loja(Loja l);

    Scene select_produtos(Utilizador u, List<String> produtos);

    void make_window(String title, Scene s);

    void setControler(IControler controler);
}
