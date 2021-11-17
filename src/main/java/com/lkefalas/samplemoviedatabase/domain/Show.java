package com.lkefalas.samplemoviedatabase.domain;

import lombok.*;
import lombok.experimental.SuperBuilder;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;


/**
 * This class represents a show (movie/tv series)
 */
@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
@Entity
@Table(name = "SHOWS")
public class Show extends BaseModel {

    @NotBlank(message = "Show title must be provided")
    @Column(length = 50)
    private String title;

    @NotNull(message = "Release year must be specified")
    @DateTimeFormat(pattern = "YYYY")
    @Min(value = 1900, message = "Release year must be greater or equal to 1900")
    @Max(value = 2100, message = "Release year must be lower or equal to 2100")
    private Integer releaseYear;

    @Positive(message = "Only positive rating values accepted")
    private BigDecimal rating;

    @NotNull(message = "A valid director id must be provided")
    @ManyToOne(fetch = FetchType.LAZY)
    private Director director;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "show")
    private Set<Role> roles = new HashSet<>();

    @NotNull(message = "You must provide at least one genre")
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name="SHOWS_GENRES",
            joinColumns=@JoinColumn(name="show_id"),
            inverseJoinColumns=@JoinColumn(name="genre_id")
    )
    private Set<Genre> genres = new HashSet<>();

    @Enumerated(EnumType.STRING)
    private ShowType showType;
}
