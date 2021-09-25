package com.kondratyev.spring5recipeapp.converters;

import com.kondratyev.spring5recipeapp.commands.IngredientCommand;
import com.kondratyev.spring5recipeapp.domain.Ingredient;
import com.kondratyev.spring5recipeapp.domain.Recipe;
import com.kondratyev.spring5recipeapp.domain.UnitOfMeasure;
import com.kondratyev.spring5recipeapp.mappers.IngredientMapper;
import com.kondratyev.spring5recipeapp.mappers.IngredientMapperImpl;
import com.kondratyev.spring5recipeapp.mappers.UnitOfMeasureMapperImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = {IngredientMapperImpl.class, UnitOfMeasureMapperImpl.class})
public class IngredientToIngredientCommandTest {

    public static final Recipe RECIPE = new Recipe();
    public static final BigDecimal AMOUNT = new BigDecimal("1");
    public static final String DESCRIPTION = "Cheeseburger";
    public static final Long UOM_ID = 2L;
    public static final Long ID_VALUE = 1L;

    @Autowired
    private IngredientMapper ingredientMapper;

    @Test
    public void testNullConvert() {
        assertNull(ingredientMapper.ingredientToIngredientCommand(null));
    }

    @Test
    public void testEmptyObject() {
        assertNotNull(ingredientMapper.ingredientToIngredientCommand(new Ingredient()));
    }

    @Test
    public void testConvertNullUOM() {
        //given
        Ingredient ingredient = new Ingredient();
        ingredient.setId(ID_VALUE);
        ingredient.setRecipe(RECIPE);
        ingredient.setAmount(AMOUNT);
        ingredient.setDescription(DESCRIPTION);
        ingredient.setUom(null);
        //when
        IngredientCommand ingredientCommand = ingredientMapper.ingredientToIngredientCommand(ingredient);
        //then
        assertNull(ingredientCommand.getUom());
        assertEquals(ID_VALUE, ingredientCommand.getId());
        // assertEquals(RECIPE, ingredientCommand.get);
        assertEquals(AMOUNT, ingredientCommand.getAmount());
        assertEquals(DESCRIPTION, ingredientCommand.getDescription());
    }

    @Test
    public void testConvertWithUom() {
        //given
        Ingredient ingredient = new Ingredient();
        ingredient.setId(ID_VALUE);
        ingredient.setRecipe(RECIPE);
        ingredient.setAmount(AMOUNT);
        ingredient.setDescription(DESCRIPTION);

        UnitOfMeasure uom = new UnitOfMeasure();
        uom.setId(UOM_ID);

        ingredient.setUom(uom);
        //when
        IngredientCommand ingredientCommand = ingredientMapper.ingredientToIngredientCommand(ingredient);
        //then
        assertEquals(ID_VALUE, ingredientCommand.getId());
        assertNotNull(ingredientCommand.getUom());
        assertEquals(UOM_ID, ingredientCommand.getUom().getId());
        assertEquals(AMOUNT, ingredientCommand.getAmount());
        assertEquals(DESCRIPTION, ingredientCommand.getDescription());
    }
}