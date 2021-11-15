package com.lkefalas.samplemoviedatabase.service;

import com.lkefalas.samplemoviedatabase.domain.Genre;
import com.lkefalas.samplemoviedatabase.repository.BaseRepository;
import com.lkefalas.samplemoviedatabase.repository.GenreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GenreServiceImpl extends AbstractService<Genre> implements GenreService {
    private final GenreRepository repository;

    @Override
    public Genre findByName(String name) {
        return repository.findByName(name);
    }

    @Override
    public BaseRepository<Genre, Long> getRepository() {
        return repository;
    }
}
