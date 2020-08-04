package com.samcancode.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CategoryTest {

	Category category;
	
	@BeforeEach
	void setUp() throws Exception {
		category = new Category();
	}

	@Test
	void getId() throws Exception {
		Long idValue = 4L;
		category.setId(idValue);
		assertEquals(idValue, category.getId());
	}

	@Test
	void getDescription() throws Exception {
		String desc = "Hello";
		category.setDescription(desc);
		assertEquals(desc, category.getDescription());
	}
	
	@Test
	void getRecipes() throws Exception {

	}

}
