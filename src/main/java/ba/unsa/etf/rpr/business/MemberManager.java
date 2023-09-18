package ba.unsa.etf.rpr.business;

import ba.unsa.etf.rpr.dao.DaoFactory;
import ba.unsa.etf.rpr.domain.Book;
import ba.unsa.etf.rpr.domain.Member;
import ba.unsa.etf.rpr.domain.Member;
import ba.unsa.etf.rpr.exceptions.DBException;

import java.util.Date;
import java.util.List;

/**
 * manager class for members
 */
public class MemberManager {
    /**
     * @param first_name info of member
     * @param last_name info of member

     * @return newly created member
     * @throws DBException
     */
    public Member createMember(String first_name, String last_name) throws DBException {
        if (first_name.isEmpty() || last_name.isEmpty() ) {
            return null;
        }



        Member member = new Member();

        member.setFirst_name(first_name);
        member.setLast_name(last_name);

        return DaoFactory.memberDao().add(member);
    }

    /**
     * @return all data from member table
     * @throws DBException
     */
    public List<Member> getAll() throws DBException {
        return DaoFactory.memberDao().getAll();
    }
    public void delete(Member member) throws DBException {
        DaoFactory.memberDao().delete(member.getId());
    }
    public Member add(Member member) throws  DBException{
        return DaoFactory.memberDao().add(member);
    }
}
