package com.example.demo.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.model.Programmer;
import com.example.demo.repository.ProgrammerRepo;

import antlr.collections.List;

@Controller
public class MainController {

	@Autowired
	ProgrammerRepo pr;
	
	@GetMapping("/home")
	public String homePage()
	{
		return "HomePage.html";
	}
	
	@PostMapping("/addProgrammer")
	public ModelAndView addProgrammer(@ModelAttribute Programmer programmer)
	{
		pr.save(programmer);
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("ProgrammerInfo.html");
		return mv;
	}
	
    @PostMapping("/findById")
    public String findById(@RequestParam int pId, Model m) {
    	Programmer p = pr.getOne(pId);
    	
    	m.addAttribute("programmer", p);
    	
    	return "ProgrammerInfo.html";
    }
    
    @GetMapping("/deleteProgrammer")
    public String deleteProgrammer(@RequestParam int pId, Model m) {
    	pr.deleteById(pId);
    	
    	return "redirect:/home";
    }
    
    @PostMapping("/updateProgrammer")
    public String updateProgrammer(@ModelAttribute Programmer programmer) {
    	Programmer p = pr.getOne(programmer.getpId());
    	p.setpName(programmer.getpName());
    	p.setpLang(programmer.getpLang());
    	pr.save(p);
    	
    	return "ProgrammerInfo.html";
    	
    }
    
}