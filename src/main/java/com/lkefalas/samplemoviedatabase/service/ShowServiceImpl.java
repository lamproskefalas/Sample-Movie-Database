package com.lkefalas.samplemoviedatabase.service;

import com.lkefalas.samplemoviedatabase.domain.Show;
import com.lkefalas.samplemoviedatabase.repository.BaseRepository;
import com.lkefalas.samplemoviedatabase.repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ShowServiceImpl extends AbstractService<Show> implements ShowService {
    private final MovieRepository repository;

    @Override
    public BaseRepository<Show, Long> getRepository() {
        return repository;
    }

    @Override
    public Show findByTitle(String title) {
        return repository.findByTitle(title);
    }
}
