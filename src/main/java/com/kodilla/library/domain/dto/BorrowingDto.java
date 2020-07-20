package com.kodilla.library.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class BorrowingDto {
    private Long borrowingId;
    private Long itemId;
    private Long readerId;
    private boolean isPaidForDamaged;
}
