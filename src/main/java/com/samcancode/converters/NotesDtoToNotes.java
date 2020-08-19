package com.samcancode.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.samcancode.Dto.NotesDto;
import com.samcancode.domain.Notes;
import com.sun.istack.Nullable;

import lombok.Synchronized;

@Component
public class NotesDtoToNotes implements Converter<NotesDto, Notes> {
    @Synchronized
    @Nullable
    @Override
    public Notes convert(NotesDto source) {
        if(source == null) {
            return null;
        }

        final Notes notes = new Notes();
        notes.setId(source.getId());
        notes.setRecipeNotes(source.getRecipeNotes());
        return notes;
    }
}
