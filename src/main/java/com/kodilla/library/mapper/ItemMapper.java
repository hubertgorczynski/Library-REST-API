package com.kodilla.library.mapper;

import com.kodilla.library.domain.Item;
import com.kodilla.library.domain.dto.ItemDto;
import org.springframework.stereotype.Component;

@Component
public class ItemMapper {

    public ItemDto mapToItemDto(final Item item) {
        return new ItemDto(
                item.getBook().getId(),
                item.getId(),
                item.getStatus()
        );
    }
}
