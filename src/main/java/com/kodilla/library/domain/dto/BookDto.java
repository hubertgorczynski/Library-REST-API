package com.kodilla.library.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class BookDto {
    private String title;
    private String author;
    private int publicationYear;
}
