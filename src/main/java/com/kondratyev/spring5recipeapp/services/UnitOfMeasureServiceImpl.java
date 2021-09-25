package com.kondratyev.spring5recipeapp.services;

import com.kondratyev.spring5recipeapp.commands.UnitOfMeasureCommand;
import com.kondratyev.spring5recipeapp.mappers.UnitOfMeasureMapper;
import com.kondratyev.spring5recipeapp.repositories.UnitOfMeasureRepository;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class UnitOfMeasureServiceImpl implements UnitOfMeasureService {

    private final UnitOfMeasureRepository unitOfMeasureRepository;
    private final UnitOfMeasureMapper unitOfMeasureMapper;

    public UnitOfMeasureServiceImpl(UnitOfMeasureRepository unitOfMeasureRepository,
                                    UnitOfMeasureMapper unitOfMeasureMapper) {
        this.unitOfMeasureRepository = unitOfMeasureRepository;
        this.unitOfMeasureMapper = unitOfMeasureMapper;
    }

    @Override
    public Set<UnitOfMeasureCommand> listAllUoms() {

        return StreamSupport.stream(unitOfMeasureRepository.findAll()
                .spliterator(), false)
                .map(unitOfMeasureMapper::unitOfMeasureToUnitOfMeasureCommand)
                .collect(Collectors.toSet());
    }
}
