package com.lkefalas.samplemoviedatabase.api.directors;

import com.lkefalas.samplemoviedatabase.api.BaseDTO;
import com.lkefalas.samplemoviedatabase.api.shows.ShowSimpleDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class DirectorFullDetailsDTO extends BaseDTO {
    private String firstName;

    private String lastName;

    private List<ShowSimpleDTO> shows;
}
