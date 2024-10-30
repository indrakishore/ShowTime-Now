package com.indra.book_my_show.Request;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@Builder
@AllArgsConstructor
@Data
public class AddShowSeatsRequest {
    private Integer showId;
    private Integer seatNo;
    private Integer priceOfClassicSeat;
    private Integer priceOfPremiumSeat;
}
