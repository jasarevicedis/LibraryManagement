package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.Member;
import ba.unsa.etf.rpr.exceptions.DBException;

public interface MemberDao extends Dao<Member>{

    public void searchByFirstName(String first_name) throws DBException;
    public void searchByListName(String last_name) throws DBException;
}
