package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.Book;
import ba.unsa.etf.rpr.exceptions.DBException;

import java.sql.ResultSet;
import java.util.Map;

public class BookDaoSQLImpl extends AbstractDao<Book> implements BookDao {
    public BookDaoSQLImpl() throws DBException {
        super("book");
    }

    @Override
    public Book row2object(ResultSet rs) throws DBException {
        return null;
    }

    @Override
    public Map<String, Object> object2row(Book object) {
        return null;
    }
}
