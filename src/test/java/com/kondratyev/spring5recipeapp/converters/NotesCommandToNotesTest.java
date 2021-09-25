package com.kondratyev.spring5recipeapp.converters;

import com.kondratyev.spring5recipeapp.commands.NotesCommand;
import com.kondratyev.spring5recipeapp.domain.Notes;
import com.kondratyev.spring5recipeapp.mappers.NotesMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import static org.junit.jupiter.api.Assertions.*;

public class NotesCommandToNotesTest {

    public static final Long ID_VALUE = 1L;
    public static final String RECIPE_NOTES = "Notes";
    NotesMapper notesMapper;

    @BeforeEach
    public void setUp() {
        notesMapper = Mappers.getMapper(NotesMapper.class);

    }

    @Test
    public void testNullParameter() {
        assertNull(notesMapper.notesCommandToNotes(null));
    }

    @Test
    public void testEmptyObject() {
        assertNotNull(notesMapper.notesCommandToNotes(new NotesCommand()));
    }

    @Test
    public void convert() {
        //given
        NotesCommand notesCommand = new NotesCommand();
        notesCommand.setId(ID_VALUE);
        notesCommand.setRecipeNotes(RECIPE_NOTES);

        //when
        Notes notes = notesMapper.notesCommandToNotes(notesCommand);

        //then
        assertNotNull(notes);
        assertEquals(ID_VALUE, notes.getId());
        assertEquals(RECIPE_NOTES, notes.getRecipeNotes());
    }

}