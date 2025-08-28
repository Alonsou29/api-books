package com.graphql.graphql.controllers;

import com.graphql.graphql.persistence.entity.Book;
import com.graphql.graphql.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

@Controller
public class BookController {

    @Autowired
    private BookService bookService;

    @QueryMapping
    public Book bookByTitle(@Argument String name){
        return bookService.findByName(name);
    }

    @QueryMapping
    public Book bookById(@Argument int id){
        return bookService.findBookById(id);
    }
}
