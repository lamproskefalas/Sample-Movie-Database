package com.lkefalas.samplemoviedatabase.service;

import com.lkefalas.samplemoviedatabase.domain.Show;
import com.lkefalas.samplemoviedatabase.repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ShowServiceImpl extends AbstractService<Show> implements ShowService {
    private final MovieRepository repository;

    @Override
    public JpaRepository<Show, Long> getRepository() {
        return repository;
    }

    @Override
    public Show findByTitle(String title) {
        return repository.findByTitle(title);
    }

    @Override
    public List<Show> findAllWithDetails() {
        return repository.findAllWithDetails();
    }
}
