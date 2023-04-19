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
import java.sql.SQLException;

@WebServlet(urlPatterns = "/secured/editCategory")
public class editCatServlet extends HttpServlet {

        @Override
        public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            int id = Integer.parseInt(req.getParameter("id"));
            categoryDao categoryDao = new categoryDao();
            Category category = null;
            try {
                category = categoryDao.getCategoryById(id);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            req.setAttribute("category", category);
            RequestDispatcher viewupdate = req.getRequestDispatcher("/WEB-INF/updateCat.jsp");
            viewupdate.forward(req, resp);}
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        System.out.println(name);
        String sid = request.getParameter("id");
        int id = Integer.parseInt(sid);
        System.out.println(id);
        categoryDao categoryDao = new categoryDao();

        categoryDao.updateCat(id, name);
        response.sendRedirect(request.getContextPath() + "/category");
    }
}