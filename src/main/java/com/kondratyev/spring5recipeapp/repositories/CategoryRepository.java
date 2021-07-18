package com.kondratyev.spring5recipeapp.repositories;

import com.kondratyev.spring5recipeapp.domain.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, Long> {
}
