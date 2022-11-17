package com.controller;

import com.Dao.AdmincDao;
import com.Dao.UserDao;
import com.model.Stock;
import com.model.Users;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "Addpro", value = "/Addpro")
public class Addpro extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("Adminc.jsp");

    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String categorie=request.getParameter("categorie");
//        System.out.println(categorie);
        String produit=request.getParameter("produit");
//        System.out.println(produit);
        int prix= Integer.parseInt(request.getParameter("prix"));
//        System.out.println(prix);
        int quantites=Integer.parseInt(request.getParameter("quantites"));
        System.out.println(quantites);
        UserDao userDao=new UserDao();
        int id_user=userDao.id;
        AdmincDao admincDao=new AdmincDao();
        Users users=admincDao.getuser(id_user);
        Stock stock=new Stock(categorie,produit,prix,quantites,users);
        stock.setCategorie(categorie);
        stock.setProduit(produit);
        stock.setPrix(prix);
        stock.setQuantites(quantites);
        admincDao.savepro(stock);
        RequestDispatcher dispatcher = request.getRequestDispatcher("Adminc.jsp");
        dispatcher.forward(request, response);

    }
}
