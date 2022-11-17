package com.controller;

import com.Dao.AdminDao;
import com.Dao.AdmincDao;
import com.Dao.UserDao;
import com.model.Responsable;
import com.model.Users;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@WebServlet(name = "Addres", value = "/Addres")
public class Addres extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private AdminDao adminDao;

    public void init() {
        adminDao = new AdminDao();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("addresp.jsp");

    }
    public static String generate_code(String input)
    {
        try
        {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] messageDigest = md.digest(input.getBytes());
            BigInteger no = new BigInteger(1, messageDigest);
            String hashtext = no.toString(16);
            while (hashtext.length() < 32)
            {
                hashtext = "0" + hashtext;
            }
            return hashtext.substring(0,5);
        }
        catch (NoSuchAlgorithmException e)
        {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String nom = request.getParameter("nom");
        System.out.println(nom);
        String prenom = request.getParameter("prenom");
        System.out.println(prenom);
        String email = request.getParameter("email");
        System.out.println(email);
        String password=generate_code(nom+prenom);
        UserDao userDao=new UserDao();
        int id_user=userDao.id;
        AdmincDao admincDao=new AdmincDao();
        Users users=admincDao.getuser(id_user);
        Responsable responsable=new Responsable(nom,prenom,email,password,users);
        responsable.setNom(nom);
        responsable.setPrenom(prenom);
        responsable.setEmail(email);
        responsable.setPassword(password);
        AdminDao adminDao=new AdminDao();
        adminDao.saveresp(responsable);
        RequestDispatcher dispatcher = request.getRequestDispatcher("addpesp.jsp");
        dispatcher.forward(request, response);
    }
}
