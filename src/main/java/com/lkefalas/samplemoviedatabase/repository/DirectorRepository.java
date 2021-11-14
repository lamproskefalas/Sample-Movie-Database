package com.lkefalas.samplemoviedatabase.repository;

import com.lkefalas.samplemoviedatabase.domain.Director;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DirectorRepository extends JpaRepository<Director, Long> {
    Director findByFirstNameAndLastName(String firstName, String lastName);

    @Query("select distinct d from Director d left join fetch d.shows s left join fetch s.roles r left join fetch r.actor left join fetch s.genres")
    List<Director> findAllWithDetails();
}
