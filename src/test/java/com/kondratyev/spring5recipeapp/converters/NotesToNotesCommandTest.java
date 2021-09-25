package com.kondratyev.spring5recipeapp.converters;

import com.kondratyev.spring5recipeapp.commands.NotesCommand;
import com.kondratyev.spring5recipeapp.domain.Notes;
import com.kondratyev.spring5recipeapp.mappers.NotesMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import static org.junit.jupiter.api.Assertions.*;

public class NotesToNotesCommandTest {

    public static final Long ID_VALUE = 1L;
    public static final String RECIPE_NOTES = "Notes";
    NotesMapper notesMapper;

    @BeforeEach
    public void setUp() {
        notesMapper = Mappers.getMapper(NotesMapper.class);
    }

    @Test
    public void convert() {
        //given
        Notes notes = new Notes();
        notes.setId(ID_VALUE);
        notes.setRecipeNotes(RECIPE_NOTES);

        //when
        NotesCommand notesCommand = notesMapper.notesToNotesCommand(notes);

        //then
        assertEquals(ID_VALUE, notesCommand.getId());
        assertEquals(RECIPE_NOTES, notesCommand.getRecipeNotes());
    }

    @Test
    public void testNull() {
        assertNull(notesMapper.notesToNotesCommand(null));
    }

    @Test
    public void testEmptyObject() {
        assertNotNull(notesMapper.notesToNotesCommand(new Notes()));
    }
}