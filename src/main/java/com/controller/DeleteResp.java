package com.controller;

import com.Dao.AdminDao;
import com.Dao.centreDao;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "DeleteResp", value = "/DeleteResp")
public class DeleteResp extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id= Integer.parseInt(request.getParameter("id"));
        AdminDao adminDao=new AdminDao();
        adminDao.deleteresp(id);
        response.sendRedirect("addpesp.jsp");
    }
}
