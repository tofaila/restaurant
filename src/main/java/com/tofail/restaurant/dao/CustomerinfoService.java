/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tofail.restaurant.dao;

import com.tofail.restaurant.model.Customerinfo;
import org.springframework.stereotype.Service;

/**
 *
 * @author tofai
 */
@Service
public interface CustomerinfoService {
     public String insertCustomerinfo(Customerinfo sm);

    public String updateCustomerinfo(Customerinfo sm);

    public String deleteCustomerinfo(int id);

    public String viewCustomerinfo();
    public Customerinfo viewOneCustomerinfo(int id);

   
    
}
