package com.lkefalas.samplemoviedatabase.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import java.util.HashSet;
import java.util.Set;

/**
 * This class represents a director
 */
@Data
@SuperBuilder
@NoArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class Director extends BaseModel {
    private String firstName;
    private String lastName;
    private Set<Movie> movies = new HashSet<>();
}
