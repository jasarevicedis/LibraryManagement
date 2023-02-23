package ba.unsa.etf.rpr.controllers;

import ba.unsa.etf.rpr.business.LoanManager;
import ba.unsa.etf.rpr.domain.Loan;
import ba.unsa.etf.rpr.exceptions.DBException;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AddLoanController {
    public TextField memberIdField;
    public TextField bookIdField;
    private final LoanManager manager = new LoanManager();

    /**
     * @param actionEvent pressing add button will add loan to the table view
     */
    public void add(javafx.event.ActionEvent actionEvent) {
        try {
            Loan loan = manager.createLoan(Integer.parseInt(memberIdField.getText()), Integer.parseInt(bookIdField.getText()));

            if (loan == null) {
                return;
            }

            Stage stage = (Stage) memberIdField.getScene().getWindow();


        } catch (DBException e) {

        }
    }
}
