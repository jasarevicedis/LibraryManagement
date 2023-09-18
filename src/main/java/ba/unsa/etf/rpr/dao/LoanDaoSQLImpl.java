package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.Book;
import ba.unsa.etf.rpr.domain.Loan;
import ba.unsa.etf.rpr.exceptions.DBException;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;
import java.util.TreeMap;

public class LoanDaoSQLImpl extends AbstractDao<Loan> implements LoanDao{
    private static LoanDaoSQLImpl instance = null;

    LoanDaoSQLImpl() throws  DBException{
        super("Loan");
    }
    public static LoanDaoSQLImpl getInstance() throws DBException {
        if(instance == null)
            instance = new LoanDaoSQLImpl();
        return instance;
    }

    @Override
    public Loan rowToObject(ResultSet rs) throws DBException {
        try {
            return new Loan(
                    rs.getInt("id"),
                    rs.getDate("loan_date"),
                    rs.getInt("Book_id"),
                    rs.getInt("member_id")
            );
        }catch(SQLException e){
            throw new DBException(e);
        }
    }

    @Override
    public Map<String, Object> objectToRow(Loan object) {
        Map<String, Object> row = new TreeMap<>();
        row.put("id", object.getId());
        row.put("loan_date", object.getLoan_date());
        row.put("Book_id", object.getBook_id());
        row.put("member_id", object.getMember_id());

        return row;
    }
}
