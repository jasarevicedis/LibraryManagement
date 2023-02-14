package ba.unsa.etf.rpr.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.awt.*;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;

public class LoginController  {
    @FXML
    private Label loginMessageLabel;
    @FXML
    private TextField usernameTextField;
    @FXML
    private PasswordField passwordPasswordField;

    public void loginButtonOnAction(ActionEvent e){


        if(usernameTextField.getText().isBlank() == false && passwordPasswordField.getText().isBlank() == false){
            loginMessageLabel.setText("You try to login");
        }
        else {
            loginMessageLabel.setText("Please enter username and password");
        }
    }


}
