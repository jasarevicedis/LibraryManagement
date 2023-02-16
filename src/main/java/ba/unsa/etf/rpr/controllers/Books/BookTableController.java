package ba.unsa.etf.rpr.controllers.Books;

import ba.unsa.etf.rpr.domain.Book;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.awt.event.MouseEvent;
import java.net.URL;
import java.util.ResourceBundle;

public class BookTableController implements Initializable {
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

    @Override
    public void initialize(URL url, ResourceBundle rb){
        loadDate();
    }


    @FXML
    private void getAddView(MouseEvent event){}
    @FXML
    private void refreshTable(MouseEvent event){}
    private void loadDate(){
        idCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        titleCol.setCellValueFactory(new PropertyValueFactory<>("title"));
        publishCol.setCellValueFactory(new PropertyValueFactory<>("PublishYear"));
        authorCol.setCellValueFactory(new PropertyValueFactory<>("author"));

    }
}
