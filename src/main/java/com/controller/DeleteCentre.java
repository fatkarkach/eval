package com.controller;

import com.Dao.centreDao;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "DeleteCentre", value = "/DeleteCentre")
public class DeleteCentre extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int id= Integer.parseInt(request.getParameter("id"));
        centreDao  centreDao=new centreDao();
        centreDao.deletecentre(id);
        response.sendRedirect("ville.jsp");

    }
}