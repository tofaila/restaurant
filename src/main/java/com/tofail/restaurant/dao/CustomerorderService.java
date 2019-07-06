/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tofail.restaurant.dao;

import com.tofail.restaurant.model.Customerorder;
import org.springframework.stereotype.Service;

/**
 *
 * @author tofai
 */
@Service
public interface CustomerorderService {
     public String insertCustomerorder(Customerorder co);

    public String updateCustomerorder(int orderid, Customerorder co);

    public String deleteCustomerorder(int orderid);

    public String viewCustomerorder();

    public Customerorder viewOneCustomerorder(int orderid);
    
}
