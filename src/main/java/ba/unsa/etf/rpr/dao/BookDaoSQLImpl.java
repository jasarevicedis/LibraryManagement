package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.Book;
import ba.unsa.etf.rpr.exceptions.DBException;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class BookDaoSQLImpl extends AbstractDao<Book> implements BookDao {
    public BookDaoSQLImpl() throws DBException {
        super("Book");
    }

    @Override
    public Book row2object(ResultSet rs) throws DBException {
        try {
            return new Book(
                    rs.getInt("book_id"),
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
        row.put("book_id", object.getId());
        row.put("title", object.getTitle());
        row.put("PublishYear", object.getPublishYear());
        row.put("author", object.getAuthor());

        return row;
    }

    @Override
    public List<Book> getByTitle(String word) throws DBException {
        List<Book> bookList = new ArrayList<>();
        String query = "SELECT * FROM book WHERE id = ?";

        try {
            PreparedStatement preparedStatement = getConnection().prepareStatement(query);

            preparedStatement.setString(1, word);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                bookList.add(row2object(resultSet));
            }

            resultSet.close();

        } catch (SQLException e) {
            throw new DBException(e);
        }

        return bookList;
    }

    @Override
    public List<Book> getByAuthor(String name) throws DBException {
        List<Book> bookList = new ArrayList<>();

        String query = "SELECT * FROM book WHERE author = ?";

        try {
            PreparedStatement preparedStatement = getConnection().prepareStatement(query);

            preparedStatement.setString(1, name);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                bookList.add(row2object(resultSet));
            }

            resultSet.close();

        } catch (SQLException e) {
            throw new DBException(e);
        }

        return bookList;
    }
}
