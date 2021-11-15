package com.lkefalas.samplemoviedatabase.repository;

import com.lkefalas.samplemoviedatabase.domain.Actor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ActorRepository  extends BaseRepository<Actor, Long> {
    Actor findByFirstNameAndLastName(String firstName, String lastName);

    @Query("select distinct a from Actor a left join fetch a.roles r left join fetch r.show")
    List<Actor> findAllWithDetails();

    @Query("select distinct a from Actor a left join fetch a.roles r left join fetch r.show where a.id = ?1")
    Actor findWithDetails(Long id);
}
