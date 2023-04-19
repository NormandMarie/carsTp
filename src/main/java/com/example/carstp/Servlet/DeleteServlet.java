package com.example.carstp.Servlet;

import com.example.carstp.Dao.CarDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

    @WebServlet(urlPatterns = "/secured/delete")
    public class DeleteServlet extends HttpServlet {
        protected void doGet(HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException {
            String sid = request.getParameter("id");
            int id = Integer.parseInt(sid);
           CarDao carDao = new CarDao();
            carDao.deleteCar(id);
            request.getRequestDispatcher("/Accueil").forward(request, response);
        }
    }
