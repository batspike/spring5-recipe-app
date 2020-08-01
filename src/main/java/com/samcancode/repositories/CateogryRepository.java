package com.samcancode.repositories;

import org.springframework.data.repository.CrudRepository;

import com.samcancode.domain.Category;

public interface CateogryRepository extends CrudRepository<Category, Long> {

}
