package com.lkefalas.samplemoviedatabase.domain;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

/**
 * This class represents the available genres
 */
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@Entity
@Table(name = "GENRES")
public class Genre extends BaseModel {
    @NotNull(message = "A genre needs a name")
    @Column(length = 50)
    private String name;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name="SHOWS_GENRES",
            joinColumns=@JoinColumn(name="genre_id"),
            inverseJoinColumns=@JoinColumn(name="show_id")
    )
    private Set<Show> shows = new HashSet<>();
}
