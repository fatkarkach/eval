package com.Dao;

import com.model.Admin;
import com.model.Centre;
import com.model.Responsable;
import com.model.Users;
import org.hibernate.Session;

public class UserDao {
   public static int id;
    public static int id_ur;
    public Boolean insert(String email, String password) {
        Users user = null;
        try {
            Session session = SessionUtil.getCurrentSession();
            session.getTransaction();
            session.getTransaction().begin();
            user = (Users) session.createQuery("SELECT U FROM Users U WHERE U.email = :email ").setParameter("email", email).uniqueResult();
            id=user.getIdUsers();
            System.out.println(user.getEmail());
            System.out.println(user.getPassword());
            System.out.println(user.getType());
            if (user != null && user.getPassword().equals(password)) {

                return true;
            }
            session.persist(user);
            session.getTransaction().commit();
            session.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("error");
        }
        return false;
    }
    public Boolean insertAdmin(String email, String password) {
        Admin admin = null;
        try {
            Session session = SessionUtil.getCurrentSession();
            session.getTransaction();
            session.getTransaction().begin();
            admin = (Admin) session.createQuery("SELECT U FROM Admin U WHERE U.email = :email ").setParameter("email", email).uniqueResult();
            System.out.println(admin.getEmail());
            System.out.println(admin.getPassword());
            if (admin != null && admin.getPassword().equals(password)) {
                return true;
            }
            session.persist(admin);
            session.getTransaction().commit();
            session.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("error");
        }
        return false;
    }

    //responsable

    public Boolean insertres(String email, String password) {
        Responsable responsable=null;
        try {
            Session session = SessionUtil.getCurrentSession();
            session.getTransaction();
            session.getTransaction().begin();
            responsable = (Responsable) session.createQuery("SELECT U FROM Responsable U WHERE U.email = :email ").setParameter("email", email).uniqueResult();
            System.out.println(responsable.getEmail());
            id_ur= responsable.getUsersByIdUsers().getIdUsers();
            System.out.println(id_ur);
            if (responsable != null && responsable.getPassword().equals(password)) {
                return true;
            }
            session.persist(responsable);
            session.getTransaction().commit();
            session.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("error");
        }
        return false;
    }
}
