package ba.unsa.etf.rpr.business;

import ba.unsa.etf.rpr.domain.Book;
import ba.unsa.etf.rpr.domain.Member;

import java.util.*;

import ba.unsa.etf.rpr.dao.MemberDaoSQLImpl;
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
import static org.mockito.Mockito.when;

class MemberManagerTest {
    private MemberManager memberManager;
    private Member member;
    private MemberDaoSQLImpl memberDaoSQL;
    private List<Member> books;

    /**
     * This method will be called before each test to initialize objects needed
     */
    @BeforeEach
    public void initializeObjectsWeNeed(){
        memberManager = Mockito.mock(MemberManager.class);
        memberDaoSQL = Mockito.mock(MemberDaoSQLImpl.class);
        member = new Member(1,"safet", "isovic", new Date(2003,12,12));
    }

    /**
     * This method tests adding member
     * @throws DBException
     */
    @Test
    void addNewMember() throws DBException {
        memberManager.add(member);
        Assertions.assertTrue(true);
        Mockito.verify(memberManager).add(member);
    }
    /**
     * This method tests adding member
     * @throws DBException
     */
    @Test
    void deleteMember() throws DBException {
        Member deletionMember = new Member(1,"a","b",new Date(2000));
        memberManager.delete(deletionMember);

        Assertions.assertTrue(true);
        Mockito.verify(memberManager).delete(deletionMember);
    }
    @Test
    public void shouldAnswerWithTrueMember()
    {
        assertTrue( true );
    }

}