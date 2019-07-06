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
 * @author B10
 */
@Service
public interface ViewCustomerorderService {
     public String updateCustomerorder(int orderid, Customerorder order);

    public String deleteCustomerorder(int orderid);

    public String viewCustomerorder();

    public Customerorder viewOneCustomerorder(int orderid);
    
}
