package com.indra.book_my_show.Models;

import com.indra.book_my_show.Enums.SeatType;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Table(name = "show_seats")
@Getter
@Setter
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class ShowSeatEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer showSeatId;

    private boolean isAvailable;
    private Integer price; //price for the Classic seat for that particular
    private String seatNumber;

    @Enumerated(value = EnumType.STRING)
    private SeatType seatType;

//    private Date bookedAt;

    @ManyToOne
    @JoinColumn
    private ShowEntity showEntity;





}
