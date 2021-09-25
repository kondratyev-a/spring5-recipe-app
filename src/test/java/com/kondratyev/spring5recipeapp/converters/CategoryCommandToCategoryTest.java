package com.kondratyev.spring5recipeapp.converters;

import com.kondratyev.spring5recipeapp.commands.CategoryCommand;
import com.kondratyev.spring5recipeapp.domain.Category;
import com.kondratyev.spring5recipeapp.mappers.CategoryMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import static org.junit.jupiter.api.Assertions.*;

public class CategoryCommandToCategoryTest {

    public static final Long ID_VALUE = 1L;
    public static final String DESCRIPTION = "description";
    CategoryMapper categoryMapper;

    @BeforeEach
    public void setUp() {
        categoryMapper = Mappers.getMapper(CategoryMapper.class);
    }

    @Test
    public void testNullObject() {
        assertNull(categoryMapper.categoryCommandToCategory(null));
    }

    @Test
    public void testEmptyObject(){
        assertNotNull(categoryMapper.categoryCommandToCategory(new CategoryCommand()));
    }

    @Test
    public void convert() {
        //given
        CategoryCommand categoryCommand = new CategoryCommand();
        categoryCommand.setId(ID_VALUE);
        categoryCommand.setDescription(DESCRIPTION);

        //when
        Category category = categoryMapper.categoryCommandToCategory(categoryCommand);

        //then
        assertEquals(ID_VALUE, category.getId());
        assertEquals(DESCRIPTION, category.getDescription());
    }

}