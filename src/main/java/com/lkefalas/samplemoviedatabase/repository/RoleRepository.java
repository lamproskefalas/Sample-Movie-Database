package com.lkefalas.samplemoviedatabase.repository;

import com.lkefalas.samplemoviedatabase.domain.Role;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RoleRepository extends BaseRepository<Role, Long> {
    @Query("select r from Role r join fetch r.actor join fetch r.show")
    List<Role> findAllWithDetails();

    @Query("select r from Role r join fetch r.actor join fetch r.show where r.id = ?1")
    Role findWithDetails(Long id);
}
