/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tofail.restaurant.daoimpl;

import com.google.gson.Gson;
import com.tofail.restaurant.model.Product;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.tofail.restaurant.dao.ProductService;

/**
 *
 * @author B10
 */
@Repository
public class ProductServiceImpl implements ProductService {
     @Autowired
    SessionFactory sessionFactory;

    @Override
    public String insertProduct(Product pm) {
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        s.save(pm);
        t.commit();
        s.close();
        return null;
    }

    @Override
    public String updateProduct(int pid, Product pm) {
       Session s = sessionFactory.openSession();
         
        Transaction t = s.getTransaction();
        t.begin();
        s.update(pm);
        t.commit();
        s.close();
        return null;
    }

    @Override
    public String deleteProduct(int pid) {
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        Product pm = (Product) s.get(Product.class, pid);
        s.delete(pm);
        t.commit();
        s.close();
        return null;
    }

    @Override
    public String viewProduct() {
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        List<Product> productlist = s.createQuery("from Product").list();
        Gson g = new Gson();
        String productlistgson = g.toJson(productlist);
        t.commit();
        s.close();
        return productlistgson;
    }

    @Override
    public Product viewOneProduct(int pid) {
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        Product pm = (Product) s.get(Product.class, pid);
//        Criteria criteria = s.createCriteria(Product.class).add(Restrictions.eq("productname", "A"));
//        Product p = null;
//        Object result = criteria.uniqueResult();
//            if (result != null) {
//                p = (Product) criteria.uniqueResult();
//                System.out.println("Genre = " + p.getProductname());
//            }
        t.commit();
        s.close();
        return pm;
    }

   

    
    }
