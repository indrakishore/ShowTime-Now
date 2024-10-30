package com.indra.book_my_show.Services;

import com.indra.book_my_show.Repositories.TheaterRepository;
import com.indra.book_my_show.Request.AddTheaterSeatRequest;
import com.indra.book_my_show.Request.TheaterEntryDto;
import com.indra.book_my_show.Enums.SeatType;
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

    @Autowired
    TheaterRepository theaterRepository;

    public String addTheater(TheaterEntryDto theaterEntryDto) {

        //Convert this AddRequestDto to an Entity
        //how to do this ??
                //Either use constructor to create an object: Generally constructors are not available
                //Create an object :
        /**
         * Steps:
         * 1. create theater seats
         * 2. I need to save theater : need theaterEntity
         * 3. Always set the attribute before saving.
         */

        //Modern way of creating the object is:
//        TheaterEntity theater = TheaterEntity.builder().address(TheaterEntryDto.getLocation())

        TheaterEntity theaterEntity = TheaterConvertors.convertDtoToEntity(theaterEntryDto);

        // Pass only theaterEntryDto to match the createTheaterSeats method signature
//        List<TheaterSeatEntity> theaterSeatEntityList = createTheaterSeats(theaterEntryDto, theaterEntity);

        // Optionally save the theaterEntity if needed, e.g.:
         theaterEntity = theaterRepository.save(theaterEntity);

        return "Theater added successfully with id: " + theaterEntity.getId();
    }

    //latest
    public String addTheaterSeat(AddTheaterSeatRequest addTheaterSeatRequest) {
        int noOfClassicSeats = addTheaterSeatRequest.getNoOfClassicSeats();
        int noOfPremiumSeats = addTheaterSeatRequest.getNoOfPremiumSeats();

        Integer theaterId = addTheaterSeatRequest.getTheaterId();
        TheaterEntity theater = theaterRepository.findById(theaterId).get();

        int classicSeatsCounter = 1;
        char ch='A';
        int rowNumber = 1;

        List<TheaterSeatEntity> theaterSeatEntityList = new ArrayList<>();

        while(classicSeatsCounter <= noOfClassicSeats) {
            String seatNo = rowNumber +""+ ch;
            TheaterSeatEntity theaterSeat = TheaterSeatEntity.builder()
                                                .seatNo(seatNo)
                                                .seatType(SeatType.CLASSIC)
                                                .theaterEntity(theater)
                                                .build();
            theaterSeatEntityList.add(theaterSeat);

            ch++; //incrementing the char by 1

            if(classicSeatsCounter % 5 == 0) {
                rowNumber = rowNumber + 1;
                ch = 'A';
            }
            classicSeatsCounter++;
        }

        //Premium Seat
        int premiumSeatsCounter = 1;
         ch='A';
         if(classicSeatsCounter%5 != 1)
            rowNumber = rowNumber + 1;


        while(premiumSeatsCounter <= noOfPremiumSeats) {
            String seatNo = rowNumber+""+ch;
            TheaterSeatEntity theaterSeat = TheaterSeatEntity.builder()
                    .seatNo(seatNo)
                    .seatType(SeatType.PREMIUM)
                    .theaterEntity(theater)//why we are saving this-> setting the unidirectional
                    .build();

            theaterSeatEntityList.add(theaterSeat);

            ch++; //incrementing the char by 1

            if(premiumSeatsCounter % 5 == 0) {
                rowNumber = rowNumber + 1;
                ch = 'A';
            }
            premiumSeatsCounter++;
        }

        //bidirectional
        theater.setTheaterSeatEntityList(theaterSeatEntityList);
//        theaterSeatRepository.saveAll(theaterSeatEntityList);//TheaterSeat will get automatically saved bcz of cascading property
//        written in parent table.
        theaterRepository.save(theater);
        return "Theater seat have been generated successfully!";
    }

    // Modify the createTheaterSeats method to accept two parameters
//    private List<TheaterSeatEntity> createTheaterSeats(TheaterEntryDto theaterEntryDto, TheaterEntity theaterEntity) {
//        int noClassicSeats = theaterEntryDto.getClassicSeatsCount();
//        int noPremiumSeats = theaterEntryDto.getPremiumSeatsCount(); // Correct the typo here
//
//        List<TheaterSeatEntity> theaterSeatEntityList = new ArrayList<>();
//
//        // Create the classic seats
//        for (int count = 1; count <= noClassicSeats; count++) {
//            theaterSeatEntityList.add(
//                    TheaterSeatEntity.builder()
//                            .seatType(SeatType.CLASSIC)
//                            .seatNo(count + "C")
//                            .theaterEntity(theaterEntity) // Theater entity is now correctly passed
//                            .build()
//            );
//        }
//
//        // Create the premium seats
//        for (int count = 1; count <= noPremiumSeats; count++) {
//            theaterSeatEntityList.add(
//                    TheaterSeatEntity.builder()
//                            .seatType(SeatType.PREMIUM)
//                            .seatNo(count + "P")
//                            .theaterEntity(theaterEntity) // Theater entity is now correctly passed
//                            .build()
//            );
//        }
//
//        theaterSeatRepository.saveAll(theaterSeatEntityList);
//        return theaterSeatEntityList;
//    }
}
