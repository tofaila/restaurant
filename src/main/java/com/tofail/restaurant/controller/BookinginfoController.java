/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tofail.restaurant.controller;

import com.tofail.restaurant.dao.BookinginfoService;
import com.tofail.restaurant.dao.CustomerinfoService;
import com.tofail.restaurant.dao.CustomerorderService;
import com.tofail.restaurant.dao.OrderdetailsService;
import com.tofail.restaurant.dao.ProductService;
import com.tofail.restaurant.dao.TableinfoService;
import com.tofail.restaurant.model.Bookinginfo;

import java.text.SimpleDateFormat;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
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
public class BookinginfoController {
     @Autowired
    BookinginfoService bdao;
    @Autowired
    TableinfoService tdao;
    @Autowired
    CustomerinfoService cdao;
   

    
     @InitBinder
    public void myInitBinder(WebDataBinder binder) {
        //binder.setDisallowedFields(new String[]{"empMobile"});
        SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
        binder.registerCustomEditor(Date.class, "bookingdate", new CustomDateEditor(format, false));
//        binder.registerCustomEditor(String.class, "ename", new EmployeeNameEditor());
    }
     @RequestMapping("/showbookinginfo")
    public ModelAndView showbookinginfopage() {
        String bookinginfolist = bdao.viewBookinginfo();
        String tableinfolist = tdao.viewTableinfo();
        String customerinfolist = cdao.viewCustomerinfo();
        
      

        ModelAndView mv = new ModelAndView("bookinginfo", "newBookinginfoObject", new Bookinginfo());
        mv.addObject("bookinginfolist", bookinginfolist);
        mv.addObject("tableinfolist", tableinfolist);
        mv.addObject("customerinfolist", customerinfolist);
         mv.addObject("check", "true");
        return mv;
    }
     @RequestMapping(value = "/addingbookinginfo", params = "Add")
    public String addbookinginfopage(@ModelAttribute("newBookinginfoObject") Bookinginfo bk) {
       bdao.insertBookinginfo(bk);
        return "redirect:/showbookinginfo";

    }
    
    @RequestMapping(value = "/bookinginfolist/addingbookinginfo", params = "Edit")
    public String editbookinginfopage(@ModelAttribute("newBookinginfoObject") Bookinginfo bk) {
        bdao.updateBookinginfo(bk.getBookingid(),bk);
        return "redirect:/showbookinginfo";

    }
    
    @RequestMapping("removingbookinginfo/{bookingid}")
    public String removebookinginfo(@PathVariable("bookingid") int bookingid) {
        bdao.deleteBookinginfo(bookingid);
        return "redirect:/showbookinginfo";
    }
    
    @RequestMapping("/editingbookinginfobutton")
    public ModelAndView editbookinginfobutton(@RequestParam("getbookingid") int bookingid) {
        Bookinginfo onebookinginfo= (Bookinginfo) bdao.viewOneBookinginfo(bookingid);

        ModelAndView mv = new ModelAndView("bookinginfo", "newBookinginfoObject", onebookinginfo);
        String bookinginfolist=bdao.viewBookinginfo();
        String tableinfogsonlist = tdao.viewTableinfo();
        String customerinfolist =cdao.viewCustomerinfo();
        mv.addObject("bookinginfolist", bookinginfolist);
        mv.addObject("tableinfolist", tableinfogsonlist);
        mv.addObject("customerinfolist", customerinfolist);
        mv.addObject("check", "false");
        return mv;
    }
    
    
}
