package ba.unsa.etf.rpr.controllers;

import ba.unsa.etf.rpr.business.BookManager;
import ba.unsa.etf.rpr.domain.Book;
import ba.unsa.etf.rpr.exceptions.DBException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableView;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.scene.Node;
import ba.unsa.etf.rpr.controllers.DashboardController;
import javafx.event.ActionEvent;

import java.util.List;

/**
 * controller for add book dialog
 */
public class AddBookController {

    public TextField titleField;
    public TextField authorField;
    public TextField publishField;

    private final BookManager manager = new BookManager();

    /**
     * @param actionEvent pressing add button will add book to the table view
     */
    public void addBook(javafx.event.ActionEvent actionEvent) {
        try {
            Book book = manager.createBook(titleField.getText(), authorField.getText(), Integer.parseInt(publishField.getText()));

            manager.add(book);

            Stage stage = (Stage) authorField.getScene().getWindow();
            stage.close();
/*
            ObservableList<Book> books = bookTable.getItems();
            books.add(book);
            bookTable.setItems(books);
*/
            System.out.println("dodanoooo");




        } catch (DBException e) {

        }
        Stage stage = (Stage) authorField.getScene().getWindow();
        stage.close();
    }



}
