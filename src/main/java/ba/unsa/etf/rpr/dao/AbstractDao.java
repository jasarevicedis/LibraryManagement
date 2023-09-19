package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.controllers.DatabaseConnection;
import ba.unsa.etf.rpr.domain.Idable;
import ba.unsa.etf.rpr.exceptions.DBException;

import java.io.FileReader;
import java.sql.*;
import java.util.*;

/**
 * Abstract class which implements core Dao method form interface Dao for all entities in the database
 */
public abstract class AbstractDao <Type extends Idable> implements Dao<Type> {

    private  final Connection connection;
    private  final String tableName;
    /**
     * creates connection
     */
    public Connection getConnection() {
        return connection;
    }
    /**
     * constructor that connects to table
     */
    public AbstractDao(String tableName) throws  DBException {

            this.tableName = tableName;
            /*
            Properties properties=new Properties();
            properties.load(ClassLoader.getSystemResource("db.properties").openStream());
            String url = properties.getProperty("connection");
            String username = properties.getProperty("username");
            String password = properties.getProperty("password");*/
            this.connection = DatabaseConnection.getConnection();

    }

    /**
     * Method for mapping ResultSet into Object
     * @param rs ResultSet from database
     * @return  a Bean object for specific table
     * @throws DBException in case of error with database
     */
    public abstract Type rowToObject(ResultSet rs) throws DBException;

    /**
     * Method for mapping Object into Map
     * @param object a Bean object for specific table
     * @return  key, value sorted map of object
     */
    public abstract Map<String, Object> objectToRow(Type object);

    @Override
    public Type getById(int id) throws DBException {
        try{
            PreparedStatement statement=getConnection().prepareStatement("SELECT * FROM "+this.tableName+" WHERE id = ?");
            statement.setInt(1,id);
            ResultSet queryResult = statement.executeQuery();
            if(queryResult.next()){
                Type record= rowToObject(queryResult);
                queryResult.close();
                return record;
            }
            else
                throw new DBException("Object not found");
        }
        catch(SQLException e){
            throw new DBException(e.getMessage());
        }
    }

    @Override
    public Type add(Type item) throws DBException {
        Map<String, Object> row = objectToRow(item);
        Map.Entry<String, String> columns = prepareInsertParts(row);

        StringBuilder query = new StringBuilder();
        query.append("INSERT INTO ").append(tableName);
        query.append(" (").append(columns.getKey()).append(") ");
        query.append("VALUES (").append(columns.getValue()).append(")");

        try{
            PreparedStatement statement = getConnection().prepareStatement(query.toString(), Statement.RETURN_GENERATED_KEYS);
            // TreeMap is used to keep columns sorted so parameters are bound correctly
            int counter = 1;
            for (Map.Entry<String, Object> entry: row.entrySet()) {
                if (entry.getKey().equals("id")) continue; // skip ID
                statement.setObject(counter, entry.getValue());
                counter++;
            }
            statement.executeUpdate();
            ResultSet queryResult = statement.getGeneratedKeys();
            queryResult.next(); // there is surely only one key
            item.setId(queryResult.getInt(1));
            return item;
        }catch (SQLException e){
            throw new DBException(e.getMessage());
        }
    }

    /**
     * Accepts KV storage of column names and return CSV of columns and question marks for insert statement
     * Example: (id, name, date) ?,?,?
     */
    private Map.Entry<String, String> prepareInsertParts(Map<String, Object> row){
        StringBuilder columns = new StringBuilder();
        StringBuilder questions = new StringBuilder();

        int counter = 0;
        for (Map.Entry<String, Object> entry: row.entrySet()) {
            counter++;
            if (entry.getKey().equals("id")) continue; //skip insertion of id due to autoincrement
            columns.append(entry.getKey());
            questions.append("?");
            if (row.size() != counter) {
                columns.append(",");
                questions.append(",");
            }
        }
        return new AbstractMap.SimpleEntry<>(columns.toString(), questions.toString());
    }

    @Override
    public Type update(Type item) throws DBException {
        Map<String, Object> row = objectToRow(item);
        String updateColumns = prepareUpdateParts(row);
        StringBuilder query = new StringBuilder();
        query.append("UPDATE ")
                .append(tableName)
                .append(" SET ")
                .append(updateColumns)
                .append(" WHERE id = ?");

        try{
            PreparedStatement statement = getConnection().prepareStatement(query.toString());
            int counter = 1;
            for (Map.Entry<String, Object> entry: row.entrySet()) {
                if (entry.getKey().equals("id")) continue; // skip ID
                statement.setObject(counter, entry.getValue());
                counter++;
            }
            statement.setObject(counter, item.getId());
            statement.executeUpdate();
            return item;
        }catch (SQLException e){
            throw new DBException(e.getMessage());
        }
    }

    /**
     * Prepare columns for update statement id=?, name=?, ...
     * @param row - row to be converted into String
     * @return String for update statement
     */
    private String prepareUpdateParts(Map<String, Object> row){
        StringBuilder columns = new StringBuilder();

        int counter = 0;
        for (Map.Entry<String, Object> entry: row.entrySet()) {
            counter++;
            if (entry.getKey().equals("id")) continue; //skip update of id due where clause
            columns.append(entry.getKey()).append("= ?");
            if (row.size() != counter) {
                columns.append(",");
            }
        }
        return columns.toString();
    }

    @Override
    public void delete(int id) throws DBException {
        try{
            PreparedStatement statement = getConnection().prepareStatement("DELETE FROM "+tableName+" WHERE id = ?", Statement.RETURN_GENERATED_KEYS);
            statement.setObject(1, id);
            statement.executeUpdate();
        }catch (SQLException e){
            throw new DBException(e.getMessage());
        }


    }

    @Override
    public List<Type> getAll() throws DBException {
        try{
            PreparedStatement statement=getConnection().prepareStatement("SELECT * FROM "+tableName);
            ResultSet queryResult = statement.executeQuery();
            List<Type> records = new ArrayList<Type>();
            while(queryResult.next()){
                Type object = rowToObject(queryResult);
                records.add(object);
            }
            queryResult.close();
            return records;
        }catch(SQLException e){
            throw new DBException(e.getMessage());
        }
    }
}