package com.chrismeehan.dojoandninja.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.chrismeehan.dojoandninja.models.Ninja;
import com.chrismeehan.dojoandninja.repositories.NinjaRepository;

@Service
public class NinjaService {
	private final NinjaRepository ninjaRepo;
	
	public NinjaService(NinjaRepository ninjaRepo) {
		this.ninjaRepo = ninjaRepo;
	}
	
	// returns all ninjas
	public List<Ninja> allNinjas(){
		return ninjaRepo.findAll();
	}
	
	// create a ninja
	public Ninja createNinja(Ninja n) {
		return ninjaRepo.save(n);
	}
	
	// get one ninja
	public Ninja findNinja(Long id) {
		Optional<Ninja> optionalNinja = ninjaRepo.findById(id);
		if(optionalNinja.isPresent()) {
			return optionalNinja.get();
		}
		return null;	
	}
	
	// update a ninja
	public Ninja updateNinja(Ninja n) {
		return ninjaRepo.save(n);
	}
	
	// delete ninja
	public Ninja deleteNinja(Long id) {
		Optional<Ninja> optionalNinja = ninjaRepo.findById(id);
		if(optionalNinja.isPresent()) {
			ninjaRepo.deleteById(id);
		}
		return null;
	}
}
