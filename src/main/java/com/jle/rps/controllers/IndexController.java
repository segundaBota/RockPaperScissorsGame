package com.jle.rps.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {

	@Value("${application.controller.title}")
	private String title;
	
	@Value("${application.controller.subtitle}")
	private String subtitle;
	
	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("title", this.title);
		model.addAttribute("subtitle", this.subtitle);
		return "index";
	}
	
	@RequestMapping(value = "/register.htm", method = RequestMethod.GET)
    public ModelAndView handleRequest(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView mav = new ModelAndView("Register");
        return mav;     
    }
}
