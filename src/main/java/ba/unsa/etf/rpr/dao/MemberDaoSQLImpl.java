package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.Book;
import ba.unsa.etf.rpr.domain.Member;
import ba.unsa.etf.rpr.exceptions.DBException;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class MemberDaoSQLImpl extends AbstractDao<Member> implements MemberDao {

    public MemberDaoSQLImpl() throws  DBException {

        super("Member");
    }

    @Override
    public Member row2object(ResultSet resultSet) throws DBException {
        try {
            return new Member(
                    resultSet.getInt("id"),
                    resultSet.getString("first_name"),
                    resultSet.getString("last_name"),
                    resultSet.getDate("join_date")

            );

        } catch (SQLException e) {
            throw new DBException(e);
        }
    }

    @Override
    public Map<String, Object> object2row(Member object) {
        Map<String, Object> row = new TreeMap<>();

        row.put("id", object.getId());
        row.put("first_name", object.getFirst_name());
        row.put("last_name", object.getLast_name());
        row.put("join_date", object.getJoin_date());

        return row;
    }


    /**
     * @param first_name
     * @throws DBException
     */
    @Override
    public List<Member> searchByFirstName(String first_name) throws DBException {
        List<Member> members = new ArrayList<>();

        String query = "SELECT * FROM member WHERE name = ?";

        try {
            PreparedStatement preparedStatement = getConnection().prepareStatement(query);

            preparedStatement.setString(1, first_name);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                members.add(row2object(resultSet));
            }

            resultSet.close();

        } catch (SQLException e) {
            throw new DBException(e);
        }

        return members;
    }

    /**
     * @param last_name
     * @throws DBException
     */
    @Override
    public List<Member> searchByLastName(String last_name) throws DBException {
        List<Member> members = new ArrayList<>();

        String query = "SELECT * FROM member WHERE name = ?";

        try {
            PreparedStatement preparedStatement = getConnection().prepareStatement(query);

            preparedStatement.setString(1, last_name);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                members.add(row2object(resultSet));
            }

            resultSet.close();

        } catch (SQLException e) {
            throw new DBException(e);
        }

        return members;
    }

    /**
     * @param first_name
     * @return
     * @throws DBException
     */
    @Override
    public List<Member> getByFirstName(String first_name) throws DBException {
        return null;
    }
}
