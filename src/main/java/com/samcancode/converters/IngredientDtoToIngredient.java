package com.samcancode.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.samcancode.Dto.IngredientDto;
import com.samcancode.domain.Ingredient;
import com.sun.istack.Nullable;

@Component
public class IngredientDtoToIngredient implements Converter<IngredientDto, Ingredient> {
	
    private final UnitOfMeasureDtoToUnitOfMeasure uomConverter;
    public IngredientDtoToIngredient(UnitOfMeasureDtoToUnitOfMeasure uomConverter) {
        this.uomConverter = uomConverter;
    }

    @Nullable
    @Override
    public Ingredient convert(IngredientDto source) {
        if (source == null) {
            return null;
        }

        final Ingredient ingredient = new Ingredient();
        ingredient.setId(source.getId());
        ingredient.setAmount(source.getAmount());
        ingredient.setDescription(source.getDescription());
        ingredient.setUom(uomConverter.convert(source.getUom()));
        return ingredient;
    }
}
