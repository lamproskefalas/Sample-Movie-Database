package com.lkefalas.samplemoviedatabase.repository;

import com.lkefalas.samplemoviedatabase.domain.Show;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MovieRepository extends BaseRepository<Show, Long> {
    Show findByTitle(String title);

    @Query("Select distinct s from Show s left join fetch s.genres left join fetch s.director left join fetch s.roles r left join fetch r.actor")
    List<Show> findAllWithDetails();

    @Query("Select distinct s from Show s left join fetch s.genres left join fetch s.director left join fetch s.roles r left join fetch r.actor where s.id = ?1")
    Show findWithDetails(Long id);
}
