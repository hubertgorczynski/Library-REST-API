package com.kodilla.library.service;

import com.kodilla.library.domain.*;
import com.kodilla.library.domain.dto.BookDto;
import com.kodilla.library.domain.dto.BorrowingDto;
import com.kodilla.library.domain.dto.ItemDto;
import com.kodilla.library.domain.dto.ReaderDto;
import com.kodilla.library.mapper.LibraryMapper;
import com.kodilla.library.repository.BookRepository;
import com.kodilla.library.repository.BorrowingRepository;
import com.kodilla.library.repository.ItemRepository;
import com.kodilla.library.repository.ReaderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class LibraryDbService {
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private BorrowingRepository borrowingRepository;
    @Autowired
    private ItemRepository itemRepository;
    @Autowired
    private ReaderRepository readerRepository;
    @Autowired
    private LibraryMapper libraryMapper;

    public BookDto saveBook(final BookDto bookDto) {
        Book book = libraryMapper.mapToBook(bookDto);
        bookRepository.save(book);
        return libraryMapper.mapToBookDto(book);
    }

    public ReaderDto saveReader(final ReaderDto readerDto) {
        Reader reader = libraryMapper.mapToReader(readerDto);
        reader.setAccountCreated(new Date());
        readerRepository.save(reader);
        return libraryMapper.mapToReaderDto(reader);
    }

    public ItemDto saveItem(final ItemDto itemDto) {
        Book book = getBookById(itemDto.getBookId());
        Item item = new Item(book);
        itemRepository.save(item);
        return libraryMapper.mapToItemDto(item);
    }

    public ItemDto updateStatus(final ItemDto itemDto) {
        Item item = getItemById(itemDto.getItemId());
        Book book = item.getBook();
        Status status = itemDto.getStatus();
        item.setStatus(status);
        item.setBook(book);
        itemRepository.save(item);
        return libraryMapper.mapToItemDto(item);
    }

    public BorrowingDto saveBorrowing(final BorrowingDto borrowingDto) {
        Reader reader = getReaderById(borrowingDto.getReaderId());
        Item item = getItemById(borrowingDto.getItemId());
        Borrowing borrowing = new Borrowing(item, reader);
        borrowing.setBorrowedFrom(new Date());
        borrowingRepository.save(borrowing);
        return libraryMapper.mapToBorrowingDto(borrowing);
    }

    public BorrowingDto returnBook(final BorrowingDto borrowingDto) {
        Borrowing borrowing = getBorrowingById(borrowingDto.getBorrowingId());
        borrowing.setBorrowedTo(new Date());
        if (borrowingDto.isPaidForDamaged()) {
            borrowing.getItem().setStatus(Status.AVAILABLE);
            borrowing.setPaidForDamaged(true);
        }
        borrowingRepository.save(borrowing);
        return libraryMapper.mapToBorrowingDto(borrowing);
    }

    public Long getNumberOfItemsByTitle(String title) {
        return itemRepository.getNumberOfBookItemsByTitle(title);
    }

    public Book getBookById(final Long id) {
        return bookRepository.findById(id).orElse(null);
    }

    public Reader getReaderById(final Long id) {
        return readerRepository.findById(id).orElse(null);
    }

    public Item getItemById(final Long id) {
        return itemRepository.findById(id).orElse(null);
    }

    public Borrowing getBorrowingById(final Long id) {
        return borrowingRepository.findById(id).orElse(null);
    }
}
