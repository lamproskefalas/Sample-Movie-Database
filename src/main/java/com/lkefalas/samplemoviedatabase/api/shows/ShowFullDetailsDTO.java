package com.lkefalas.samplemoviedatabase.api.shows;

import com.lkefalas.samplemoviedatabase.api.BaseDTO;
import com.lkefalas.samplemoviedatabase.api.genres.GenreSimpleDTO;
import com.lkefalas.samplemoviedatabase.api.directors.DirectorSimpleDTO;
import com.lkefalas.samplemoviedatabase.api.roles.ShowRoleWithActorsDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class ShowFullDetailsDTO extends BaseDTO {
    private String title;

    private Integer releaseYear;

    private BigDecimal rating;

    private ShowTypeDTO showType;

    private List<ShowRoleWithActorsDTO> roles;

    private DirectorSimpleDTO director;

    private List<GenreSimpleDTO> genres;
}
