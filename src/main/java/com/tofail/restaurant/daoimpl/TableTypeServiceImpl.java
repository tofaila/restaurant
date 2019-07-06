/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tofail.restaurant.daoimpl;

import com.google.gson.Gson;
import com.tofail.restaurant.dao.TableTypeService;
import com.tofail.restaurant.model.TableType;
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
public class TableTypeServiceImpl implements TableTypeService{
     @Autowired
    SessionFactory sessionFactory;

    @Override
    public String addTableType(TableType tableType) {
       Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        s.save(tableType);
        t.commit();
        s.close();
        return null; 
    }

    @Override
    public String updateTableType(TableType tableType) {
      Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        //CategoriesModel cm = (CategoriesModel)s.get(CategoriesModel.class, categoryid);
        s.update(tableType);
        t.commit();
        s.close();
        return null;
    }

     @Override
    public String deleteTableType(String tableno) {
       Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        TableType tableType = (TableType) s.get(TableType.class, tableno);
        s.delete(tableType);
        t.commit();
        s.close();

        return null;
    }

    @Override
    public String viewAllTableType() {
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        List<TableType> tableTypelist = s.createQuery("from TableType").list();
//        json class Gson object g
        Gson g = new Gson();
        String tableTypelistgson = g.toJson(tableTypelist);
        t.commit();
        s.close();
        //System.out.println(categorylistgson);
        return tableTypelistgson;
    }

    public TableType viewTableType(String tableno) {
         Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        TableType rm = (TableType) s.get(TableType.class, tableno);
        t.commit();
        s.close();
        Gson g = new Gson();
        String categorygson = g.toJson(rm);
        return rm;
    } 
}
