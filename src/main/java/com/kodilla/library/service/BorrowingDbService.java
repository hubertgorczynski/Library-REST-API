package com.kodilla.library.service;

import com.kodilla.library.domain.Borrowing;
import com.kodilla.library.domain.Item;
import com.kodilla.library.domain.Reader;
import com.kodilla.library.domain.Status;
import com.kodilla.library.domain.dto.BorrowingDto;
import com.kodilla.library.mapper.BorrowingMapper;
import com.kodilla.library.repository.BorrowingRepository;
import com.kodilla.library.repository.ItemRepository;
import com.kodilla.library.repository.ReaderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class BorrowingDbService {

    @Autowired
    private BorrowingMapper borrowingMapper;
    @Autowired
    private BorrowingRepository borrowingRepository;
    @Autowired
    private ReaderRepository readerRepository;
    @Autowired
    private ItemRepository itemRepository;

    public BorrowingDto saveBorrowing(final BorrowingDto borrowingDto) {
        Reader reader = getReaderById(borrowingDto.getReaderId());
        Item item = getItemById(borrowingDto.getItemId());
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

    public Reader getReaderById(final Long id) {
        return readerRepository.findById(id).orElse(null);
    }

    public Item getItemById(final Long id) {
        return itemRepository.findById(id).orElse(null);
    }

    public Borrowing getBorrowingById(final Long id) {
        return borrowingRepository.findById(id).orElse(null);
    }
}
