package ru.javaproject.newsfeed.model;

import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@SuppressWarnings("JpaQlInspection")
@NamedQueries({
        @NamedQuery(name = News.ALL, query = "SELECT n FROM News n ORDER BY n.id"),
        @NamedQuery(name = News.UPDATE, query = "UPDATE News n SET n.name=:name, n.content=:content WHERE n.id=:id"),
        @NamedQuery(name = News.DELETE, query = "DELETE FROM News n WHERE n.id=:id")
})

@Entity
@Table(name = "newsfeed")
@Access(AccessType.FIELD)
public class News extends NamedEntity{
    public static final String UPDATE = "News.select";
    public static final String DELETE = "News.delete";
    public static final String ALL = "News.getAll";

    public News() {
    }

    public News(String name, String content, LocalDate datacreate, Categories categories) {
        this(null, name, content, datacreate, categories);
    }

    public News(Integer id, String name, String content, LocalDate datacreate, Categories categories) {
        super(id, name);
        this.content = content;
        this.datacreate = datacreate;
        this.categories = categories;
    }

    @NotBlank
    private String content;

    @Column(name = "datacreate")
    @NotNull
    private LocalDate datacreate;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="categories_id", nullable = false)
    private Categories categories;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDate getDatacreate() {
        return datacreate;
    }

    public void setDatacreate(LocalDate datacreate) {
        this.datacreate = datacreate;
    }

    public Categories getCategories() {
        return categories;
    }

    public void setCategories(Categories categories) {
        this.categories = categories;
    }

    @Override
    public String toString() {
        return "News{" +
                "content='" + content + '\'' +
                ", datacreate=" + datacreate +
                ", categories=" + categories +
                '}';
    }
}
