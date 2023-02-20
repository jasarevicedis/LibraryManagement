package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.Book;
import ba.unsa.etf.rpr.exceptions.DBException;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

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
        Map<String, Object> row = new TreeMap<>();
        row.put("id", object.getId());
        row.put("title", object.getTitle());
        row.put("PublishYear", object.getPublishYear());
        row.put("author", object.getAuthor());

        return row;
    }

    @Override
    public List<Book> getByTitle(String word) throws DBException {

    }

    @Override
    public List<Book> getByAuthor(String name) throws DBException {
        return null;
    }
}
