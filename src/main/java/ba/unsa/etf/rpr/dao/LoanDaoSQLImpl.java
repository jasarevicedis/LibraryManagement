package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.Book;
import ba.unsa.etf.rpr.domain.Loan;
import ba.unsa.etf.rpr.exceptions.DBException;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;
import java.util.TreeMap;

public class LoanDaoSQLImpl extends AbstractDao<Loan> implements LoanDao{
    public LoanDaoSQLImpl() throws DBException {
        super("Loan");
    }

    @Override
    public Loan row2object(ResultSet rs) throws DBException {
        try {
            return new Loan(
                    rs.getInt("loan_id"),
                    rs.getDate("loan_date"),
                    rs.getInt("Book_id"),
                    rs.getInt("member_id")
            );
        }catch(SQLException e){
            throw new DBException(e);
        }
    }

    @Override
    public Map<String, Object> object2row(Loan object) {
        Map<String, Object> row = new TreeMap<>();
        row.put("loan_id", object.getId());
        row.put("loan_date", object.getLoan_date());
        row.put("Book_id", object.getBook_id());
        row.put("member_id", object.getMember_id());

        return row;
    }
}
