package com.samcancode.repositories;

import org.springframework.data.repository.CrudRepository;

import com.samcancode.domain.Recipe;

public interface RecipeRepository extends CrudRepository<Recipe, Long> {

}
