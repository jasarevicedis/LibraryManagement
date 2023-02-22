package ba.unsa.etf.rpr.business;

import ba.unsa.etf.rpr.dao.DaoFactory;
import ba.unsa.etf.rpr.domain.Loan;
import ba.unsa.etf.rpr.exceptions.DBException;

import java.util.Date;
import java.util.List;

public class LoanManager {
    public Loan createLoan(int id, int member_id, int book_id, Date loanDate) throws DBException {
        if (member_id == 0|| book_id ==0 || loanDate == null) {
            return null;
        }


        Loan loan = new Loan();



        return DaoFactory.loanDao().add(loan);
    }
    public List<Loan> getAll() throws DBException {
        return DaoFactory.loanDao().getAll();
    }
}
