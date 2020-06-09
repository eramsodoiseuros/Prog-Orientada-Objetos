package View;

import Model.*;
import Controler.*;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;

public class View implements IView{

    private IControler c;
    private Stage window;
    private TextField usertxt, txt, txt2, txt3, txt4;
    private PasswordField passwordtxt;
    private ListView<String> listView;

    public View(IControler c){
        this.c = c;
    }

    public View(){
        c = new Controler();
    }

    @Override
    public void alert(String titulo, String mensagem){
        Stage w = new Stage();
        w.initModality(Modality.APPLICATION_MODAL);
        w.setTitle(titulo);
        w.setMinWidth(300);

        Label label = new Label();
        label.setText(mensagem);
        Button closeButton = new Button("Fechar.");
        closeButton.setOnAction(e -> w.close());

        VBox layout = new VBox(15);
        layout.getChildren().addAll(label, closeButton);
        layout.setAlignment(Pos.CENTER);

        Scene scene = new Scene(layout);
        w.setScene(scene);
        w.showAndWait();
    } // done

    @Override
    public Scene menu() {
        VBox layout = new VBox(10);
        layout.setPadding(new Insets(20, 20, 20, 20));

        listView= new ListView<>();
        listView.getItems().addAll("Registar Utilizador", "Registar Transportadora", "Registar Voluntário", "Registar Loja", "Login Utilizador", "Login Transportadora", "Login Voluntário", "Login Loja", "Encomendas Ativas");
        listView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);

        Button b1 = new Button("Escolher.");
        b1.setOnAction(e -> escolher_menu());

        Button b2 = new Button("Sair.");
        b2.setOnAction(e -> {
            c.save();
            Platform.exit();
        });

        Button b3 = new Button("Guardar.");
        b3.setOnAction(e -> {
            c.save();
            c.end_scene(e);
            make_window("Menu Principal", menu());
        });

        layout.getChildren().addAll(listView,b1,b2,b3);
        return new Scene(layout, 400, 300);
    } // done

    @Override
    public Scene registar_user() {
        VBox layout = new VBox(10);
        layout.setPadding(new Insets(20, 20, 20, 20));

        usertxt = new TextField();
        Label lblUser = new Label("Email de Utilizador");

        passwordtxt = new PasswordField();
        Label lblPassword = new Label("Password");

        txt = new TextField();
        Label lblNome = new Label("Nome");

        Button b = new Button("Registar.");
        b.setOnAction(e -> {
            String user = usertxt.getText();
            String pwd = passwordtxt.getText();
            String nome = txt.getText();

            if(user.equals("")) alert("Email NULL", "Precisa de inserir um email para se registar.");
            if(pwd.equals("")) alert("Password NULL", "Precisa de inserir uma palavra-passe para se registar.");
            if(nome.equals("")) alert("Nome NULL", "Precisa de inserir um nome para se registar.");
            else {
                c.validaRegUser(user, pwd, nome);
                c.end_scene(e);
            }
        });

        layout.getChildren().addAll(lblUser, usertxt, lblPassword, passwordtxt, lblNome, txt, b);
        return new Scene(layout, 500, 400);
    } // done

    @Override
    // not done
    public Scene registar_transportadora() {
        VBox layout = new VBox(10);
        layout.setPadding(new Insets(20, 20, 20, 20));

        usertxt = new TextField();
        Label lblUser = new Label("Email de Transportadora");

        passwordtxt = new PasswordField();
        Label lblPassword = new Label("Password");

        txt = new TextField();
        Label lblNome = new Label("Nome");

        txt2 = new TextField();
        Label lblNif = new Label("Nif");

        txt3 = new TextField();
        Label lblRange = new Label("Range");

        txt4 = new TextField();
        Label lblPreco = new Label("Preço/km");

        Button b = new Button("Registar.");
        b.setOnAction(e -> {
            String user = usertxt.getText();
            String pwd = passwordtxt.getText();
            String nome = txt.getText();
            String nif = txt2.getText();
            String range = txt3.getText();
            String precokm = txt4.getText();

            if(user.equals("")) alert("Email NULL", "Precisa de inserir um email para se registar.");
            if(pwd.equals("")) alert("Password NULL", "Precisa de inserir uma palavra-passe para se registar.");
            if(nome.equals("")) alert("Nome NULL", "Precisa de inserir um nome para se registar.");
            if(nif.equals("")) alert("Nif NULL", "Precisa de inserir um nif para se registar.");
            if(range.equals("")) alert("Range NULL", "Precisa de inserir um range para se registar.");
            if(precokm.equals("")) alert("Preço NULL", "Precisa de inserir um preço/km para se registar.");
            else {
                c.validaRegTrans(user, pwd, nome, nif, range, precokm);
                c.end_scene(e);
            }
        });

        layout.getChildren().addAll(lblUser, usertxt, lblPassword, passwordtxt, lblNome, txt, lblNif, txt2, lblRange, txt3, lblPreco, txt4, b);
        return new Scene(layout, 500, 450);
    } // done

    @Override
    // not done
    public Scene registar_voluntario() {
        VBox layout = new VBox(10);
        layout.setPadding(new Insets(20, 20, 20, 20));

        usertxt = new TextField();
        Label lblUser = new Label("Email de Voluntário");

        passwordtxt = new PasswordField();
        Label lblPassword = new Label("Password");

        txt = new TextField();
        Label lblNome = new Label("Nome");

        txt3 = new TextField();
        Label lblRange = new Label("Range");

        Button b = new Button("Registar.");
        b.setOnAction(e -> {
            String user = usertxt.getText();
            String pwd = passwordtxt.getText();
            String nome = txt.getText();
            String range = txt3.getText();

            if(user.equals("")) alert("Email NULL", "Precisa de inserir um email para se registar.");
            if(pwd.equals("")) alert("Password NULL", "Precisa de inserir uma palavra-passe para se registar.");
            if(nome.equals("")) alert("Nome NULL", "Precisa de inserir um nome para se registar.");
            if(range.equals("")) alert("Range NULL", "Precisa de inserir um range para se registar.");
            else {
                c.validaRegVol(user, pwd, nome, range);
                c.end_scene(e);
            }
        });

        layout.getChildren().addAll(lblUser, usertxt, lblPassword, passwordtxt, lblNome, txt, lblRange, txt3, b);
        return new Scene(layout, 500, 400);
    } // done

    @Override
    //not done
    public Scene registar_loja() {
        VBox layout = new VBox(10);
        layout.setPadding(new Insets(20, 20, 20, 20));

        usertxt = new TextField();
        Label lblUser = new Label("Email de Loja");

        passwordtxt = new PasswordField();
        Label lblPassword = new Label("Password");

        txt = new TextField();
        Label lblNome = new Label("Nome");

        Button b = new Button("Registar.");
        b.setOnAction(e -> {
            String user = usertxt.getText();
            String pwd = passwordtxt.getText();
            String nome = txt.getText();

            if(user.equals("")) alert("Email NULL", "Precisa de inserir um email para se registar.");
            if(pwd.equals("")) alert("Password NULL", "Precisa de inserir uma palavra-passe para se registar.");
            if(nome.equals("")) alert("Nome NULL", "Precisa de inserir um nome para se registar.");
            else {
                c.validaRegLoja(user, pwd, nome);
                c.end_scene(e);
            }
        });

        layout.getChildren().addAll(lblUser, usertxt, lblPassword, passwordtxt, lblNome, txt, b);
        return new Scene(layout, 500, 400);
    } // done

    @Override
    public Scene login_user() {
        VBox layout = new VBox(10);
        layout.setPadding(new Insets(20, 20, 20, 20));

        usertxt = new TextField();

        Label lblUser = new Label("Email de Utilizador");

        passwordtxt = new PasswordField();
        Label lblPassword = new Label("Password");

        Button b = new Button("Login.");
        b.setOnAction(e -> {
            String user = usertxt.getText();
            String pwd = passwordtxt.getText();
            c.validaLogInUser(user, pwd);
            c.end_scene(e);
        });

        layout.getChildren().addAll(lblUser, usertxt, lblPassword, passwordtxt, b);
        return new Scene(layout, 400, 300);
    } // done

    @Override
    public Scene login_voluntario() {
        VBox layout = new VBox(10);
        layout.setPadding(new Insets(20, 20, 20, 20));

        usertxt = new TextField();

        Label lblUser = new Label("Email de Voluntário");

        passwordtxt = new PasswordField();
        Label lblPassword = new Label("Password");

        Button b = new Button("Login.");
        b.setOnAction(e -> {
            String user = usertxt.getText();
            String pwd = passwordtxt.getText();
            c.validaLogInVol(user, pwd);
            c.end_scene(e);
        });

        layout.getChildren().addAll(lblUser, usertxt, lblPassword, passwordtxt, b);
        return new Scene(layout, 400, 300);
    } // done

    @Override
    public Scene login_transportadora() {
        VBox layout = new VBox(10);
        layout.setPadding(new Insets(20, 20, 20, 20));

        usertxt = new TextField();

        Label lblUser = new Label("Email de Transportadora");

        passwordtxt = new PasswordField();
        Label lblPassword = new Label("Password");

        Button b = new Button("Login.");
        b.setOnAction(e -> {
            String user = usertxt.getText();
            String pwd = passwordtxt.getText();
            c.validaLogInTrans(user, pwd);
            c.end_scene(e);
        });

        layout.getChildren().addAll(lblUser, usertxt, lblPassword, passwordtxt, b);
        return new Scene(layout, 400, 300);
    } // done

    @Override
    public Scene login_loja() {
        VBox layout = new VBox(10);
        layout.setPadding(new Insets(20, 20, 20, 20));

        usertxt = new TextField();

        Label lblUser = new Label("Email de Loja");

        passwordtxt = new PasswordField();
        Label lblPassword = new Label("Password");

        Button b = new Button("Login.");
        b.setOnAction(e -> {
            String user = usertxt.getText();
            String pwd = passwordtxt.getText();
            c.validaLogInLoja(user, pwd);
            c.end_scene(e);
        });

        layout.getChildren().addAll(lblUser, usertxt, lblPassword, passwordtxt, b);
        return new Scene(layout, 400, 300);
    } // done

    @Override
    public Scene menu_user(Utilizador u, List<String> lojas, List<String> historico ) {
        VBox layout = new VBox(10);
        layout.setPadding(new Insets(20, 20, 20, 20));

        ComboBox<String> cb = new ComboBox<>();
        cb.getItems().addAll(lojas);
        cb.setPromptText("Selecione a Loja da qual pertende encomendar:");
        cb.setOnAction(e -> {
            c.loja_selecionada(u, cb.getValue());
            c.end_scene(e);
        });

        ComboBox<String> cb2 = new ComboBox<>();
        cb2.getItems().addAll(historico);
        cb2.setPromptText("Ver histórico de encomendas:");
        cb2.setOnAction(e -> {
            c.update_user(u);
            c.end_scene(e);
        });

        Button update = new Button("Update");
        update.setOnAction(e -> {
            c.update_user(u);
            c.end_scene(e);
        });

        layout.getChildren().addAll(cb, cb2, update);
        return new Scene(layout, 400, 300);
    }

    @Override
    public Scene menu_transportadora(Transportadora t, List<String> lojas, List<String> faturacao ) {
        VBox layout = new VBox(10);
        layout.setPadding(new Insets(20, 20, 20, 20));

        ComboBox<String> cb = new ComboBox<>();
        cb.getItems().addAll(lojas);
        cb.setPromptText("Selecione a Loja da qual pertende entregar:");
        cb.setOnAction(e -> {
            c.loja_selecionada(t, cb.getValue());
            c.end_scene(e);
        });

        ComboBox<String> cb2 = new ComboBox<>();
        cb2.getItems().addAll(faturacao);
        cb2.setPromptText("Ver histórico de faturacao:");

        Button update = new Button("Update");
        update.setOnAction(e -> {
            c.update_transportadora(t);
            c.end_scene(e);
        });

        layout.getChildren().addAll(cb, cb2, update);
        return new Scene(layout, 400, 300);
    }

    @Override
    public Scene menu_voluntario(Voluntario v, List<String> lojas) {
        return null;
    }

    @Override
    public Scene menu_loja(Loja l) {
        return null;
    }

    @Override
    public Scene select_produtos(Utilizador u, Loja l, List<String> produtos) {
        VBox layout = new VBox(10);

        Button comprar = new Button("Finalizar encomenda");
        comprar.setOnAction(e -> {
            for (LinhaEncomenda ec : l.getInventario()) {
                if(listView.getSelectionModel().getSelectedItems().contains(ec.getDescricao())){
                    try {
                        c.pedidoUser(ec, l.getId(), u.getId());
                    } catch (IOException ioException) {
                        alert("Erro", "Falhou a realizar uma encomenda");
                    }
                }
            }
            c.update_user(u);
            c.end_scene(e);
        });

        listView = new ListView<>();
        listView.getItems().addAll(produtos);
        listView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        layout.getChildren().addAll(listView,comprar);
        layout.setPadding(new Insets(20, 20, 20, 20));
        return new Scene(layout, 400, 300);
    }

    @Override
    public void make_window(String title, Scene s){
        Stage w = new Stage();
        w.setTitle(title);
        w.setScene(s);
        w.show();
    }

    @Override
    public void setControler(IControler controler) {
        this.c = controler;
    }

    @Override
    public Scene encomendas_ativas(Transportadora t, List<String> recolhas){
        VBox layout = new VBox(10);

        ComboBox<String> cb = new ComboBox<>();
        cb.getItems().addAll(recolhas);
        cb.setPromptText("Selecione a Loja da qual pertende ir realizar uma recolha:");
        cb.setOnAction(e -> {
            c.loja_selecionada(t, cb.getValue());
            c.end_scene(e);
        });

        layout.getChildren().addAll(cb);
        layout.setPadding(new Insets(20, 20, 20, 20));
        return new Scene(layout, 400, 300);
    }

    @Override
    public Scene encomendas_ativas(Voluntario v, List<String> recolhas){
        return null;
    }

    /* Verifica a escolhe feita no menu */
    private void escolher_menu(){
        String s = String.valueOf(listView.getSelectionModel().getSelectedItems());
        if(s.equals("[Registar Utilizador]")){
            Stage w = new Stage();
            w.setTitle("Registo de Utilizador");
            w.setScene(registar_user());
            w.show();
        }

        if(s.equals("[Registar Transportadora]")){
            Stage w = new Stage();
            w.setTitle("Registo de Transportadora");
            w.setScene(registar_transportadora());
            w.show();
        }

        if(s.equals("[Registar Voluntário]")){
            Stage w = new Stage();
            w.setTitle("Registo de Voluntário");
            w.setScene(registar_voluntario());
            w.show();
        }

        if(s.equals("[Registar Loja]")){
            Stage w = new Stage();
            w.setTitle("Registo de Loja");
            w.setScene(registar_loja());
            w.show();
        }

        if(s.equals("[Login Utilizador]")){
            Stage w = new Stage();
            w.setTitle("Login de Utilizador");
            w.setScene(login_user());
            w.show();
        }

        if(s.equals("[Login Transportadora]")){
            Stage w = new Stage();
            w.setTitle("Login de Transportadora");
            w.setScene(login_transportadora());
            w.show();
        }

        if(s.equals("[Login Voluntário]")){
            Stage w = new Stage();
            w.setTitle("Login de Voluntário");
            w.setScene(login_voluntario());
            w.show();
        }

        if(s.equals("[Login Loja]")){
            Stage w = new Stage();
            w.setTitle("Login de Loja");
            w.setScene(login_loja());
            w.show();
        }

        if(s.equals("[Encomendas Ativas]")){
            alert("Funcionalidade", "CODE NOT IMPLEMENTED"); // HELP
        }
    } // need fix
}
