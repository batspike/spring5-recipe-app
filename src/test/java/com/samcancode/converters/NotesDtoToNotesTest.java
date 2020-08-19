package com.samcancode.converters;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.samcancode.Dto.NotesDto;
import com.samcancode.domain.Notes;

class NotesDtoToNotesTest {
	public static final String RECIPE_NOTES = "Notes";
	public static final Long ID_VALUE = Long.valueOf("1");
	
	NotesDtoToNotes converter;

	@BeforeEach
	void setUp() throws Exception {
		converter = new NotesDtoToNotes();
	}

	@Test
	void testConvert() {
        //given
        NotesDto notesDto = new NotesDto();
        notesDto.setId(ID_VALUE);
        notesDto.setRecipeNotes(RECIPE_NOTES);

        //when
        Notes notes = converter.convert(notesDto);

        //then
        assertNotNull(notes);
        assertEquals(ID_VALUE, notes.getId());
        assertEquals(RECIPE_NOTES, notes.getRecipeNotes());
	}

    @Test
    public void testNullParameter() throws Exception {
        assertNull(converter.convert(null));
    }

    @Test
    public void testEmptyObject() throws Exception {
        assertNotNull(converter.convert(new NotesDto()));
    }

}
