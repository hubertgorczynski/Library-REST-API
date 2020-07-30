package com.kodilla.library.service;

import com.kodilla.library.domain.Reader;
import com.kodilla.library.domain.dto.ReaderDto;
import com.kodilla.library.mapper.ReaderMapper;
import com.kodilla.library.repository.ReaderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class ReaderDbService {

    private final ReaderRepository readerRepository;
    private final ReaderMapper readerMapper;

    @Autowired
    public ReaderDbService(ReaderRepository readerRepository, ReaderMapper readerMapper) {
        this.readerRepository = readerRepository;
        this.readerMapper = readerMapper;
    }

    public ReaderDto saveReader(final ReaderDto readerDto) {
        Reader reader = readerMapper.mapToReader(readerDto);
        reader.setAccountCreated(new Date());
        readerRepository.save(reader);
        return readerMapper.mapToReaderDto(reader);
    }

    public Reader getReaderById(final Long id) {
        return readerRepository.findById(id).orElse(null);
    }
}
