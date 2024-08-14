package com.indra.book_my_show.Services;

import com.indra.book_my_show.EntryDtos.MovieEntryDto;
import com.indra.book_my_show.Models.MovieEntity;
import com.indra.book_my_show.Repositories.MovieRepository;
import com.indra.book_my_show.convertors.MovieConvertor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieService {

    @Autowired
    MovieRepository movieRepository;

    public String addMovie(MovieEntryDto movieEntryDto) throws Exception{
        MovieEntity movieEntity = MovieConvertor.convertEntryDtoToEntity(movieEntryDto);
        movieRepository.save(movieEntity);
        return "movie added successfully";
    }
}
