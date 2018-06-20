package ru.javaproject.newsfeed.model;

import javax.persistence.*;

@SuppressWarnings("JpaQlInspection")
@NamedQueries({
        @NamedQuery(name = Categories.ALL, query = "SELECT c FROM Categories c ORDER BY c.id")
})
@Entity
@Access(AccessType.FIELD)
@Table(name = "categories")
public class Categories extends NamedEntity{
    public static final String ALL = "Categories.getAll";

    public Categories() {
    }

    public Categories(Integer id, String name) {
        super(id, name);
    }
}
