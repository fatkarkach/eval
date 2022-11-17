package com.controller;

import com.Dao.*;
import com.model.Promotion;
import com.model.Stock;
import com.model.Users;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "PromoServlet", value = "/PromoServlet")
public class PromoServlet extends HttpServlet {
    private String dateExpiration;
    private int id, days;
    private operationE operation_expiration;
    private static final long serialVersionUID = 1L;
    private PromoDao promoDao;

    public void init() {
        promoDao = new PromoDao();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("promotion.jsp");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String categorie=request.getParameter("categorie");
        System.out.println(categorie);
        String produit=request.getParameter("produit");
        System.out.println(produit);
        int promo = Integer.parseInt(request.getParameter("promo"));
        System.out.println(promo);
        if(categorie=="multimédia" && promo>=20)
        {
            promo=0;
        }
        int point=promo+10;
        System.out.println(point);
        AdmincDao admincDao=new AdmincDao();
        System.out.println(promoDao.insertid(produit));
       Stock stock=admincDao.getStokes(promoDao.insertid(produit));
        UserDao userDao=new UserDao();
        int id_user=userDao.id;
        Users users=admincDao.getuser(id_user);
        String disponible="Non";
        operation_expiration = new  operationE();
        days=Integer.parseInt(request.getParameter("dateExpiration"));
        dateExpiration = All_op_timer.add_some_days_to_my_datetime(days);
        Promotion promotion=new Promotion(promo,point,disponible,dateExpiration,stock,users);
        promotion.setPromo(promo);
        promotion.setPoints(point);
        promotion.setStockByIdStocks(stock);
        promotion.setDisponible(disponible);
        promoDao.savepromo(promotion);
       RequestDispatcher dispatcher = request.getRequestDispatcher("promotion.jsp");
        dispatcher.forward(request, response);

    }
}
