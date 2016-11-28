package com.brainacad.java.flyer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PriceList {

    // Add new price
//    public void addPassenger(Connection connection, String idFlight, String idClass, int sum,
//                             String nationality, String passport, String dOb, String gender) {
//        try {
//            connection.setAutoCommit(false);
//            String query = "INSERT INTO Passenger ('firstName', 'lastName', 'nationality', 'passport', 'dOb', 'gender') "
//                    + "VALUES (?, ?, ?, ?, ?, ?);";
//            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
//                preparedStatement.setString(1, firstName);
//                preparedStatement.setString(2, lastName);
//                preparedStatement.setString(3, nationality);
//                preparedStatement.setString(4, passport);
//                preparedStatement.setString(5, dOb);
//                preparedStatement.setString(6, gender);
//                preparedStatement.executeUpdate();
//                System.out.println("Preparing is OK");
//            } catch (SQLException e) {
//                e.printStackTrace();
//                connection.rollback();
//                System.out.println("Insert is FALSE, Rollback");
//            } finally {
//                connection.commit();
//                System.out.println("New passenger is added");
//            }
//            // Show added passenger
//            query = "SELECT DISTINCT idPassenger, firstName, lastName FROM Passenger WHERE firstName = ? AND lastName = ?;";
//            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
//                preparedStatement.setString(1, firstName);
//                preparedStatement.setString(2, lastName);
//                View.outData(preparedStatement.executeQuery());
//            } catch (SQLException e) {
//                e.printStackTrace();
//                System.out.println("Select of added passenger is FALSE, Rollback");
//            } finally {
//                System.out.println("Select of added passenger is OK");
//            }
//        } catch(SQLException e)
//        {
//            e.printStackTrace();
//        }
//    }
}
