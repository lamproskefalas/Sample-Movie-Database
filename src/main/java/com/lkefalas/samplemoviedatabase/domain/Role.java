package com.lkefalas.samplemoviedatabase.domain;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * This class represents a cast member of a movie/tv show
 */
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@Entity
@Table(name = "ROLES")
public class Role extends BaseModel {
    @NotNull(message = "Character name cannot be empty")
    @Column(length = 50)
    private String characterName;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "actor_id")
    private Actor actor;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "show_id")
    private Show show;
}
