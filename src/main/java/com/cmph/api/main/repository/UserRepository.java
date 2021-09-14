package com.cmph.api.main.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cmph.api.main.model.AuthUser;

@Repository
public interface UserRepository extends JpaRepository<AuthUser, Long>{
	
	Optional<AuthUser> findByUserName(String username);
	Optional<AuthUser> findByUserNameOrEmail(String userName, String email);
	
}
