package ba.unsa.etf.rpr.controllers;

import ba.unsa.etf.rpr.business.BookManager;
import ba.unsa.etf.rpr.dao.DaoFactory;
import ba.unsa.etf.rpr.domain.Book;
import ba.unsa.etf.rpr.exceptions.DBException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.TableView;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.scene.Node;
import ba.unsa.etf.rpr.controllers.DashboardController;
import javafx.event.ActionEvent;

import java.io.IOException;
import java.util.List;

/**
 * controller for add book dialog
 */
public class AddBookController {
    @FXML
    public TextField titleField;
    @FXML
    public TextField authorField;
    @FXML
    public TextField publishField;

    private final BookManager manager = new BookManager();

    /**
     * @param actionEvent pressing add button will add book to the table view
     */
    public void addBook(javafx.event.ActionEvent actionEvent) throws IOException {
        System.out.println("adadadadada");

        Book book = new Book();

        book.setTitle(titleField.getText());
        System.out.println("1");

        book.setAuthor(authorField.getText());
        System.out.println("1");

        book.setPublishYear(Integer.parseInt(publishField.getText()));
        System.out.println("1");


        //return DaoFactory.bookDao().add(book);
        //Book book = manager.createBook(titleField.getText(), authorField.getText(), Integer.parseInt(publishField.getText()));
        try {
            manager.add(book);
        }catch (Exception e){
            e.printStackTrace();
        }

        System.out.println("1");

        System.out.println( book.getTitle());

/*
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("fxml/dashboard.fxml"));
        Parent root = fxmlLoader.load();
        DashboardController controller = fxmlLoader.getController();
        controller.updateBookTable();*/
/*
            ObservableList<Book> books = bookTable.getItems();
            books.add(book);
            bookTable.setItems(books);
*/
        System.out.println("dodanoooo");


        Stage stage = (Stage) authorField.getScene().getWindow();
        stage.close();
    }



}
