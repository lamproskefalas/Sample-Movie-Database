package com.lkefalas.samplemoviedatabase.service;

import com.lkefalas.samplemoviedatabase.domain.Actor;
import com.lkefalas.samplemoviedatabase.exception.NotFoundException;
import com.lkefalas.samplemoviedatabase.repository.ActorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ActorServiceImpl extends AbstractService<Actor> implements ActorService {
    private final ActorRepository repository;

    @Override
    public Actor findByFirstNameAndLastName(String firstName, String lastName) {
        return repository.findByFirstNameAndLastName(firstName,lastName);
    }

    @Override
    public List<Actor> findAllWithDetails() {
        return repository.findAllWithDetails();
    }

    @Override
    public JpaRepository<Actor, Long> getRepository() {
        return repository;
    }
}
