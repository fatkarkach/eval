package com.controller;

import com.Dao.centreDao;
import com.model.Centre;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "CentreServlet", value = "/CentreServlet")
public class CentreServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("ville.jsp");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String nom_centre=request.getParameter("nom_centre");
        String ville=request.getParameter("ville");
        String status="Non";
        Centre centre=new Centre(nom_centre,status,ville);
        centre.setNomCentre(nom_centre);
        centre.setStatus(status);
        centre.setVille(ville);
        centreDao  centreDao=new centreDao();
        centreDao.savecentre(centre);
        RequestDispatcher dispatcher = request.getRequestDispatcher("ville.jsp");
        dispatcher.forward(request, response);
    }
}
