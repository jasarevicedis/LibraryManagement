package ba.unsa.etf.rpr.controllers;


import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class DashboardController implements Initializable {
    @FXML
    private Button logoutButton;
    @FXML
    private Button cancelButton;
    @FXML
    private Button btnHome;

    @FXML
    private Button btnBooks;

    @FXML
    private Button btnMembers;

    @FXML
    private Button btnLoans;

    @FXML
    private Label lblPageName;

    @FXML
    private GridPane pnHome;

    @FXML
    private GridPane pnBooks;

    @FXML
    private GridPane pnMembers;

    @FXML
    private GridPane pnLoans;
    @Override
    public void initialize(URL location, ResourceBundle resources){}

    @FXML
    private void handleClicks(ActionEvent event){
        if(event.getSource() == btnHome){
            lblPageName.setText("Home");
            pnHome.toFront();
        }
        else if(event.getSource() == btnBooks){
            lblPageName.setText("Books");
            pnBooks.toFront();
        }
        else if(event.getSource() == btnMembers){
            lblPageName.setText("Members");
            pnMembers.toFront();
        }
        else if(event.getSource() == btnLoans){
            lblPageName.setText("Loans");
            pnLoans.toFront();
        }
    }
    public void cancelButtonOnAction(ActionEvent e){
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }

    public void logoutButtonOnAction(ActionEvent e){}
}
