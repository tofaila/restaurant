/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tofail.restaurant.controller;

import com.tofail.restaurant.dao.CustomerinfoService;
import com.tofail.restaurant.model.Customerinfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author tofai
 */
@Controller
public class CustomerinfoController {
     @Autowired
    CustomerinfoService cdao;
    
    @RequestMapping("/showcustomerinfo")
    public ModelAndView showcustomerinfosapage() {
        String customerinfolist = cdao.viewCustomerinfo();
        //System.out.println("this is "+ supplierslist);
        ModelAndView mv = new ModelAndView("customerinfo", "newCustomerinfoObject", new Customerinfo());
        mv.addObject("customerinfolist", customerinfolist);
        mv.addObject("check", "true");
        return mv;
    }
    @RequestMapping(value = "/addingcustomerinfo", params = "Addingcustomerinfo")
    public String addsupplierpage(@ModelAttribute("newCustomerinfoObject") Customerinfo sm) {
        cdao.insertCustomerinfo(sm);
        return "redirect:/showcustomerinfo";

    }
    
    @RequestMapping(value = "/addingcustomerinfo", params = "EditingCustomerinfo")
    public String editcustomerinfopage(@ModelAttribute("newCustomerinfoObject") Customerinfo sm) {
        cdao.updateCustomerinfo(sm);
        return "redirect:/showcustomerinfo";

    }
    
    @RequestMapping("removingcustomerinfo/{custid}")
    public String removecategory(@PathVariable("custid") int custid) {
        cdao.deleteCustomerinfo(custid);
        return "redirect:/showcustomerinfo";
    }
    
    @RequestMapping("/editingcustomerinfobutton")
    public ModelAndView editcustomerinfobutton(@RequestParam("getcustid") int custid) {
        Customerinfo onecustomerinfo = (Customerinfo) cdao.viewOneCustomerinfo(custid);

        ModelAndView mv = new ModelAndView("customerinfo", "newCustomerinfoObject", onecustomerinfo);
        String customerinfogsonlist = cdao.viewCustomerinfo();
        mv.addObject("customerinfolist", customerinfogsonlist);
        mv.addObject("check", "false");
        return mv;
    }
    
}
