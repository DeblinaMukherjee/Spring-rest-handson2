package com.cognizant.springlearn.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import com.cognizant.springlearn.Country;
import com.cognizant.springlearn.service.exception.CountryNotFoundException;

@Service
public class CountryService {
	
	private List<Country> countries = new ArrayList<Country>();
	
	public CountryService() {
		ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");		
		countries = context.getBean("countryList", ArrayList.class);
	}

	public Country getCountryIndia() {
		ApplicationContext context = new ClassPathXmlApplicationContext("country.xml"); 
		Country country = (Country)context.getBean("country", Country.class);
		return country;
	}

	public List<Country> getAllCountries() {
		return countries;
		
	}
	
	public Country getCountry(String code) throws CountryNotFoundException {
		Country country=null;
		int k=0;
		for(Country c: countries){
			if(c.getCode().equalsIgnoreCase(code)){
				country=c;
				k++;
			}
		}
		if(k==0)
			throw new CountryNotFoundException();
		return country;
		}
}
