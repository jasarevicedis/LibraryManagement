package ba.unsa.etf.rpr.business;
import ba.unsa.etf.rpr.domain.Book;
import ba.unsa.etf.rpr.domain.Loan;

import java.util.*;

import ba.unsa.etf.rpr.dao.LoanDaoSQLImpl;
import ba.unsa.etf.rpr.dao.DaoFactory;
import ba.unsa.etf.rpr.exceptions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

class LoanManagerTest {
    private LoanManager loanManager;
    private Loan loan;
    private LoanDaoSQLImpl loanDaoSQL;
    private List<Loan> loans;

    /**
     * This method will be called before each test to initialize objects needed
     */
    @BeforeEach
    public void initializeObjectsWeNeed(){
        loanManager = Mockito.mock(LoanManager.class);
        loanDaoSQL = Mockito.mock(LoanDaoSQLImpl.class);
        loan = new Loan(1,new Date(2003), 1, 1);
    }

    /**
     * This method tests adding loan
     * @throws DBException
     */
    @Test
    void addNewLoan() throws DBException {
        loanManager.add(loan);
        Assertions.assertTrue(true);
        Mockito.verify(loanManager).add(loan);
    }
    /**
     * This method tests deleting loan
     * @throws DBException
     */
    @Test
    void deleteLoan() throws DBException {
        Loan deletionLoan = new Loan(1,new Date(2003),2000,3);
        loanManager.delete(deletionLoan);

        Assertions.assertTrue(true);
        Mockito.verify(loanManager).delete(deletionLoan);
    }
    @Test
    public void shouldAnswerWithTrueLoan()
    {
        assertTrue( true );
    }
}
