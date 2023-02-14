package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.Admin;
import ba.unsa.etf.rpr.exceptions.LibraryException;

import java.sql.ResultSet;

/**
 * MYSQL DAO implementation
 */

public class AdminDaoSQLImpl extends AbstractDao<Admin> implements AdminDao{
    private static  AdminDaoSQLImpl instance = null;
    private AdminDaoSQLImpl() {
        super("admin");
    }

    public static AdminDaoSQLImpl getInstance(){
        if(instance==null)
            instance = new AdminDaoSQLImpl();
        return instance;
    }

    public static void removeInstance(){
        if(instance!=null)
            instance=null;
    }

    @Override
    public Admin row2object(ResultSet rs) throws LibraryException {
        try {
            Admin adm = new Admin();
            adm.setId(rs.getInt("id"));
            adm.setName(rs.getString("name"));
            return adm;
        } catch (SQLException e) {
            throw new QuoteException(e.getMessage(), e);
        }
    }

    @Override
    public Map<String, Object> object2row(Category object) {
        Map<String, Object> row = new TreeMap<>();
        row.put("id", object.getId());
        row.put("name", object.getName());
        return row;
    }
}
