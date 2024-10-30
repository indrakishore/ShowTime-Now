package com.indra.book_my_show.Models;

import com.indra.book_my_show.Enums.ShowType;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "shows")
@Getter
@Setter
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class ShowEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer showId;

    private LocalDate showDate; //"yyyy-mm-dd"
    private LocalTime showTime;//"HH:MM:SS"

    @Enumerated(value = EnumType.STRING)
    private ShowType showType;

//    @CreationTimestamp
//    private Date createdOn;

//    @UpdateTimestamp
//    private Date updateOn;

    //This is child wrt to the movieEntity
    @ManyToOne
    @JoinColumn
    private MovieEntity movieEntity;

    //This is the child wrt to TheaterEntity
    @ManyToOne
    @JoinColumn
    private TheaterEntity theaterEntity;

    //Show is parent wrt to the ticketEntity
    @OneToMany(mappedBy = "showEntity",cascade = CascadeType.ALL)
    private List<TicketEntity> listOfBookedTickets = new ArrayList<>();

    @OneToMany(mappedBy = "showEntity", cascade = CascadeType.ALL)
    private List<ShowSeatEntity> listOfShowSeats = new ArrayList<>();


}
