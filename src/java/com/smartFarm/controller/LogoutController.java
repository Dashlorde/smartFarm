/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smartFarm.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author zhouyunlu
 */
@Controller
@RequestMapping("/logout.htm")
public class LogoutController {
    
    @RequestMapping(method=RequestMethod.GET)
    protected String logout(HttpServletRequest request) throws Exception{
        HttpSession session=request.getSession();
        session.invalidate();
        return "redirect:/showAllLivestock.htm";
    }
}
