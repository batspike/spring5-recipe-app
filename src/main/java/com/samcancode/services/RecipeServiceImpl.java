package com.samcancode.services;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.samcancode.Dto.RecipeDto;
import com.samcancode.converters.RecipeDtoToRecipe;
import com.samcancode.converters.RecipeToRecipeDto;
import com.samcancode.domain.Recipe;
import com.samcancode.repositories.RecipeRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class RecipeServiceImpl implements RecipeService {

	private final RecipeRepository recipeRepo;
    private final RecipeDtoToRecipe recipeDtoToRecipe;
    private final RecipeToRecipeDto recipeToRecipeDto;

	public RecipeServiceImpl(RecipeRepository recipeRepo, RecipeDtoToRecipe recipeDtoToRecipe, RecipeToRecipeDto recipeToRecipeDto) {
		this.recipeRepo = recipeRepo;
		this.recipeDtoToRecipe = recipeDtoToRecipe;
	    this.recipeToRecipeDto = recipeToRecipeDto;
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
	
	@Override
    @Transactional
    public RecipeDto findDtoById(Long id) {
        return recipeToRecipeDto.convert(findById(id));
    }

	@Override
	@Transactional
	public RecipeDto saveRecipeDto(RecipeDto command) {
        Recipe detachedRecipe = recipeDtoToRecipe.convert(command);

        Recipe savedRecipe = recipeRepo.save(detachedRecipe);
        log.debug("Saved RecipeId:" + savedRecipe.getId());
        return recipeToRecipeDto.convert(savedRecipe);
	}

}
