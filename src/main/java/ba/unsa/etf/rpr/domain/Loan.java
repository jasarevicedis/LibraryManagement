package ba.unsa.etf.rpr.domain;

import java.util.Date;

public class Loan {
    private int id;
    private Date loan_date;
    private int  member_id;
    private int book_id;

    public int getId(){return id;}
    public Date getLoan_date(){
        return loan_date;
    }
    public int getMember_id(){
        return member_id;
    }
    public int getBook_id(){
        return book_id;
    }
}
