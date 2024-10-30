package com.indra.book_my_show.Controllers;

import com.indra.book_my_show.Request.AddTheaterSeatRequest;
import com.indra.book_my_show.Request.TheaterEntryDto;
import com.indra.book_my_show.Services.TheaterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/theater")
public class TheaterController {

    @Autowired
    TheaterService theaterService;

    @PostMapping("addTheater")
    public String addTheater(@RequestBody TheaterEntryDto theaterEntryDto) {
        String result = theaterService.addTheater(theaterEntryDto);
        return result;
    }

    //Add Theater Seats

    @PostMapping("addTheaterSeats")
    public String createTheaterSeats(@RequestBody AddTheaterSeatRequest addTheaterSeatRequest) {
        String result = theaterService.addTheaterSeat(addTheaterSeatRequest);
        return result;
    }

}
