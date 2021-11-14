package com.lkefalas.samplemoviedatabase.repository;

import com.lkefalas.samplemoviedatabase.domain.Director;
import com.lkefalas.samplemoviedatabase.domain.Show;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MovieRepository extends JpaRepository<Show, Long> {
    Show findByTitle(String title);

    @Query("Select distinct m from Show m join fetch m.genres join fetch m.director join fetch m.roles r join fetch r.actor")
    List<Show> findAllWithDetails();

}
