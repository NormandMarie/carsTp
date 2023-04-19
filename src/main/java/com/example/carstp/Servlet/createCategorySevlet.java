package com.example.carstp.Servlet;

import com.example.carstp.Dao.categoryDao;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(urlPatterns = "/secured/newCategory")
public class createCategorySevlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        RequestDispatcher viewdash = req.getRequestDispatcher("/WEB-INF/createCat.jsp");
        viewdash.forward(req,resp);
    }
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String name= req.getParameter("name");
        categoryDao categoryDao = new categoryDao();
        categoryDao.createCategory(name);
        resp.sendRedirect(req.getContextPath() + "/category");
    }

}
