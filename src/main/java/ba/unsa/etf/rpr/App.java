package ba.unsa.etf.rpr;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import static javafx.scene.control.PopupControl.USE_COMPUTED_SIZE;

public class App extends Application {

    @Override
    public void start(Stage primaryStage) throws  Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/login.fxml"));
        primaryStage.initStyle(StageStyle.UNDECORATED);
        //primaryStage.setTitle(" Hello world !!!");
        primaryStage.setScene(new Scene(root,USE_COMPUTED_SIZE,  USE_COMPUTED_SIZE));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}