package com.kodilla.library.domain;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "BORROWINGS")
public class Borrowing {

    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "ID", unique = true)
    private Long id;

    @NotNull
    @Column(name = "BORROWED_FROM")
    private Date borrowedFrom;

    @Column(name = "BORROWED_TO")
    private Date borrowedTo;

    @Column(name = "PAID_FOR_DAMAGED")
    private boolean isPaidForDamaged;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ITEM_ID")
    private Item item;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "READER_ID")
    private Reader reader;
}
