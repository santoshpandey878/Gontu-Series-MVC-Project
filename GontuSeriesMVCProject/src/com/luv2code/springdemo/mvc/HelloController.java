package com.luv2code.springdemo.mvc;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class HelloController {

	@RequestMapping("/welcome/{countryName}/{userName}")
	public ModelAndView helloWorld(@PathVariable("countryName") String countryName,@PathVariable("userName") String userName){
		
		ModelAndView model = new ModelAndView("HelloPage");
		model.addObject("msg", userName + ". You are from :"+countryName);
		
		return model;
		
	}
	
	@RequestMapping("/hello/{countryName}/{userName}")
	public ModelAndView helloWorld2(@PathVariable Map<String,String> var){
		
		String userName = var.get("userName");
		String countryName = var.get("countryName");
		
		ModelAndView model = new ModelAndView("HelloPage");
		model.addObject("msg", userName + ". You are from :"+countryName);
		
		return model;
		
	}
	
}
