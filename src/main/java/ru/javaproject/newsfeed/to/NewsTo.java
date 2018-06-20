package ru.javaproject.newsfeed.to;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDate;

public class NewsTo implements Serializable {
    private static final long serialVersionUID = 3L;

    private Integer id;

    @Length.List({
            @Length(min = 10, message = "должно быть более 10 символов"),
            @Length(max = 80, message = "должно быть не более 80 символов")
    })
    @NotBlank
    private String name;
    @Length.List({
            @Length(min = 10, message = "должно быть более 10 символов"),
            @Length(max = 2000, message = "должно быть не более 2000 символов")
    })
    @NotBlank
    private String content;

    private @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate datacreate;

    @NotNull
    private Integer categoriesid;

    public NewsTo() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getCategoriesid() {
        return categoriesid;
    }

    public LocalDate getDatacreate() {
        return datacreate;
    }

    public void setDatacreate(LocalDate datacreate) {
        this.datacreate = datacreate;
    }

    public void setCategoriesid(Integer categoriesid) {
        this.categoriesid = categoriesid;
    }

    @Override
    public String toString() {
        return "NewsTo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", content='" + content + '\'' +
                ", datacreate=" + datacreate +
                ", categoriesid=" + categoriesid +
                '}';
    }
}
