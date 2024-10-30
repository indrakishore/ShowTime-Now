package com.indra.book_my_show.Request;

import lombok.Data;

@Data
public class UserEntryDto {

    private int id;
    private String name;
    private int age;
    private String email;
    private String mobNo;
    private String address;
}
