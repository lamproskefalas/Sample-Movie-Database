package com.lkefalas.samplemoviedatabase.api.genres;

import com.lkefalas.samplemoviedatabase.api.BasePersistDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class GenrePersistDTO extends BasePersistDTO {
    private String name;
}
