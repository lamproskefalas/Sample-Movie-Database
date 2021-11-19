package com.lkefalas.samplemoviedatabase.api.genres;

import com.lkefalas.samplemoviedatabase.api.BaseDTO;
import com.lkefalas.samplemoviedatabase.domain.Show;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class GenreFullDetailsDTO extends BaseDTO {
    private String name;
    private List<Show> shows;
}
