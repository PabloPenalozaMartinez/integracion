package com.integracion.service;

import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.integracion.entity.User;
import com.integracion.exception.DataValidationException;
import com.integracion.repository.UserRepository;
import com.integracion.security.JWTUtil;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
    private UserRepository userRepository;
	
	@Autowired
	private JWTUtil jWTUtil;
	
	@Value("${regex.mail}")
    private String regexMail;
	
	@Value("${regex.password}")
	private String regexPassword;

	@Override
	public User saveUser(User user) throws DataValidationException {
		 
		this.validateData(user);
		 
		user.setCreated(new Date());
		user.setModified(new Date());
		user.setLastLogin(new Date());
		user.setToken(jWTUtil.generateToken(user.getName()));
		user.setIsActive(true);
		 
		return userRepository.save(user);
	}

	private void validateData(User user) {
		
		Iterable<User> lista = userRepository.findAll();
		List<User> result = StreamSupport.stream(lista.spliterator(), false)
				 .filter(u -> u.getEmail().equals(user.getEmail()))
			     .collect(Collectors.toList());
		 
		if(result.size() > 0)
			throw new DataValidationException("El correo ya registrado");
		
		if(!Pattern.compile(regexMail, Pattern.CASE_INSENSITIVE).matcher(user.getEmail()).matches())
			throw new DataValidationException("El formato del correo no es correcto");
		
		if(!Pattern.compile(regexPassword, Pattern.CASE_INSENSITIVE).matcher(user.getPassword()).matches())
			throw new DataValidationException("El formato de la clave no es correcto");
		
	}

}
