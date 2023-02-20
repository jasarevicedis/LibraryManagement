package ba.unsa.etf.rpr.business;

import ba.unsa.etf.rpr.dao.DaoFactory;
import ba.unsa.etf.rpr.domain.Book;
import ba.unsa.etf.rpr.exceptions.DBException;

public class BookManager {
    public Book createBook(String title, String author, int publish_year) throws DBException {
        if (title.isEmpty() || author.isEmpty() || publish_year == 0) {
            return null;
        }

        if (DaoFactory.bookDao().getByTitle(title) !=null) {
            throw new DBException("Book title is already added");
        }

        Book book = new Book();

        book.setTitle(title);
        book.setAuthor(author);
        book.setPublishYear(publish_year);

        return DaoFactory.bookDao().add(book);
    }
}
