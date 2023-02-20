package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.Book;
import ba.unsa.etf.rpr.exceptions.DBException;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

public class BookDaoSQLImpl extends AbstractDao<Book> implements BookDao {
    public BookDaoSQLImpl() throws DBException {
        super("book");
    }

    @Override
    public Book row2object(ResultSet rs) throws DBException {
        try {
            return new Book(
                    rs.getInt("id"),
                    rs.getString("title"),
                    rs.getInt("PublishYear"),
                    rs.getString("author")
            );
        }catch(SQLException e){
            throw new DBException(e);
        }
    }

    @Override
    public Map<String, Object> object2row(Book object) {
        return null;
    }
}
