package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.Book;
import ba.unsa.etf.rpr.domain.Member;
import ba.unsa.etf.rpr.exceptions.DBException;

import java.sql.ResultSet;
import java.util.List;
import java.util.Map;

public class MemberDaoSQLImpl extends AbstractDao<Member> implements MemberDao {

    public MemberDaoSQLImpl() {
        super("member");
    }

    @Override
    public Member row2object(ResultSet rs) throws DBException {
        try {
            return new Member(
                    resultSet.getInt("id"),
                    resultSet.getString("username"),
                    resultSet.getString("password"),
                    resultSet.getString("first_name"),
                    resultSet.getString("last_name")
            );

        } catch (SQLException e) {
            throw new DBHandleException(e);
        }
    }

    @Override
    public Map<String, Object> object2row(Member object) {
        return null;
    }


}
