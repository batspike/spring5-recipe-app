package com.samcancode.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.samcancode.Dto.NotesDto;
import com.samcancode.domain.Notes;
import com.sun.istack.Nullable;

import lombok.Synchronized;

@Component
public class NotesToNotesDto implements Converter<Notes, NotesDto> {
    @Synchronized
    @Nullable
    @Override
    public NotesDto convert(Notes source) {
        if (source == null) {
            return null;
        }

        final NotesDto notesDto = new NotesDto();
        notesDto.setId(source.getId());
        notesDto.setRecipeNotes(source.getRecipeNotes());
        return notesDto;
    }
}
