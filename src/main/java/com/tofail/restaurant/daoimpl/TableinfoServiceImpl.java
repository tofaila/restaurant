/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tofail.restaurant.daoimpl;

import com.google.gson.Gson;
import com.tofail.restaurant.dao.TableinfoService;
import com.tofail.restaurant.model.Tableinfo;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class TableinfoServiceImpl implements TableinfoService {
    @Autowired
    SessionFactory sessionFactory;
    
    @Override
    public String insertTableinfo(Tableinfo cm) {
        
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        s.save(cm);
        t.commit();
        s.close();
        return null;
    }

    @Override
    public String updateTableinfo(Tableinfo cm) {
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        //CategoriesModel cm = (CategoriesModel)s.get(CategoriesModel.class, categoryid);
        s.update(cm);
        t.commit();
        s.close();
        return null;
    }

    @Override
    public String deleteTableinfo(int tableid) {
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        Tableinfo cm = (Tableinfo) s.get(Tableinfo.class, tableid);
        s.delete(cm);
        t.commit();
        s.close();

        return null;
    }

    @Override
    public String viewTableinfo() {
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        List<Tableinfo> categorieslist = s.createQuery("from Tableinfo").list();
        Gson g = new Gson();
        String categorylistgson = g.toJson(categorieslist);
        t.commit();
        s.close();
        //System.out.println(categorylistgson);
        return categorylistgson;
    }

    @Override
    public Tableinfo viewOneTableinfo(int tableid) {
       Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        Tableinfo cm = (Tableinfo) s.get(Tableinfo.class, tableid);
        t.commit();
        s.close();
        return cm;
    }
}
