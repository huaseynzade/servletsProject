package org.example.product;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class DbProgresses {
    public static Connection connector;

    public void checkDriver() throws ClassNotFoundException {
        Class.forName("org.postgresql.Driver");
    }
    public Connection createConnection() throws SQLException {

            Connection connector = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "rebbin12");

        return connector;
    }

    public void stopConnection(){

        try {
            System.out.println("Connection is closing...");
            connector.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
