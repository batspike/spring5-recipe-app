package com.samcancode.services;

import java.util.Set;

import com.samcancode.domain.Recipe;

public interface RecipeService {
	Set<Recipe> getRecipes();
	Recipe findById(Long id);
}
