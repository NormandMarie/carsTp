package com.example.carstp.Dao;

import com.example.carstp.model.Car;
import com.example.carstp.model.Category;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static com.example.carstp.Dao.CarDao.*;

public class categoryDao {
    public List<Category> getAllCategory() {
        List<Category> categorys = new ArrayList<>();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM category");
            {
                while (rs.next()) {
                    int id = rs.getInt("id");
                    String name = rs.getString("name");

                    Category category = new Category(id, name);
                    categorys.add(category);

                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return categorys;
    }
    public void deleteCategory(int catId) {
        final String sql = "DELETE FROM category WHERE id = ?";

        try (Connection connection = DriverManager.getConnection(URL,USER, PASSWORD);
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, catId);
            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public Category createCategory(String name) {
        final String sql = "INSERT INTO category (name) VALUES (?)";

        Category newPost = null;
        try {

            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection(URL,USER,PASSWORD);


            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, name);
            statement.executeUpdate();
            newPost = new Category(name);


            //connection.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        return newPost;
    }
}


