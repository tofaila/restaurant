/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tofail.restaurant.daoimpl;

import com.google.gson.Gson;
import com.tofail.restaurant.dao.BookinginfoService;
import com.tofail.restaurant.model.Bookinginfo;
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
public class BookinginfoServiceImpl implements BookinginfoService{
     @Autowired
    SessionFactory sessionFactory;

    @Override
    public String insertBookinginfo(Bookinginfo bk) {
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        s.save(bk);
        t.commit();
        s.close();
        return null;
    }

    @Override
    public String updateBookinginfo(int bookingid, Bookinginfo bk) {
       Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        Bookinginfo onebookinginfoobject = (Bookinginfo) s.get(Bookinginfo.class, bookingid);
        onebookinginfoobject.setBookingid(bk.getBookingid());
        onebookinginfoobject.setTableid(bk.getTableid());
        onebookinginfoobject.setCustid(bk.getCustid());
        onebookinginfoobject.setBookingdate(bk.getBookingdate());
        onebookinginfoobject.setBookingtime(bk.getBookingtime());
        onebookinginfoobject.setBookingcharge(bk.getBookingcharge());
        onebookinginfoobject.setOrderdetails(bk.getOrderdetails());
        s.update(onebookinginfoobject);
        t.commit();
        s.close();
        return null;
    }

    @Override
    public String deleteBookinginfo(int bookingid) {
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        Bookinginfo bk = (Bookinginfo) s.get(Bookinginfo.class, bookingid);
        s.delete(bk);
        t.commit();
        s.close();
        return null;
    }

    @Override
    public String viewBookinginfo() {
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        List<Bookinginfo> bookinginfolist = s.createQuery("from Bookinginfo").list();
        Gson g = new Gson();
        String bookinginfolistgson = g.toJson(bookinginfolist);
        t.commit();
        s.close();
        return bookinginfolistgson;
    }

    @Override
    public Bookinginfo viewOneBookinginfo(int bookingid) {
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        Bookinginfo bk = (Bookinginfo) s.get(Bookinginfo.class, bookingid);
//        Criteria criteria = s.createCriteria(Product.class).add(Restrictions.eq("productname", "A"));
//        Product p = null;
//        Object result = criteria.uniqueResult();
//            if (result != null) {
//                p = (Product) criteria.uniqueResult();
//                System.out.println("Genre = " + p.getProductname());
//            }
        t.commit();
        s.close();
        return bk;
    }
    
    
}
