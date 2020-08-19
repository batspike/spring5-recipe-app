package com.samcancode.converters;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.samcancode.Dto.CategoryDto;
import com.samcancode.Dto.UnitOfMeasureDto;
import com.samcancode.domain.Category;
import com.samcancode.domain.UnitOfMeasure;

class CategoryDtoToCategoryTest {
	public static final String DESCRIPTION = "description";
	public static final Long LONG_VALUE = Long.valueOf("1");
	
	CategoryDtoToCategory converter;

	@BeforeEach
	void setUp() throws Exception {
		converter = new CategoryDtoToCategory();
	}

	@Test
	void testConvert() {
		//Given
		CategoryDto dto = new CategoryDto();
		dto.setId(LONG_VALUE);
		dto.setDescription(DESCRIPTION);
		
		//When
		Category uom = converter.convert(dto);
		
		//Then
		assertNotNull(uom);
		assertEquals(LONG_VALUE, uom.getId());
		assertEquals(DESCRIPTION, uom.getDescription());
	}
	
	@Test
	void testNullParameter() {
		assertNull(converter.convert(null));
	}
	
	@Test
	void testEmptyObject() {
		assertNotNull(converter.convert(new CategoryDto()));
	}
}
