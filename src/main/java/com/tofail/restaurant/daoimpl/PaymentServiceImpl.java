/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tofail.restaurant.daoimpl;

import com.google.gson.Gson;
import com.tofail.restaurant.dao.PaymentService;
import com.tofail.restaurant.model.Orderdetails;
import com.tofail.restaurant.model.Payment;
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
public class PaymentServiceImpl implements PaymentService{
     @Autowired
    SessionFactory sessionFactory;

    @Override
    public String insertPayment(Payment pm) {
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        s.save(pm);
        t.commit();
        s.close();
        return null;
    }

     @Override
    public String updatePayment(String payid, Payment pm) {
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
         Payment onepaymentobject = (Payment) s.get(Payment.class, payid);
        onepaymentobject.setCustid(pm.getCustid());
        onepaymentobject.setOrderid(pm.getOrderid());
        onepaymentobject.setPaydate(pm.getPaydate());
        onepaymentobject.setAmount(pm.getAmount());
        onepaymentobject.setPaytype(pm.getPaytype());
        s.update(onepaymentobject);
        t.commit();
        s.close();
        return null;
    }

    @Override
    public String deletePayment(String payid) {
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        Payment pm = (Payment) s.get(Payment.class, payid);
        s.delete(pm);
        t.commit();
        s.close();
        return null;
    }

    @Override
    public String viewPayment() {
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        List<Payment> paymentlist = s.createQuery("from Payment").list();
        Gson g = new Gson();
        String paymentlistgson = g.toJson(paymentlist);
        t.commit();
        s.close();
        return paymentlistgson;
    }

    @Override
    public Payment viewOnePayment(String payid) {
       Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        Payment pm = (Payment) s.get(Payment.class, payid);
		//Gson gson = new Gson();
        //String onesuppliergsonstring = gson.toJson(sm);
        t.commit();
        s.close();
        return pm;
    }
    
}
