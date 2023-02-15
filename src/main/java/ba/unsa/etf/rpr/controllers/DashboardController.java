package ba.unsa.etf.rpr.controllers;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

import java.net.URL;
import java.util.ResourceBundle;

public class DashboardController implements Initializable {

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
        }
        else if(event.getSource() == btnBooks){
            lblPageName.setText("Books");

        }
        else if(event.getSource() == btnMembers){
            lblPageName.setText("Members");

        }
        else if(event.getSource() == btnLoans){
            lblPageName.setText("Loans");

        }
    }
}
