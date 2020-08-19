package com.samcancode.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import com.samcancode.Dto.CategoryDto;
import com.samcancode.domain.Category;

import lombok.Synchronized;

@Component
public class CategoryToCategoryDto implements Converter<Category, CategoryDto> {
    @Synchronized
    @Nullable
    @Override
    public CategoryDto convert(Category source) {
        if (source == null) {
            return null;
        }

        final CategoryDto categoryDto = new CategoryDto();

        categoryDto.setId(source.getId());
        categoryDto.setDescription(source.getDescription());

        return categoryDto;
    }
}
