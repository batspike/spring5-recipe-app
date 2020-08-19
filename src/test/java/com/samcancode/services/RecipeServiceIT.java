package com.samcancode.services;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.samcancode.Dto.RecipeDto;
import com.samcancode.converters.RecipeDtoToRecipe;
import com.samcancode.converters.RecipeToRecipeDto;
import com.samcancode.domain.Recipe;
import com.samcancode.repositories.RecipeRepository;

@SpringBootTest //enable Spring Context so can use @Autowired
class RecipeServiceIT {
	public static final String NEW_DESCRIPTION = "New Description";
	
	@Autowired
	RecipeService recipeService;
	
	@Autowired
	RecipeRepository recipeRepository;
	
	@Autowired
	RecipeDtoToRecipe recipeDtoToRecipe;
	
	@Autowired
	RecipeToRecipeDto recipeToRecipeDto;
	
	@Transactional
	@Test
	void testSaveRecipeDtoForDescription() {
        //given
        Iterable<Recipe> recipes = recipeRepository.findAll();
        Recipe testRecipe = recipes.iterator().next();
        RecipeDto testRecipeDto = recipeToRecipeDto.convert(testRecipe);

        //when
        testRecipeDto.setDescription(NEW_DESCRIPTION);
        RecipeDto savedRecipeDto = recipeService.saveRecipeDto(testRecipeDto);

        //then
        assertEquals(NEW_DESCRIPTION, savedRecipeDto.getDescription());
        assertEquals(testRecipe.getId(), savedRecipeDto.getId());
        assertEquals(testRecipe.getCategories().size(), savedRecipeDto.getCategories().size());
        assertEquals(testRecipe.getIngredients().size(), savedRecipeDto.getIngredients().size());
	}

}
