package com.Dao;

import com.controller.SendMail;
import com.model.Centre;
import com.model.Responsable;
import com.model.Stock;
import com.model.Users;
import org.hibernate.Session;

import javax.mail.MessagingException;
import java.util.List;

public class AdminDao {
    SendMail sendMail=new SendMail();
    public void saveUser(Users user) {
        try  {
            Session session = SessionUtil.getCurrentSession();
            session.getTransaction();
            session.getTransaction().begin();
            // save the student object
            session.save(user);
            session.persist(user);
            System.out.println(user.getEmail());
            sendMail.go(user.getEmail(), user.getEmail(), user.getPassword());
            session.getTransaction().commit();
            session.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("error");
            e.printStackTrace();
        }
    }
    public List < Users > getAllUser() {
        List< Users > listOfUser = null;
        try {
            Session session = SessionUtil.getCurrentSession();
            session.getTransaction();
            session.getTransaction().begin();
            // get an user object

            listOfUser = session.createQuery("from Users ").getResultList();
            // commit transaction
            session.getTransaction().commit();
            session.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("error");
            e.printStackTrace();
        }
        return listOfUser;
    }
    //delete admin
    public void deleteUser(int id) {


        try {
            // start a transaction
            Session session = SessionUtil.getCurrentSession();
            session.getTransaction();
            session.getTransaction().begin();

            // Delete a user object
            Users user = session.get(Users.class, id);
            if (user != null) {
                session.delete(user);
                System.out.println("user is deleted");
            }
            // commit transaction
            session.getTransaction().commit();
            session.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("error");
            e.printStackTrace();
        }
    }
    //update
    public void updateUser(Users user) {
        try{
            // start a transaction
            Session session = SessionUtil.getCurrentSession();
            session.getTransaction();
            session.getTransaction().begin();
            // save the student object
            session.update(user);
            // commit transaction
            session.persist(user);
            session.getTransaction().commit();
            session.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("error");
            e.printStackTrace();
        }
    }
    public void updateRes(Responsable resp) {
        try{
            // start a transaction
            Session session = SessionUtil.getCurrentSession();
            session.getTransaction();
            session.getTransaction().begin();
            // save the student object
            session.update(resp);
            // commit transaction
            session.persist(resp);
            session.getTransaction().commit();
            session.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("error");
            e.printStackTrace();
        }
    }
    //delet resp
    public void deleteresp(int id) {


        try {
            // start a transaction
            Session session = SessionUtil.getCurrentSession();
            session.getTransaction();
            session.getTransaction().begin();

            // Delete a user object
            Responsable responsable = session.get(Responsable.class, id);
            if (responsable != null) {
                session.delete(responsable);
                System.out.println("user is deleted");
            }
            // commit transaction
            session.getTransaction().commit();
            session.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("error");
            e.printStackTrace();
        }
    }
    //add resp
    public void saveresp(Responsable responsable) {
        try  {
            Session session = SessionUtil.getCurrentSession();
            session.getTransaction();
            session.getTransaction().begin();
            // save the student object
            session.save(responsable);
            session.persist(responsable);
            sendMail.go(responsable.getEmail(),responsable.getEmail(),responsable.getPassword());
            session.getTransaction().commit();
            session.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("error");
            e.printStackTrace();
        }
    }
    //return responsable
    public List <Responsable> getAllresp() {
        List< Responsable > listOfUser = null;
        try {
            Session session = SessionUtil.getCurrentSession();
            session.getTransaction();
            session.getTransaction().begin();
            // get an user object

            listOfUser = session.createQuery("from Responsable ").getResultList();

            // commit transaction
            session.getTransaction().commit();
            session.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("error");
            e.printStackTrace();
        }
        return listOfUser;
    }

    //return id centre
    public int insertcentreid(String centre) {
        Centre centre1 = null;

        try {
            Session session = SessionUtil.getCurrentSession();
            session.getTransaction();
            session.getTransaction().begin();
            centre1 = (Centre) session.createQuery("SELECT U FROM Centre U WHERE U.nomCentre = :centre ").setParameter("centre", centre).uniqueResult();

            session.getTransaction().commit();
            session.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("error");
        }
        return centre1.getIdCentre();
    }
    //updatestatus
    public void updateStatus(Centre centre) {
        try{
            // start a transaction
            Session session = SessionUtil.getCurrentSession();
            session.getTransaction();
            session.getTransaction().begin();
            // save the student object
            session.update(centre);
            // commit transaction
            session.persist(centre);
            session.getTransaction().commit();
            session.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("error");
            e.printStackTrace();
        }
    }
}
