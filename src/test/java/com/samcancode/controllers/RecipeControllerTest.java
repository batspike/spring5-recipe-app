package com.samcancode.controllers;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.samcancode.Dto.RecipeDto;
import com.samcancode.domain.Recipe;
import com.samcancode.services.RecipeService;

class RecipeControllerTest {
	@Mock
	RecipeService recipeSvc;
	
	RecipeController controller;

	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		controller = new RecipeController(recipeSvc);
	}

	@Test
	void testShowById() throws Exception {
		Recipe recipe = new Recipe();
		recipe.setId(1L);
		
		MockMvc mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
		
		when(recipeSvc.findById(anyLong())).thenReturn(recipe);
		
		mockMvc.perform(get("/recipe/1/show"))
				.andExpect(status().isOk())
				.andExpect(view().name("recipe/show"));
	}

	@Test
	void testSaveRecipe() throws Exception {
		RecipeDto recipeDto = new RecipeDto();
		recipeDto.setId(1L);
		recipeDto.setDescription("This a new Save Recipe");
		
		MockMvc mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
		
		when(recipeSvc.saveRecipeDto(any())).thenReturn(recipeDto);
		
		mockMvc.perform(post("/recipe", new RecipeDto()))
		.andExpect(status().is3xxRedirection())
		.andExpect(view().name("redirect:/recipe/" + recipeDto.getId() + "/show"));
	}
	
	@Test
	void testGetUpdateView() throws Exception {
		RecipeDto dto = new RecipeDto();
		dto.setId(2L);
		
		MockMvc mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
		
		when(recipeSvc.findDtoById(anyLong())).thenReturn(dto);
		
		mockMvc.perform(get("/recipe/1/update"))
				.andExpect(status().isOk())
				.andExpect(view().name("recipe/recipeform"))
				.andExpect(model().attributeExists("recipe"));
	}
	
	@Test
	void testDeleteAction() throws Exception {
		MockMvc mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
		
		mockMvc.perform(get("/recipe/1/delete"))
				.andExpect(status().is3xxRedirection())
				.andExpect(view().name("redirect:/"));
		
		verify(recipeSvc, times(1)).deleteById(anyLong());
	}
}
