package com.cognizant.springlearn.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.springlearn.Country;
import com.cognizant.springlearn.service.CountryService;
import com.cognizant.springlearn.service.exception.CountryNotFoundException;

@RestController
public class CountryController {
	
	@Autowired
	private CountryService service;
	
	@RequestMapping("/country")
	public Country getCountryIndia() {
		return service.getCountryIndia();
	}
	
	@GetMapping("/countries") 
	public List<Country> getAllCountries(){
		return service.getAllCountries();
	}
	
	@GetMapping("/countries/{code}")
	public Country getCountry(@PathVariable String code) throws CountryNotFoundException{
		return service.getCountry(code);
	}

}
