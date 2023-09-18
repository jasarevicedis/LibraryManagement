package ba.unsa.etf.rpr.business;

import ba.unsa.etf.rpr.dao.DaoFactory;
import ba.unsa.etf.rpr.domain.Book;
import ba.unsa.etf.rpr.domain.Loan;
import ba.unsa.etf.rpr.exceptions.DBException;

import java.util.Date;
import java.util.List;

/**
 * manager class for loan class/table
 */
public class LoanManager {
    /**

     * @param member_id
     * @param book_id

     * @return new created loan
     * @throws DBException
     */
    public Loan createLoan(int member_id, int book_id) throws DBException {
        if (member_id == 0|| book_id ==0 ) {
            return null;
        }


        Loan loan = new Loan();



        return DaoFactory.loanDao().add(loan);
    }

    /**
     * @return all data from loan table
     * @throws DBException
     */
    public List<Loan> getAll() throws DBException {
        return DaoFactory.loanDao().getAll();
    }
    public void delete(Loan loan) throws DBException {
        DaoFactory.loanDao().delete(loan.getId());
    }
    public Loan add(Loan loan) throws  DBException{
        return DaoFactory.loanDao().add(loan);
    }
}
