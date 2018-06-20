package ru.javaproject.newsfeed.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import ru.javaproject.newsfeed.model.News;
import ru.javaproject.newsfeed.repository.NewsRepository;

import java.util.Collection;

import static ru.javaproject.newsfeed.util.ValidationUtil.checkNotFoundWithId;

@Service
public class NewsServiceImpl implements NewsService {

    @Autowired
    private NewsRepository repository;

    @Override
    public News save(News news) {
        Assert.notNull(news, "product must not be null");
        return repository.save(news);
    }

    @Override
    public News update(News news) {
        Assert.notNull(news,"news must not be null");
        return checkNotFoundWithId(repository.save(news), news.getId());
    }

    @Override
    public void delete(int id) {
        repository.delete(id);
    }

    @Override
    public News get(int id) {
        return repository.get(id);
    }

    @Override
    public Collection<News> getAll() {
        return repository.getAll();
    }
}
