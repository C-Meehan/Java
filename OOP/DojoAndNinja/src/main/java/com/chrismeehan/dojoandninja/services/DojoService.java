package com.chrismeehan.dojoandninja.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.chrismeehan.dojoandninja.models.Dojo;
import com.chrismeehan.dojoandninja.repositories.DojoRepository;

@Service
public class DojoService {
	private final DojoRepository dojoRepo;
	
	public DojoService(DojoRepository dojoRepo) {
		this.dojoRepo = dojoRepo;
	}
	
	// returns all dojos
	public List<Dojo> allDojos(){
		return dojoRepo.findAll();
	}
	
	// create a dojo
	public Dojo createDojo(Dojo d) {
		return dojoRepo.save(d);
	}
	
	// get one dojo
	public Dojo findDojo(Long id) {
		Optional<Dojo> optionalDojo = dojoRepo.findById(id);{
			if(optionalDojo.isPresent()) {
				return optionalDojo.get();
			}
			return null;
		}
	}
	
	// update a dojo
	public Dojo updateDojo(Dojo d) {
		return dojoRepo.save(d);
	}
	
	// delete a dojo
	public Dojo deleteDojo(Long id) {
		Optional<Dojo> optionalDojo = dojoRepo.findById(id);
		if(optionalDojo.isPresent()) {
			dojoRepo.deleteById(id);
		}
		return null;
	}
}
