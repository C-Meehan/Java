package com.chrismeehan.bookclub.services;

import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.chrismeehan.bookclub.models.LoginUser;
import com.chrismeehan.bookclub.models.User;
import com.chrismeehan.bookclub.repositories.UserRepository;

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
		if (!createdUser.getName().matches("[a-zA-Z]+")) {
			result.rejectValue("name", "Invalid", "Name must only contain letters!");
		}
//		if (!createdUser.getPassword().matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$")) {
//			result.rejectValue("password", "Invalid", "Password must contain at least 1: lowercase and uppercase letter, number, and special character [@$!%*?&] ");
//		}
		if (result.hasErrors()){
			return null;
		}
		if (!createdUser.getPassword().equals(createdUser.getConfirm())) {
			result.rejectValue("confirm", "Match", "Password must match Confirm password!");
			return null;
		}
		if (userRepo.findByEmail(createdUser.getEmail()).isPresent()) {
			result.rejectValue("email", "Unique", "Email already exists!");
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
		if (user.isPresent() && (BCrypt.checkpw(loginUser.getPassword(), user.get().getPassword()))) {
			return user.get();
		}
		result.rejectValue("password", "Invalid", "Invalid Credentials!");
		return null;
	}
}
