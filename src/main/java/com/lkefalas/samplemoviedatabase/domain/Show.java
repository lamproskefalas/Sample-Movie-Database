package com.lkefalas.samplemoviedatabase.domain;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;


/**
 * This class represents a movie
 */
@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
@Entity
@Table(name = "SHOWS")
public class Show extends BaseModel {

    @NotNull(message = "Title cannot be null")
    @Column(length = 50)
    private String title;

    @NotNull(message = "Release year must be specified")
    private Integer releaseYear;

    @Positive(message = "Only positive rating values accepted")
    private BigDecimal rating;

    @ManyToOne(fetch = FetchType.LAZY)
    private Director director;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "show")
    private Set<Role> roles = new HashSet<>();

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name="SHOWS_GENRES",
            joinColumns=@JoinColumn(name="show_id"),
            inverseJoinColumns=@JoinColumn(name="genre_id")
    )
    private Set<Genre> genres = new HashSet<>();

    private ShowType showType;
}
