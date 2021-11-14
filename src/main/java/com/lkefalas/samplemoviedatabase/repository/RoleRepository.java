package com.lkefalas.samplemoviedatabase.repository;

import com.lkefalas.samplemoviedatabase.domain.Director;
import com.lkefalas.samplemoviedatabase.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RoleRepository extends JpaRepository<Role, Long> {
    @Query("select r from Role r")
    List<Role> findAllWithDetails();

}
