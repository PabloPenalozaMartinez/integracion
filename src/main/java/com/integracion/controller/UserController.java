package com.integracion.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.integracion.dto.ErrorResponse;
import com.integracion.entity.User;
import com.integracion.exception.DataValidationException;
import com.integracion.service.UserService;

@RestController
public class UserController {

	@Autowired 
	private UserService userService;
	
	@PostMapping("/user")
    public ResponseEntity<User> saveUser(@RequestBody User user){
		try {
			return new ResponseEntity(userService.saveUser(user), HttpStatus.CREATED);
		} catch (DataValidationException e) {
			return new ResponseEntity(new ErrorResponse(e.getMessage()), HttpStatus.CONFLICT);
		} catch (Exception e) {
			return new ResponseEntity(new ErrorResponse(e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
		}
    }

}
