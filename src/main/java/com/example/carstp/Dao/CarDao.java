package com.example.carstp.Dao;

import com.example.carstp.model.Car;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;



public class CarDao {

    static String URL = "jdbc:mysql://localhost:3306/databaseexo";
    static String USER = "root";
    static String PASSWORD = "Marie121";

    public List<Car> getAllCars() {
        List<Car> cars = new ArrayList<>();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM car");
            {
                while (rs.next()) {
                    int id = rs.getInt("id");
                    String name = rs.getString("name");
                    String detailText = rs.getString("detail_text");
                    String photo = rs.getString("photo");
                    int price = rs.getInt("price");
                    int categoryId = rs.getInt("category_id");
                    Car car = new Car(id, name, detailText, photo, price, categoryId);
                    cars.add(car);

                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return cars;
    }
    public Car findById(int id)  {
        final String sql = "SELECT * FROM car WHERE id = ?";

        try {
            Connection connection = DriverManager.getConnection(URL,USER,PASSWORD);
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);

            ResultSet result = statement.executeQuery();


            if (result.next()) {
                int idr = result.getInt("id");
                String name = result.getString("name");
                String detail = result.getString("detail_text");
                String photo = result.getString("photo");
                int price = result.getInt("price");
                int categoryId = result.getInt("category_id");

                return new Car(idr, name, detail, photo, price, categoryId);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }


    public String getNameById(int id) {
        String name = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
            PreparedStatement statement = connection.prepareStatement("SELECT name FROM category WHERE id = ?");
            statement.setInt(1, id);
            ResultSet result = statement.executeQuery();
            if (result.next()) {
                name = result.getString("name");
            }
            result.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return name;
    }
    public Car createCar(String name, String detail, String photo, int price,int categoryId) {
        final String sql = "INSERT INTO car (name, detail_text, photo,price,category_id) VALUES (?, ?, ?,?,?)";

        Car newCar = null;
        try {

            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);


            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, name);
            statement.setString(2, detail);
            statement.setString(3, photo);
            statement.setInt(4, price);
            statement.setInt(5, categoryId);
            statement.executeUpdate();
            newCar = new Car(name, detail, photo,price,categoryId);


        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        return newCar;
    }

    public void deleteCar(int carId) {
        final String sql = "DELETE FROM car WHERE id = ?";

        try (Connection connection = DriverManager.getConnection(URL,USER, PASSWORD);
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, carId);
            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
