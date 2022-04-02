package com.example.demo.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.model.Programmer;

import antlr.collections.List;

@Controller
public class MainController {

	@GetMapping("/home")
	public String homePage()
	{
		return "HomePage.html";
	}
	
	@PostMapping("/addProgrammer")
	public ModelAndView addProgrammer(@ModelAttribute Programmer programmer)
	{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("ProgrammerInfo.html");
		return mv;
	}
	
	@GetMapping("/allProgrammer")
	public String allProgrammer(Model m)
	{
		List p = (List) new ArrayList<Programmer>();
		p.add(new Programmer(101, "maksud alam", "C++"));
		p.add(new Programmer(102, "Jakariya Sakil", "PHP"));
		p.add(new Programmer(101, "Ashikur Rahman", "JavaScript"));
		
		m.addAttribute("Programmers", p);
		return "allProgrammer.html";
	}
}