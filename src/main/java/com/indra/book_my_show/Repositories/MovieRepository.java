package com.indra.book_my_show.Repositories;

import com.indra.book_my_show.Models.MovieEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends JpaRepository<MovieEntity, Integer> {

//    MovieEntity findMovieByMovieName(String movieName);

    //Custom Query for findMovieByMovieName
    @Query(value = "select * from movies m where m.movie_name=:movieName",nativeQuery = true)
    MovieEntity findMovie(String movieName);
}

