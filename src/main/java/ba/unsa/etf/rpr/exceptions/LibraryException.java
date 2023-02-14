package ba.unsa.etf.rpr.exceptions;

/**
 * User exception
 * @author ejasarevic3
 */

public class LibraryException extends Exception{
    public LibraryException(String msg, Exception reason){
        super(msg, reason);
    }

    public LibraryException(String msg){
        super(msg);
    }
}
