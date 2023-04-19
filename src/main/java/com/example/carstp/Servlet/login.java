package com.example.carstp.Servlet;

import jakarta.servlet.ServletException;
import com.example.carstp.Dao.adminDao;
import com.example.carstp.model.Admin;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.*;


@WebServlet(urlPatterns = "/login")
public class login extends HttpServlet {
    public adminDao adminDao;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        adminDao = new adminDao();
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        try {
            Admin admin = adminDao.verif(username, password);
            if (admin != null) {
                // Si les informations de connexion sont correctes, on stocke les données de l'utilisateur dans la session et on redirige vers la page d'accueil
                HttpSession session = req.getSession();
                session.setAttribute("username", admin.getUsername());
                session.setAttribute("password", admin.getPassword());
                resp.sendRedirect(req.getContextPath()+"/Accueil");
            } else {
                // Si les informations de connexion sont incorrectes, on renvoie l'utilisateur vers la page de connexion avec un message d'erreur
                req.setAttribute("isError", true);
                req.getRequestDispatcher("/WEB-INF/login.jsp").forward(req, resp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Gestion de l'erreur
        }
    }
}