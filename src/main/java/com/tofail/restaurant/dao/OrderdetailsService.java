/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tofail.restaurant.dao;


import com.tofail.restaurant.model.Orderdetails;
import java.util.ArrayList;
import org.springframework.stereotype.Service;

/**
 *
 * @author tofai
 */
@Service
public interface OrderdetailsService {
    public String insertOrderdetails(ArrayList<Orderdetails> orderdetails);

    public String updateOrderdetails(int orderid, Orderdetails orderdetails);

    public String deleteOrderdetails(int orderid);

    public String viewCustomerorder();

    public Orderdetails viewOneCustomerorder(int orderid);
    
}
