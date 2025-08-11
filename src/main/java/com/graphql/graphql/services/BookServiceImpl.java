package com.graphql.graphql.services;

import com.graphql.graphql.persistence.entity.Author;
import com.graphql.graphql.persistence.entity.Book;
import com.graphql.graphql.persistence.repository.AuthorRepository;
import com.graphql.graphql.persistence.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private AuthorRepository authorRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Book> findAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Book> findBooksByAuthorId(Integer id) {
        Author findAuthor = authorRepository.findById(id).orElse(null);
        if(findAuthor == null){
            return null;
        }
        return bookRepository.findBooksByAuthorId(findAuthor.getId());
    }

    @Override
    @Transactional(readOnly = true)
    public Book findByName(String name) {
        return bookRepository.findBookByTitle(name);
    }

    @Override
    @Transactional
    public void saveBook(Book book) {
        Book book2 = bookRepository.findById(book.getId()).orElse(null);
        if(book2 == null){
            bookRepository.save(book);
        }
    }

    @Override
    @Transactional
    public void deleteBookById(Integer id) {
        bookRepository.findById(id).ifPresent(bookRepository::delete);
    }
}
