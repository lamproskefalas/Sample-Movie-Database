package com.lkefalas.samplemoviedatabase.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.List;

@NoRepositoryBean
public interface BaseRepository<T,ID> extends JpaRepository<T, ID> {
    // Used to eagerly load details about child elements
    T findWithDetails(Long id);

    List<T> findAllWithDetails();
}
