package com.indra.book_my_show.Repositories;

import com.indra.book_my_show.Models.MovieEntity;
import com.indra.book_my_show.Models.ShowEntity;
import com.indra.book_my_show.Models.TheaterEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalTime;

@Repository
public interface ShowRepository extends JpaRepository<ShowEntity, Integer> {

    public ShowEntity findShowEntityByShowDateAndShowTimeAndMovieEntityAndTheaterEntity(LocalDate showDate, LocalTime showTime, MovieEntity movie, TheaterEntity theater);
}
