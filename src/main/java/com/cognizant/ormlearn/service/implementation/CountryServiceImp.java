package com.cognizant.ormlearn.service.Implementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Sort;
import com.cognizant.ormlearn.model.Country;
import com.cognizant.ormlearn.repository.CountryRepository;
import com.cognizant.ormlearn.service.CountryService;
import com.cognizant.ormlearn.service.exp.CountryNotFoundException;
import org.springframework.transaction.annotation.Transactional;

@Transactional()
@Service()
public class CountryServiceImpl implements CountryService {

	@Autowired
	private CountryRepository countryRepository;

	@Transactional(readOnly = true)
	@Override
	public List<Country> getAllCountries() {
		return countryRepository.findAll();
	}

	@Override
	public void addCountry(Country country) {
		countryRepository.save(country);
	}

	@Override
	public void deleteCountry(String code) {
		countryRepository.deleteById(code);
	}

	public Country findCountryByCode(String countryCode) throws CountryNotFoundException {

		Optional<Country> result = countryRepository.findById(countryCode);

		if (!result.isPresent()) {
			throw new CountryNotFoundException();
		}

		return (result.get());
	}

	@Override
	public void updateCountry(String code, String name) {
		Country updateTable = countryRepository.findById(code).get();
		updateTable.setName(name);
		countryRepository.save(updateTable);
	}

	@Override
	public List<Country> getSearchingCountry(String name) {
		List<Country> countryList = countryRepository.findCountryNameContain(name);
		return countryList;
	}

	@Override
	public List<Country> getSortingCountry(String name) {
		return countryRepository.findCountryNameAndSort(name, Sort.by("name").ascending());
	}

}
