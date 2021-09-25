package com.kondratyev.spring5recipeapp.converters;

import com.kondratyev.spring5recipeapp.commands.IngredientCommand;
import com.kondratyev.spring5recipeapp.commands.UnitOfMeasureCommand;
import com.kondratyev.spring5recipeapp.domain.Ingredient;
import com.kondratyev.spring5recipeapp.mappers.IngredientMapper;
import com.kondratyev.spring5recipeapp.mappers.IngredientMapperImpl;
import com.kondratyev.spring5recipeapp.mappers.UnitOfMeasureMapperImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = {IngredientMapperImpl.class, UnitOfMeasureMapperImpl.class})
public class IngredientCommandToIngredientTest {

    public static final BigDecimal AMOUNT = new BigDecimal("1");
    public static final String DESCRIPTION = "Cheeseburger";
    public static final Long ID_VALUE = 1L;
    public static final Long UOM_ID = 2L;

    @Autowired
    private IngredientMapper ingredientMapper;

    @Test
    public void testNullObject() {
        assertNull(ingredientMapper.ingredientCommandToIngredient(null));
    }

    @Test
    public void testEmptyObject() {
        assertNotNull(ingredientMapper.ingredientCommandToIngredient(new IngredientCommand()));
    }

    @Test
    public void convert() {
        //given
        IngredientCommand command = new IngredientCommand();
        command.setId(ID_VALUE);
        command.setAmount(AMOUNT);
        command.setDescription(DESCRIPTION);
        UnitOfMeasureCommand unitOfMeasureCommand = new UnitOfMeasureCommand();
        unitOfMeasureCommand.setId(UOM_ID);
        command.setUom(unitOfMeasureCommand);

        //when
        Ingredient ingredient = ingredientMapper.ingredientCommandToIngredient(command);

        //then
        assertNotNull(ingredient);
        assertNotNull(ingredient.getUom());
        assertEquals(ID_VALUE, ingredient.getId());
        assertEquals(AMOUNT, ingredient.getAmount());
        assertEquals(DESCRIPTION, ingredient.getDescription());
        assertEquals(UOM_ID, ingredient.getUom().getId());
    }

    @Test
    public void convertWithNullUOM() {
        //given
        IngredientCommand command = new IngredientCommand();
        command.setId(ID_VALUE);
        command.setAmount(AMOUNT);
        command.setDescription(DESCRIPTION);

        //when
        Ingredient ingredient = ingredientMapper.ingredientCommandToIngredient(command);

        //then
        assertNotNull(ingredient);
        assertNull(ingredient.getUom());
        assertEquals(ID_VALUE, ingredient.getId());
        assertEquals(AMOUNT, ingredient.getAmount());
        assertEquals(DESCRIPTION, ingredient.getDescription());

    }

}