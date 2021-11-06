package com.lkefalas.samplemoviedatabase.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

/**
 * This class represents a cast member of a movie
 */
@Data
@SuperBuilder
@NoArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class Cast extends BaseModel {
    private String characterName;
    private Actor actor;
    private Movie movie;
}
