package com.samcancode.converters;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.samcancode.Dto.IngredientDto;
import com.samcancode.domain.Ingredient;
import com.samcancode.domain.Recipe;
import com.samcancode.domain.UnitOfMeasure;

class IngredientToIngredientDtoTest {
    public static final Recipe RECIPE = new Recipe();
    public static final BigDecimal AMOUNT = new BigDecimal("1");
    public static final String DESCRIPTION = "Cheeseburger";
    public static final Long UOM_ID = Long.valueOf(2L);
    public static final Long ID_VALUE = Long.valueOf(1L);
    
    IngredientToIngredientDto converter;
    
	@BeforeEach
	void setUp() throws Exception {
		converter = new IngredientToIngredientDto(new UnitOfMeasureToUnitOfMeasureDto());
	}

	@Test
	void testConvertWithNullUom() {
		//given
        Ingredient ingredient = new Ingredient();
        ingredient.setId(ID_VALUE);
        ingredient.setRecipe(RECIPE);
        ingredient.setAmount(AMOUNT);
        ingredient.setDescription(DESCRIPTION);
        ingredient.setUom(null);
        
        //when
        IngredientDto ingredientDto = converter.convert(ingredient);
        
        //then
        assertNull(ingredientDto.getUom());
        assertEquals(ID_VALUE, ingredientDto.getId());
        assertEquals(AMOUNT, ingredientDto.getAmount());
        assertEquals(DESCRIPTION, ingredientDto.getDescription());
	}

	@Test
	void testConvertWithNotNullUom() {
		//given
		Ingredient ingredient = new Ingredient();
		ingredient.setId(ID_VALUE);
		ingredient.setRecipe(RECIPE);
		ingredient.setAmount(AMOUNT);
		ingredient.setDescription(DESCRIPTION);
		ingredient.setUom(null);
        UnitOfMeasure uom = new UnitOfMeasure();
        uom.setId(UOM_ID);
        ingredient.setUom(uom);
		
		//when
		IngredientDto ingredientDto = converter.convert(ingredient);
		
		//then
		assertEquals(ID_VALUE, ingredientDto.getId());
		assertNotNull(ingredientDto.getUom());
        assertEquals(UOM_ID, ingredientDto.getUom().getId());
		assertEquals(AMOUNT, ingredientDto.getAmount());
		assertEquals(DESCRIPTION, ingredientDto.getDescription());
	}
	
    @Test
    public void testNullConvert() throws Exception {
        assertNull(converter.convert(null));
    }

    @Test
    public void testEmptyObject() throws Exception {
        assertNotNull(converter.convert(new Ingredient()));
    }
}
