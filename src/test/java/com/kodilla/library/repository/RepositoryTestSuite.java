package com.kodilla.library.repository;

import com.kodilla.library.domain.Book;
import com.kodilla.library.domain.Borrowing;
import com.kodilla.library.domain.Item;
import com.kodilla.library.domain.Reader;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RepositoryTestSuite {
    @Autowired
    BookRepository bookRepository;
    @Autowired
    BorrowingRepository borrowingRepository;
    @Autowired
    ItemRepository itemRepository;
    @Autowired
    ReaderRepository readerRepository;

    @Test
    public void testBookRepository() {
        //Given
        Book book1 = new Book("Test title", "Test author", 1973);
        bookRepository.save(book1);
        long id = book1.getId();

        //Then
        Assert.assertNotEquals(0, id);

        //CleanUp
        bookRepository.delete(book1);
    }

    @Test
    public void testBorrowingRepository() {
        //Given
        Book book1 = new Book("Test title 1", "Test author 1", 1992);
        Book book2 = new Book("Test title 2", "Test author 2", 1956);

        Item item1 = new Item(book1);
        Item item2 = new Item(book2);

        Reader reader = new Reader("John", "Smith");
        Borrowing borrowing1 = new Borrowing(item1, reader);
        Borrowing borrowing2 = new Borrowing(item2, reader);

        reader.getReadersBorrowings().add(borrowing1);
        reader.getReadersBorrowings().add(borrowing2);

        //When
        borrowingRepository.save(borrowing1);
        long id1 = borrowing1.getId();
        borrowingRepository.save(borrowing2);
        long id2 = borrowing2.getId();

        //Then
        Assert.assertNotEquals(0, id1);
        Assert.assertNotEquals(0, id2);

        //CleanUp
        borrowingRepository.delete(borrowing1);
        borrowingRepository.delete(borrowing2);
    }

    @Test
    public void testItemRepository() {
        //Given
        Book book1 = new Book("Test title", "Test author", 1972);
        Item item1 = new Item(book1);

        //When
        itemRepository.save(item1);
        long id = item1.getId();

        //Then
        Assert.assertNotEquals(0, id);

        //CleanUp
        itemRepository.delete(item1);
    }

    @Test
    public void testReaderRepository() {
        //Given
        Reader reader = new Reader("John", "Smith");

        //When
        readerRepository.save(reader);
        long id = reader.getId();

        //Then
        Assert.assertNotEquals(0, id);

        //CleanUp
        readerRepository.delete(reader);
    }
}
