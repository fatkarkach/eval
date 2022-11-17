package com.controller;

import com.Dao.AdminDao;
import com.model.Centre;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "DeleteAdmin", value = "/DeleteAdmin")
public class DeleteAdmin extends HttpServlet {
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
        adminDao.deleteUser(id);
        String ville = request.getParameter("ville");
        System.out.println(ville);
        String centre = request.getParameter("centre");
        System.out.println(centre);
        int idcentre=adminDao.insertcentreid(centre);
        System.out.println(adminDao.insertcentreid(centre));
        String status="Non";
        Centre centre1=new Centre(idcentre,centre,status,ville);
        adminDao.updateStatus(centre1);
        response.sendRedirect("login-success.jsp");
    }
}
