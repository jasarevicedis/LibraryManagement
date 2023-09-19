package ba.unsa.etf.rpr.controllers;

import ba.unsa.etf.rpr.business.MemberManager;
import ba.unsa.etf.rpr.domain.Book;
import ba.unsa.etf.rpr.domain.Member;
import ba.unsa.etf.rpr.exceptions.DBException;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;

import static org.apache.velocity.tools.ConversionUtils.toDate;

/**
 * controller for add member dialog
 */
public class AddMemberController {
    public TextField memberFirstNameField;
    public TextField memberLastNameField;
    private final MemberManager manager = new MemberManager();

    /**
     * @param actionEvent pressing add button will add member to the table view
     */
    public void addMember(javafx.event.ActionEvent actionEvent) throws IOException {
        System.out.println("adadadadada");

        Member member = new Member();

        member.setFirst_name(memberFirstNameField.getText());
        System.out.println("1");

        member.setLast_name(memberLastNameField.getText());
        System.out.println("1");

        member.setJoin_date(toDate(LocalDate.now()));
        System.out.println("1");


        //return DaoFactory.bookDao().add(book);
        //Book book = manager.createBook(titleField.getText(), authorField.getText(), Integer.parseInt(publishField.getText()));
        try {
            manager.add(member);
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


        Stage stage = (Stage) memberLastNameField.getScene().getWindow();
        stage.close();
    }
}
