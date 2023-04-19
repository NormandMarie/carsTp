package com.example.carstp.Servlet;

import com.example.carstp.Dao.CarDao;
import com.example.carstp.model.Car;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;


@WebServlet(urlPatterns = "/Accueil")
public class accueilServlet extends HttpServlet {

        CarDao CarDao;

        @Override
        public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

            CarDao = new CarDao();
            List<Car> cars = CarDao.getAllCars();
            req.setAttribute("cars", cars);
            req.setAttribute("CarDao", CarDao);
            RequestDispatcher viewaccueil = req.getRequestDispatcher("/WEB-INF/Accueil.jsp");
            viewaccueil.forward(req, resp);

        }

    }

