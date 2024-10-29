package com.indra.book_my_show.EntryDtos;

import com.indra.book_my_show.Enums.Genre;
import com.indra.book_my_show.Enums.Language;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MovieEntryDto {

    private Integer movieId;
    private String movieName;
    private double rating;
    private double duration;
    private Language language;
    private Genre genre;

}


