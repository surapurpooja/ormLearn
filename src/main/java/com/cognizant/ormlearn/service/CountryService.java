package com.cognizant.ormlearn.service;

import java.util.List;

import com.cognizant.ormlearn.model.Country;
import com.cognizant.ormlearn.service.exp.CountryNotFoundException;

public interface CountryService {

	public List<Country> getAllCountries();

	public void addCountry(Country country);

	public void deleteCountry(String code);

	public Country findCountryByCode(String countryCode) throws CountryNotFoundException;

	public void updateCountry(String code, String name);

	public List<Country> getSearchingCountry(String name);

	public List<Country> getSortingCountry(String name);
}
