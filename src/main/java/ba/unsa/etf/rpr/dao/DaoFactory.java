package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.exceptions.DBException;

public class DaoFactory {
    private static BookDao bookDao = null;
    private static MemberDao memberDao = null;
    private  static LoanDao loanDao = null;

    private DaoFactory() {};

    public static BookDao bookDao() throws DBException {
        if(bookDao == null){
            bookDao = new BookDaoSQLImpl();
        }
        return bookDao;
    }
}
