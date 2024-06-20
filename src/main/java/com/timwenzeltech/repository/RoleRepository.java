package com.timwenzeltech.repository;

import java.util.Optional;

import com.timwenzeltech.models.Role;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {
    Optional<Role> findByAuthority(String autorithy);
}
