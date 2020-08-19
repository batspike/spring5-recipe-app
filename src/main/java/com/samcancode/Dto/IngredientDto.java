package com.samcancode.Dto;

import java.math.BigDecimal;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class IngredientDto {
    private Long id;
    private String description;
    private BigDecimal amount;
    private UnitOfMeasureDto uom;
}
