package com.samcancode.services;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.never;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.samcancode.converters.RecipeDtoToRecipe;
import com.samcancode.converters.RecipeToRecipeDto;
import com.samcancode.domain.Recipe;
import com.samcancode.repositories.RecipeRepository;

class RecipeServiceImplTest {
	
	RecipeService recipeService;
	
	@Mock
	RecipeRepository recipeRepo;
	
	@Mock
    RecipeToRecipeDto recipeToRecipeDto;

    @Mock
    RecipeDtoToRecipe recipeDtoToRecipe;

	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		recipeService = new RecipeServiceImpl(recipeRepo, recipeDtoToRecipe, recipeToRecipeDto);
	}

	@Test
	void getRecipeByIdTest() throws Exception {
		Recipe recipe = new Recipe();
		recipe.setId(1L);
		Optional<Recipe> recipeOptional = Optional.of(recipe);
		
		when(recipeRepo.findById(anyLong())).thenReturn(recipeOptional);
		
		Recipe recipeReturned = recipeService.findById(1L);
		
		assertNotNull(recipeReturned, "Null recipe returned");
		verify(recipeRepo, times(1)).findById(anyLong());
		verify(recipeRepo, never()).findAll();
	}
	
	@Test
	void getRecipesTest() throws Exception {
		Recipe recipe = new Recipe();
		Set<Recipe> recipes = new HashSet<>();
		recipes.add(recipe);
		
		when(recipeRepo.findAll()).thenReturn(recipes);
		
		Set<Recipe> actualRecipes = recipeService.getRecipes();
		
		assertEquals(actualRecipes.size(), 1);
		verify(recipeRepo, times(1)).findAll(); // verify the recipeRepo was called once during the above test.
		verify(recipeRepo, never()).findById(anyLong());
	}

}
