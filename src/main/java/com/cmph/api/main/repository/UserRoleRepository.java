package com.cmph.api.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cmph.api.main.model.AuthRoles;

@Repository
public interface UserRoleRepository extends JpaRepository<AuthRoles, Long> {

	AuthRoles findByRoleNameContaining(String roleName);
}
