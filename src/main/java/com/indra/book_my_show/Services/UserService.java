package com.indra.book_my_show.Services;

import com.indra.book_my_show.EntryDtos.UserEntryDto;
import com.indra.book_my_show.Models.UserEntity;
import com.indra.book_my_show.Repositories.UserRepository;
import com.indra.book_my_show.convertors.UserConvertor;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public String addUser(UserEntryDto userEntryDto) throws Exception, NullPointerException{

        UserEntity userEntity = UserConvertor.convertDtoToEntity(userEntryDto);
        userRepository.save(userEntity);

        return "User added successfully.";
    }


}
