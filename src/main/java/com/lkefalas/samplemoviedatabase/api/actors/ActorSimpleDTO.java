package com.lkefalas.samplemoviedatabase.api.actors;

import com.lkefalas.samplemoviedatabase.api.BaseDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ActorSimpleDTO extends BaseDTO {
    private String firstName;

    private String lastName;
}
