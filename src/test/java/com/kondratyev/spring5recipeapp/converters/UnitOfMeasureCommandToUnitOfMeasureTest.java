package com.kondratyev.spring5recipeapp.converters;

import com.kondratyev.spring5recipeapp.commands.UnitOfMeasureCommand;
import com.kondratyev.spring5recipeapp.domain.UnitOfMeasure;
import com.kondratyev.spring5recipeapp.mappers.UnitOfMeasureMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import static org.junit.jupiter.api.Assertions.*;

public class UnitOfMeasureCommandToUnitOfMeasureTest {

    public static final String DESCRIPTION = "description";
    public static final Long LONG_VALUE = 1L;

    UnitOfMeasureMapper unitOfMeasureMapper;

    @BeforeEach
    public void setUp() {
        unitOfMeasureMapper = Mappers.getMapper(UnitOfMeasureMapper.class);
    }

    @Test
    public void testNullParameter() {
        assertNull(unitOfMeasureMapper.unitOfMeasureCommandToUnitOfMeasure(null));
    }

    @Test
    public void testEmptyObject() {
        assertNotNull(unitOfMeasureMapper.unitOfMeasureCommandToUnitOfMeasure(new UnitOfMeasureCommand()));
    }

    @Test
    public void convert() {
        //given
        UnitOfMeasureCommand command = new UnitOfMeasureCommand();
        command.setId(LONG_VALUE);
        command.setDescription(DESCRIPTION);

        //when
        UnitOfMeasure uom = unitOfMeasureMapper.unitOfMeasureCommandToUnitOfMeasure(command);

        //then
        assertNotNull(uom);
        assertEquals(LONG_VALUE, uom.getId());
        assertEquals(DESCRIPTION, uom.getDescription());

    }

}