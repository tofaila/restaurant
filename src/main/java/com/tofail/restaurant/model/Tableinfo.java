/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tofail.restaurant.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author B10
 */
@Entity
public class Tableinfo implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int tableid;
    String tableno;
    String totalseat;

    public int getTableid() {
        return tableid;
    }

    public void setTableid(int tableid) {
        this.tableid = tableid;
    }

    public String getTableno() {
        return tableno;
    }

    public void setTableno(String tableno) {
        this.tableno = tableno;
    }

    public String getTotalseat() {
        return totalseat;
    }

    public void setTotalseat(String totalseat) {
        this.totalseat = totalseat;
    }
    
    
    
}
