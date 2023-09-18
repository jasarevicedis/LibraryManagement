package ba.unsa.etf.rpr.business;

import ba.unsa.etf.rpr.dao.DaoFactory;
import ba.unsa.etf.rpr.domain.Book;
import ba.unsa.etf.rpr.exceptions.DBException;

import java.util.List;

/**
 * @author Edis jasarevic
 * Manager layer class for books
 */
public class BookManager {

    /**
     * @param title book title
     * @param author book author
     * @param publish_year book publish year
     * @return new created Book
     * @throws DBException
     */
    public Book createBook(String title, String author, int publish_year) throws DBException {
        if (title.isEmpty() || author.isEmpty() || publish_year == 0) {
            return null;
        }

        if (DaoFactory.bookDao().searchByTitle(title) !=null) {
            throw new DBException("Book title is already added");
        }

        Book book = new Book();

        book.setTitle(title);
        book.setAuthor(author);
        book.setPublishYear(publish_year);

        return DaoFactory.bookDao().add(book);
    }

    /**
     * @return all data from book table
     * @throws DBException
     */
    public List<Book> getAll() throws DBException {
        return DaoFactory.bookDao().getAll();
    }
    public void delete(Book book) throws DBException {
        DaoFactory.bookDao().delete(book.getId());
    }
    public Book add(Book book) throws  DBException{
        return DaoFactory.bookDao().add(book);
    }
}
