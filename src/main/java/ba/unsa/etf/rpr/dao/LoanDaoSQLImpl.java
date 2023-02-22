package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.Loan;
import ba.unsa.etf.rpr.exceptions.DBException;

import java.sql.ResultSet;
import java.util.Map;

public class LoanDaoSQLImpl extends AbstractDao<Loan> implements LoanDao{
    public LoanDaoSQLImpl() throws DBException {
        super("Loan");
    }

    @Override
    public Loan row2object(ResultSet rs) throws DBException {
        return null;
    }

    @Override
    public Map<String, Object> object2row(Loan object) {
        return null;
    }
}
