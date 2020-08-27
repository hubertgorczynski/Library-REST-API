package com.kodilla.library.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ReaderDto {
    private String name;
    private String lastName;
    private Date accountCreated;
}
