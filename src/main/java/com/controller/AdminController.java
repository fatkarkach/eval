package com.controller;

import com.Dao.AdminDao;
import com.model.Centre;
import com.model.Users;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import javax.mail.MessagingException;
import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@WebServlet(name = "AdminController", value = "/AdminController")
public class AdminController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    public  static String password;
    private AdminDao adminDao;

    public void init() {
        adminDao = new AdminDao();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("login-success.jsp");

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
        //inserer  les admins
        String nom = request.getParameter("nom");
        System.out.println(nom);
        String prenom = request.getParameter("prenom");
        System.out.println(prenom);
        String ville = request.getParameter("ville");
        System.out.println(ville);
        String centre = request.getParameter("centre");
        System.out.println(centre);
        String email = request.getParameter("email");
        System.out.println(email);
        String password=generate_code(nom+prenom);
        String rol="adminc";
        Users user = new Users(nom, prenom,email, password, ville, centre, rol);
        user.setNom(nom);
        user.setPrenom(prenom);
        user.setEmail(email);
        user.setPassword(password);
        user.setType(rol);
        user.setVille(ville);
        user.setCentre(centre);
        AdminDao adminDao=new AdminDao();
        adminDao.saveUser(user);
        int id=adminDao.insertcentreid(centre);
        System.out.println(adminDao.insertcentreid(centre));
        String status="Oui";
        Centre centre1=new Centre(id,centre,status,ville);
        adminDao.updateStatus(centre1);
        RequestDispatcher dispatcher = request.getRequestDispatcher("login-success.jsp");
        dispatcher.forward(request, response);
    }

    }
