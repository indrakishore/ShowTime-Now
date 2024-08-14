package com.indra.book_my_show.EntryDtos;

import com.indra.book_my_show.Genres.Genre;
import com.indra.book_my_show.Genres.Language;
import com.indra.book_my_show.Models.ShowEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MovieEntryDto {

    private String movieName;
    private double rating;
    private double duration;
    private Language language;
    private Genre genre;

}


