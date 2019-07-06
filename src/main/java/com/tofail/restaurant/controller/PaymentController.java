/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tofail.restaurant.controller;

import com.tofail.restaurant.dao.CustomerinfoService;
import com.tofail.restaurant.dao.CustomerorderService;
import com.tofail.restaurant.dao.OrderdetailsService;
import com.tofail.restaurant.dao.PaymentService;
import com.tofail.restaurant.dao.ProductService;
import com.tofail.restaurant.model.Orderdetails;
import com.tofail.restaurant.model.Payment;
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
public class PaymentController {
     @Autowired
    PaymentService pdao;
    @Autowired
    CustomerinfoService cdao;
    @Autowired
    CustomerorderService tdao;
   

    
     @InitBinder
    public void myInitBinder(WebDataBinder binder) {
        //binder.setDisallowedFields(new String[]{"empMobile"});
        SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
        binder.registerCustomEditor(Date.class, "paydate", new CustomDateEditor(format, false));
//        binder.registerCustomEditor(String.class, "ename", new EmployeeNameEditor());
   }
     @RequestMapping("/showpaymentpage")
    public ModelAndView showorderdetailspage() {
        String paymentlist = pdao.viewPayment();
         String customerinfolist = cdao.viewCustomerinfo();
        String customerorderlist = tdao.viewCustomerorder();
       
        
      

        ModelAndView mv = new ModelAndView("payment", "newPaymentObject", new Payment());
        mv.addObject("paymentlist", paymentlist);
         mv.addObject("customerinfolist", customerinfolist);
        mv.addObject("customerorderlist", customerorderlist);
       
         mv.addObject("check", "true");
        return mv;
    }
     @RequestMapping(value = "/addingpayment", params = "Addingpayment")
    public String addorderdetailspage(@ModelAttribute("newPaymentObject") Payment pm) {
       pdao.insertPayment(pm);
        return "redirect:/showpaymentpage";

    }
    
    @RequestMapping(value = "/addingpayment", params = "EditingPayment")
    public String editorderdetailspage(@ModelAttribute("newPaymentObject") Payment pm) {
        pdao.updatePayment(pm.getPayid(),pm);
        return "redirect:/showpaymentpage";

    }
    
    @RequestMapping("removingpayment/{payid}")
    public String removepayment(@PathVariable("payid") String payid) {
        pdao.deletePayment(payid);
        return "redirect:/showpaymentpage";
    }
    
    @RequestMapping("/editingpaymentbutton")
    public ModelAndView editpaymentbutton(@RequestParam("getpayid") String payid) {
        Payment onepayment= (Payment) pdao.viewOnePayment(payid);

        ModelAndView mv = new ModelAndView("payment", "newPaymentObject", onepayment);
        String paymentlist=pdao.viewPayment();
         String customerinfolist =cdao.viewCustomerinfo();
        String customerordergsonlist = tdao.viewCustomerorder();
       
        mv.addObject("paymentlist", paymentlist);
         mv.addObject("customerinfolist", customerinfolist);
        mv.addObject("customerorderlist", customerordergsonlist);
       
        mv.addObject("check", "false");
        return mv;
    }
    
}
