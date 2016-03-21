package com.gontuseries.dtucontroller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import java.lang.reflect.Method;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DtuController {
	
	@RequestMapping(value="/mainForm.html", method = RequestMethod.GET)
	public ModelAndView getForm(HttpSession session) {
		if(session.getAttribute("loggedInUser")==null)
		{
			ModelAndView m = new ModelAndView("/MainForm");
			return m;
		}
		ModelAndView m = new ModelAndView("/CGPA.html");
		return m;
		
	}
	
	@ModelAttribute
	public void add(Model model1){
		model1.addAttribute("headerMsg", "DELHI TECHNOLOGICAL UNIVERSITY, NEW DELHI");
	}
	
	@RequestMapping(value ="/CGPA.html", method = RequestMethod.POST)
	public ModelAndView cgpa (@RequestParam Map<String, String> reqPar, HttpSession session )throws Exception {
		String username = reqPar.get("username");
		String password = reqPar.get("password");
//		if(result.hasErrors())
//		{
//			ModelAndView model1 = new ModelAndView("mainForm");
//			return model1;
//		}
//		String exceptionOcc = "NULL_POINTER";
//		if(exceptionOcc.equalsIgnoreCase("NULL_POINTER")){
//			throw new NullPointerException("Null Pointer Exception");
//		}
//		ApplicationContext ctx = new ClassPathXmlApplicationContext("/home/meenal/workspace/FirstSpringMVCProject/WebContent/WEB-INF/spring-dispatcher-servlet.xml");
//		GetStudent dao = ctx.getBean(GetStudent.class);
		System.out.println(username);
		System.out.println(password);
		 Student st1 =new GetStudent().getStudentInfo(username, password);
		 if(st1==null)
		 {
			 ModelAndView model1 = new ModelAndView("MainForm");
				return model1;
			 
		 }
		 session.setAttribute("loggedInUser", st1);
		 
		Double aggr = st1.getAggregate();
//		Double aggr = Double.parseDouble(agg);
		ModelAndView model = new ModelAndView("/CGPACal");
		double ans = (aggr+7.5)/10;
	
		model.addObject("msg1","Hey " +st1.getStudentName()+" !!!"+" from "+st1.getBranch()+" Your cgpa is "+ans);
		model.addObject("st1", st1);
		return model;
	}
	@ExceptionHandler(value= NullPointerException.class)
	public String handleNullPointerException(Exception e)
	{
		System.out.println("Null pointer exception occured"+e);
		return "NullPointerException";
	}
	

}
