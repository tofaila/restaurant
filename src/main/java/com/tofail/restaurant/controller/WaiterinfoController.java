/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tofail.restaurant.controller;

import com.tofail.restaurant.dao.CustomerinfoService;
import com.tofail.restaurant.dao.WaiterinfoService;
import com.tofail.restaurant.model.Customerinfo;
import com.tofail.restaurant.model.Waiterinfo;
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
public class WaiterinfoController {
      @Autowired
    WaiterinfoService wdao;
    
    @RequestMapping("/showwaiterinfo")
    public ModelAndView showwaiterinfopage() {
        String waiterinfolist = wdao.viewWaiterinfo();
        //System.out.println("this is "+ supplierslist);
        ModelAndView mv = new ModelAndView("waiterinfo", "newWaiterinfoObject", new Waiterinfo());
        mv.addObject("waiterinfolist", waiterinfolist);
        mv.addObject("check", "true");
        return mv;
    }
    @RequestMapping(value = "/addingwaiterinfo", params = "Addingwaiterinfo")
    public String addwaiterinfopage(@ModelAttribute("newWaiterinfoObject") Waiterinfo wa) {
        wdao.insertWaiterinfo(wa);
        return "redirect:/showwaiterinfo";

    }
    
    @RequestMapping(value = "/addingwaiterinfo", params = "EditingWaiterinfo")
    public String editwaiterinfopage(@ModelAttribute("newWaiterinfoObject") Waiterinfo wa) {
        wdao.updateWaiterinfo(wa);
        return "redirect:/showwaiterinfo";

    }
    
    @RequestMapping("removingwaiterinfo/{waiterid}")
    public String removecategory(@PathVariable("waiterid") int waiterid) {
        wdao.deleteWaiterinfo(waiterid);
        return "redirect:/showwaiterinfo";
    }
    
    @RequestMapping("/editingwaiterinfobutton")
    public ModelAndView editwaiterinfobutton(@RequestParam("getwaiterid") int waiterid) {
        Waiterinfo onewaiterinfo = (Waiterinfo) wdao.viewOneWaiterinfo(waiterid);

        ModelAndView mv = new ModelAndView("waiterinfo", "newWaiterinfoObject", onewaiterinfo);
        String waiterinfogsonlist = wdao.viewWaiterinfo();
        mv.addObject("waiterinfolist", waiterinfogsonlist);
        mv.addObject("check", "false");
        return mv;
    }
    
}
