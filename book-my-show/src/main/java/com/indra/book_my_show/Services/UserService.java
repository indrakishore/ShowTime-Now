package com.indra.book_my_show.Services;

import com.indra.book_my_show.EntryDtos.UserEntryDto;
import com.indra.book_my_show.Models.UserEntity;
import com.indra.book_my_show.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public void addUser(UserEntryDto userEntryDto){

        // Convert UserEntryDto to UserEntity and save.
        UserEntity userEntity = UserEntity.builder()
                .age(userEntryDto.getAge())
                .name(userEntryDto.getName())
                .address(userEntryDto.getAddress())
                .email(userEntryDto.getEmail())
                .mobNo(userEntryDto.getMobNo())
                .build();

        userRepository.save(userEntity);
    }
}
