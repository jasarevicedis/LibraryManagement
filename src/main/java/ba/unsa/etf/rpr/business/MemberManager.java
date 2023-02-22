package ba.unsa.etf.rpr.business;

import ba.unsa.etf.rpr.dao.DaoFactory;
import ba.unsa.etf.rpr.domain.Member;
import ba.unsa.etf.rpr.domain.Member;
import ba.unsa.etf.rpr.exceptions.DBException;

import java.util.Date;
import java.util.List;

public class MemberManager {
    public Member createMember(String first_name, String last_name, Date joinDate) throws DBException {
        if (first_name.isEmpty() || last_name.isEmpty() || joinDate == null) {
            return null;
        }



        Member member = new Member();

        member.setFirst_name(first_name);
        member.setLast_name(last_name);
        member.setJoin_date(joinDate);

        return DaoFactory.memberDao().add(member);
    }
    public List<Member> getAll() throws DBException {
        return DaoFactory.memberDao().getAll();
    }
}
