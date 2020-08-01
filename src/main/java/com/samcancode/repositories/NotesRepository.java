package com.samcancode.repositories;

import org.springframework.data.repository.CrudRepository;

import com.samcancode.domain.Notes;

public interface NotesRepository extends CrudRepository<Notes, Long> {

}
