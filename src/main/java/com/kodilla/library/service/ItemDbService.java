package com.kodilla.library.service;

import com.kodilla.library.domain.Book;
import com.kodilla.library.domain.Item;
import com.kodilla.library.domain.Status;
import com.kodilla.library.domain.dto.ItemDto;
import com.kodilla.library.mapper.ItemMapper;
import com.kodilla.library.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemDbService {

    private final ItemRepository itemRepository;
    private final ItemMapper itemMapper;
    private final BookDbService bookDbService;

    @Autowired
    public ItemDbService(ItemRepository itemRepository, ItemMapper itemMapper, BookDbService bookDbService) {
        this.itemRepository = itemRepository;
        this.itemMapper = itemMapper;
        this.bookDbService = bookDbService;
    }

    public ItemDto saveItem(final ItemDto itemDto) {
        Book book = bookDbService.getBookById(itemDto.getBookId());
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
        return itemRepository.countAllByBook_Title(title);
    }

    public Item getItemById(final Long id) {
        return itemRepository.findById(id).orElse(null);
    }
}
