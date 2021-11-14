package com.lkefalas.samplemoviedatabase.api.directors;

import com.lkefalas.samplemoviedatabase.api.BasePersistDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class DirectorPersistDTO extends BasePersistDTO {
    private String firstName;

    private String lastName;
}
