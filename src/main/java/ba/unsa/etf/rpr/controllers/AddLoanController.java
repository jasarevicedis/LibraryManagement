package ba.unsa.etf.rpr.controllers;

import ba.unsa.etf.rpr.business.LoanManager;
import ba.unsa.etf.rpr.domain.Book;
import ba.unsa.etf.rpr.domain.Loan;
import ba.unsa.etf.rpr.exceptions.DBException;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.apache.velocity.tools.ConversionUtils.toDate;

public class AddLoanController {
    public TextField memberIdField;
    public TextField bookIdField;
    private final LoanManager manager = new LoanManager();

    /**
     * @param actionEvent pressing add button will add loan to the table view
     */
    public void addLoan(javafx.event.ActionEvent actionEvent) throws IOException {
        System.out.println("adadadadada");

        Loan loan = new Loan();

        loan.setMember_id(Integer.parseInt(memberIdField.getText()));
        //System.out.println("1");
        loan.setBook_id(Integer.parseInt(bookIdField.getText()));


        System.out.println("1");

        loan.setLoan_date(toDate(LocalDate.now()));
        System.out.println("1");


        //return DaoFactory.bookDao().add(book);
        //Book book = manager.createBook(titleField.getText(), authorField.getText(), Integer.parseInt(publishField.getText()));
        try {
            manager.add(loan);
        }catch (Exception e){
            e.printStackTrace();
        }

        System.out.println("1");

        //System.out.println( book.getTitle());



/*
            ObservableList<Book> books = bookTable.getItems();
            books.add(book);
            bookTable.setItems(books);
*/
        System.out.println("dodanoooo");


        Stage stage = (Stage) memberIdField.getScene().getWindow();
        stage.close();
    }
}
