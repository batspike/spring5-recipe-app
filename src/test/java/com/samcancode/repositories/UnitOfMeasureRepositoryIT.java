package com.samcancode.repositories;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.MethodMode;

import com.samcancode.domain.UnitOfMeasure;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
class UnitOfMeasureRepositoryIT {

	@Autowired
	UnitOfMeasureRepository uomRepo;
	
	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	@Order(1)
	@DirtiesContext(methodMode=MethodMode.AFTER_METHOD)//reset context after current method completed.
	void findByDescriptionTeaSpoon() {
		Optional<UnitOfMeasure> uomOptional = uomRepo.findByDescription("Teaspoon");
		assertEquals("Teaspoon", uomOptional.get().getDescription());
	}

	@Test
	@Order(2)
	void findByDescriptionCup() {
		Optional<UnitOfMeasure> uomOptional = uomRepo.findByDescription("Cup");
		assertEquals("Cup", uomOptional.get().getDescription());
	}
	
}
