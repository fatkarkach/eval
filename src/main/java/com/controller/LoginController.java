package com.controller;

import com.Dao.SessionUtil;
import com.Dao.UserDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.hibernate.Session;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
@FunctionalInterface
interface Sayable{
    String say(String message);
}
@WebServlet(name = "LoginController", value = "/LoginController")
public class LoginController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private UserDao loginDao;

    public void init() {
        loginDao = new UserDao();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.sendRedirect("index.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        try {
            // You can pass multiple statements in lambda expression
            Sayable person = (message)-> {
                String str1 = "Vous etes connectes comme:";
                String str2 = str1 + message;
                return str2;
            };
        String email = request.getParameter("email");
            System.out.println(email);
            String password = request.getParameter("password");
            System.out.println(password);
            //tester heure:
            String timeStamp1 = new SimpleDateFormat("HH:mm").format(Calendar.getInstance().getTime());
            SimpleDateFormat sdformat = new SimpleDateFormat("HH:mm");
            Date date1 = sdformat.parse("8:00");
            Date date2 = sdformat.parse(timeStamp1);
            Date date3 = sdformat.parse("12:00");

            if (loginDao.insert(email,password)) {
                session.setAttribute("user", true);
                System.out.println(person.say("Admin de centre"));
                request.getRequestDispatcher("Adminc.jsp").forward(request, response);
            } else if (loginDao.insertAdmin(email,password)) {
                System.out.println(person.say("Admin général"));
                session.setAttribute("admin", true);
                request.getRequestDispatcher("login-success.jsp").forward(request, response);

            } //tester
            else if (loginDao.insertres(email,password)) {
//                if(date2.compareTo(date1) < 0 || date2.compareTo(date3) <0 ) {
//                    System.out.println("ba9i 7al");
//                    System.out.println("klchi mzyan");
                System.out.println(person.say("Responsable de Rayon"));
                session.setAttribute("responsable", true);
                request.getRequestDispatcher("Responsable.jsp").forward(request, response);
//                }
//                else {
//                    System.out.println("mcha l7al");
//                    request.getRequestDispatcher("index.jsp").forward(request, response);
//                }

            } else {
                System.out.println("machi mzyan");
                request.getRequestDispatcher("index.jsp").forward(request, response);
                request.getSession(false);
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
