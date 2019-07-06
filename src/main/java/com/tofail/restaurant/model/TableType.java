/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tofail.restaurant.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author B10
 */
@Entity
public class TableType implements Serializable{

    @Id
   String tableno;
   

    public String getTableno() {
        return tableno;
    }

    public void setTableno(String tableno) {
        this.tableno = tableno;
    }

//    public String getTotalseat() {
//        return totalseat;
//    }
//
//    public void setTotalseat(String totalseat) {
//        this.totalseat = totalseat;
//    }
    
    
}
