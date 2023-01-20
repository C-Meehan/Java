package com.chrismeehan.productmanagement.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chrismeehan.productmanagement.models.Project;
import com.chrismeehan.productmanagement.repositories.ProjectRepository;

@Service
public class ProjectService {

	@Autowired
	ProjectRepository projectRepo;
	
	public List <Project> allProjects (){
		  return projectRepo.findAll();
		  }
		 
	 public Project findProject(Long id) {
		 Optional<Project> optionalProject = projectRepo.findById(id);
		 if(optionalProject.isPresent()) {
			 return optionalProject.get();
		 }
		 else{
			 return null;
		 }
	 } 
	  
	 public Project createProject(Project p) {
		 return projectRepo.save(p);
	 }
	  
	 public Project updateProject(Project p) {
		 return projectRepo.save(p);
	 }
	 
	 public Project deleteProject(Long id) {
		 Optional<Project> optionalProject = projectRepo.findById(id);
		 if(optionalProject.isPresent()) {
			 projectRepo.deleteById(id);
			 return optionalProject.get();
		 }
		 return null;
	 } 

}
