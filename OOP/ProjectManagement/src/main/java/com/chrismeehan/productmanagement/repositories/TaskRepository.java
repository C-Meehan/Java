package com.chrismeehan.productmanagement.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

//import com.chrismeehan.productmanagement.models.Project;
import com.chrismeehan.productmanagement.models.Task;

public interface TaskRepository extends CrudRepository<Task, Long>{

	List<Task> findAll();
//	List<Task> findAllByProject_task(Project project_task);
}
