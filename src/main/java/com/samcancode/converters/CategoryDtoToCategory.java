package com.samcancode.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.samcancode.Dto.CategoryDto;
import com.samcancode.domain.Category;
import com.sun.istack.Nullable;

import lombok.Synchronized;

@Component
public class CategoryDtoToCategory implements Converter<CategoryDto, Category> {
    @Synchronized
    @Nullable
    @Override
    public Category convert(CategoryDto source) {
        if (source == null) {
            return null;
        }

        final Category category = new Category();
        category.setId(source.getId());
        category.setDescription(source.getDescription());
        return category;
    }
}
