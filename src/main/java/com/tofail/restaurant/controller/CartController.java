/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tofail.restaurant.controller;

import com.google.gson.Gson;
import com.tofail.restaurant.dao.ProductService;
import com.tofail.restaurant.model.Cart;
import com.tofail.restaurant.model.Product;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author B10
 */
@Controller
public class CartController {
     @Autowired
    ProductService pdao;

    @RequestMapping("/showcartpage")
    public ModelAndView showCartPage(HttpSession httpSession) {
        ModelAndView mv = new ModelAndView("cart");
        Gson g = new Gson();
        ArrayList<Cart> cart = (ArrayList<Cart>) httpSession.getAttribute("usercart");
        if(cart.isEmpty()) {
            httpSession.setAttribute("cartempty", "true");
            return mv;
        } else {
            String cartgson = g.toJson(cart);
            mv.addObject("itemsincart", cartgson);
            httpSession.setAttribute("grandtotal", getGrandTotal(cart));
            httpSession.setAttribute("grandquantity", getgrandquantity(cart));
            httpSession.setAttribute("cartempty", "false");
            return mv;
        }
    }

    @RequestMapping("/addtocart")
    public String addingToCart(@RequestParam("getPid") int pid, HttpSession session) {

        Product pm = pdao.viewOneProduct(pid);
        session.setAttribute("pid", pid);
        String flag = "not inserted";
        ArrayList<Cart> cartarray = (ArrayList<Cart>) session.getAttribute("usercart");

        if (cartarray.isEmpty()) {
            cartarray.add(new Cart(pm.getPid(), pm.getPname(), 1, pm.getPrice(), pm.getPrice()));
            flag = "inserted";
        } else {
            Iterator<Cart> lit = cartarray.iterator();
            while (lit.hasNext()) {
                Cart d = lit.next();
                if (d.getPid() == pid) {
                    int index = cartarray.indexOf(d);
                    String name = d.getPname();
                    int qty = d.getQty() + 1;
                    double price = d.getPrice();
                    cartarray.remove(index);
                    cartarray.add(index, new Cart(pid, name, qty, price, ((qty) * price)));
                    session.setAttribute("usercart", cartarray);
                    flag = "inserted";
                    break;
                }
            }
            if (flag.equals("not inserted")) {
                cartarray.add(new Cart(pm.getPid(), pm.getPname(), 1, pm.getPrice(), pm.getPrice()));
                session.setAttribute("usercart", cartarray);
            }
        }
        session.setAttribute("grandquantity", getgrandquantity(cartarray));
//        UserCartDetails usercart = new UserCartDetails();
//        Integer intcart = Integer.parseInt(session.getAttribute("Cartid").toString());
//        usercart.setCartid(Integer.parseInt(session.getAttribute("Cartid").toString()));
//        usercart.setProductsincart(cartarray.toString());
//        cdao.insertCartwithProducts(usercart);
        return "redirect:/showcartpage";
    }

    public int getgrandquantity(ArrayList<Cart> items) {
        int grandquant = 0;
        ListIterator<Cart> itr = items.listIterator();
        while (itr.hasNext()) {
            Cart obj = (Cart) itr.next();
            grandquant = grandquant + obj.getQty();
        }
        return grandquant;
    }

    public double getGrandTotal(ArrayList<Cart> item) {
        double gtotal = 0;
        ListIterator<Cart> itr = item.listIterator();
        while (itr.hasNext()) {
            Cart ob = (Cart) itr.next();
            gtotal = gtotal + (ob.getQty() * ob.getPrice());
        }
        return gtotal;
    }

    @RequestMapping(value = "/editquantity")
    public String editCart(@RequestParam("getpid") int id, @RequestParam("value") String sign, HttpSession session) {
        ArrayList<Cart> c = (ArrayList<Cart>) session.getAttribute("usercart");
        Iterator<Cart> lit = c.iterator();
        while (lit.hasNext()) {
            Cart d = lit.next();
            int index = c.indexOf(d);
            if (d.getPid() == id) {
                String name = d.getPname();
                int qty = d.getQty();
                double price = d.getPrice();
                c.remove(index);
                if (sign.equals("decrease") && qty > 1) {
                    c.add(index, new Cart(id, name, qty - 1, price, ((qty + 1) * price)));
                } else if (sign.equals("decrease") && qty == 1) {
                    c.add(index, new Cart(id, name, 1, price, price));
                } else if (sign.equals("increase") && qty < 100) {
                    c.add(index, new Cart(id, name, qty + 1, price, ((qty + 1) * price)));
                } else {
                    c.add(index, new Cart(id, name, qty, price, ((qty) * price)));
                }
                break;
            }
        }
        session.setAttribute("grandquantity", getgrandquantity(c));
        session.setAttribute("usercart", c);

        return "redirect:/showcartpage";
    }

    @RequestMapping("/removeproductitem")
    public String removeproductitem(@RequestParam("pid") int pid, HttpSession session) {
        @SuppressWarnings("unchecked")
        ArrayList<Cart> cartitems = (ArrayList<Cart>) session.getAttribute("usercart");
        Iterator<Cart> list = (Iterator<Cart>) cartitems.iterator();
        while (list.hasNext()) {
            Cart c = list.next();
            if (c.getPid() == pid) {
                cartitems.remove(cartitems.indexOf(c));
                break;
            }
        }
        session.setAttribute("grandquantity", getgrandquantity(cartitems));
        session.setAttribute("usercart", cartitems);
        return "redirect:/showcartpage";
    }
    
}
