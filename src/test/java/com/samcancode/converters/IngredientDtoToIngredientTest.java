package com.samcancode.converters;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.samcancode.Dto.IngredientDto;
import com.samcancode.Dto.UnitOfMeasureDto;
import com.samcancode.domain.Ingredient;
import com.samcancode.domain.Recipe;

class IngredientDtoToIngredientTest {
    public static final Recipe RECIPE = new Recipe();
    public static final BigDecimal AMOUNT = new BigDecimal("1");
    public static final String DESCRIPTION = "Cheeseburger";
    public static final Long ID_VALUE = Long.valueOf(1L);
    public static final Long UOM_ID = Long.valueOf(2L);

    IngredientDtoToIngredient converter;

	@BeforeEach
	void setUp() throws Exception {
		converter = new IngredientDtoToIngredient(new UnitOfMeasureDtoToUnitOfMeasure());
	}

	@Test
	void testConvert() {
		//Given
		IngredientDto dto = new IngredientDto();
		dto.setId(ID_VALUE);
		dto.setAmount(AMOUNT);
		dto.setDescription(DESCRIPTION);
		UnitOfMeasureDto uomDto = new UnitOfMeasureDto();
		uomDto.setId(UOM_ID);
		dto.setUnitOfMeasure(uomDto);
		
		//When
		Ingredient ingredient = converter.convert(dto);
		
		//Then
		assertNotNull(ingredient);
		assertEquals(ID_VALUE, ingredient.getId());
		assertEquals(AMOUNT, ingredient.getAmount());
		assertEquals(DESCRIPTION, ingredient.getDescription());
	}
	
	@Test
	void testConvertWithNullUom() {
		//Given
		IngredientDto dto = new IngredientDto();
		dto.setId(ID_VALUE);
		dto.setAmount(AMOUNT);
		dto.setDescription(DESCRIPTION);
		
		//When
		Ingredient ingredient = converter.convert(dto);
		
		//Then
		assertNotNull(ingredient);
		assertNull(ingredient.getUom());
		assertEquals(ID_VALUE, ingredient.getId());
		assertEquals(AMOUNT, ingredient.getAmount());
		assertEquals(DESCRIPTION, ingredient.getDescription());
	}
	
	@Test
	void testNullParameter() {
		assertNull(converter.convert(null));
	}
	
	@Test
	void testEmptyObject() {
		assertNotNull(converter.convert(new IngredientDto()));
	}


}
