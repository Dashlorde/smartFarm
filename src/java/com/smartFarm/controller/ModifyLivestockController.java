/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smartFarm.controller;

import com.smartFarm.DAO.LivestockDao;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author zhouyunlu
 */
@Controller
public class ModifyLivestockController {

    @Autowired
    LivestockDao livestockDao = new LivestockDao();

    @RequestMapping(value = "/modifyLivestock.htm", method = RequestMethod.GET)
    protected String getModifyPage(HttpServletRequest request, Model model) {
        String type = request.getParameter("type");
        long id = Long.parseLong(request.getParameter("id"));
        model.addAttribute("id", id);
        if (type.equals("cow")) {
            model.addAttribute("livestockType", "cow");

        } else if (type.equals("pig")) {
            model.addAttribute("livestockType", "pig");

        }
        return "modify";
    }

    @RequestMapping(value = "/modifyLivestock.htm", method = RequestMethod.POST)
    protected String doSubmitModify(HttpServletRequest request) throws SQLException {
        String type = request.getParameter("type");
        long id = Long.parseLong(request.getParameter("id"));
        System.out.println("livestock type is: " + type);
        System.out.println("livestock id is: " + id);
        long employeeId;
        int weight;

        if (type.equals("cow")) {
            if (!request.getParameter("employeeId").isEmpty()) {
                employeeId = Long.parseLong(request.getParameter("employeeId"));
                livestockDao.updateCowEmployeeId(id, employeeId);
            }

            if (!request.getParameter("weight").isEmpty()) {
                weight = Integer.parseInt(request.getParameter("weight"));
                livestockDao.updateCowWeight(id, weight);
            }

            return "redirect://showAllCow.htm";
        }

        if (type.equals("pig")) {
            if (!request.getParameter("employeeId").isEmpty()) {
                employeeId = Long.parseLong(request.getParameter("employeeId"));
                livestockDao.updatePigEmployeeId(id, employeeId);
            }

            if (!request.getParameter("weight").isEmpty()) {
                weight = Integer.parseInt(request.getParameter("weight"));
                livestockDao.updatePigWeight(id, weight);
            }

            return "redirect://showAllPig.htm";
        }

        return null;
    }

}
