package com.kodilla.library.mapper;

import com.kodilla.library.domain.Book;
import com.kodilla.library.domain.Borrowing;
import com.kodilla.library.domain.Item;
import com.kodilla.library.domain.Reader;
import com.kodilla.library.domain.dto.BookDto;
import com.kodilla.library.domain.dto.BorrowingDto;
import com.kodilla.library.domain.dto.ItemDto;
import com.kodilla.library.domain.dto.ReaderDto;
import org.springframework.stereotype.Component;

@Component
public class LibraryMapper {

    public Book mapToBook(final BookDto bookDto) {
        return new Book(
                bookDto.getTitle(),
                bookDto.getAuthor(),
                bookDto.getPublicationYear()
        );
    }

    public BookDto mapToBookDto(final Book book) {
        return new BookDto(
                book.getTitle(),
                book.getAuthor(),
                book.getPublicationYear()
        );
    }

    public Reader mapToReader(final ReaderDto readerDto) {
        return new Reader(
                readerDto.getName(),
                readerDto.getLastName()
        );
    }

    public ReaderDto mapToReaderDto(final Reader reader) {
        return new ReaderDto(
                reader.getName(),
                reader.getLastName(),
                reader.getAccountCreated()
        );
    }

    public ItemDto mapToItemDto(final Item item) {
        return new ItemDto(
                item.getBook().getId(),
                item.getId(),
                item.getStatus()
        );
    }

    public BorrowingDto mapToBorrowingDto(final Borrowing borrowing) {
        return new BorrowingDto(
                borrowing.getReader().getId(),
                borrowing.getItem().getId(),
                borrowing.getId(),
                borrowing.isPaidForDamaged()
        );
    }
}
