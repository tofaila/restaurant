/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tofail.restaurant.dao;

import com.tofail.restaurant.model.TableType;
import org.springframework.stereotype.Service;

/**
 *
 * @author B10
 */
@Service
public interface TableTypeService {
    public String addTableType(TableType tableType);
    public String updateTableType(TableType tableType);
    public String deleteTableType(String tableno);
    public String viewAllTableType();
    public TableType viewTableType(String tableno);
    
}
