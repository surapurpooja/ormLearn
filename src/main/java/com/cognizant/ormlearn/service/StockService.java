package com.cognizant.ormlearn.service;

import java.util.List;

import com.cognizant.ormlearn.model.Stock;
import com.cognizant.ormlearn.service.exp.StockNotFoundException;

public interface StockService {

	public List<Stock> findByCodeAndDate() throws StockNotFoundException;

	public List<Stock> findByCodeAndPrice() throws StockNotFoundException;

	public List<Stock> findByHighestVolume() throws StockNotFoundException;

	public List<Stock> findByLowestVolumeNflx() throws StockNotFoundException;
}
