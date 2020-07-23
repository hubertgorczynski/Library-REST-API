package com.kodilla.library.domain;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "READERS")
public class Reader {

    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "ID", unique = true)
    private Long id;

    @NotNull
    @Column(name = "NAME")
    private String name;

    @NotNull
    @Column(name = "LAST_NAME")
    private String lastName;

    @Column(name = "ACCOUNT_CREATED")
    private Date accountCreated;

    @OneToMany(
            targetEntity = Borrowing.class,
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER,
            mappedBy = "reader")
    private List<Borrowing> readersBorrowings = new ArrayList<>();

    public Reader(String name, String lastName) {
        this.name = name;
        this.lastName = lastName;
    }
}
