package ba.unsa.etf.rpr.controllers;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {
    public Connection databaseLink;
    public Connection getConnection(){
        String databaseName = "freedb_RPRprojekatbaza";
        String databaseUser = "freedb_ejasarevic3";
        String databasePassword = "yDUg2u$7HZ2f?a%";
        String url = "jdbc:mysql://localhost/"+ databaseName;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            databaseLink = DriverManager.getConnection(url,databaseUser,databasePassword);
        }catch (Exception e){
            e.printStackTrace();
        }
        return databaseLink;
    }
}
