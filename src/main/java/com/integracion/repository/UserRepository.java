package com.integracion.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.integracion.entity.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

}
