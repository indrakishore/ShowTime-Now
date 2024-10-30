package com.indra.book_my_show.Request;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TheaterEntryDto {

    //Attributes that we require
    private String name;
    private String location;
    private Integer numberOfScreens;
//    private int classicSeatsCount;
//    private int premiumSeatsCount;

}
