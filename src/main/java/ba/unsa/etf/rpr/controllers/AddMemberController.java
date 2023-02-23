package ba.unsa.etf.rpr.controllers;

import ba.unsa.etf.rpr.business.MemberManager;
import ba.unsa.etf.rpr.domain.Member;
import ba.unsa.etf.rpr.exceptions.DBException;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AddMemberController {
    public TextField memberFirstNameField;
    public TextField memberLastNameField;
    private final MemberManager manager = new MemberManager();

    /**
     * @param actionEvent pressing add button will add member to the table view
     */
    public void add(javafx.event.ActionEvent actionEvent) {
        try {
            Member member = manager.createMember(memberFirstNameField.getText(), memberLastNameField.getText());

            if (member == null) {
                return;
            }

            Stage stage = (Stage) memberFirstNameField.getScene().getWindow();


        } catch (DBException e) {

        }
    }
}
