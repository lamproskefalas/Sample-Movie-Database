package com.lkefalas.samplemoviedatabase.domain;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

/**
 * This class represents a director
 */
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@Entity
@Table(name = "DIRECTORS")
public class Director extends BaseModel {
    @NotNull(message = "First name of the Director cannot be null")
    @Column(length = 50)
    private String firstName;

    @NotNull(message = "Last name of the Director cannot be null")
    @Column(length = 50)
    private String lastName;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "director")
    private Set<Show> shows = new HashSet<>();
}
