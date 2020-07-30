package com.kodilla.library.service;

import com.kodilla.library.domain.Borrowing;
import com.kodilla.library.domain.Item;
import com.kodilla.library.domain.Reader;
import com.kodilla.library.domain.Status;
import com.kodilla.library.domain.dto.BorrowingDto;
import com.kodilla.library.mapper.BorrowingMapper;
import com.kodilla.library.repository.BorrowingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class BorrowingDbService {

    private final BorrowingMapper borrowingMapper;
    private final BorrowingRepository borrowingRepository;
    private final ReaderDbService readerDbService;
    private final ItemDbService itemDbService;

    @Autowired
    public BorrowingDbService(BorrowingMapper borrowingMapper, BorrowingRepository borrowingRepository,
                              ReaderDbService readerDbService, ItemDbService itemDbService) {
        this.borrowingMapper = borrowingMapper;
        this.borrowingRepository = borrowingRepository;
        this.readerDbService = readerDbService;
        this.itemDbService = itemDbService;
    }

    public BorrowingDto saveBorrowing(final BorrowingDto borrowingDto) {
        Reader reader = readerDbService.getReaderById(borrowingDto.getReaderId());
        Item item = itemDbService.getItemById(borrowingDto.getItemId());
        Borrowing borrowing = new Borrowing(item, reader);
        borrowing.setBorrowedFrom(new Date());
        borrowingRepository.save(borrowing);
        return borrowingMapper.mapToBorrowingDto(borrowing);
    }

    public BorrowingDto returnBook(final BorrowingDto borrowingDto) {
        Borrowing borrowing = getBorrowingById(borrowingDto.getBorrowingId());
        borrowing.setBorrowedTo(new Date());
        if (borrowingDto.isPaidForDamaged()) {
            borrowing.getItem().setStatus(Status.AVAILABLE);
            borrowing.setPaidForDamaged(true);
        }
        borrowingRepository.save(borrowing);
        return borrowingMapper.mapToBorrowingDto(borrowing);
    }

    public Borrowing getBorrowingById(final Long id) {
        return borrowingRepository.findById(id).orElse(null);
    }
}
