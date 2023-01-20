package com.chrismeehan.authentication.services;

import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.chrismeehan.authentication.models.LoginUser;
import com.chrismeehan.authentication.models.User;
import com.chrismeehan.authentication.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository userRepo;
	
	public User create(User u) {
		return userRepo.save(u);
	}
	
	public User getById(Long id) {
		Optional<User> user = userRepo.findById(id);
		if (user.isEmpty()) {
			return null;
		}
		return user.get();
	}
	
	public User register(User createdUser, BindingResult result) {
		if (!createdUser.getPassword().equals(createdUser.getConfirm())) {
			result.rejectValue("confirm", "Match", "Password incorrect!");
			return null;
		}
		if(userRepo.findByEmail(createdUser.getEmail()).isPresent()) {
			result.rejectValue("email", "Unique", "Email already exists");
			return null;
		}
		else {
			String hashed = BCrypt.hashpw(createdUser.getPassword(), BCrypt.gensalt());
			createdUser.setPassword(hashed);
			return createdUser;
		}
	}
	
	public User login(LoginUser loginUser, BindingResult result) {
		Optional<User> user = userRepo.findByEmail(loginUser.getEmail());
		if (user.isPresent() && (BCrypt.checkpw(loginUser.getPassword(),user.get().getPassword()))) {
			return user.get();
		}
		result.rejectValue("password", "Invalid", "Invalid Credentials");
		return null;
	}
}
