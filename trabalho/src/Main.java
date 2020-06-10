import Controler.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import View.*;
import Model.*;

public class Main extends Application {
    Stage window;

    @Override
    public void start(Stage primaryStage) throws Exception{

        IView view = new View();
        window = primaryStage;
        window.setScene(view.menu());
        window.setTitle("Menu Principal");
        window.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
