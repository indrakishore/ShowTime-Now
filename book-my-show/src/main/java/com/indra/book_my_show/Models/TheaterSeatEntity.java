package com.indra.book_my_show.Models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "theater_seats")
@Data
@NoArgsConstructor
public class TheaterSeatEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    // This is the child wrt theaterEntity
    @ManyToOne
    @JoinColumn(name = "theater_id")
    private TheaterEntity theaterEntity;

}
