package com.indra.book_my_show.Models;

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
    private UserEntity userEntity;

    //This is the child wrt showEntity
    @ManyToOne
    @JoinColumn
    private TheaterEntity theaterEntity;


    //Ticket is the child wrt to the show entity
    @ManyToOne
    @JoinColumn
    private ShowEntity showEntity;



}
