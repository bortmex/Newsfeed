package ru.javaproject.newsfeed.web.catagories;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import ru.javaproject.newsfeed.model.News;
import ru.javaproject.newsfeed.service.NewsService;

import java.util.Collection;

public abstract class AbstractNewsController {

    private static final Logger LOG = LoggerFactory.getLogger(AbstractNewsController.class);

    @Autowired
    private NewsService service;

    public News create(News news){
        LOG.info("create news {}", news);
        return service.save(news);
    }

    public void update(News news) {
        LOG.info("update news {}", news);
        service.update(news);
    }

    public News get(int id){
        LOG.info("get news {} ", id);
        return service.get(id);
    }

    public void delete(int id){
        LOG.info("delete news {}", id);
        service.delete(id);
    }

    public Collection<News> getAll(){
        LOG.info("getAll()");
        return service.getAll();
    }

}
