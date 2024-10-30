package com.indra.book_my_show.convertors;

import com.indra.book_my_show.Request.UserEntryDto;
import com.indra.book_my_show.Models.UserEntity;

public class UserConvertor {
    // static is kept to avoid calling it via objects/instances
    public static UserEntity convertDtoToEntity(UserEntryDto userEntryDto) {
        // we need to return the built UserEntity

        // Using the builder pattern to create a UserEntity instance
        UserEntity userEntity = UserEntity.builder()
                .age(userEntryDto.getAge())
                .address(userEntryDto.getAddress())
                .email(userEntryDto.getEmail())
                .name(userEntryDto.getName())
                .mobNo(userEntryDto.getMobNo())
                .build(); // Correctly call build() to create the UserEntity object

        // Return the created UserEntity
        return userEntity;
    }
}
