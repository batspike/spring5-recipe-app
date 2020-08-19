package com.samcancode.services;

import java.util.Set;

import com.samcancode.Dto.RecipeDto;
import com.samcancode.domain.Recipe;

public interface RecipeService {
	Set<Recipe> getRecipes();
	Recipe findById(Long id);
	RecipeDto findDtoById(Long id);
	RecipeDto saveRecipeDto(RecipeDto command);
}
