package ru.javaproject.newsfeed.util;

import ru.javaproject.newsfeed.model.News;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class NewsUtil {
    public static List<News> getNewsWithFilterget(List<News> newsList, Integer id, String name, String content){
        return newsList.stream().filter(x-> Objects.equals(x.getCategories().getId(), id)).filter(x-> x.getName().contains(name)).filter(x-> x.getContent().contains(content)).collect(Collectors.toList());
    }

    public static List<News> getNewsWithFiltergetWithOutId(List<News> newsList, String name, String content){
        return newsList.stream().filter(x-> x.getName().contains(name)).filter(x-> x.getContent().contains(content)).collect(Collectors.toList());
    }

}
