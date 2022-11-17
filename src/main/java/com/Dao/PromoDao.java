package com.Dao;

import com.model.Promotion;
import com.model.Stock;
import org.hibernate.Session;

import java.util.List;

public class PromoDao {
    public int insertid(String produit) {
        Stock stock = null;

        try {
            Session session = SessionUtil.getCurrentSession();
            session.getTransaction();
            session.getTransaction().begin();
            stock = (Stock) session.createQuery("SELECT U FROM Stock U WHERE U.produit = :produit ").setParameter("produit", produit).uniqueResult();

            session.getTransaction().commit();
            session.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("error");
        }
        return stock.getIdStock();
    }
    public int insertprix(String produit) {
        Stock stock = null;
        int prix = 0;
        try {
            Session session = SessionUtil.getCurrentSession();
            session.getTransaction();
            session.getTransaction().begin();
            stock = (Stock) session.createQuery("SELECT U FROM Stock U WHERE U.produit = :produit ").setParameter("produit", produit).uniqueResult();
            prix = stock.getPrix();
            session.getTransaction().commit();
            session.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("error");
        }
        return prix;
    }
    public void savepromo(Promotion promo) {
        try  {
            Session session = SessionUtil.getCurrentSession();
            session.getTransaction();
            session.getTransaction().begin();
            // save the student object
            session.save(promo);
            session.persist(promo);
            session.getTransaction().commit();
            session.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("error");
            e.printStackTrace();
        }
    }
    public List<Stock> getAllStockPromo() {
        List<Stock> listOfStock = null;
        try {
            Session session = SessionUtil.getCurrentSession();
            session.getTransaction();
            session.getTransaction().begin();
            // get an user object

            listOfStock = session.createQuery("select s from Stock s ", Stock.class).getResultList();

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
    public List<Promotion> getAllPromo() {
        List<Promotion> listOfPromotion = null;
        try {
            Session session = SessionUtil.getCurrentSession();
            session.getTransaction();
            session.getTransaction().begin();
            // get an user object

            listOfPromotion = session.createQuery("select s from Promotion s ", Promotion.class).getResultList();

            // commit transaction
            session.getTransaction().commit();
            session.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("error");
            e.printStackTrace();
        }
        return listOfPromotion;
    }

    public void appdisp(Promotion promotion) {
        try{
            // start a transaction
            Session session = SessionUtil.getCurrentSession();
            session.getTransaction();
            session.getTransaction().begin();
            // save the student object
            session.update(promotion);
            // commit transaction
            session.persist(promotion);
            session.getTransaction().commit();
            session.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("error");
            e.printStackTrace();
        }
    }

}
