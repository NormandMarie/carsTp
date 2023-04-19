package com.example.carstp.Servlet;

import com.example.carstp.Dao.categoryDao;
import com.example.carstp.model.Category;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/category")
public class catgoryServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        categoryDao category = new  categoryDao();
        List<Category> categorys  = category.getAllCategory();
        req.setAttribute("categorys", categorys);
        RequestDispatcher viewcategory = req.getRequestDispatcher("/WEB-INF/category.jsp");
        viewcategory.forward(req, resp);
    }
}