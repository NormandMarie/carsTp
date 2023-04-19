package com.example.carstp.Servlet;

import com.example.carstp.Dao.CarDao;
import com.example.carstp.Dao.categoryDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
@WebServlet(urlPatterns = "/secured/deleteCategory")
public class DeletecCategory extends HttpServlet {

        protected void doGet(HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException {
            String sid = request.getParameter("id");
            int id = Integer.parseInt(sid);
            categoryDao categoryDao = new categoryDao();
            categoryDao.deleteCategory(id);
            response.sendRedirect(request.getContextPath() + "/category");
        }
    }

