package com.indra.book_my_show.Request;


import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Data
public class BookTicketRequest {

    private String movieName;
    private LocalDate showDate;
    private LocalTime showTime;
    private List<String> requestedSeats;
    private Integer theaterId;
    private String mobileNumber;

}
