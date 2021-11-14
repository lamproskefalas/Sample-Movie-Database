package com.lkefalas.samplemoviedatabase.service;

import com.lkefalas.samplemoviedatabase.domain.Director;
import com.lkefalas.samplemoviedatabase.exception.NotFoundException;
import com.lkefalas.samplemoviedatabase.repository.DirectorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DirectorServiceImpl extends AbstractService<Director> implements DirectorService {
    private final DirectorRepository repository;

    @Override
    public Director findByFirstNameAndLastName(String firstName, String lastName) {
        return repository.findByFirstNameAndLastName(firstName, lastName);
    }

    @Override
    public JpaRepository<Director, Long> getRepository() {
        return repository;
    }

    @Override
    public List<Director> findAllWithDetails() {
        return repository.findAllWithDetails();
    }
}
