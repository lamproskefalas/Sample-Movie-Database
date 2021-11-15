package com.lkefalas.samplemoviedatabase.service;

import com.lkefalas.samplemoviedatabase.domain.Actor;

public interface ActorService extends BaseService<Actor,Long> {
    Actor findByFirstNameAndLastName(String firstName, String lastName);
}
