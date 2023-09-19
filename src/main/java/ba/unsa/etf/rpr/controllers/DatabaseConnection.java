package ba.unsa.etf.rpr.controllers;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * controller for database connection
 */
public class DatabaseConnection {
    public static Connection databaseLink;
    public static Connection getConnection(){
        String databaseName = "freedb_RPRprojekatbaza";
        String databaseUser = "freedb_ejasarevic3";
        String databasePassword = "yDUg2u$7HZ2f?a%";
        String url = "jdbc:mysql://sql.freedb.tech/"+ databaseName;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            databaseLink = DriverManager.getConnection(url,databaseUser,databasePassword);
        }catch (Exception e){
            e.printStackTrace();
        }
        return databaseLink;
    }
}
