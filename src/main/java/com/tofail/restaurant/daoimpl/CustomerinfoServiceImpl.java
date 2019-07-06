/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tofail.restaurant.daoimpl;

import com.google.gson.Gson;
import com.tofail.restaurant.dao.CustomerinfoService;
import com.tofail.restaurant.model.Customerinfo;
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
public class CustomerinfoServiceImpl implements CustomerinfoService {
    @Autowired
    SessionFactory sessionFactory;

    @Override
    public String insertCustomerinfo(Customerinfo sm) {
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        s.save(sm);
        t.commit();
        s.close();
        return null;
    }

    @Override
    public String updateCustomerinfo(Customerinfo sm) {
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        s.update(sm);
        t.commit();
        s.close();
        return null;
    }

    @Override
    public String deleteCustomerinfo(int id) {
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        Customerinfo sm = (Customerinfo) s.get(Customerinfo.class, id);
        s.delete(sm);
        t.commit();
        s.close();
        return null;
    }

    @Override
    public String viewCustomerinfo() {
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        List<Customerinfo> customerinfolist = s.createQuery("from Customerinfo").list();
        Gson g = new Gson();
        String customerinfolistgson = g.toJson(customerinfolist);
        t.commit();
        s.close();
        return customerinfolistgson;
    }

    @Override
    public Customerinfo viewOneCustomerinfo(int id) {
       Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        Customerinfo sm = (Customerinfo) s.get(Customerinfo.class, id);
		//Gson gson = new Gson();
        //String onesuppliergsonstring = gson.toJson(sm);
        t.commit();
        s.close();
        return sm;
    }

   

   
   
    
  
    
}
