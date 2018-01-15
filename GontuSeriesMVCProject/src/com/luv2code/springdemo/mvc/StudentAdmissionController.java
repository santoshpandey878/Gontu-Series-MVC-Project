package com.luv2code.springdemo.mvc;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class StudentAdmissionController {

	@RequestMapping(value="/admissionForm.html",method=RequestMethod.GET)
	public ModelAndView getAdmissionForm(){
		
		ModelAndView model = new ModelAndView("AdmissionForm");	
		return model;
		
		
		
	}
	
	@RequestMapping(value="/submitAdmissionForm.html",method=RequestMethod.POST)
	public ModelAndView submitAdmissionForm(@RequestParam(value="studentName", defaultValue="sp") String studentName, @RequestParam("studentHobby") String studentHobby){
		
		//we can also use @RequestParam Map<String,String> var to get all the request param values in key-value pair
		
		Student student1 = new Student();
		student1.setStudentName(studentName);
		student1.setStudentHobby(studentHobby);
		
		ModelAndView model = new ModelAndView("AdmissionSuccess");	
		model.addObject("msg", "Detail submitted by you : Name: "+studentName+", Hobby: "+studentHobby);
		model.addObject("student1", student1);
		
		return model;
		
	}
	
	@RequestMapping(value="/submitAdmissionFormWithModelAttribute.html",method=RequestMethod.POST)
	public ModelAndView submitAdmissionFormWithModelAttribute(@ModelAttribute("student1") Student student1, BindingResult res){
		
		if(res.hasErrors()){
			ModelAndView model = new ModelAndView("AdmissionForm");
			return model;
		}
		
		ModelAndView model = new ModelAndView("AdmissionSuccess");	
		model.addObject("msg", "Detail submitted by you : Name: "+student1.getStudentName()+", Hobby: "+student1.getStudentHobby());
		
		return model;	
	}
	
	@ModelAttribute
	public void addingCommonObject(Model model){
		model.addAttribute("headerMessage", "Gontu Series");
	}
	
	@InitBinder
	public void initBinder(WebDataBinder binder){
		// to disallow field to not bind data for that field
		binder.setDisallowedFields(new String[] {"studentMobile"});
		
		//customizing property like date format customization
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy*****mm*****dd");
		binder.registerCustomEditor(Date.class, "studentDOB", new CustomDateEditor(dateFormat, false));
		
		//with our own custom property editor class
		binder.registerCustomEditor(String.class, "studentName", new CustomStudentNameEditor());
	}
	
}
