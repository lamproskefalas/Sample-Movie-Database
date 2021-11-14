package com.lkefalas.samplemoviedatabase.service;

import com.lkefalas.samplemoviedatabase.domain.Genre;
import com.lkefalas.samplemoviedatabase.exception.NotFoundException;
import com.lkefalas.samplemoviedatabase.repository.GenreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GenreServiceImpl extends AbstractService<Genre> implements GenreService {
    private final GenreRepository repository;

    @Override
    public Genre findByName(String name) {
        return repository.findByName(name);
    }

    @Override
    public JpaRepository<Genre, Long> getRepository() {
        return repository;
    }

    @Override
    public List<Genre> findAllWithDetails() {
        return null;
    }
}
