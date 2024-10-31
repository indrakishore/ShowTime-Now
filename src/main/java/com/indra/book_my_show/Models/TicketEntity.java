package com.indra.book_my_show.Models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;

@Entity
@Table(name = "tickets")
@Getter
@Setter
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class TicketEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID ticketId;

    private String movieName;

    private LocalDate showDate;

    private LocalTime showTime;

    private Integer totalAmountPaid;

    private String theaterNameAndAddress;

    @JoinColumn
    @ManyToOne
//    @JsonIgnore // This will exclude userEntity from JSON response
    private UserEntity userEntity;

    // This will exclude theaterEntity from JSON response
    @ManyToOne
    @JoinColumn
    @JsonIgnore
    private TheaterEntity theaterEntity;

    // This will exclude showEntity from JSON response
    @ManyToOne
    @JoinColumn
    @JsonIgnore
    private ShowEntity showEntity;

}
