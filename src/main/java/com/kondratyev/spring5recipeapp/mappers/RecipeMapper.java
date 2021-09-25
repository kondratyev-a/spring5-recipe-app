package com.kondratyev.spring5recipeapp.mappers;

import com.kondratyev.spring5recipeapp.commands.RecipeCommand;
import com.kondratyev.spring5recipeapp.domain.Recipe;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {CategoryMapper.class, IngredientMapper.class, NotesMapper.class})
public interface RecipeMapper {
    RecipeCommand recipeToRecipeCommand(Recipe recipe);

    Recipe recipeCommandToRecipe(RecipeCommand recipeCommand);
}
