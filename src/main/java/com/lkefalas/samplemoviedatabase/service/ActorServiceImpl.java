package com.lkefalas.samplemoviedatabase.service;

import com.lkefalas.samplemoviedatabase.domain.Actor;
import com.lkefalas.samplemoviedatabase.repository.ActorRepository;
import com.lkefalas.samplemoviedatabase.repository.BaseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ActorServiceImpl extends AbstractService<Actor> implements ActorService {
    private final ActorRepository repository;

    @Override
    public Actor findByFirstNameAndLastName(String firstName, String lastName) {
        return repository.findByFirstNameAndLastName(firstName,lastName);
    }

    @Override
    public BaseRepository<Actor, Long> getRepository() {
        return repository;
    }
}
