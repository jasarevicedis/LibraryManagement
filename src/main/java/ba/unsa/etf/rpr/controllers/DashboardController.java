package ba.unsa.etf.rpr.controllers;


import ba.unsa.etf.rpr.domain.Book;
import ba.unsa.etf.rpr.exceptions.DBException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;

import static javafx.scene.control.PopupControl.USE_COMPUTED_SIZE;
import static jdk.internal.org.jline.utils.Curses.toInteger;

public class DashboardController implements Initializable {

    @FXML
    private TextField titleField;
    @FXML
    private TextField authorField;
    @FXML
    private TextField publishField;
    @FXML
    private StackPane dashboardStack;
    @FXML
    private TableView<Book> booksTable;
    @FXML
    private TableColumn<Book, String> idCol;
    @FXML
    private TableColumn<Book, String> titleCol;
    @FXML
    private TableColumn<Book, Integer> publishCol;
    @FXML
    private TableColumn<Book, String> authorCol;
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
            dashboardStack.toFront();
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

    public void logoutButtonOnAction(ActionEvent e) throws IOException {
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/login.fxml"));
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    String query= null;
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
    Book book = null;
    ObservableList<Book> bookList = FXCollections.observableArrayList();

    @FXML
    private void close(MouseEvent event){
        Stage stage =(Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close();
    }
    @FXML
    private void getAddBookView(MouseEvent event) throws DBException {
        try {
            Parent parent = FXMLLoader.load(getClass().getResource("/fxml/addBook.fxml"));
            Scene scene = new Scene(parent);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.initStyle(StageStyle.UTILITY);
            stage.show();
        }catch(Exception e){

        }
    }
    @FXML
    private void save(MouseEvent event){
        String title = titleField.getText();
        String author = authorField.getText();
        int publishYear;
        publishYear = Integer.parseInt( publishField.getText());
    }
    @FXML
    private void refreshBookTable(MouseEvent event){
        bookList.clear();
    }
    private void loadDateBooks(){
        idCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        titleCol.setCellValueFactory(new PropertyValueFactory<>("title"));
        publishCol.setCellValueFactory(new PropertyValueFactory<>("PublishYear"));
        authorCol.setCellValueFactory(new PropertyValueFactory<>("author"));

    }
}
