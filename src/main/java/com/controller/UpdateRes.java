package com.controller;

import com.Dao.AdminDao;
import com.Dao.AdmincDao;
import com.model.Responsable;
import com.model.Users;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "UpdateRes", value = "/UpdateRes")
public class UpdateRes extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int id= Integer.parseInt(request.getParameter("id"));
        String nom= request.getParameter("nom");
        String prenom=request.getParameter("prénom");
        String Email=request.getParameter("email");
        String password=request.getParameter("password");
        int id_user=Integer.parseInt(request.getParameter("id_user"));
        AdmincDao admincDao=new AdmincDao();
        Users users=admincDao.getuser(id_user);
        Responsable responsable=new Responsable(id,nom,prenom, Email,password,users);
        AdminDao adminDao=new AdminDao();
        adminDao.updateRes(responsable);
        response.sendRedirect("addpesp.jsp");

    }
}
