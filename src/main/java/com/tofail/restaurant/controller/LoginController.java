/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tofail.restaurant.controller;

import com.tofail.restaurant.dao.CustomerorderService;
import com.tofail.restaurant.dao.Userservice;
import com.tofail.restaurant.model.Cart;

import com.tofail.restaurant.model.User;
import java.util.ArrayList;
import java.util.Collection;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author B10
 */
@Controller
public class LoginController {
    
      @Autowired
    Userservice user;
    
    @Autowired
    CustomerorderService cdao;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String showLogin() {
        return "login";
    }
    
    @RequestMapping("/perlogcheck")
    public String prologin(HttpSession session, @RequestParam("getPid") int id) {
        //logger.info("Inside prologin method in login controller");
        session.setAttribute("pid", id);
        //logger.info("end of prologin method in login controller");
        return "login";
    }

    @RequestMapping(value = "/welcome", method = RequestMethod.GET)
    public String showWelcome() {
        return "welcome";
    }
    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public ModelAndView showAdmin() {
        String customerorderlist = cdao.viewCustomerorder();
        ModelAndView mv = new ModelAndView("admin");
        mv.addObject("customerorderlist", customerorderlist);
        //logger.info("End of Landingpage in home controller");
        return mv;
    }

    @RequestMapping(value = "/loginsuccess")
    public String loginsuccess(HttpSession session) {
        System.out.println("success..........");

        String userid = SecurityContextHolder.getContext().getAuthentication().getName();
        User us = user.viewUser(userid);
        Collection<GrantedAuthority> authorities = (Collection<GrantedAuthority>) SecurityContextHolder.getContext().getAuthentication().getAuthorities();
        String page = "";
        String role = "ROLE_USER";
        for (GrantedAuthority authority : authorities) {
            if (authority.getAuthority().equals(role)) {
                session.setAttribute("UserLoggedIn", us.getUsername());
                session.setAttribute("UserId", userid);
                session.setAttribute("usercart", new ArrayList<Cart>());
                page= "redirect:/showindexpage";
            }
            else if (authority.getAuthority().equals("ROLE_ADMIN")) {
                session.setAttribute("UserLoggedIn", us.getUsername());
                session.setAttribute("UserId", userid);
                session.setAttribute("usercart", new ArrayList<Cart>());
                page= "redirect:/admin";
            }
            else{
            page= "redirect:/";
            }
        }
        return page;
    }
    
}
