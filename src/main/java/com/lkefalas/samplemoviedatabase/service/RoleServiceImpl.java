package com.lkefalas.samplemoviedatabase.service;

import com.lkefalas.samplemoviedatabase.domain.Role;
import com.lkefalas.samplemoviedatabase.repository.BaseRepository;
import com.lkefalas.samplemoviedatabase.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl extends AbstractService<Role> implements RoleService {
    private final RoleRepository repository;

    @Override
    public BaseRepository<Role, Long> getRepository() {
        return repository;
    }
}
