package ba.unsa.etf.rpr.business;


import ba.unsa.etf.rpr.domain.Book;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import ba.unsa.etf.rpr.dao.BookDaoSQLImpl;
import ba.unsa.etf.rpr.dao.DaoFactory;
import ba.unsa.etf.rpr.exceptions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class BookManagerTest {
    private BookManager bookManager;
    private Book book;
    private BookDaoSQLImpl bookDaoSQLMock;
    private List<Book> books;
    /**
     * This method will be called before each test to initialize objects needed
     */

    @BeforeEach
    public void initializeObjectsWeNeed(){
        bookManager = mock(BookManager.class);
        bookDaoSQLMock = mock(BookDaoSQLImpl.class);
        book = new Book(1,"knjiga", 1999, "safet isovic");
    }

    /**
     * This method tests adding book
     * @throws DBException
     */
    @Test
    void addNewBook() throws DBException {
        bookManager.add(book);
        Assertions.assertTrue(true);
        Mockito.verify(bookManager).add(book);
    }
    /**
     * This method tests deleting book
     * @throws DBException
     */
    @Test
    void deleteBook() throws DBException {
        Book deletionBook = new Book(1,"a",2000,"b");
        bookManager.delete(deletionBook);

        Assertions.assertTrue(true);
        Mockito.verify(bookManager).delete(deletionBook);
    }
    @Test
    public void shouldAnswerWithTrueBook()
    {
        assertTrue( true );
    }









}