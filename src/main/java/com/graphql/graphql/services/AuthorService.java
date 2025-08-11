package com.graphql.graphql.services;

import com.graphql.graphql.persistence.entity.Author;

import java.util.List;

public interface AuthorService {

    void saveAuthor(Author author);

    List<Author> findAllAuthors();

    Author findAuthorById(Integer id);

    void deleteAuthorById(Integer id);

}
