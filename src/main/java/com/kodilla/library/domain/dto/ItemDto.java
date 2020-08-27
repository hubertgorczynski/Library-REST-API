package com.kodilla.library.domain.dto;

import com.kodilla.library.domain.Status;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ItemDto {
    private Long itemId;
    private Long bookId;
    private Status status;
}
