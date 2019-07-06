/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tofail.restaurant.daoimpl;

import com.google.gson.Gson;
import com.tofail.restaurant.dao.WaiterinfoService;
import com.tofail.restaurant.model.Tableinfo;
import com.tofail.restaurant.model.Waiterinfo;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author B10
 */
@Repository
public class WaiterinfoServiceImpl implements WaiterinfoService{
     @Autowired
    SessionFactory sessionFactory;
    
     @Override
    public String insertWaiterinfo(Waiterinfo wa) {
        
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        s.save(wa);
        t.commit();
        s.close();
        return null;
    }

    public String updateWaiterinfo(Waiterinfo wa) {
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        //CategoriesModel cm = (CategoriesModel)s.get(CategoriesModel.class, categoryid);
        s.update(wa);
        t.commit();
        s.close();
        return null;
    }

     @Override
    public String deleteWaiterinfo(int id) {
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        Waiterinfo wa = (Waiterinfo) s.get(Waiterinfo.class, id);
        s.delete(wa);
        t.commit();
        s.close();

        return null;
    }

     @Override
    public String viewWaiterinfo() {
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        List<Waiterinfo> categorieslist = s.createQuery("from Waiterinfo").list();
        Gson g = new Gson();
        String categorylistgson = g.toJson(categorieslist);
        t.commit();
        s.close();
        //System.out.println(categorylistgson);
        return categorylistgson;
    }

     @Override
    public Waiterinfo viewOneWaiterinfo(int id) {
       Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        Waiterinfo wa = (Waiterinfo) s.get(Waiterinfo.class, id);
        t.commit();
        s.close();
        return wa;
    }

   

   
    
}
