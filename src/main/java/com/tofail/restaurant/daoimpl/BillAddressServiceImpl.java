/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tofail.restaurant.daoimpl;

import com.google.gson.Gson;
import com.tofail.restaurant.dao.BillAddressService;
import com.tofail.restaurant.model.BillAddress;
import java.util.ArrayList;
import java.util.Iterator;
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
public class BillAddressServiceImpl implements BillAddressService{
    @Autowired
    SessionFactory sessionFactory;

    @Override
    public String insertBillAddress(BillAddress billaddress) {
        Session s = sessionFactory.openSession();
        Transaction tr = s.getTransaction();
        tr.begin();
        s.save(billaddress);
        tr.commit();
        s.close();

        return null;
    }

    @Override
    public String updateBillAddress(int addressid, BillAddress billaddress) {
        Session s = sessionFactory.openSession();
        Transaction tr = s.getTransaction();
        tr.begin();
        BillAddress bm = (BillAddress) s.get(BillAddress.class, addressid);

        bm.setAddressid(billaddress.getAddressid());
        bm.setAddresslineone(billaddress.getAddresslineone());
        bm.setAddresslinetwo(billaddress.getAddresslinetwo());
        bm.setCountry(billaddress.getCountry());
        bm.setCity(billaddress.getCity());
        bm.setStatename(billaddress.getStatename());
        bm.setPhone(billaddress.getPhone());
        bm.setEmailid(billaddress.getEmailid());

        s.update(bm);

        tr.commit();
        s.close();
        return null;
    }

    @Override
    public String deleteBillAddress(int addressid) {
        Session s = sessionFactory.openSession();
        Transaction tr = s.getTransaction();
        tr.begin();
        BillAddress bm = (BillAddress) s.get(BillAddress.class, addressid);
        s.delete(bm);
        tr.commit();
        s.close();
        return null;
    }

    @Override
    public String viewBillAddresses(String emailid) {
        Session s = sessionFactory.openSession();
        Transaction tr = s.getTransaction();
        tr.begin();
        ArrayList<BillAddress> addressarray = new ArrayList<BillAddress>();
        List<BillAddress> addresslist = s.createQuery("from BillAddress").list();
        Iterator<BillAddress> iterator = addresslist.iterator();
        while (iterator.hasNext()) {
            BillAddress bam = iterator.next();
            if (bam.getEmailid().equals(emailid)) {
                addressarray.add(bam);
            }
        }
        Gson gson = new Gson();
        String addressjsonlist = gson.toJson(addressarray);
        tr.commit();
        s.close();
        return addressjsonlist;
    }

    @Override
    public BillAddress viewOneBillAddress(int bid) {
        Session s = sessionFactory.openSession();
        Transaction tr = s.getTransaction();
        tr.begin();
        BillAddress oneaddressobj = (BillAddress) s.get(BillAddress.class, bid);
        tr.commit();
        s.close();
        return oneaddressobj;
    }
    
}
