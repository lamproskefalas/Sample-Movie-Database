package com.lkefalas.samplemoviedatabase.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

/**
 * This class represents a director
 */
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
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
    @JsonIgnore
    private Set<Show> shows = new HashSet<>();
}
