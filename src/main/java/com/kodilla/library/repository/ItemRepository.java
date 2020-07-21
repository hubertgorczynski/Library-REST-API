package com.kodilla.library.repository;

import com.kodilla.library.domain.Item;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public interface ItemRepository extends CrudRepository<Item, Long> {
    @Query(nativeQuery = true)
    Long getNumberOfBookItemsByTitle(@Param("TITLE") String title);
}
