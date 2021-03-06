package com.translationcalculator.translationform.controller;

import com.translationcalculator.translationform.model.CatToolsWebCalculator;
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
    String customerSubmit(@ModelAttribute CatToolsWebCalculator calculator, Model model, ModelMap map, HttpServletRequest request) {
        calculator.setTranslationType(request.getParameter("translationType"));
        calculator.setVatPayerString(request.getParameter("isVatPayer"));

        model.addAttribute("catToolsWebCalculator", calculator);
        map.put("totalPrice", calculator.prepareCalculations());
        map.put("n7599MatchWords", calculator.getPriceFor75to99MatchWords());
        map.put("noMatchWords", calculator.getPriceForNoMatchWords());
        map.put("n100matchWords", calculator.getPriceFor100MatchWords());
        if (calculator.isVatPayer()){
            map.put("taxPrice", calculator.getTaxPrice());
            map.put("netPrice", calculator.getNetPrice());
        }

        return "catresult";
    }
}

