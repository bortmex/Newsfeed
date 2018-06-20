package ru.javaproject.newsfeed.web.news;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import ru.javaproject.newsfeed.model.Categories;
import ru.javaproject.newsfeed.service.CategoriesService;
import ru.javaproject.newsfeed.web.catagories.AbstractNewsController;

import java.util.Collection;

public class AbstractCategoriesController {

    private static final Logger LOG = LoggerFactory.getLogger(AbstractNewsController.class);

    @Autowired
    private CategoriesService service;

    public Categories get(int id){
        LOG.info("get categories {} ", id);
        return service.get(id);
    }
    public Collection<Categories> getAll(){
        LOG.info("getAll()");
        return service.getAll();
    }

}
