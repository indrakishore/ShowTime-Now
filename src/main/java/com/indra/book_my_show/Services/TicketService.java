package com.indra.book_my_show.Services;

import com.indra.book_my_show.Exceptions.SeatUnavailableException;
import com.indra.book_my_show.Models.*;
import com.indra.book_my_show.Repositories.*;
import com.indra.book_my_show.Request.BookTicketRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketService {

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private TheaterRepository theaterRepository;

    @Autowired
    private ShowRepository showRepository;

    @Autowired
    private ShowSeatRepository showSeatRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TicketRepository ticketRepository;

    public TicketEntity bookTicket(BookTicketRequest bookTicketRequest) throws Exception {

        //1. Calculate the total cost of the ticket
        MovieEntity movie = movieRepository.findMovieByMovieName(bookTicketRequest.getMovieName());

        TheaterEntity theater = theaterRepository.findById(bookTicketRequest.getTheaterId()).get();

            //1.1 find the showEntity with this date and time
        ShowEntity show = showRepository.findShowEntityByShowDateAndShowTimeAndMovieEntityAndTheaterEntity(
                bookTicketRequest.getShowDate(), bookTicketRequest.getShowTime(),movie, theater);

        Integer showId = show.getShowId();
        List<ShowSeatEntity> showSeatList = showSeatRepository.findShowSeats(showId);

        //Calculate the total ammount if all the seats mentioned are available or not
        Integer totalAmount = 0;
        Boolean areAllSeatsAvailable = Boolean.TRUE;

        for (String seatNo: bookTicketRequest.getRequestedSeats()) {
            for(ShowSeatEntity showSeat: showSeatList) {
                if(showSeat.getSeatNumber().equals(seatNo)) {

                    if(showSeat.isBooked() == Boolean.FALSE) {
                        areAllSeatsAvailable = Boolean.FALSE;
                        break;
                    }
                    totalAmount = totalAmount + showSeat.getPrice();
                }
            }
        }

        if(areAllSeatsAvailable == Boolean.FALSE) {
            throw new SeatUnavailableException("The requested seat is not available");
        }

        //2. Make the seats booked (only if seats are available otherwise throw exception)

        for (String seatNo: bookTicketRequest.getRequestedSeats()) {
            for(ShowSeatEntity showSeat: showSeatList) {
                if(showSeat.getSeatNumber().equals(seatNo)) {
                    showSeat.setBooked(Boolean.FALSE);
                }
            }
        }

        UserEntity user = userRepository.findUserEntitiesByMobileNo(bookTicketRequest.getMobileNumber());
        //3. Save the ticketEntity
        TicketEntity ticket = TicketEntity.builder().userEntity(user)
                .movieName(bookTicketRequest.getMovieName())
                .showDate(bookTicketRequest.getShowDate())
                .theaterNameAndAddress(theater.getName()+" "+theater.getLocation())
                .showTime(bookTicketRequest.getShowTime())
                .totalAmountPaid(totalAmount)
                .build();

        //4. Generate and return back the actual ticket response
        ticket = ticketRepository.save(ticket);

        return ticket;
    }
}
