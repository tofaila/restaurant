/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tofail.restaurant.daoimpl;

import com.google.gson.Gson;
import com.tofail.restaurant.dao.OrderdetailsService;

import com.tofail.restaurant.model.Orderdetails;
import java.util.ArrayList;
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
public class OrderdetailsServiceImpl implements OrderdetailsService{
     @Autowired
    SessionFactory sessionFactory;

     @Override
    public String insertOrderdetails(ArrayList<Orderdetails> orderdetails) {
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        for(Orderdetails details : orderdetails)
        s.save(details);
        t.commit();
        s.close();
        return null;
    }
     @Override
    public String updateOrderdetails(int orderid, Orderdetails orderdetails) {
      
        return null;
    }

     @Override
    public String deleteOrderdetails(int orderid) {
       
        return null;
    }

     @Override
    public String viewCustomerorder() {
       
        return null;
    }

     @Override
    public Orderdetails viewOneCustomerorder(int orderid) {
       
        return null;
    }

   
   
    
}
