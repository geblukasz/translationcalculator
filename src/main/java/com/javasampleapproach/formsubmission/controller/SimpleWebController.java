package com.javasampleapproach.formsubmission.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.javasampleapproach.formsubmission.model.FreelancerCalculator;
 
 
@Controller
public class SimpleWebController {
 
    Logger log = LoggerFactory.getLogger(this.getClass());
     
    @RequestMapping(value="/freelancerform", method=RequestMethod.GET)
    public String customerForm(Model model) {
        model.addAttribute("freelancerCalculator", new FreelancerCalculator());
        return "freelancerform";
    }
 
    @RequestMapping(value="/freelancerform", method=RequestMethod.POST)
    public String customerSubmit(@ModelAttribute FreelancerCalculator freelancerCalculator, Model model) {
        model.addAttribute("freelancerCalculator", freelancerCalculator);
        String info = String.format("FreelancerCalculator Submission: id = %d, firstname = %s, lastname = %s",
                                        freelancerCalculator.getSignsNumber(), freelancerCalculator.getFirstname(), freelancerCalculator.getLastname());
        log.info(info);

        return "result";
    }
 
}
