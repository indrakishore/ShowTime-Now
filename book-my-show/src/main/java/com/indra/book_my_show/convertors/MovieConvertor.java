package com.indra.book_my_show.convertors;

import com.indra.book_my_show.EntryDtos.MovieEntryDto;
import com.indra.book_my_show.Models.MovieEntity;

public class MovieConvertor {

    public static MovieEntity convertEntryDtoToEntity(MovieEntryDto movieEntryDto) {

        // Using the builder pattern to create a MovieEntity instance
        MovieEntity movieEntity = MovieEntity.builder()
                .movieName(movieEntryDto.getMovieName())
                .duration(movieEntryDto.getDuration())
                .genre(movieEntryDto.getGenre())
                .language(movieEntryDto.getLanguage())
                .rating(movieEntryDto.getRating())
                .build(); // Correctly call build() to create the MovieEntity object

        // Return the created MovieEntity
        return movieEntity;
    }
}
