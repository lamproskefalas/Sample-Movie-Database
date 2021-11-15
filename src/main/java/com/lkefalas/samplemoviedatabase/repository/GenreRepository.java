package com.lkefalas.samplemoviedatabase.repository;

import com.lkefalas.samplemoviedatabase.domain.Genre;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface GenreRepository  extends BaseRepository<Genre, Long> {
    Genre findByName(String name);

    @Query("select g from Genre g")
    List<Genre> findAllWithDetails();

    @Query("select g from Genre g where g.id = ?1")
    Genre findWithDetails(Long id);
}
