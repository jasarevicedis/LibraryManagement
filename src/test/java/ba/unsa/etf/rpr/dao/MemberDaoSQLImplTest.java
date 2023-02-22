package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.Member;
import ba.unsa.etf.rpr.exceptions.DBException;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MemberDaoSQLImplTest {
    @Test
    void DoesSQLWork2() throws DBException {
        try {
            MemberDaoSQLImpl testClass = new MemberDaoSQLImpl();
            List<Member> list = testClass.getAll();
            assertFalse(0 == list.size());
        }catch (Exception e){
            throw new DBException(e);
        }

    }
}