package com.lkefalas.samplemoviedatabase.service;

import com.lkefalas.samplemoviedatabase.domain.Role;
import com.lkefalas.samplemoviedatabase.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl extends AbstractService<Role> implements RoleService {
    private final RoleRepository repository;

    @Override
    public JpaRepository<Role, Long> getRepository() {
        return repository;
    }

    @Override
    public List<Role> findAllWithDetails() {
        return null;
    }
}
