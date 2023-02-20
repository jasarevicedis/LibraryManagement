package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.Member;
import ba.unsa.etf.rpr.exceptions.DBException;

import java.sql.ResultSet;
import java.util.Map;

public class MemberDaoSQLImpl extends AbstractDao<Member> implements MemberDao {

    public MemberDaoSQLImpl() {
        super("member");
    }

    @Override
    public Member row2object(ResultSet rs) throws DBException {
        return null;
    }

    @Override
    public Map<String, Object> object2row(Member object) {
        return null;
    }
}
