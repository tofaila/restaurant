/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tofail.restaurant.dao;

import com.tofail.restaurant.model.BillAddress;
import org.springframework.stereotype.Service;

/**
 *
 * @author tofai
 */
@Service
public interface BillAddressService {
     public String insertBillAddress(BillAddress billaddress);

    public String updateBillAddress(int addressid, BillAddress billaddress);

    public String deleteBillAddress(int addressid);

    public String viewBillAddresses(String emailid);

    public BillAddress viewOneBillAddress(int bid);
    
}
