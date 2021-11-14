package com.lkefalas.samplemoviedatabase.service;

import com.lkefalas.samplemoviedatabase.domain.Actor;
import com.lkefalas.samplemoviedatabase.exception.NotFoundException;

import java.util.List;

public interface ActorService extends BaseService<Actor,Long> {
    Actor findByFirstNameAndLastName(String firstName, String lastName) throws NotFoundException;

    List<Actor> findAllWithDetails();
}
