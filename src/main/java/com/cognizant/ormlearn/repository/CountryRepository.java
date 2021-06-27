package com.cognizant.ormlearn.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Sort;
import com.cognizant.ormlearn.model.Country;

@Repository
public interface CountryRepository extends JpaRepository<Country, String> {
	@Query("select c from Country c where c.name like %?1%")
	public List<Country> findCountryNameContain(String name);

	@Query("select c from Country c where c.name like %?1%")
	public List<Country> findCountryNameAndSort(String name, Sort sort);
}
