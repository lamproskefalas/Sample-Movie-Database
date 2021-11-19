package com.lkefalas.samplemoviedatabase.api.roles;

import com.lkefalas.samplemoviedatabase.api.BaseDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class RoleSimpleDTO extends BaseDTO {
    private String characterName;
}
