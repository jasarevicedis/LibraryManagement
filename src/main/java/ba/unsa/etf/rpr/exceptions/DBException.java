package ba.unsa.etf.rpr.exceptions;

/**
 * User exception
 * @author ejasarevic3
 */

public class DBException extends Exception{
    public DBException(){}
    public DBException(String msg, Exception reason){
        super(msg, reason);
    }

    public DBException(String msg){
        super(msg);
    }

    public DBException(Throwable reason){
        super(reason);
    }
}
