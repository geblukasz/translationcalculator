package com.translationcalculator.translationform.controller;

import com.translationcalculator.translationform.model.CatToolsWebCalculator;
import com.translationcalculator.translationform.model.FreelancerCalculator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

@Controller
public class CatController {

    @RequestMapping(value = "/cattoolsform", method = RequestMethod.GET)
    public String hello(Model model) {
        model.addAttribute("catToolsWebCalculator", new CatToolsWebCalculator());
        return "catform";
    }

    @RequestMapping(value = "/cattoolsform", method = RequestMethod.POST)
    String customerSubmit(@ModelAttribute FreelancerCalculator freelancerCalculator, Model model, ModelMap map, HttpServletRequest request) {
        freelancerCalculator.setTranslationType(request.getParameter("translationType"));
        freelancerCalculator.setVatPayer(request.getParameter("isVatPayer"));

        model.addAttribute("freelancerCalculator", freelancerCalculator);
        map.put("totalPrice", freelancerCalculator.calculate());

        return "result";
    }
}

