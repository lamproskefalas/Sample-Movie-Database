package com.lkefalas.samplemoviedatabase.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * This class represents a movie
 */
@Data
@SuperBuilder
@NoArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class Movie extends BaseModel {
    private String title;
    private Date releaseDate;
    private BigDecimal rating;
    private Set<Director> directors = new HashSet<>();
    private Set<Cast> cast = new HashSet<>();
    private Set<Crew> productionCrew = new HashSet<>();
    private Set<Genre> genres = new HashSet<>();
}
