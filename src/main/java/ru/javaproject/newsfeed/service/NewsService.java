package ru.javaproject.newsfeed.service;

import ru.javaproject.newsfeed.model.News;

import java.util.Collection;

public interface NewsService {

    News save(News news);

    News update(News news);

    void delete(int id);

    News get(int id);

    Collection<News> getAll();
}
