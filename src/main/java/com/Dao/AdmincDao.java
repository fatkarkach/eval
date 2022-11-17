package com.Dao;

import com.model.Stock;
import com.model.Users;
import org.hibernate.Session;
import java.util.List;

public class AdmincDao {
    public void savepro(Stock stock) {
        try  {
            Session session = SessionUtil.getCurrentSession();
            session.getTransaction();
            session.getTransaction().begin();

            // save the student object
            session.save(stock);
            session.persist(stock);
            session.getTransaction().commit();
            session.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("error");
            e.printStackTrace();
        }
    }
    public List<Stock> getAllStock() {
        List< Stock > listOfStock = null;
        try {
            Session session = SessionUtil.getCurrentSession();
            session.getTransaction();
            session.getTransaction().begin();
            // get an user object

            listOfStock = session.createQuery("from Stock ").getResultList();

            // commit transaction
            session.getTransaction().commit();
            session.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("error");
            e.printStackTrace();
        }
        return listOfStock;
    }


    public Stock getStokes(int id) {
         Stock stock= null;
        try {
            Session session = SessionUtil.getCurrentSession();
            session.getTransaction();
            session.getTransaction().begin();
            // get an user object
            stock = (Stock) session.createQuery("select s from Stock s where s.idStock=:id", Stock.class).setParameter("id", id).uniqueResult();
            // commit transaction
            session.getTransaction().commit();
            session.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("error");
            e.printStackTrace();
        }
        return stock;
    }
    //get user
    public Users getuser(int id) {
        Users users= null;
        try {
            Session session = SessionUtil.getCurrentSession();
            session.getTransaction();
            session.getTransaction().begin();
            // get an user object
            users = (Users) session.createQuery("select s from Users s where s.idUsers=:id", Users.class).setParameter("id", id).uniqueResult();
            // commit transaction
            session.getTransaction().commit();
            session.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("error");
            e.printStackTrace();
        }
        return users;
    }
    //delete
    public void deleteAdminc(int id) {


        try {
            // start a transaction
            Session session = SessionUtil.getCurrentSession();
            session.getTransaction();
            session.getTransaction().begin();

            // Delete a user object
            Stock stock = session.get(Stock.class, id);
            if (stock != null) {
                session.delete(stock);
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
    //update product
    public void updatepro(Stock stock) {
        try{
            // start a transaction
            Session session = SessionUtil.getCurrentSession();
            session.getTransaction();
            session.getTransaction().begin();
            // save the student object
            session.update(stock);
            // commit transaction
            session.persist(stock);
            session.getTransaction().commit();
            session.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("error");
            e.printStackTrace();
        }
    }
}
