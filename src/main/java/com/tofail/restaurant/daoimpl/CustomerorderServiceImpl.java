/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tofail.restaurant.daoimpl;

import com.google.gson.Gson;
import com.tofail.restaurant.dao.CustomerorderService;
import com.tofail.restaurant.model.Customerorder;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author tofai
 */
@Repository
public class CustomerorderServiceImpl implements CustomerorderService{
     @Autowired
    SessionFactory sessionFactory;

     @Override
    public String insertCustomerorder(Customerorder order) {
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        s.save(order);
        t.commit();
        s.close();
        return null;
    }
     @Override
    public String updateCustomerorder(int orderid, Customerorder order) {
       
        return null;
    }

     @Override
    public String deleteCustomerorder(int orderid) {
       
        return null;
    }

     @Override
   public String viewCustomerorder() {
      Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        List<Customerorder> customerorderlist = s.createQuery("from Customerorder").list();
        Gson g = new Gson();
        String customerorderlistgson = g.toJson(customerorderlist);
        t.commit();
        s.close();
        return customerorderlistgson;
    }

     @Override
    public Customerorder viewOneCustomerorder(int orderid) {
       
        return null;
    }
    
}
