package com.telusko.SpringMVC;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.telusko.SpringMVC.model.Alien;

@Controller
public class HomeContoller {
	
	@ModelAttribute
	public void modelData(Model m) {
		
		m.addAttribute("name","Aliens");
	}

	@RequestMapping("/")
	public String home() {
		
		return "index";
	}
	@RequestMapping("add")
	
	public ModelAndView add(@RequestParam("num1") int i,@RequestParam("num2") int j,HttpSession session ){
		
		ModelAndView mv=new ModelAndView();
		mv.setViewName("result");
		int num3=i+j;
		
		mv.addObject("num3",num3);
		
		return mv;
	}
	@RequestMapping("addAlien")
	public String addAlien(@ModelAttribute("alien") Alien a) {
		
		
		
		return "result";
	}
	
}
