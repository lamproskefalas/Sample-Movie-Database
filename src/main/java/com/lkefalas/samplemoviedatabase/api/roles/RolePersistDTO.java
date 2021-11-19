package com.lkefalas.samplemoviedatabase.api.roles;

import com.lkefalas.samplemoviedatabase.api.BasePersistDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class RolePersistDTO extends BasePersistDTO {
    private String characterName;
    private Long actorId;
    private Long showId;
}
