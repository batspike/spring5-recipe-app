package com.samcancode.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import com.samcancode.Dto.RecipeDto;
import com.samcancode.domain.Category;
import com.samcancode.domain.Recipe;

import lombok.Synchronized;

@Component
public class RecipeToRecipeDto implements Converter<Recipe, RecipeDto> {
    private final CategoryToCategoryDto categoryConveter;
    private final IngredientToIngredientDto ingredientConverter;
    private final NotesToNotesDto notesConverter;

    public RecipeToRecipeDto(CategoryToCategoryDto categoryConveter, IngredientToIngredientDto ingredientConverter,
                                 NotesToNotesDto notesConverter) {
        this.categoryConveter = categoryConveter;
        this.ingredientConverter = ingredientConverter;
        this.notesConverter = notesConverter;
    }

    @Synchronized
    @Nullable
    @Override
    public RecipeDto convert(Recipe source) {
        if (source == null) {
            return null;
        }

        final RecipeDto dto = new RecipeDto();
        dto.setId(source.getId());
        dto.setCookTime(source.getCookTime());
        dto.setPrepTime(source.getPrepTime());
        dto.setDescription(source.getDescription());
        dto.setDifficulty(source.getDifficulty());
        dto.setDirections(source.getDirections());
        dto.setServings(source.getServings());
        dto.setSource(source.getSource());
        dto.setUrl(source.getUrl());
        dto.setNotes(notesConverter.convert(source.getNotes()));

        if (source.getCategories() != null && source.getCategories().size() > 0){
            source.getCategories()
                    .forEach((Category category) -> dto.getCategories().add(categoryConveter.convert(category)));
        }

        if (source.getIngredients() != null && source.getIngredients().size() > 0){
            source.getIngredients()
                    .forEach(ingredient -> dto.getIngredients().add(ingredientConverter.convert(ingredient)));
        }

        return dto;
    }
}
