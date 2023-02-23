package ba.unsa.etf.rpr.controllers;

import ba.unsa.etf.rpr.business.BookManager;
import ba.unsa.etf.rpr.domain.Book;
import ba.unsa.etf.rpr.exceptions.DBException;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.awt.event.ActionEvent;

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
    public void add(javafx.event.ActionEvent actionEvent) {
        try {
            Book book = manager.createBook(titleField.getText(), authorField.getText(), Integer.parseInt(publishField.getText()));

            if (book == null) {
                return;
            }

            Stage stage = (Stage) titleField.getScene().getWindow();


        } catch (DBException e) {

        }
    }



}
