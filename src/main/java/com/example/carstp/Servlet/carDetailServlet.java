package com.example.carstp.Servlet;


import com.example.carstp.Dao.CarDao;
import com.example.carstp.model.Car;
import com.example.carstp.model.Category;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;


@WebServlet(urlPatterns = "/detail")
public class carDetailServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        com.example.carstp.Dao.CarDao CarDao = new com.example.carstp.Dao.CarDao();
        String sid = req.getParameter("id");
        int id = Integer.parseInt(sid);
        Car car = CarDao.findById(id);
        com.example.carstp.Dao.CarDao carDao = new CarDao();
        String categoryCar = carDao.getNameById(car.category_id);
        req.setAttribute("car",car);
        req.setAttribute("categoryCar",categoryCar);
        RequestDispatcher viewcar = req.getRequestDispatcher("/WEB-INF/carDetails.jsp");
        viewcar.forward(req, resp);

    }

}
