package com.samcancode.services;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.samcancode.domain.Recipe;
import com.samcancode.repositories.RecipeRepository;

class RecipeServiceImplTest {
	
	RecipeService recipeService;
	
	@Mock
	RecipeRepository recipeRepo;

	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		recipeService = new RecipeServiceImpl(recipeRepo);
	}

	@Test
	void getRecipes() throws Exception {
		Recipe recipe = new Recipe();
		Set<Recipe> recipes = new HashSet<>();
		recipes.add(recipe);
		
		when(recipeRepo.findAll()).thenReturn(recipes);
		
		Set<Recipe> actualRecipes = recipeService.getRecipes();
		
		assertEquals(actualRecipes.size(), 1);
		verify(recipeRepo, times(1)).findAll(); // verify the recipeRepo was called once during the above test.
	}

}
