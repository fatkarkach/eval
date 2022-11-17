package com.Dao;
import com.model.Promotion;
import org.hibernate.Session;

import java.util.List;

public class operationE {


    public  void start(){

                All_op_timer.main_start();

    }


    //    =============>  admin  <=================

    //    admin add date expiration
    public void add_date_expiration(Promotion expirationEntity) {
        try  {
            Session session = SessionUtil.getCurrentSession();
            session.getTransaction();
            session.getTransaction().begin();
            // save the student object
            session.save(expirationEntity);
            session.persist(expirationEntity);
            session.getTransaction().commit();
            session.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("error");
            e.printStackTrace();
        }
    }

    //    admin delete date expiration
    public void delete_date_expiration(int id) {
        try {
            // start a transaction
            Session session = SessionUtil.getCurrentSession();
            session.getTransaction();
            session.getTransaction().begin();

            // Delete a user object
            Promotion expirationEntity = session.get(Promotion.class, id);
            if (expirationEntity != null) {
                session.delete(expirationEntity);
                System.out.println("expirationEntity is deleted");
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

    public List<Promotion> getAll_Expiration_date() {
        List<Promotion> list_experation_date = null;
        try {
            Session session = SessionUtil.getCurrentSession();
            session.getTransaction();
            session.getTransaction().begin();
            // get an user object
            list_experation_date = session.createQuery("select U from  Promotion U").getResultList();
            // commit transaction
            session.getTransaction().commit();
            session.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("error");
            e.printStackTrace();
        }
        return list_experation_date;
    }


}
