package com.lkefalas.samplemoviedatabase.domain;

import com.fasterxml.jackson.annotation.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

/**
 * This class represents an actor/actress.
 */
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@Entity
@Table(
        name = "ACTORS",
        uniqueConstraints=@UniqueConstraint(columnNames={"firstName", "lastName"}),
        indexes = @Index(columnList = "id", unique = true)
)
public class Actor extends BaseModel {
    @NotNull(message = "First name of the Actor cannot be null")
    @Column(length = 50)
    private String firstName;

    @NotNull(message = "Last name of the Actor cannot be null")
    @Column(length = 50)
    private String lastName;

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "actor")
    private Set<Role> roles = new HashSet<>();
}
