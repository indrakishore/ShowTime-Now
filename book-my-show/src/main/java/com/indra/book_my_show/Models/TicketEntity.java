package com.indra.book_my_show.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;

@Entity
@Table(name = "tickets")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TicketEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String movieName;
    private LocalDate showDate;
    private LocalTime showTime;
    private int totalAmount;
    private String tickedId = UUID.randomUUID().toString();
    private String theaterName;

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
