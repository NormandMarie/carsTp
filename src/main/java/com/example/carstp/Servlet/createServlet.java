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

@WebServlet(urlPatterns = "/secured/create")
public class createServlet extends HttpServlet {
    CarDao CarDao;
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        RequestDispatcher viewpost = req.getRequestDispatcher("/WEB-INF/create.jsp");
        viewpost.forward(req, resp);

    }
//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//       CarDao = new CarDao();
//        String name = req.getParameter("title");
//        String detail = req.getParameter("author");
//        String photo = req.getParameter("content");
//        int price = Integer.parseInt(req.getParameter("price"));
//        int categoryId = Integer.parseInt(req.getParameter("categoryId"));
//        Car newCar = CarDao.createCar(name, detail, photo,price,categoryId);
//        resp.sendRedirect(req.getContextPath() + "/secured/create");

//    }
}
