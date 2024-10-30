package com.indra.book_my_show.Models;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "theaters")
@Getter
@Setter
@NoArgsConstructor
@Builder
@AllArgsConstructor

public class TheaterEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private String location;
    private Integer numberOfScreens;

//    private Integer classicSeatsCount;
//    private Integer premiumSeatsCount;

    //This is the parent wrt to theaterSeats
    @OneToMany(mappedBy = "theaterEntity", cascade = CascadeType.ALL)
    private List<TheaterSeatEntity> theaterSeatEntityList = new ArrayList<>();

    @OneToMany(mappedBy = "theaterEntity", cascade = CascadeType.ALL)
    private List<ShowEntity> showEntityList = new ArrayList<>();
}
