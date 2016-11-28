package com.brainacad.java.flyer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnection {

    private Connection connection = null;
    private Statement statement = null;

    // Connecting to DB
    public Connection connect() {

        try {
            connection = DriverManager.getConnection("jdbc:sqlite:FlyerrDB.db");
            System.out.println("Connection is established");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        System.out.println("...Start working with DB...");
        return connection;
    }

    // Closing connection
    public boolean disconnect() {

        try {
            if (connection != null) {
                connection.close();
                System.out.println("...Connection is closed...");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }

    // Create statement
    public Statement getStatementDB() {
        try {
            statement = connection.createStatement();
            System.out.println("Statement was created");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return statement;
    }

    // Close statement
    public boolean closeStatemntDB() {
        try {
            if (statement != null) {
                statement.close();
                System.out.println("Statement closed");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}