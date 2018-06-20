package ru.javaproject.newsfeed.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.javaproject.newsfeed.model.Categories;
import ru.javaproject.newsfeed.repository.CategoriesRepository;

import java.util.List;

@Service
public class CategoriesServiceImpl implements CategoriesService {

    @Autowired
    private CategoriesRepository repository;

    @Override
    public Categories get(int id) {
        return repository.get(id);
    }

    @Override
    public List<Categories> getAll() {
        return repository.getAll();
    }
}
