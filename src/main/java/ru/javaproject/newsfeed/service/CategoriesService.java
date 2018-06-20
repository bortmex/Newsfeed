package ru.javaproject.newsfeed.service;

import ru.javaproject.newsfeed.model.Categories;

import java.util.List;

public interface CategoriesService {

    Categories get(int id);

    List<Categories> getAll();
}
