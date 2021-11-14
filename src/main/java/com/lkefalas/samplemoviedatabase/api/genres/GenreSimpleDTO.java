package com.lkefalas.samplemoviedatabase.api.genres;

import com.lkefalas.samplemoviedatabase.api.BaseDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class GenreSimpleDTO extends BaseDTO {
    private String name;
}
