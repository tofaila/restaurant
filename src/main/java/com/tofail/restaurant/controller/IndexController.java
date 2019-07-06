/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tofail.restaurant.controller;

//import info.javaknowledge.project36.dao.ProductService;
import com.tofail.restaurant.dao.ProductService;
import com.tofail.restaurant.dao.ViewCustomerorderService;
import com.tofail.restaurant.model.Product;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
//import info.javaknowledge.project36.dao.ViewProductOrderService;
/**
 *
 * @author User
 */
@Controller
public class IndexController {
    @Autowired
    ProductService pdao;
    @Autowired
    ViewCustomerorderService cdao;
     @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView landingPage(HttpSession httpSession) {
        //logger.info("Inside Landingpage in home controller");
        //vdao.viewProductOrder();
        String productlist = pdao.viewProduct();
        ModelAndView mv = new ModelAndView("index");
        mv.addObject("productlist", productlist);
        //logger.info("End of Landingpage in home controller");
        return mv;
//    @RequestMapping(value = "/")
//    public String helloMessage(ModelMap map) {
//        map.addAttribute("hello", "Welcome to spring");
//        return "index";
    }
    
    
    
    
}
