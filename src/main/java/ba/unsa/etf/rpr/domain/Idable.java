package ba.unsa.etf.rpr.domain;

/**
 * Interface for forcing all POJO fields to have id
 */
public interface Idable {
    void setId(int id);
    void getId();
}
