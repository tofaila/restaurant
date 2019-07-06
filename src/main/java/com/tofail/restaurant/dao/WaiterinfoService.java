/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tofail.restaurant.dao;

import com.tofail.restaurant.model.Tableinfo;
import com.tofail.restaurant.model.Waiterinfo;
import org.springframework.stereotype.Service;

/**
 *
 * @author B10
 */
@Service
public interface WaiterinfoService {
     public String insertWaiterinfo(Waiterinfo wa);

    public String updateWaiterinfo(Waiterinfo wa);

    public String deleteWaiterinfo(int id);

    public String viewWaiterinfo();

    public Waiterinfo viewOneWaiterinfo(int id);
    
}
