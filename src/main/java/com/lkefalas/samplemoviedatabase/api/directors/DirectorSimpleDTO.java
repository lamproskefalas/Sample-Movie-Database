package com.lkefalas.samplemoviedatabase.api.directors;

import com.lkefalas.samplemoviedatabase.api.BaseDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class DirectorSimpleDTO extends BaseDTO {
    private String firstName;

    private String lastName;
}
