package com.kodilla.library.controller;

import com.kodilla.library.domain.dto.ReaderDto;
import com.kodilla.library.service.ReaderDbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("v1/library")
public class ReaderController {

    @Autowired
    private final ReaderDbService readerDbService;

    @Autowired
    public ReaderController(ReaderDbService readerDbService) {
        this.readerDbService = readerDbService;
    }

    @PostMapping(value = "reader")
    public ReaderDto createReader(@RequestBody ReaderDto readerDto) {
        return readerDbService.saveReader(readerDto);
    }
}
