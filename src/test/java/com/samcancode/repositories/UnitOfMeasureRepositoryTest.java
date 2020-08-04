package com.samcancode.repositories;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.samcancode.domain.UnitOfMeasure;

@SpringBootTest
class UnitOfMeasureRepositoryTest {

	@Autowired
	UnitOfMeasureRepository uomRepo;
	
	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void findByDescriptionTeaSpoon() {
		Optional<UnitOfMeasure> uomOptional = uomRepo.findByDescription("Teaspoon");
		assertEquals("Teaspoon", uomOptional.get().getDescription());
	}

	@Test
	void findByDescriptionCup() {
		Optional<UnitOfMeasure> uomOptional = uomRepo.findByDescription("Cup");
		assertEquals("Cup", uomOptional.get().getDescription());
	}
	
}
