package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.Book;
import ba.unsa.etf.rpr.exceptions.DBException;
import javafx.collections.ObservableList;

import java.util.List;

public interface BookDao extends Dao<Book>{
    Book searchByTitle(String name) throws DBException;
    List<Book> getByTitle(String word) throws DBException;
    List<Book> getByAuthor(String name) throws DBException;




}
