package com.indra.book_my_show.Repositories;

import com.indra.book_my_show.Models.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {

    public UserEntity findUserEntitiesByMobileNo(String mobileNo);
}
