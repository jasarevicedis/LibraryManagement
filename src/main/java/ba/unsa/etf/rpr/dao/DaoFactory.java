package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.exceptions.DBException;

public class DaoFactory {
    private static final BookDao bookDao;

    static {
        try {
            bookDao = BookDaoSQLImpl.getInstance();
        } catch (DBException e) {
            throw new RuntimeException(e);
        }
    }

    private static final MemberDao memberDao;

    static {
        try {
            memberDao = MemberDaoSQLImpl.getInstance();
        } catch (DBException e) {
            throw new RuntimeException(e);
        }
    }

    private static final LoanDao loanDao;

    static {
        try {
            loanDao = LoanDaoSQLImpl.getInstance();
        } catch (DBException e) {
            throw new RuntimeException(e);
        }
    }


    private DaoFactory() {};

    public static BookDao bookDao() throws DBException {
        return bookDao;
    }

    public static MemberDao memberDao() throws DBException {

        return memberDao;
    }

    public static LoanDao loanDao() throws DBException {

        return loanDao;
    }
}
