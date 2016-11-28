package com.brainacad.java.flyer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Passenger {

    // Add new passenger
    public void addPassenger(Connection connection, String firstName, String lastName,
                             String nationality, String passport, String dOb, String gender) {
        try {
            connection.setAutoCommit(false);
            String query = "INSERT INTO Passenger ('firstName', 'lastName', 'nationality', 'passport', 'dOb', 'gender') "
                    + "VALUES (?, ?, ?, ?, ?, ?);";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, firstName);
                preparedStatement.setString(2, lastName);
                preparedStatement.setString(3, nationality);
                preparedStatement.setString(4, passport);
                preparedStatement.setString(5, dOb);
                preparedStatement.setString(6, gender);
                preparedStatement.executeUpdate();
                System.out.println("Preparing is OK");
            } catch (SQLException e) {
                e.printStackTrace();
                connection.rollback();
                System.out.println("Insert is FALSE, Rollback");
            } finally {
                connection.commit();
                System.out.println("New passenger is added");
            }
            // Show added passenger
            query = "SELECT DISTINCT idPassenger, firstName, lastName FROM Passenger WHERE firstName = ? AND lastName = ?;";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, firstName);
                preparedStatement.setString(2, lastName);
                View.outData(preparedStatement.executeQuery());
            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("Select of added passenger is FALSE, Rollback");
            } finally {
                System.out.println("Select of added passenger is OK");
            }
    } catch(SQLException e)
        {
            e.printStackTrace();
        }
    }

    // Get all passengers
    public void getAllStudents(Connection connection) {
        String query = "SELECT * from Student";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            View.outData(preparedStatement.executeQuery());
            System.out.println("Preparing is OK");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Select of students is FALSE, Rollback");
        } finally {
            System.out.println("Select of students is OK");
        }
    }

    // Update passenger
    public void updatePassenger(Connection connection, int idPassenger, String firstName, String lastName,
                             String nationality, String passport, String dOb, String gender) {
        try {
            connection.setAutoCommit(false);
            String query = "INSERT INTO Passenger ('firstName', 'lastName', 'nationality', 'passport', 'dOb', 'gender') "
                    + "VALUES (?, ?, ?, ?, ?, ?);";

            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, firstName);
                preparedStatement.setString(2, lastName);
                preparedStatement.setString(3, nationality);
                preparedStatement.setString(4, passport);
                preparedStatement.setString(5, dOb);
                preparedStatement.setString(6, gender);
                preparedStatement.executeUpdate();
                System.out.println("Preparing is OK");
            } catch (SQLException e) {
                e.printStackTrace();
                connection.rollback();
                System.out.println("Insert is FALSE, Rollback");
            } finally {
                connection.commit();
                System.out.println("Passenger is updated");
            }
            // Show updated passenger
            query = "SELECT DISTINCT idPassenger, firstName, lastName, nationality, passport, dob, gender FROM Passenger WHERE idPassenger = ?;";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, String.valueOf(idPassenger));
                View.outData(preparedStatement.executeQuery());
            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("Select of updated passenger is FALSE, Rollback");
            } finally {
                System.out.println("Select of updated passenger is OK");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Delete passenger
    public void deletePassenger(Connection connection, int idPassenger) {
        try {
            connection.setAutoCommit(false);
            // Show passenger before deleting
            String query = "SELECT idPassenger, firstName, lastName from Passenger WHERE idPassenger = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setInt(1, idPassenger);
                View.outData(preparedStatement.executeQuery());
            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("Select of passenger is FALSE, Rollback");
            } finally {
                System.out.println("Select of passenger is OK");
            }
            // Deleting passenger
            query = "DELETE FROM Passenger WHERE idPassenger = ?;";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setInt(1, idPassenger);
                preparedStatement.executeUpdate();
                System.out.println("Preparing is OK");
            } catch (SQLException e) {
                e.printStackTrace();
                connection.rollback();
                System.out.println("Delete is FALSE, Rollback");
            } finally {
                connection.commit();
                System.out.println("Passenger was deleted");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}