package com.cmph.api.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.cmph.api.main.dto.UserDto;
import com.cmph.api.main.model.AuthUser;
import com.cmph.api.main.service.AuthUserService;

@RestController
@RequestMapping("/oauth/users")
public class UserController {

	@Autowired
	private AuthUserService authUserService;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public AuthUser register(@RequestBody UserDto userDto) {

		return authUserService.register(userDto);
	}

}
