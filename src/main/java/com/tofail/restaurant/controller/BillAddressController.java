/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tofail.restaurant.controller;

import com.tofail.restaurant.dao.BillAddressService;
import com.tofail.restaurant.dao.Userservice;
import com.tofail.restaurant.model.BillAddress;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author tofai
 */
@Controller
public class BillAddressController {
    @Autowired
    BillAddressService bdao;
    @Autowired
    Userservice us;

    @RequestMapping("/billaddresspage")
    public ModelAndView billaddressPage(HttpSession httpSession) {
        String email = (String) httpSession.getAttribute("UserId");
        String addressesjson = bdao.viewBillAddresses(email);
        //User urm = us.viewUser(email);
        BillAddress bm = new BillAddress();
        bm.setEmailid(email);
        ModelAndView mv = new ModelAndView("billaddress", "billAddressObj", bm);
        mv.addObject("addressesjson", addressesjson);
        httpSession.setAttribute("newobj", "true");
        return mv;
    }

    @RequestMapping(value = "/addnewaddress", params = "addnew")
    public String addnewaddress(@ModelAttribute("billAddressObj") BillAddress billaddress, HttpSession httpSession) {
        String email = (String) httpSession.getAttribute("UserId");
        billaddress.setEmailid(email);
        bdao.insertBillAddress(billaddress);
        httpSession.setAttribute("newobj", "false");
        return "redirect:/billaddresspage";
    }

    @RequestMapping("/editaddress")
    public ModelAndView showeditaddresspage(@RequestParam("getaddressid") int addressid, HttpSession httpSession) {
        String email = (String) httpSession.getAttribute("UserId");
        String addressesjson = bdao.viewBillAddresses(email);

        BillAddress bm = (BillAddress) bdao.viewOneBillAddress(addressid);
        System.out.println("this is address line 1 " + bm.getAddresslineone());
        System.out.println("this is address line 2 " + bm.getAddresslinetwo());
        System.out.println("this is user " + bm.getEmailid());

        ModelAndView mv = new ModelAndView("billaddress");
        mv.addObject("billAddressObj", bm);
        mv.addObject("addressesjson", addressesjson);
        httpSession.setAttribute("newobj", "false");
        return mv;
    }
    
    @RequestMapping(value = "/addnewaddress", params = "edit")
    public String editingaddress(@ModelAttribute("billAddressObj") BillAddress billaddress, HttpSession httpSession) {
        String email = (String) httpSession.getAttribute("UserId");
        //User urm = us.viewUser(email);
        billaddress.setEmailid(email);
        int billaddresid = billaddress.getAddressid();
        bdao.updateBillAddress(billaddresid, billaddress);
        httpSession.setAttribute("newobj", "false");
        return "redirect:/billaddresspage";
    }

    @RequestMapping("/removeaddress")
    public String removeaddress(@RequestParam("getaddressid") int addressid, HttpSession httpSession) {

        bdao.deleteBillAddress(addressid);
        httpSession.setAttribute("newobj", "false");
        return "redirect:/billaddresspage";
    }
    
}
