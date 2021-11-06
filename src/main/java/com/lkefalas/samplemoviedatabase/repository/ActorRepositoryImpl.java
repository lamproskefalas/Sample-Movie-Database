package com.lkefalas.samplemoviedatabase.repository;

import com.lkefalas.samplemoviedatabase.domain.Actor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ActorRepositoryImpl extends AbstractRepository<Actor> implements ActorRepository {
    List <Actor> actorStorage = new ArrayList<>();
    @Override
    public List<Actor> getStorage() {
        return actorStorage;
    }
}
