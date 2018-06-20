package ru.javaproject.newsfeed.repository.jpa;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.javaproject.newsfeed.model.Categories;
import ru.javaproject.newsfeed.repository.CategoriesRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional(readOnly = true)
public class JpaCategoriesRepositoryImpl implements CategoriesRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    public Categories get(int id) {
        return em.find(Categories.class, id);
    }

    @Override
    public List<Categories> getAll() {
        return em.createNamedQuery(Categories.ALL, Categories.class).getResultList();
    }
}
