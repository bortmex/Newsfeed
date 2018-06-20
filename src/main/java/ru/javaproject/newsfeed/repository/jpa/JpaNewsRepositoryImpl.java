package ru.javaproject.newsfeed.repository.jpa;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.javaproject.newsfeed.model.News;
import ru.javaproject.newsfeed.repository.NewsRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Collection;

@Repository
@Transactional(readOnly = true)
public class JpaNewsRepositoryImpl implements NewsRepository{

    @PersistenceContext
    private EntityManager em;

    @Override
    @Transactional
    public News save(News news) {
        if (news.isNew()) {
            em.persist(news);
            return news;
        } else {
            return em.merge(news);
        }
    }

    @Override
    @Transactional
    public boolean delete(int id) {
        return em.createNamedQuery(News.DELETE).setParameter("id", id).executeUpdate() != 0;
    }

    @Override
    public News get(int id) {
        return em.find(News.class, id);
    }

    @Override
    public Collection<News> getAll() {
        return em.createNamedQuery(News.ALL, News.class).getResultList();
    }
}
