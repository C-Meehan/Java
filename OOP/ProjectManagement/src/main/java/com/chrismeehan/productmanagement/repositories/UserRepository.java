package com.chrismeehan.productmanagement.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.chrismeehan.productmanagement.models.User;

public interface UserRepository extends CrudRepository<User, Long>{
	public Optional<User> findByEmail(String email);
	public List<User> findAll();
	public Optional<User> findById(Long id);
}
