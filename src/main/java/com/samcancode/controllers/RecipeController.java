package com.samcancode.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.samcancode.services.RecipeService;

@Controller
public class RecipeController {
	
	private final RecipeService recipeSvc;
	public RecipeController(RecipeService recipeSvc) {
		this.recipeSvc = recipeSvc;
	}

	@RequestMapping("/recipe/show/{id}")
	public String showById(@PathVariable String id, Model model) {
		model.addAttribute("recipes", recipeSvc.findById(Long.valueOf(id)));
		
		return "recipe/show";
	}
}
