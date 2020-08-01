package com.samcancode.controllers;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.samcancode.domain.Category;
import com.samcancode.domain.UnitOfMeasure;
import com.samcancode.repositories.CategoryRepository;
import com.samcancode.repositories.UnitOfMeasureRepository;

@Controller
public class IndexController {
	
	private CategoryRepository categoryRepo;
	private UnitOfMeasureRepository uomRepo;
	public IndexController(CategoryRepository categoryRepo, UnitOfMeasureRepository uomRepo) {
		this.categoryRepo = categoryRepo;
		this.uomRepo = uomRepo;
	}

	@RequestMapping({"","/","/index"})
	public String getIndexPage() {
		
		Optional<Category> category = categoryRepo.findByDescription("Mexican");
		Optional<UnitOfMeasure> uom = uomRepo.findByDescription("Pinch");
		System.out.println("Category: "+ category.get().getId() + " "+ category.get().getDescription());
		System.out.println("UOM: "+ uom.get().getId() + " "+ uom.get().getDescription());
		
		return "index";
	}
}
