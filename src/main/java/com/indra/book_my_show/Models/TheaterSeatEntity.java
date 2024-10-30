package com.indra.book_my_show.Models;

import com.indra.book_my_show.Enums.SeatType;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "theater_seats")
@Getter
@Setter
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class TheaterSeatEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Enumerated(value =  EnumType.STRING)
    private SeatType seatType;
    private String seatNo;

    // This is the child wrt theaterEntity
    @ManyToOne
    @JoinColumn(name = "theater_id")
    private TheaterEntity theaterEntity;

}
