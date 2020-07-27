package com.kodilla.library.service;

import com.kodilla.library.domain.Book;
import com.kodilla.library.domain.Item;
import com.kodilla.library.domain.Status;
import com.kodilla.library.domain.dto.ItemDto;
import com.kodilla.library.mapper.ItemMapper;
import com.kodilla.library.repository.BookRepository;
import com.kodilla.library.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemDbService {

    @Autowired
    private ItemRepository itemRepository;
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private ItemMapper itemMapper;

    public ItemDto saveItem(final ItemDto itemDto) {
        Book book = getBookById(itemDto.getBookId());
        Item item = new Item(book);
        itemRepository.save(item);
        return itemMapper.mapToItemDto(item);
    }

    public ItemDto updateStatus(final ItemDto itemDto) {
        Item item = getItemById(itemDto.getItemId());
        Book book = item.getBook();
        Status status = itemDto.getStatus();
        item.setStatus(status);
        item.setBook(book);
        itemRepository.save(item);
        return itemMapper.mapToItemDto(item);
    }

    public Long getNumberOfItemsByTitle(String title) {
        return itemRepository.countAllByTitleAndBook(title);
    }

    public Book getBookById(final Long id) {
        return bookRepository.findById(id).orElse(null);
    }

    public Item getItemById(final Long id) {
        return itemRepository.findById(id).orElse(null);
    }
}
