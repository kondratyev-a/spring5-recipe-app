package com.kondratyev.spring5recipeapp.mappers;

import com.kondratyev.spring5recipeapp.commands.NotesCommand;
import com.kondratyev.spring5recipeapp.domain.Notes;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface NotesMapper {
    NotesCommand notesToNotesCommand(Notes notes);

    Notes notesCommandToNotes(NotesCommand notesCommand);
}