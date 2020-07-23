package com.kodilla.library.controller;

import com.kodilla.library.domain.dto.BookDto;
import com.kodilla.library.domain.dto.BorrowingDto;
import com.kodilla.library.domain.dto.ItemDto;
import com.kodilla.library.domain.dto.ReaderDto;
import com.kodilla.library.mapper.LibraryMapper;
import com.kodilla.library.repository.BookRepository;
import com.kodilla.library.repository.ItemRepository;
import com.kodilla.library.service.LibraryDbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("v1/library")
public class LibraryController {

    @Autowired
    LibraryDbService libraryDbService;
    @Autowired
    BookRepository bookRepository;
    @Autowired
    ItemRepository itemRepository;
    @Autowired
    LibraryMapper libraryMapper;

    @RequestMapping(method = RequestMethod.POST, value = "createReader", consumes = APPLICATION_JSON_VALUE)
    public ReaderDto createReader(@RequestBody ReaderDto readerDto) {
        return libraryDbService.saveReader(readerDto);
    }

    @RequestMapping(method = RequestMethod.POST, value = "createBook", consumes = APPLICATION_JSON_VALUE)
    public BookDto createBook(@RequestBody BookDto bookDto) {
        return libraryDbService.saveBook(bookDto);
    }

    @RequestMapping(method = RequestMethod.POST, value = "createItem", consumes = APPLICATION_JSON_VALUE)
    public ItemDto createItem(@RequestBody ItemDto itemDto) {
        return libraryDbService.saveItem(itemDto);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "updateStatus")
    public ItemDto updateStatus(@RequestBody ItemDto itemDto) {
        return libraryDbService.updateStatus(itemDto);
    }

    @RequestMapping(method = RequestMethod.GET, value = "getNumberOfItemsByTitle")
    public Long getNumberOfItemsByTitle(@RequestParam String title) {
        return libraryDbService.getNumberOfItemsByTitle(title);
    }

    @RequestMapping(method = RequestMethod.POST, value = "createBorrowing", consumes = APPLICATION_JSON_VALUE)
    public BorrowingDto createBorrowing(@RequestBody BorrowingDto borrowingDto) {
        return libraryDbService.saveBorrowing(borrowingDto);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "returnBook")
    public BorrowingDto returnBook(@RequestBody BorrowingDto borrowingDto) {
        return libraryDbService.returnBook(borrowingDto);
    }
}
