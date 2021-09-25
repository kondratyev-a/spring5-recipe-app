package com.kondratyev.spring5recipeapp.converters;

import com.kondratyev.spring5recipeapp.commands.CategoryCommand;
import com.kondratyev.spring5recipeapp.domain.Category;
import com.kondratyev.spring5recipeapp.mappers.CategoryMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import static org.junit.jupiter.api.Assertions.*;

public class CategoryToCategoryCommandTest {

    public static final Long ID_VALUE = 1L;
    public static final String DESCRIPTION = "description";
    CategoryMapper categoryMapper;

    @BeforeEach
    public void setUp() {
        categoryMapper = Mappers.getMapper(CategoryMapper.class);
    }

    @Test
    public void testNullObject() {
        assertNull(categoryMapper.categoryToCategoryCommand(null));
    }

    @Test
    public void testEmptyObject() {
        assertNotNull(categoryMapper.categoryToCategoryCommand(new Category()));
    }

    @Test
    public void convert() {
        //given
        Category category = new Category();
        category.setId(ID_VALUE);
        category.setDescription(DESCRIPTION);

        //when
        CategoryCommand categoryCommand = categoryMapper.categoryToCategoryCommand(category);

        //then
        assertEquals(ID_VALUE, categoryCommand.getId());
        assertEquals(DESCRIPTION, categoryCommand.getDescription());

    }

}