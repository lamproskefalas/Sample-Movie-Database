package com.lkefalas.samplemoviedatabase.api.roles;

import com.lkefalas.samplemoviedatabase.api.BaseDTO;
import com.lkefalas.samplemoviedatabase.api.actors.ActorsSimpleDTO;
import com.lkefalas.samplemoviedatabase.api.shows.ShowSimpleDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class RoleFullDetailsDTO extends BaseDTO {
    private String characterName;
    private ActorsSimpleDTO actor;
    private ShowSimpleDTO show;
}
