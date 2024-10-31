package com.indra.book_my_show.Services;

import com.indra.book_my_show.Request.UserEntryDto;
import com.indra.book_my_show.Models.UserEntity;
import com.indra.book_my_show.Repositories.UserRepository;
import com.indra.book_my_show.convertors.UserConvertor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public String addUser(UserEntryDto userEntryDto) {

        UserEntity userEntity = UserConvertor.convertDtoToEntity(userEntryDto);
        userEntity = userRepository.save(userEntity);

        return "User added successfully to the Db with userId: " + userEntity.getUserId();
    }


}
