package com.indra.book_my_show.Repositories;

import com.indra.book_my_show.Models.ShowEntity;
import com.indra.book_my_show.Models.ShowSeatEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShowSeatRepository extends JpaRepository<ShowSeatEntity, Integer> {

//    public List<ShowSeatEntity> findAllByShowEntity(ShowEntity showEntity);//inbuilt

     //custom JPA Query
    @Query(value = "select  * from show_seats where showid=:showId", nativeQuery = true)
    public List<ShowSeatEntity> findShowSeats(Integer showId);
}
