/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tofail.restaurant.dao;

import com.tofail.restaurant.model.Bookinginfo;
import org.springframework.stereotype.Service;

/**
 *
 * @author tofai
 */
@Service
public interface BookinginfoService {
     public String insertBookinginfo(Bookinginfo bk);

    public String updateBookinginfo(int bookingid, Bookinginfo bk);

    public String deleteBookinginfo(int bookingid);

    public String viewBookinginfo();

    public Bookinginfo viewOneBookinginfo(int bookingid);
    
}
