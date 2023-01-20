package com.chrismeehan.productmanagement.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chrismeehan.productmanagement.models.Task;
import com.chrismeehan.productmanagement.repositories.TaskRepository;

@Service
public class TaskService {

	@Autowired
	TaskRepository taskRepo;
	
	List<Task> findAll(){
		  return taskRepo.findAll();
		 }
		 
		 public Task createTask(Task task) {
			 return taskRepo.save(task);
		 }
		 
		 public Task findTask(Long id) {
		  Optional<Task> optionalTask = taskRepo.findById(id);
		  if(optionalTask.isPresent()) {
			  return optionalTask.get();
		  }
		  else {
			  return null;
		  }
	} 
		 
		 
}
