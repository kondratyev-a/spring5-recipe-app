package com.kondratyev.spring5recipeapp.services;

import com.kondratyev.spring5recipeapp.commands.UnitOfMeasureCommand;
import com.kondratyev.spring5recipeapp.domain.UnitOfMeasure;
import com.kondratyev.spring5recipeapp.mappers.UnitOfMeasureMapper;
import com.kondratyev.spring5recipeapp.repositories.UnitOfMeasureRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class UnitOfMeasureServiceImplTest {

    UnitOfMeasureService service;

    @Mock
    UnitOfMeasureRepository unitOfMeasureRepository;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);

        service = new UnitOfMeasureServiceImpl(unitOfMeasureRepository, Mappers.getMapper(UnitOfMeasureMapper.class));
    }

    @Test
    public void listAllUoms() {
        //given
        Set<UnitOfMeasure> unitOfMeasures = new HashSet<>();
        UnitOfMeasure uom1 = new UnitOfMeasure();
        uom1.setId(1L);
        unitOfMeasures.add(uom1);

        UnitOfMeasure uom2 = new UnitOfMeasure();
        uom2.setId(2L);
        unitOfMeasures.add(uom2);

        when(unitOfMeasureRepository.findAll()).thenReturn(unitOfMeasures);

        //when
        Set<UnitOfMeasureCommand> commands = service.listAllUoms();

        //then
        assertEquals(2, commands.size());
        verify(unitOfMeasureRepository, times(1)).findAll();
    }

}