package ba.unsa.etf.rpr.controllers;


import ba.unsa.etf.rpr.business.BookManager;
import ba.unsa.etf.rpr.business.LoanManager;
import ba.unsa.etf.rpr.business.MemberManager;
import ba.unsa.etf.rpr.domain.Book;
import ba.unsa.etf.rpr.domain.Loan;
import ba.unsa.etf.rpr.domain.Member;
import ba.unsa.etf.rpr.exceptions.DBException;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
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
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;


public class DashboardController  {

    @FXML
    public TextField titleField;
    @FXML
    public TextField authorField;
    @FXML
    public TextField publishField;
    @FXML
    private StackPane dashboardStack;
    @FXML
    public TableView<Book> bookTable;
    @FXML
    public TableColumn<Book, Integer> bookIdCol;
    @FXML
    public TableColumn<Book, String> bookTitleCol;
    @FXML
    public TableColumn<Book, Integer> bookPublishCol;
    @FXML
    public TableColumn<Book, String> bookAuthorCol;

    @FXML
    public TableView<Loan> loanTable;
    @FXML
    public TableColumn<Loan, Integer> loanIdCol;
    @FXML
    public TableColumn<Loan, String> loanMemberCol;
    @FXML
    public TableColumn<Loan, String> loanBookCol;
    @FXML
    public TableColumn<Loan, Date> loanDateCol;

    @FXML
    public TableView<Member> memberTable;
    @FXML
    public TableColumn<Member, Integer> memberIdCol;
    @FXML
    public TableColumn<Member, String> memberFirstNameCol;
    @FXML
    public TableColumn<Member, String> memberLastNameCol;
    @FXML
    public TableColumn<Member, Date> memberJoinDateCol;




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


    private final BookManager bookManager = new BookManager();
    private final LoanManager loanManager = new LoanManager();
    private final MemberManager memberManager;String query = null;
    Connection connection = null ;
    PreparedStatement preparedStatement = null ;
    ResultSet resultSet = null ;


    {
        memberManager = new MemberManager();
    }

    public DashboardController() {
    }

    @FXML
    public void initialize(){

        bookIdCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        bookTitleCol.setCellValueFactory(new PropertyValueFactory<>("title"));
        bookPublishCol.setCellValueFactory(new PropertyValueFactory<>("PublishYear"));
        bookAuthorCol.setCellValueFactory(new PropertyValueFactory<>("Author"));


        memberIdCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        memberFirstNameCol.setCellValueFactory(new PropertyValueFactory<>("first_name"));
        memberLastNameCol.setCellValueFactory(new PropertyValueFactory<>("last_name"));
        memberJoinDateCol.setCellValueFactory(new PropertyValueFactory<>("join_date"));

        loanIdCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        loanMemberCol.setCellValueFactory(new PropertyValueFactory<>("member_id"));
        loanBookCol.setCellValueFactory(new PropertyValueFactory<>("Book_id"));
        loanDateCol.setCellValueFactory(new PropertyValueFactory<>("loan_date"));

        updateBookTable();
        updateLoanTable();
        updateMemberTable();
    }

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
        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.setScene(scene);
        primaryStage.show();
    }




    @FXML
    private void close(MouseEvent event){
        Stage stage =(Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close();
    }
    @FXML
    private void getAddBookView(ActionEvent event) throws DBException {
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
    private void deleteBook(ActionEvent actionEvent) throws DBException {
        Book book = bookTable.getSelectionModel().getSelectedItem();
        bookManager.delete(book);
        updateBookTable();
        
    }

    @FXML
    private void deleteMember() throws DBException {
        Member member = memberTable.getSelectionModel().getSelectedItem();
        memberManager.delete(member);
        updateMemberTable();
    }
    @FXML
    private void deleteLoan() throws DBException {
        Loan loan = loanTable.getSelectionModel().getSelectedItem();
        loanManager.delete(loan);
        updateLoanTable();
    }
    @FXML
    private void getAddMemberView(ActionEvent event) throws DBException {
        try {
            Parent parent = FXMLLoader.load(getClass().getResource("/fxml/addMember.fxml"));
            Scene scene = new Scene(parent);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.initStyle(StageStyle.UTILITY);
            stage.show();
        }catch(Exception e){

        }
    }
    @FXML
    private void getAddLoanView(ActionEvent event) throws DBException {
        try {
            Parent parent = FXMLLoader.load(getClass().getResource("/fxml/addLoan.fxml"));
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
    private void refreshTable() {
        /*
        try {

            StudentList.clear();

            query = "SELECT * FROM `student`";
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                StudentList.add(new  Student(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getDate("birth"),
                        resultSet.getString("adress"),
                        resultSet.getString("email")));
                studentsTable.setItems(StudentList);

            }


        } catch (SQLException ex) {
            Logger.getLogger(TableViewController.class.getName()).log(Level.SEVERE, null, ex);
        }
*/


    }

    @FXML
    private void refreshBookTable(ActionEvent event){

        bookIdCol.setCellValueFactory(new PropertyValueFactory<>("Id"));
        bookTitleCol.setCellValueFactory(new PropertyValueFactory<>("Title"));
        //publishCol.setCellValueFactory(new PropertyValueFactory<>("PublishYear"));
        bookAuthorCol.setCellValueFactory(new PropertyValueFactory<>("Author"));

    }
    public void updateBookTable() {
        try {
            bookTable.setItems(FXCollections.observableList(bookManager.getAll()));
        }catch (DBException e){};
        bookTable.refresh();
    }
    public void updateLoanTable() {
        try {
            loanTable.setItems(FXCollections.observableList(loanManager.getAll()));
        }catch (DBException e){};
        loanTable.refresh();
    }
    public void updateMemberTable() {
        try {
            memberTable.setItems(FXCollections.observableList(memberManager.getAll()));
        }catch (DBException e){};
        memberTable.refresh();
    }

    public void refreshMembersTable(ActionEvent actionEvent) {
    }

    public void refreshLoansTable(ActionEvent actionEvent) {
    }
}
