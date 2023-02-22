package ba.unsa.etf.rpr.domain;

import java.util.Date;

public class Loan implements Idable {
    private int loan_id;
    private Date loan_date;
    private int  Member_member_id;
    private int Book_book_id;

    public Loan(){};
    public Loan(int id, Date loan_date, int Book_book_id,int Member_member_id){
        this.loan_id=id;
        this.loan_date=loan_date;
        this.Member_member_id=Member_member_id;
        this.Book_book_id = Book_book_id;
    };

    public int getId(){return loan_id;}
    public Date getLoan_date(){
        return loan_date;
    }
    public int getMember_id(){
        return Member_member_id;
    }
    public int getBook_id(){
        return Book_book_id;
    }

    public void setId(int id){
        this.loan_id = id;
    }
    public void setLoan_date(Date loan_date){
        this.loan_date = loan_date;
    }
    public void setMember_id(int member_id){
        this.Member_member_id = member_id;
    }
    public void setBook_id(int book_id){
        this.Book_book_id = book_id;
    }
}
