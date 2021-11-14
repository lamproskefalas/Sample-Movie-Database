package com.lkefalas.samplemoviedatabase.api.actors;

import com.lkefalas.samplemoviedatabase.api.BaseDTO;
import com.lkefalas.samplemoviedatabase.api.roles.ActorRoleWithShowDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class ActorFullDetailsDTO extends BaseDTO {
    private String firstName;

    private String lastName;

    private List<ActorRoleWithShowDTO> roles;
}
