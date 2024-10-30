package com.indra.book_my_show.Services;

import com.indra.book_my_show.Enums.SeatType;
import com.indra.book_my_show.Models.*;
import com.indra.book_my_show.Repositories.MovieRepository;
import com.indra.book_my_show.Repositories.ShowRepository;
import com.indra.book_my_show.Repositories.ShowSeatRepository;
import com.indra.book_my_show.Repositories.TheaterRepository;
import com.indra.book_my_show.Request.AddShowRequest;
import com.indra.book_my_show.Request.AddShowSeatsRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import java.util.Optional;

@Service
public class ShowService {

    @Autowired
    private ShowRepository showRepository;

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private TheaterRepository theaterRepository;

    @Autowired
    private ShowSeatRepository showSeatRepository;

    public String addShow(AddShowRequest addShowRequest) {
        //I need to get the MovieEntity and TheaterEntity: bcz need to create showEntity
        MovieEntity movie = movieRepository.findMovie(addShowRequest.getMovieName());

        Optional<TheaterEntity> theater = theaterRepository.findById(addShowRequest.getTheaterId());

        //Build an object of the show entity and save it to the DB
        ShowEntity show = ShowEntity.builder()
                .showDate(addShowRequest.getShowDate())
                .showTime(addShowRequest.getShowTime())
                .movieEntity(movie)
                .theaterEntity(theater.get())
                .build();

        show = showRepository.save(show);
        return "The Show added Successfully with showId + " + show;
    }

    public String addShowSeats(AddShowSeatsRequest showSeatsRequest) {
        Integer showId = showSeatsRequest.getShowId();
        ShowEntity show = showRepository.findById(showId).orElse(null);

        TheaterEntity theater = show.getTheaterEntity();
        List<TheaterSeatEntity> theaterSeatEntityList = theater.getTheaterSeatEntityList();

        //Your goal is generation of show seat list
        List<ShowSeatEntity> showSeatEntityList = new ArrayList<>();

        for(TheaterSeatEntity theaterSeat : theaterSeatEntityList) {
            ShowSeatEntity showSeat = ShowSeatEntity.builder()
                    .seatNumber(theaterSeat.getSeatNo())
                    .seatType(theaterSeat.getSeatType())
                    .isBooked(Boolean.TRUE)
                    .showEntity(show)
                    .build();
            if(theaterSeat.getSeatType().equals(SeatType.CLASSIC)) {
                showSeat.setPrice(showSeatsRequest.getPriceOfClassicSeat());
            } else {
                showSeat.setPrice(showSeatsRequest.getPriceOfPremiumSeat());
            }
            showSeatEntityList.add(showSeat);
        }

        showSeatRepository.saveAll(showSeatEntityList);

        return "The Show added Successfully with showId + " + show;
    }
}
