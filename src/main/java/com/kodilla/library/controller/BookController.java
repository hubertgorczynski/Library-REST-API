package com.kodilla.library.controller;

import com.kodilla.library.domain.dto.BookDto;
import com.kodilla.library.service.BookDbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("v1/library")
public class BookController {

    private final BookDbService bookDbService;

    @Autowired
    public BookController(BookDbService bookDbService) {
        this.bookDbService = bookDbService;
    }

    @PostMapping(value = "book")
    public BookDto createBook(@RequestBody BookDto bookDto) {
        return bookDbService.saveBook(bookDto);
    }
}
