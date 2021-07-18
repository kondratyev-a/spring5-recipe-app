package com.kondratyev.spring5recipeapp.repositories;

import com.kondratyev.spring5recipeapp.domain.UnitOfMeasure;
import org.springframework.data.repository.CrudRepository;

public interface UnitOfMeasureRepository extends CrudRepository<UnitOfMeasure, Long> {
}
