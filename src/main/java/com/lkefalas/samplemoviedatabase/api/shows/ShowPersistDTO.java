package com.lkefalas.samplemoviedatabase.api.shows;

import com.lkefalas.samplemoviedatabase.api.BasePersistDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class ShowPersistDTO extends BasePersistDTO {
    private String title;

    private Integer releaseYear;

    private BigDecimal rating;

    private ShowTypeDTO showType;

    private Long directorId;

    private List<Long> movieGenres;
}
