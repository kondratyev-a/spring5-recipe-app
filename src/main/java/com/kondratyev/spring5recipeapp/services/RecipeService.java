package com.kondratyev.spring5recipeapp.services;

import com.kondratyev.spring5recipeapp.commands.RecipeCommand;
import com.kondratyev.spring5recipeapp.domain.Recipe;

import java.util.Set;

public interface RecipeService {
    Set<Recipe> getRecipes();

    Recipe findById(Long id);

    RecipeCommand saveRecipeCommand (RecipeCommand command);
}
