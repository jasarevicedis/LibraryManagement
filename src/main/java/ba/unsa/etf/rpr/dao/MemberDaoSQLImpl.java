package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.Book;
import ba.unsa.etf.rpr.domain.Member;
import ba.unsa.etf.rpr.exceptions.DBException;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class MemberDaoSQLImpl extends AbstractDao<Member> implements MemberDao {

    public MemberDaoSQLImpl() {
        super("member");
    }

    @Override
    public Member row2object(ResultSet resultSet) throws DBException {
        try {
            return new Member(
                    resultSet.getInt("id"),
                    resultSet.getString("first_name"),
                    resultSet.getString("last_name"),
                    resultSet.getDate("loan_date")

            );

        } catch (SQLException e) {
            throw new DBException(e);
        }
    }

    @Override
    public Map<String, Object> object2row(Member object) {
        return null;
    }


}
