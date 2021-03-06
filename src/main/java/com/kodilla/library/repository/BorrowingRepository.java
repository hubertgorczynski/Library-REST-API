package com.kodilla.library.repository;

import com.kodilla.library.domain.Borrowing;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public interface BorrowingRepository extends CrudRepository<Borrowing, Long> {
}
