package com.lkefalas.samplemoviedatabase.service;

import com.lkefalas.samplemoviedatabase.base.AbstractLogComponent;
import com.lkefalas.samplemoviedatabase.domain.BaseModel;

import java.util.List;

public abstract class BaseServiceImpl<T extends BaseModel> extends AbstractLogComponent
        implements BaseService<T,Long>{
    @Override
    public List<T> createAll(final T... entities) {
        return null;
    }

    @Override
    public List<T> createAll(final List<T> entities) {
        return null;
    }

    @Override
    public T create(final T entity) {
        return null;
    }

    @Override
    public void update(final T entity) {
    }

    @Override
    public void delete(final T entity) {
    }

    @Override
    public void deleteById(final Long id) {
    }

    @Override
    public boolean exists(final T entity) {
        return false;
    }

    @Override
    public List<T> findAll() {
        return null;
    }

    @Override
    public T find(Long id) {
        return null;
    }
}
