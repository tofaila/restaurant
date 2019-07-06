/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tofail.restaurant.dao;

import com.tofail.restaurant.model.Customerorder;
import com.tofail.restaurant.model.Payment;
import org.springframework.stereotype.Service;

/**
 *
 * @author tofai
 */
@Service
public interface PaymentService {
     public String insertPayment(Payment pm);

    public String updatePayment(String payid, Payment pm);

    public String deletePayment(String payid);

    public String viewPayment();

    public Payment viewOnePayment(String payid);
    
    
}
