package com.controller;

import com.Dao.centreDao;
import com.model.Centre;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "UpdateCentre", value = "/UpdateCentre")
public class UpdateCentre extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int id= Integer.parseInt(request.getParameter("id"));
        String centre=request.getParameter("centre");
        String ville=request.getParameter("ville");
        String status=request.getParameter("status");
        Centre centre1=new Centre(id,centre,status,ville);
        centreDao centreDao=new centreDao();
        centreDao.updatecentre(centre1);
        response.sendRedirect("ville.jsp");
    }
}
