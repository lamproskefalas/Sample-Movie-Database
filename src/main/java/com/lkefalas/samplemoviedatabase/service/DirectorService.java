package com.lkefalas.samplemoviedatabase.service;

import com.lkefalas.samplemoviedatabase.domain.Director;
import com.lkefalas.samplemoviedatabase.exception.NotFoundException;

public interface DirectorService extends BaseService<Director,Long> {
    Director findByFirstNameAndLastName(String firstName, String lastName) throws NotFoundException;
}
