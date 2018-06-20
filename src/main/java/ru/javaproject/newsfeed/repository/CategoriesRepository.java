package ru.javaproject.newsfeed.repository;

import ru.javaproject.newsfeed.model.Categories;

import java.util.List;

public interface CategoriesRepository {

    Categories get(int id);

    List<Categories> getAll();
}
