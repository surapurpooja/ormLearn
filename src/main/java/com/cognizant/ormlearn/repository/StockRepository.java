package com.cognizant.ormlearn.repository;

import java.math.BigDecimal;
import java.util.*;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cognizant.ormlearn.model.Stock;

@Repository
public interface StockRepository extends JpaRepository<Stock, String> {
	@Query("select s from Stock s where s.code=?1 and month(s.date)=?2")
	public List<Stock> stockDetailsOfFacebook(String code, int month);

	@Query("select s from Stock s where s.code=?1 and s.close>?2")
	public List<Stock> stockDetailsOfGoogle(String code, BigDecimal close);

	@Query(value = "select * from Stock where st_code=:code order by st_volume asc limit 0,3;", nativeQuery = true)
	public List<Stock> stockDetailsOfHighestFb(String code);

	@Query(value = "select * from Stock where st_code=:code order by st_volume desc limit 0,3;", nativeQuery = true)
	public List<Stock> stockDetailsOfLowestNflx(String code);

}
