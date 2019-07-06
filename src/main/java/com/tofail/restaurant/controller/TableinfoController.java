/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tofail.restaurant.controller;

import com.tofail.restaurant.dao.TableinfoService;
import com.tofail.restaurant.model.Tableinfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TableinfoController {
    @Autowired
    TableinfoService cat;

    @RequestMapping("/showtablepage")
    public ModelAndView showcatpage() {
        String categorygsonlist = cat.viewTableinfo();
        ModelAndView mv = new ModelAndView("tableinfo", "addTableinfoObject1", new Tableinfo());
        mv.addObject("tableinfomodelobject", categorygsonlist);
        mv.addObject("check", "true");
        return mv;
    }
    @RequestMapping(value = "/addingtableinfo", params = "Addtableinfo")
    public String insertTableinfo(@ModelAttribute("addTableinfoObject1") Tableinfo cm) {
        //String categorygsonlist = cdao.viewCategory();
        //ModelAndView mv =new ModelAndView("AddCategory");
        cat.insertTableinfo(cm);
        //mv.addObject("categorymodelobject", categorygsonlist);
        return "redirect:/showtablepage";
    }

    @RequestMapping(value = "/addingtableinfo", params = "EditTableinfo")
    public String editTableinfo(@ModelAttribute("addTableinfoObject1") Tableinfo cm) {

        //ModelAndView mv =new ModelAndView("AddCategory");
        cat.updateTableinfo(cm);
        return "redirect:/showtablepage";
    }

    @RequestMapping("removetableinfo/{Id}")
    public String removetableinfo(@PathVariable("Id") int tableId) {
        cat.deleteTableinfo(tableId);
        return "redirect:/showtablepage";
    }

    @RequestMapping("/edittableinfobutton")
    public ModelAndView passingonetableinfo(@RequestParam("gettableid") int tableId) {

        Tableinfo onetableinfo = cat.viewOneTableinfo(tableId);
        String tableinfosonlist = cat.viewTableinfo();
        ModelAndView mv = new ModelAndView("tableinfo", "addTableinfoObject1", onetableinfo);
        mv.addObject("tableinfomodelobject", tableinfosonlist);
        mv.addObject("check", "false");
        return mv;
    }
     @RequestMapping(value = "/index", method = RequestMethod.GET)
     String showIndex() {
        return "index";
    }
     @RequestMapping(value = "/about", method = RequestMethod.GET)
    public String showAbout() {
        return "about";
    }
     @RequestMapping(value = "/blog", method = RequestMethod.GET)
    public String showBlog() {
        return "blog";
    }
     @RequestMapping(value = "/contact", method = RequestMethod.GET)
    public String showContact() {
        return "contact";
    }
     @RequestMapping(value = "/specialties", method = RequestMethod.GET)
    public String showSpecialties() {
        return "specialties";
    }
     @RequestMapping(value = "/showdashboard", method = RequestMethod.GET)
    public String showDashboard() {
        return "dashboard";
    }
    
    
    
     @RequestMapping(value = "/index_old", method = RequestMethod.GET)
    public String showIndex_old() {
        return "index_old";
    }

}
