package com.lkefalas.samplemoviedatabase.service;

import com.lkefalas.samplemoviedatabase.domain.Genre;
import com.lkefalas.samplemoviedatabase.exception.NotFoundException;

public interface GenreService extends BaseService<Genre,Long> {
    Genre findByName(String name) throws NotFoundException;
}
