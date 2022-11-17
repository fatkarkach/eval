package com.controller;

import com.Dao.AdminDao;
import com.model.Users;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "UpdateAdmin", value = "/UpdateAdmin")
public class UpdateAdmin extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private AdminDao adminDao;

    public void init() {
        adminDao = new AdminDao();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("login-success.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        System.out.println(id);
        String nom = request.getParameter("nom");
        System.out.println(nom);
        String prenom = request.getParameter("prenom");
        System.out.println(prenom);
        String email = request.getParameter("email");
        System.out.println(email);
        String password = request.getParameter("password");
        String centre = request.getParameter("centre");
        String ville = request.getParameter("ville");
        String type = request.getParameter("type");
        Users user = new Users(id,nom, prenom, email,password,ville,centre,type);
        adminDao.updateUser(user);
        response.sendRedirect("login-success.jsp");

    }
}
