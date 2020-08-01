package com.samcancode.repositories;

import org.springframework.data.repository.CrudRepository;

import com.samcancode.domain.Ingredient;

public interface IngredientRepository extends CrudRepository<Ingredient, Long> {

}
