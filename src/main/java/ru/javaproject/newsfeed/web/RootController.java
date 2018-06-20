package ru.javaproject.newsfeed.web;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import ru.javaproject.newsfeed.service.CategoriesService;
import ru.javaproject.newsfeed.service.NewsService;

import java.io.IOException;

@Controller
public class RootController {
    @Autowired
    private NewsService newsService;
    @Autowired
    private CategoriesService categoriesService;

    @GetMapping("/")
    public String root(ModelMap modelMap) {
        modelMap.addAttribute("categories", categoriesService.getAll());
        /*modelMap.addAttribute("news", newsService.getAll());*/
        return "index";
    }

    @GetMapping("/createnews")
    public String createNews(ModelMap modelMap) {
        modelMap.addAttribute("categories", categoriesService.getAll());
        return "createNews";
    }


    @GetMapping("/getnews/{id}")
    public String getNews(@PathVariable("id") int id, ModelMap modelMap) throws IOException {
        modelMap.addAttribute("categories", categoriesService.getAll());
        modelMap.addAttribute("editnew", true);
        modelMap.addAttribute("newsedit", newsService.get(id));
        return "createNews";
    }

}
