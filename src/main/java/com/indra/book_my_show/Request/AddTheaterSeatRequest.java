package com.indra.book_my_show.Request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddTheaterSeatRequest {

    private Integer noOfClassicSeats;
    private Integer noOfPremiumSeats;
    private Integer theaterId;
}
