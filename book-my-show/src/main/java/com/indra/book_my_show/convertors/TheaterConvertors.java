package com.indra.book_my_show.convertors;

import com.indra.book_my_show.EntryDtos.TheaterEntryDto;
import com.indra.book_my_show.Models.TheaterEntity;

public class TheaterConvertors {

    public static TheaterEntity convertDtoToEntity(TheaterEntryDto theaterEntityDto) {
        return TheaterEntity.builder()
                .location(theaterEntityDto.getLocation())
                .name(theaterEntityDto.getName())
                .build(); // Corrected to build()
    }
}

