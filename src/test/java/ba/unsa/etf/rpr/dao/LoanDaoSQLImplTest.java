package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.Loan;
import ba.unsa.etf.rpr.exceptions.DBException;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LoanDaoSQLImplTest {
    @Test
    void DoesSQLWork3() throws DBException {
        try {
            LoanDaoSQLImpl testClass = new LoanDaoSQLImpl();
            List<Loan> list = testClass.getAll();
            assertFalse(0 == list.size());
        }catch (Exception e){
            throw new DBException(e);
        }

    }
}