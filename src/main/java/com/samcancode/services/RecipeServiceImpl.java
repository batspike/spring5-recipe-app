package com.samcancode.services;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.samcancode.domain.Recipe;
import com.samcancode.repositories.RecipeRepository;

@Service
public class RecipeServiceImpl implements RecipeService {

	private final RecipeRepository recipeRepo;
	public RecipeServiceImpl(RecipeRepository recipeRepo) {
		this.recipeRepo = recipeRepo;
	}

	@Override
	public Set<Recipe> getRecipes() {
		Set<Recipe> recipes = new HashSet<>();
		recipeRepo.findAll().forEach(recipes::add);
		return recipes;
	}

	@Override
	public Recipe findById(Long id) {
		Optional<Recipe> recipeOptional = recipeRepo.findById(id);
		
		return recipeOptional.orElse(null);
	}

}
