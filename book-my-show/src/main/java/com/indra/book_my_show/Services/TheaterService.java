package com.indra.book_my_show.Services;

import com.indra.book_my_show.EntryDtos.TheaterEntryDto;
import com.indra.book_my_show.Genres.SeatType;
import com.indra.book_my_show.Models.TheaterEntity;
import com.indra.book_my_show.Models.TheaterSeatEntity;
import com.indra.book_my_show.Repositories.TheaterSeatRepository;
import com.indra.book_my_show.convertors.TheaterConvertors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TheaterService {

    @Autowired
    TheaterSeatRepository theaterSeatRepository;

    public String addTheater(TheaterEntryDto theaterEntryDto) {

        /**
         * Steps:
         * 1. create theater seats
         * 2. I need to save theater : need theaterEntity
         * 3. Always set the attribute before saving.
         */

        TheaterEntity theaterEntity = TheaterConvertors.convertDtoToEntity(theaterEntryDto);

        // Pass only theaterEntryDto to match the createTheaterSeats method signature
        List<TheaterSeatEntity> theaterSeatEntityList = createTheaterSeats(theaterEntryDto, theaterEntity);

        // Optionally save the theaterEntity if needed, e.g.:
        // theaterRepository.save(theaterEntity);

        return "Theater added successfully!";
    }

    // Modify the createTheaterSeats method to accept two parameters
    private List<TheaterSeatEntity> createTheaterSeats(TheaterEntryDto theaterEntryDto, TheaterEntity theaterEntity) {
        int noClassicSeats = theaterEntryDto.getClassicSeatsCount();
        int noPremiumSeats = theaterEntryDto.getPremiumSeatsCount(); // Correct the typo here

        List<TheaterSeatEntity> theaterSeatEntityList = new ArrayList<>();

        // Create the classic seats
        for (int count = 1; count <= noClassicSeats; count++) {
            theaterSeatEntityList.add(
                    TheaterSeatEntity.builder()
                            .seatType(SeatType.CLASSIC)
                            .seatNo(count + "C")
                            .theaterEntity(theaterEntity) // Theater entity is now correctly passed
                            .build()
            );
        }

        // Create the premium seats
        for (int count = 1; count <= noPremiumSeats; count++) {
            theaterSeatEntityList.add(
                    TheaterSeatEntity.builder()
                            .seatType(SeatType.PREMIUM)
                            .seatNo(count + "P")
                            .theaterEntity(theaterEntity) // Theater entity is now correctly passed
                            .build()
            );
        }

        theaterSeatRepository.saveAll(theaterSeatEntityList);
        return theaterSeatEntityList;
    }
}
