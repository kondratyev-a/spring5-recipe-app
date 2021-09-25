package com.kondratyev.spring5recipeapp.mappers;

import com.kondratyev.spring5recipeapp.commands.UnitOfMeasureCommand;
import com.kondratyev.spring5recipeapp.domain.UnitOfMeasure;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UnitOfMeasureMapper {
    UnitOfMeasureCommand unitOfMeasureToUnitOfMeasureCommand(UnitOfMeasure unitOfMeasure);

    UnitOfMeasure unitOfMeasureCommandToUnitOfMeasure(UnitOfMeasureCommand unitOfMeasureCommand);
}