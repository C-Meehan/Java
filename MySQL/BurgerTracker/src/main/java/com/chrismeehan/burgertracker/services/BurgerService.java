package com.chrismeehan.burgertracker.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.chrismeehan.burgertracker.models.Burger;
import com.chrismeehan.burgertracker.repositories.BurgerRepository;

@Service
public class BurgerService {
	private final BurgerRepository burgerRepository;
	
	public BurgerService(BurgerRepository burgerRepository) {
		this.burgerRepository = burgerRepository;
	}
	
	// returns all the burgers
    public List<Burger> allBurgers() {
        return burgerRepository.findAll();
    }
    // creates a burger
    public Burger createBurger(Burger b) {
        return burgerRepository.save(b);
    }
    // retrieves a burger
    public Burger findBurger(Long id) {
        Optional<Burger> optionalBurger = burgerRepository.findById(id);
        if(optionalBurger.isPresent()) {
            return optionalBurger.get();
        } else {
            return null;
        }
    }
    // updates a burger
    public Burger updateBurger(Burger burger) {
    	return burgerRepository.save(burger);
    }
    // deletes a burger
    public void deleteBurger(Long id) {
    	Optional<Burger> optionalBurger = burgerRepository.findById(id);
    	if(optionalBurger.isPresent()) {
    		burgerRepository.deleteById(id);
    	}
    }
}
