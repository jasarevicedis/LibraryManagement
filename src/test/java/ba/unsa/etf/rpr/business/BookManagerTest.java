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
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

class BookManagerTest {
    private BookManager bookManager;
    private Book book;
    private BookDaoSQLImpl bookDaoSQLMock;
    private List<Book> books;
    MockedStatic<DaoFactory> daoFactoryMockedStatic;

    @BeforeEach
    void setUp() throws DBException {
        bookManager = Mockito.mock(BookManager.class);

        book = new Book(1,"Random knjiga 1",11, "random author 1");

        bookDaoSQLMock = Mockito.mock(BookDaoSQLImpl.class);

        books = new ArrayList<>();

        books.addAll(Arrays.asList(
                new Book(1, "Random knjiga 1", 11,"random author 1"),
                new Book(2, "Random knjiga 2",1934, "random author 2"),
                new Book(3, "Random knjiga 3",1657, "random author 3")
        ));

        daoFactoryMockedStatic = Mockito.mockStatic(DaoFactory.class);

        daoFactoryMockedStatic.when(DaoFactory::bookDao).thenReturn(bookDaoSQLMock);

        when(bookDaoSQLMock.getAll()).thenReturn(books);

        when(bookDaoSQLMock.searchByTitle(anyString())).thenAnswer(invocationOnMock -> {
            String name = invocationOnMock.getArgument(0);

            return books.stream().filter(cat -> Objects.equals(cat.getTitle(), name)).findAny().orElse(null);
        });

        when(bookDaoSQLMock.add(any())).thenAnswer(invocationOnMock ->  {
            Book book = invocationOnMock.getArgument(0);

            books.add(book);

            return book;
        });
    }

    @Test
    void createBook() throws DBException {
        bookManager.createBook( "Orlovi rano lete", "Branko Copic",1970);

        assertEquals(4, books.size());
        Mockito.verify(bookManager).createBook("Zbirka iz matematike", "neko tamo", 2003);
    }

    @Test
    void createExistingBook() throws DBException {
        assertThrows(DBException.class, () -> {
            bookManager.createBook(book.getTitle(), book.getAuthor(), book.getPublishYear());
        });

        daoFactoryMockedStatic.verify(DaoFactory::bookDao);
        Mockito.verify(bookManager).createBook(book.getTitle(), book.getAuthor(), book.getPublishYear());

        daoFactoryMockedStatic.close();
    }

    @AfterEach
    void closeStaticMock() {
        daoFactoryMockedStatic.close();
    }
}