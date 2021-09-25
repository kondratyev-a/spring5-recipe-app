package com.kondratyev.spring5recipeapp.mappers;

import com.kondratyev.spring5recipeapp.commands.CategoryCommand;
import com.kondratyev.spring5recipeapp.domain.Category;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    CategoryCommand categoryToCategoryCommand(Category category);

    Category categoryCommandToCategory(CategoryCommand categoryCommand);
}