package com.cognizant.ormlearn.services;

import java.util.Date;
import java.util.List;

import com.cognizant.ormlearn.model.Stock;

public interface StockService {

	List<Stock> getAllStockDetails();

	List<Stock> findStockUsingCode(String code);

	List<Stock> findFBStockInSep19(String code, Date startDate, Date endDate);

	List<Stock> findGoogleStockGreaterThan1250(String code, double price);
	
	List<Stock> findTop3VolumeStock();
	
	List<Stock> findLowest3NetflixStocks(String code);
}
