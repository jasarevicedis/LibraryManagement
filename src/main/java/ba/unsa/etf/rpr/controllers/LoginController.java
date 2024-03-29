package ba.unsa.etf.rpr.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;

import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.stage.StageStyle;

/**
 * controller for sign in option
 */
public class LoginController  {
    private int  loginSuccessfull=0;
    @FXML
    private Button cancelButton;
    @FXML
    private Label loginMessageLabel;
    @FXML
    private TextField usernameTextField;
    @FXML
    private PasswordField passwordPasswordField;


    /**
     * method that works after clicking login
     */
    public void loginButtonOnAction(ActionEvent e) throws IOException {


        if(usernameTextField.getText().isBlank() == false && passwordPasswordField.getText().isBlank() == false){
            //loginMessageLabel.setText("You try to login");
            validateLogin();
            if(loginSuccessfull==1){
                Stage stage = (Stage) cancelButton.getScene().getWindow();
                stage.close();
                Stage primaryStage = new Stage();
                Parent root = FXMLLoader.load(getClass().getResource("/fxml/dashboard.fxml"));
                primaryStage.initStyle(StageStyle.UNDECORATED);
                Scene scene = new Scene(root);
                primaryStage.setScene(scene);
                primaryStage.show();

            }
        }
        else {
            loginMessageLabel.setText("Please enter username and password");
        }
    }
    /**
     * checks if login data is regular
     */
    public void validateLogin(){
        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.getConnection();

        String verifyLogin = "SELECT count(1) FROM admin WHERE username = '"+ usernameTextField.getText() +"' AND password = '"+ passwordPasswordField.getText() +"'";
        try {
            Statement statement = connectDB.createStatement();
            ResultSet queryResult = statement.executeQuery(verifyLogin);

            while(queryResult.next()){
                if(queryResult.getInt(1) == 1){
                    loginMessageLabel.setText("Welcome");
                    loginSuccessfull = 1;
                }else{
                    loginMessageLabel.setText("Invalid login!");
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    /**
     * leaving of the screen
     */
    public void cancelButtonOnAction(ActionEvent e){
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }


}
