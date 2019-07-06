/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tofail.restaurant.controller;

import com.google.gson.Gson;
import com.tofail.restaurant.dao.BillAddressService;
import com.tofail.restaurant.dao.CustomerorderService;
import com.tofail.restaurant.dao.OrderdetailsService;
import com.tofail.restaurant.dao.ProductService;
import com.tofail.restaurant.model.BillAddress;
import com.tofail.restaurant.model.Cart;
import com.tofail.restaurant.model.Customerorder;
import com.tofail.restaurant.model.Orderdetails;
import com.tofail.restaurant.model.Product;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author tofai
 */
@Controller
public class InvoiceController {
     @Autowired
    BillAddressService bdao;
    @Autowired
    CustomerorderService cdao;
    @Autowired
    OrderdetailsService odetdao;
    @Autowired
    ProductService pdao;

    @RequestMapping("/generatinginvoice")
    public ModelAndView showingReceipt(@RequestParam("getaddressid") int addressid, HttpSession httpSession) {
        BillAddress bm = (BillAddress) bdao.viewOneBillAddress(addressid);
        ArrayList<Cart> c = (ArrayList<Cart>) httpSession.getAttribute("usercart");
        Gson g = new Gson();
        String cartgson = g.toJson(c);
        String addressgson = g.toJson(bm);
        String currentDateTimeString = DateFormat.getDateTimeInstance().format(new Date());
        System.out.println("this is date  " + currentDateTimeString);

        ModelAndView mv = new ModelAndView("invoice");
        mv.addObject("addressobject", addressgson);
        mv.addObject("itemsincart", cartgson);
        mv.addObject("bill", "true");
        httpSession.setAttribute("addressid", addressid);
        httpSession.setAttribute("Date", currentDateTimeString);

        httpSession.setAttribute("usercart", c);
        httpSession.setAttribute("grandquantity", 0);
        return mv;
    }

    @RequestMapping("/confirmorder")
    public ModelAndView confirmOrder(@RequestParam("getaddressid") int addressid, HttpSession httpSession) {
        BillAddress bm = (BillAddress) bdao.viewOneBillAddress(addressid);
        ArrayList<Cart> c = (ArrayList<Cart>) httpSession.getAttribute("usercart");
        String email = (String) httpSession.getAttribute("UserId");
        Customerorder corder = new Customerorder();
        corder.setUseremail(email);
        corder.setAddressid(addressid);
        cdao.insertCustomerorder(corder);
        ArrayList<Orderdetails> odetails = new ArrayList<Orderdetails>();
        for (Cart cart : c) {
            Orderdetails sorder = new Orderdetails();
            sorder.setOrderid(corder.getOrderid());
            sorder.setPid(cart.getPid());
            sorder.setQuantity(cart.getQty());
            sorder.setPrice(cart.getPrice());
            odetails.add(sorder);
            // get product and update quantity
            Product p = pdao.viewOneProduct(cart.getPid());
            p.setQuantity(p.getQuantity()-cart.getQty());
            pdao.updateProduct(cart.getPid(), p);
            
        }
        odetdao.insertOrderdetails(odetails);
        odetails.removeAll(odetails);
        ModelAndView mv = new ModelAndView("invoice");
        mv.addObject("bill", "false");
        mv.addObject("success", "true");
        mv.addObject("orderid", corder.getOrderid());
        httpSession.setAttribute("usercart", new ArrayList<Cart>());
        httpSession.setAttribute("grandquantity", 0);
        return mv;
    }
    
}
