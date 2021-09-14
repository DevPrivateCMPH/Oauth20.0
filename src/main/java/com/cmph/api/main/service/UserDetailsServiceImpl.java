package com.cmph.api.main.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.cmph.api.main.model.AuthUser;
import com.cmph.api.main.repository.UserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<AuthUser> optUser = userRepository.findByUserName(username);
		
		if(optUser.isPresent()) {
			AuthUser authUser = optUser.get();
			
			List<SimpleGrantedAuthority> roles = 
					authUser.getRoles()
					.stream()
					.map(role -> new SimpleGrantedAuthority(role.getRoleName()))
					.collect(Collectors.toList());
			
			return new User(authUser.getUserName(), authUser.getPassword(), roles);
		}
		throw new UsernameNotFoundException("User not exist");
	}

}
