package com.lkefalas.samplemoviedatabase.api.actors;

import com.lkefalas.samplemoviedatabase.api.BasePersistDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ActorsPersistDTO extends BasePersistDTO {
    private String firstName;

    private String lastName;
}
