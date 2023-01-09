package com.chrismeehan.languages.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.chrismeehan.languages.models.Language;
import com.chrismeehan.languages.services.LanguageService;

@Controller
public class LanguageController {

	@Autowired
	LanguageService languageService;
	
	@GetMapping("/languages")
	public String dashboard(@ModelAttribute("language") Language language, Model model) {
		List<Language> languages = languageService.allLanguages();
		model.addAttribute("languages", languages);
		return "index.jsp";
	}
	
	@PostMapping("/language")
	public String create(@Valid @ModelAttribute("language") Language language, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "index.jsp";
		}
		languageService.createLanguage(language);
		return "redirect:/languages";
	}
	
	@GetMapping("/languages/{id}")
	public String show(@PathVariable("id") Long id, @ModelAttribute("language") Language language, Model model) {
		model.addAttribute("language", languageService.findLanguage(id));
		return "show.jsp";
	}
	
	@GetMapping("/languages/{id}/edit")
	public String edit(@PathVariable("id") Long id, @ModelAttribute("language") Language language, Model model) {
		model.addAttribute("language", languageService.findLanguage(id));
		return "edit.jsp";
	}
	
	@PutMapping("/languages/{id}")
	public String update(@Valid @ModelAttribute("language") Language language, BindingResult result,
			@PathVariable("id") Long id, Model model) {
		if (result.hasErrors()) {
			return "edit.jsp";
		}
		languageService.updateLanguage(language);
		return "redirect:/languages";
	}
	
	@DeleteMapping("/languages/{id}/delete")
	public String delete(@PathVariable("id") Long id) {
		languageService.deleteLanguage(id);
		return "redirect:/languages";
	}
	
}
