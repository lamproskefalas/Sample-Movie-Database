package com.lkefalas.samplemoviedatabase.service;

import com.lkefalas.samplemoviedatabase.domain.Show;
import com.lkefalas.samplemoviedatabase.exception.NotFoundException;

import java.util.List;

public interface ShowService extends BaseService<Show,Long> {
    Show findByTitle(String title) throws NotFoundException;

    List<Show> findAllWithDetails();
}
