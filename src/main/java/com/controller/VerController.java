package com.controller;

import com.Dao.AdmincDao;
import com.Dao.PromoDao;
import com.Dao.UserDao;
import com.model.Promotion;
import com.model.Stock;
import com.model.Users;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "VerController", value = "/VerController")
public class VerController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int idpromo= Integer.parseInt(request.getParameter("idpromo"));
        String disponible= request.getParameter("disponible");
        int promo= Integer.parseInt(request.getParameter("promo"));
        int points= Integer.parseInt(request.getParameter("points"));
        String date= request.getParameter("date");
        String produit=request.getParameter("produit");
        PromoDao promoDao=new PromoDao();
        AdmincDao admincDao=new AdmincDao();
        System.out.println(promoDao.insertid(produit));
        Stock stock=admincDao.getStokes(promoDao.insertid(produit));
        UserDao userDao=new UserDao();
        int id_user=userDao.id;
        Users users=admincDao.getuser(id_user);
        Promotion promotion=new Promotion(promo,points,disponible,date, stock, users);
        promoDao.appdisp(promotion);
        response.sendRedirect("Responsable.jsp");

    }
}
