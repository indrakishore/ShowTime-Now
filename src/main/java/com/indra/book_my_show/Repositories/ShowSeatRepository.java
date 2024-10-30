package com.indra.book_my_show.Repositories;

import com.indra.book_my_show.Models.ShowSeatEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShowSeatRepository extends JpaRepository<ShowSeatEntity, Integer> {
}
