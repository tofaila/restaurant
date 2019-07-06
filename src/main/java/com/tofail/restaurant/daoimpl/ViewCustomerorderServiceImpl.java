/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tofail.restaurant.daoimpl;

import com.google.gson.Gson;
import com.tofail.restaurant.dao.ViewCustomerorderService;
import com.tofail.restaurant.model.Customerorder;
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
 * @author B10
 */
@Repository
public class ViewCustomerorderServiceImpl implements ViewCustomerorderService{
     @Autowired
    SessionFactory sessionFactory;

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
        List<Customerorder> orderList = s.createQuery("from Customerorder order by orderid").list();
        List<Orderdetails> orderDetailList = s.createQuery("from Orderdetails order by orderid").list();
        //adding blank orderdetails
        for (int i = 0; i < orderList.size(); i++) {
            orderList.get(i).setOrderdetails(new ArrayList<Orderdetails>());
        }
        List<Integer> parentId = new ArrayList<>();
        List<Integer> childId = new ArrayList<>();
        //list all orderid from order
        for (int i = 0; i < orderList.size(); i++) {
            parentId.add(orderList.get(i).getOrderid());            
        }
        //list all orderid from orderdetails
        for (int i = 0; i < orderDetailList.size(); i++) {
            childId.add(orderDetailList.get(i).getOrderid());            
        }
        //List<OrderDetails> subchild;
        try {
            int index=0;
            for (int i : childId) {
            if (parentId.contains(i)) {
                //subchild = new ArrayList<>();
                System.out.println(parentId.indexOf(i)+" Match Found " + i);
                //subchild.add(orderDetailList.get(index));                
                orderList.get(parentId.indexOf(i)).getOrderdetails().add(orderDetailList.get(index));
                index++;
            }
        }
        } catch (Exception e) {
            e.printStackTrace();
        }
        //orderList.addAll(orderDetailList);
        //for (int i = 0; i < orderDetailList.size(); i++) {
            //if(orderList.get(i).getOrderid()!=0)
            //if(orderDetailList.get(i).getOrderid()==orderList.get(i).getOrderid()){
            //orderList.get(0).setOrderDetails(orderDetailList);
            //}            
        //}
        Gson g = new Gson();
        String orderListgson = g.toJson(orderList);
        t.commit();
        s.close();
        System.out.println("-----"+orderListgson);
        return orderListgson;
    }

    public Customerorder viewOneCustomerorder(int orderid) {
        return null;
    }
    
}
