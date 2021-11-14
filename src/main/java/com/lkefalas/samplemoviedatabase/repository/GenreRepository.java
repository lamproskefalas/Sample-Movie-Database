package com.lkefalas.samplemoviedatabase.repository;

import com.lkefalas.samplemoviedatabase.domain.Director;
import com.lkefalas.samplemoviedatabase.domain.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface GenreRepository  extends JpaRepository<Genre, Long> {
    Genre findByName(String name);

    @Query("select g from Genre g")
    List<Director> findAllWithDetails();

}
