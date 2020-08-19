package com.samcancode.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.samcancode.Dto.RecipeDto;
import com.samcancode.services.RecipeService;

@Controller
public class RecipeController {
	
	private final RecipeService recipeSvc;
	public RecipeController(RecipeService recipeSvc) {
		this.recipeSvc = recipeSvc;
	}

	@RequestMapping("/recipe/{id}/show")
	public String showById(@PathVariable String id, Model model) {
		model.addAttribute("recipe", recipeSvc.findById(Long.valueOf(id)));
		
		return "recipe/show";
	}
	
	@RequestMapping("recipe/new")
	public String newRecipe(Model model) {
		model.addAttribute("recipe", new RecipeDto());
		
		return "recipe/recipeform";
	}
	
	@PostMapping("recipe")
	public String saveOrUpdate(@ModelAttribute RecipeDto dto) {
		RecipeDto savedDto = recipeSvc.saveRecipeDto(dto);
		
		return "redirect:/recipe/" + savedDto.getId() + "/show";
	}
	
	@RequestMapping("recipe/{id}/update")
    public String updateRecipe(@PathVariable String id, Model model){
        model.addAttribute("recipe", recipeSvc.findDtoById(Long.valueOf(id)));
        return  "recipe/recipeform";
    }
}
