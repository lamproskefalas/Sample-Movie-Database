package com.lkefalas.samplemoviedatabase.api.roles;

import com.lkefalas.samplemoviedatabase.api.BaseDTO;
import com.lkefalas.samplemoviedatabase.api.actors.ActorSimpleDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ShowRoleWithActorsDTO extends BaseDTO {
    private String characterName;
    private ActorSimpleDTO actor;
}
