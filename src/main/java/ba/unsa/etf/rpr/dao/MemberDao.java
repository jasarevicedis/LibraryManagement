package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.Member;
import ba.unsa.etf.rpr.exceptions.DBException;

import java.util.List;

public interface MemberDao extends Dao<Member>{

    public List<Member> searchByFirstName(String first_name) throws DBException;
    public List<Member> searchByLastName(String last_name) throws DBException;
}
