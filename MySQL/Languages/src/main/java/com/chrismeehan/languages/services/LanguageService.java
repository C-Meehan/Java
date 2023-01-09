package com.chrismeehan.languages.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.chrismeehan.languages.models.Language;
import com.chrismeehan.languages.repositories.LanguageRepository;

@Service
public class LanguageService {
	private final LanguageRepository languageRepo;
	
	public LanguageService(LanguageRepository languageRepo) {
		this.languageRepo = languageRepo;
	}
	
	// returns all languages
	public List<Language> allLanguages(){
		return languageRepo.findAll();				
	}
	
	// create a language
	public Language createLanguage(Language l) {
		return languageRepo.save(l);
	}
	
	// get one language
	public Language findLanguage(Long id) {
		Optional<Language> optionalLanguage = languageRepo.findById(id);{
			if(optionalLanguage.isPresent()) {
				return optionalLanguage.get();
			}
			return null;
		}
	}
	
	// update language
	public Language updateLanguage(Language l) {
		return languageRepo.save(l);
	}
	
	// delete language
	public Language deleteLanguage(Long id) {
		Optional<Language> optionalLanguage = languageRepo.findById(id);
		if(optionalLanguage.isPresent()) {
			languageRepo.deleteById(id);
		}
		return null;
	}
}
