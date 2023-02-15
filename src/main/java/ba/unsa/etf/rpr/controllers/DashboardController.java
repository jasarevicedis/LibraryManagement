package ba.unsa.etf.rpr.controllers;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

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
    @Override
    public void initialize(URL location, ResourceBundle resources){}

    @FXML
    private void handleClicks(ActionEvent event){
        if(event.getSource() == btnHome){

        }
        else if(event.getSource() == btnBooks){

        }
        else if(event.getSource() == btnMembers){

        }
        else if(event.getSource() == btnLoans){

        }
    }
}
