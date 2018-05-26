package com.translationcalculator.translationform.controller;

import com.translationcalculator.translationform.model.calculator.FreelancerCalculator;
import com.translationcalculator.translationform.service.StorageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;


@Controller
public class FreelancerWebController {

    private final StorageService storageService;

    @Autowired
    public FreelancerWebController(StorageService storageService) {
        this.storageService = storageService;
    }

    Logger log = LoggerFactory.getLogger(this.getClass());

    @RequestMapping(value = "/freelancerform", method = RequestMethod.GET)
    public String customerForm(Model model) {
        model.addAttribute("freelancerCalculator", new FreelancerCalculator());
        return "freelancerform";
    }

    @RequestMapping(value = "/freelancerform", method = RequestMethod.POST)
    String customerSubmit(@ModelAttribute FreelancerCalculator freelancerCalculator, Model model, ModelMap map, HttpServletRequest request) {
        freelancerCalculator.setTranslationType(request.getParameter("translationType"));
        freelancerCalculator.setVatPayer(request.getParameter("isVatPayer"));

        model.addAttribute("freelancerCalculator", freelancerCalculator);
        map.put("totalPrice", freelancerCalculator.calculate());

        return "result";
    }
}
