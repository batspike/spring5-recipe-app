package com.samcancode.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.samcancode.services.RecipeService;

@Controller
public class IndexController {
	
	private final RecipeService recipeSvc;
	public IndexController(RecipeService recipeSvc) {
		this.recipeSvc = recipeSvc;
	}

	@RequestMapping({"","/","/index"})
	public String getIndexPage(Model model) {
		model.addAttribute("recipes", recipeSvc.getRecipes());
		
		return "index";
	}
}
