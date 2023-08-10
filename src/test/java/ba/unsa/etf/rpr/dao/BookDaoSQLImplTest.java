package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.Book;
import ba.unsa.etf.rpr.exceptions.DBException;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;

class BookDaoSQLImplTest {
    @Test
    void DoesSQLWork() throws DBException {
        try {
            BookDaoSQLImpl testClass = new BookDaoSQLImpl();
            List<Book> list = testClass.getAll();
            assertFalse(0 == list.size());
        }catch (Exception e){
            throw new DBException(e);
        }

    }




}