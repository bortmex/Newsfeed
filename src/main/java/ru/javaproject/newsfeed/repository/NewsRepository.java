package ru.javaproject.newsfeed.repository;

import ru.javaproject.newsfeed.model.News;

import java.util.Collection;

public interface NewsRepository {
    News save(News news);

    boolean delete(int id);

    News get(int id);

    Collection<News> getAll();
}
