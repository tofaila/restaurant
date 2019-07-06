/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tofail.restaurant.dao;

import com.tofail.restaurant.model.Product;

/**
 *
 * @author B10
 */
public interface ProductService {
    public String insertProduct(Product pm);

    public String updateProduct(int pid, Product pm);

    public String deleteProduct(int pid);

    public String viewProduct();

    public Product viewOneProduct(int pid);

   

    
    
}
