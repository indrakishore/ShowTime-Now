package com.indra.book_my_show.Models;

import com.indra.book_my_show.Genres.SeatType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "theater_seats")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TheaterSeatEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private SeatType seatType;
    private String seatNo;

    // This is the child wrt theaterEntity
    @ManyToOne
    @JoinColumn(name = "theater_id")
    private TheaterEntity theaterEntity;

}
