package com.indra.book_my_show.convertors;

import com.indra.book_my_show.Request.TheaterEntryDto;
import com.indra.book_my_show.Models.TheaterEntity;

public class TheaterConvertors {

    public static TheaterEntity convertDtoToEntity(TheaterEntryDto theaterEntityDto) {
        return TheaterEntity.builder()
                .location(theaterEntityDto.getLocation())
                .numberOfScreens(theaterEntityDto.getNumberOfScreens())
                .name(theaterEntityDto.getName())
//                .classicSeatsCount(theaterEntityDto.getClassicSeatsCount())
//                .premiumSeatsCount(theaterEntityDto.getPremiumSeatsCount())
                .build(); // Corrected to build()
    }
}

