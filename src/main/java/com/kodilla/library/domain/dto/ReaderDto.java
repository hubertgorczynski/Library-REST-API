package com.kodilla.library.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Date;

@Getter
@AllArgsConstructor
public class ReaderDto {
    private String name;
    private String lastName;
    private Date accountCreated;
}
