package com.integracion.service;

import com.integracion.entity.User;
import com.integracion.exception.DataValidationException;

public interface UserService {
	User saveUser(User user) throws DataValidationException;
}
