package com.kondratyev.spring5recipeapp.mappers;

import com.kondratyev.spring5recipeapp.commands.IngredientCommand;
import com.kondratyev.spring5recipeapp.domain.Ingredient;
import com.kondratyev.spring5recipeapp.domain.Recipe;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring", uses = UnitOfMeasureMapper.class)
public interface IngredientMapper {
    IngredientCommand ingredientToIngredientCommand(Ingredient ingredient);

    @AfterMapping
    default void setRecipeId(Ingredient ingredient, @MappingTarget IngredientCommand ingredientCommand) {
        if (ingredient.getRecipe() != null) {
            ingredientCommand.setRecipeId(ingredient.getRecipe().getId());
        }
    }

    Ingredient ingredientCommandToIngredient(IngredientCommand ingredientCommand);

    @AfterMapping
    default void setRecipe(IngredientCommand ingredientCommand, @MappingTarget Ingredient ingredient) {
        if(ingredientCommand.getRecipeId() != null){
            Recipe recipe = new Recipe();
            recipe.setId(ingredientCommand.getRecipeId());
            ingredient.setRecipe(recipe);
            recipe.addIngredient(ingredient);
        }
    }
}
