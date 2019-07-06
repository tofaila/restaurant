///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package com.tofail.restaurant.controller;
//
//import com.google.gson.Gson;
//import com.tofail.restaurant.dao.BookinginfoService;
//import com.tofail.restaurant.dao.CustomerinfoService;
//import com.tofail.restaurant.dao.TableTypeService;
//import com.tofail.restaurant.dao.TableinfoService;
//import com.tofail.restaurant.dao.Userservice;
//import java.text.SimpleDateFormat;
//import java.util.Date;
//import javax.servlet.http.HttpSession;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.propertyeditors.CustomDateEditor;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.WebDataBinder;
//import org.springframework.web.bind.annotation.InitBinder;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.servlet.ModelAndView;
//
///**
// *
// * @author Faisal
// */
//@Controller
//public class SearchController {
//    @Autowired
//    BookinginfoService bookinginfoService;
//    @Autowired
//    TableinfoService tableinfoService;
//    @Autowired
//    TableTypeService tableTypeService;
//    @Autowired
//    CustomerinfoService customerinfoService;
//    @Autowired
//    Userservice userservice;
//    
//    @InitBinder
//    public void myInitBinder(WebDataBinder binder) {
//        //binder.setDisallowedFields(new String[]{"empMobile"});
//        SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
//        binder.registerCustomEditor(Date.class, "startdate", new CustomDateEditor(format, false));
//        SimpleDateFormat format1 = new SimpleDateFormat("yyyy/MM/dd");
//        binder.registerCustomEditor(Date.class, "enddate", new CustomDateEditor(format1, false));
//
////        binder.registerCustomEditor(String.class, "ename", new EmployeeNameEditor());
//    }
//    @RequestMapping("/search")
//    public ModelAndView showAllRoom() {
//        String tableinfo = tableinfoService.viewAllTableinfo();
//
////        String roombookingList = roombookingService.viewAllRoombooking();
//        String tableTypeall = tableTypeService.viewAllTableType();
//      
//
//        ModelAndView mv = new ModelAndView("searchroom");
//
//        mv.addObject("tableinfoList", tableinfo);
//        mv.addObject("tableTypeList", tableTypeall);
////        mv.addObject("categoryList", categoryall);
////        mv.addObject("roombookinglist", roombookingList);
//        //mv.addObject("check", "true");
//        mv.addObject("check", "false");
//        mv.addObject("s", "null");
//        return mv;
//    }
//     @RequestMapping("/tablesearch")
//    //read the provided form data  
//    public ModelAndView display(@RequestParam("tableno") String tableno, @RequestParam("startdate") String startdate, @RequestParam("enddate") String enddate,HttpSession session) {
//        String searchtable = tableinfoService.viewSingleTableinfo(tableno,  startdate, enddate);
//        System.out.println("tttttttttttttttttttttttttttttttt" + searchtable);
//        String tableinfo = tableinfoService.viewAllTableinfo();
//        
//        
//        Gson g = new Gson();
//        String tableinfolistgson = g.toJson(searchtable);
//        System.out.println("88888888522222222222222222222222222222222222" + tableinfolistgson);
//        
//        session.setAttribute("tableno", tableno);
//        session.setAttribute("startdate", startdate);
//        session.setAttribute("enddate", enddate);
//       
//        ModelAndView mv = new ModelAndView("searchtable");
//        mv.addObject("tableinfoList", tableinfo);
//        mv.addObject("check", "true");
//        mv.addObject("s", searchtable);
//        return mv;
//    }
//    
//    
//}
