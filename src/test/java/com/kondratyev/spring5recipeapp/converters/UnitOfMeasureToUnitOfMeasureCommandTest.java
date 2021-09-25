package com.kondratyev.spring5recipeapp.converters;

import com.kondratyev.spring5recipeapp.commands.UnitOfMeasureCommand;
import com.kondratyev.spring5recipeapp.domain.UnitOfMeasure;
import com.kondratyev.spring5recipeapp.mappers.UnitOfMeasureMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import static org.junit.jupiter.api.Assertions.*;

public class UnitOfMeasureToUnitOfMeasureCommandTest {

    public static final String DESCRIPTION = "description";
    public static final Long LONG_VALUE = 1L;

    UnitOfMeasureMapper unitOfMeasureMapper;

    @BeforeEach
    public void setUp() {
        unitOfMeasureMapper = Mappers.getMapper(UnitOfMeasureMapper.class);
    }

    @Test
    public void testNullObjectConvert() {
        assertNull(unitOfMeasureMapper.unitOfMeasureToUnitOfMeasureCommand(null));
    }

    @Test
    public void testEmptyObj() {
        assertNotNull(unitOfMeasureMapper.unitOfMeasureToUnitOfMeasureCommand(new UnitOfMeasure()));
    }

    @Test
    public void convert() {
        //given
        UnitOfMeasure uom = new UnitOfMeasure();
        uom.setId(LONG_VALUE);
        uom.setDescription(DESCRIPTION);
        //when
        UnitOfMeasureCommand uomc = unitOfMeasureMapper.unitOfMeasureToUnitOfMeasureCommand(uom);

        //then
        assertEquals(LONG_VALUE, uomc.getId());
        assertEquals(DESCRIPTION, uomc.getDescription());
    }

}