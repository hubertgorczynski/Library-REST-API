package com.kodilla.library.domain;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Component
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@NamedNativeQuery(
        name = "Item.getNumberOfBookItemsByTitle",
        query = "SELECT COUNT (*) FROM BOOKS, ITEMS WHERE BOOKS.ID = ITEMS.BOOK_ID AND TITLE = :TITLE",
        resultClass = Item.class
)
@Entity
@Table(name = "ITEMS")
public class Item {

    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "ID", unique = true)
    private Long id;

    @Enumerated
    @Column(name = "STATUS")
    private Status status;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "BOOK_ID")
    private Book book;

    public Item(Book book) {
        this.book = book;
        this.status = Status.AVAILABLE;
    }
}
