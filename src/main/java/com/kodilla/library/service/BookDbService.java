package com.kodilla.library.service;

import com.kodilla.library.domain.Book;
import com.kodilla.library.domain.dto.BookDto;
import com.kodilla.library.mapper.BookMapper;
import com.kodilla.library.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookDbService {

    @Autowired
    private BookMapper bookMapper;
    @Autowired
    private BookRepository bookRepository;

    public BookDto saveBook(final BookDto bookDto) {
        Book book = bookMapper.mapToBook(bookDto);
        bookRepository.save(book);
        return bookMapper.mapToBookDto(book);
    }
}
