package com.example.carstp.Dao;

import com.example.carstp.model.Admin;

import java.sql.*;

import static com.example.carstp.Dao.CarDao.*;


public class adminDao {

        public Admin verif(String username, String password) throws SQLException {
            String requeteSQl = "SELECT * FROM admin WHERE username = ? AND password = ?";

            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
                PreparedStatement statement = connection.prepareStatement(requeteSQl);
                {

                    statement.setString(1, username);
                    statement.setString(2, password);
                    ResultSet result = statement.executeQuery();

                    if (result.next()) {
                        String userUsername = result.getString("username");
                        String userPassword = result.getString("password");
                        return new Admin(userUsername, userPassword);
                    } else {
                        return null;
                    }
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }


        }

        public Admin creat(String username, String password) {
            final String INSERT_SQL = "INSERT INTO admin (username, password) VALUES (?, ?)";
            Admin admin  = null;
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);

                PreparedStatement statement = connection.prepareStatement(INSERT_SQL);
                statement.setString(1, username);
                statement.setString(2, password);
                int rowsInserted = statement.executeUpdate();
                if (rowsInserted > 0) {
                    admin = new Admin(username, password);
                }
                connection.close();
            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
            }
            return admin ;
        }

    }