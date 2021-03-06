package com.lkefalas.samplemoviedatabase.service;

import com.lkefalas.samplemoviedatabase.base.AbstractLogComponent;
import com.lkefalas.samplemoviedatabase.domain.BaseModel;
import com.lkefalas.samplemoviedatabase.repository.BaseRepository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class AbstractService<T extends BaseModel> extends AbstractLogComponent implements BaseService<T, Long> {
    public abstract BaseRepository<T, Long> getRepository();

    @Override
    public List<T> createAll(final T... entities) {
        return createAll(Arrays.asList(entities));
    }

    @Override
    public List<T> createAll(final List<T> entities) {
        final List<T> updatedEntities = new ArrayList<>();
        for (final T entity : entities) {
            updatedEntities.add(create(entity));
        }
        return updatedEntities;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED, rollbackFor = Exception.class)
    public T create(final T entity) {
        logger.trace("Creating {}.", entity);
        return getRepository().save(entity);
    }

    @Override
    public void update(final T entity) {
        logger.trace("Updating {}.", entity);
        getRepository().save(entity);
    }

    @Override
    public void delete(final T entity) {
        logger.trace("Deleting {}.", entity);
        getRepository().delete(entity);
    }

    @Override
    public void deleteById(final Long id) {
        final T entityFound = getRepository().findById(id).get();
        logger.trace("Deleting {}.", entityFound);
        getRepository().deleteById(id);
    }

    @Override
    public boolean exists(final T entity) {
        logger.trace("Checking whether {} exists.", entity);
        return getRepository().existsById(entity.getId());
    }

    @Override
    public List<T> findAll() {
        logger.trace("Retrieving all entities.");
        return getRepository().findAll();
    }

    @Override
    public T find(Long id) {
        logger.trace("Retrieving entity with id {}.", id.toString());
        return getRepository().findById(id).orElse(null);
    }

    @Override
    public T findWithDetails(Long id) {
        logger.trace("Retrieving details for entity with id {}.", id.toString());
        return getRepository().findWithDetails(id);
    }

    @Override
    public List<T> findAllWithDetails() {
        logger.trace("Retrieving details for all entities");
        return getRepository().findAllWithDetails();
    }
}
