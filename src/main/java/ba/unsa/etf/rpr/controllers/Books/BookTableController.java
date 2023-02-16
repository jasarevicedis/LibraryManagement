package ba.unsa.etf.rpr.controllers.Books;

import ba.unsa.etf.rpr.domain.Book;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

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
    private TableColumn<Book, String> authorCol;

    @Override
    public void initialize(URL url, ResourceBundle rb){}

}
