/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tofail.restaurant.dao;

import com.tofail.restaurant.model.Tableinfo;
import org.springframework.stereotype.Service;

@Service
public interface TableinfoService {
     public String insertTableinfo(Tableinfo cm);

    public String updateTableinfo(Tableinfo cm);

    public String deleteTableinfo(int tableid);

    public String viewTableinfo();

    public Tableinfo viewOneTableinfo(int tableid);
}
