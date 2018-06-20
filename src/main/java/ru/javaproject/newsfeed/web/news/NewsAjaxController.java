package ru.javaproject.newsfeed.web.news;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.javaproject.newsfeed.model.Categories;
import ru.javaproject.newsfeed.model.News;
import ru.javaproject.newsfeed.to.NewsTo;
import ru.javaproject.newsfeed.util.NewsUtil;
import ru.javaproject.newsfeed.util.ValidationUtil;
import ru.javaproject.newsfeed.web.catagories.AbstractNewsController;

import javax.validation.Valid;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/ajax")
public class NewsAjaxController extends AbstractNewsController {

    @GetMapping(value = "/getall", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<News> getAllNews() {
        return (List<News>) super.getAll();
    }

    @GetMapping(value = "/getallfiltercategorieswithoutid/name{name}/content{content}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<News> getAllNewswithFilterWithOutId( @PathVariable("name") String name, @PathVariable("content") String content) {
        return NewsUtil.getNewsWithFiltergetWithOutId( (List<News>) super.getAll(), name, content);
    }

    @GetMapping(value = "/getallfiltercategories/{idcategories}/name{name}/content{content}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<News> getAllNewswithFilter(@PathVariable("idcategories") Integer id, @PathVariable("name") String name, @PathVariable("content") String content) {
        return NewsUtil.getNewsWithFilterget( (List<News>) super.getAll(), id, name, content);
    }

    @DeleteMapping("/deletenews/{id}")
    public void deleteProd(@PathVariable("id") int id) {
        delete(id);
    }

    @PostMapping("/createnews")
    public ResponseEntity<String> update(@Valid NewsTo newsTo, BindingResult bindingResult, BindingResult result) throws IOException {
        if (result.hasErrors()) {
            return ValidationUtil.getErrorResponse(result);
        }
        if (newsTo.getId() == null)
            super.create(new News(newsTo.getName(), newsTo.getContent(), LocalDate.now(), new Categories(newsTo.getCategoriesid(), "")));
        else
            super.update(new News(newsTo.getId(), newsTo.getName(), newsTo.getContent(), newsTo.getDatacreate(), new Categories(newsTo.getCategoriesid(), "")));

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
