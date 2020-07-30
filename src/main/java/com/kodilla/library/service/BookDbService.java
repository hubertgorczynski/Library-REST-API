package com.kodilla.library.service;

import com.kodilla.library.domain.Book;
import com.kodilla.library.domain.dto.BookDto;
import com.kodilla.library.mapper.BookMapper;
import com.kodilla.library.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookDbService {

    private final BookMapper bookMapper;
    private final BookRepository bookRepository;

    @Autowired
    public BookDbService(BookMapper bookMapper, BookRepository bookRepository) {
        this.bookMapper = bookMapper;
        this.bookRepository = bookRepository;
    }

    public BookDto saveBook(final BookDto bookDto) {
        Book book = bookMapper.mapToBook(bookDto);
        bookRepository.save(book);
        return bookMapper.mapToBookDto(book);
    }

    public Book getBookById(final Long id) {
        return bookRepository.findById(id).orElse(null);
    }
}
