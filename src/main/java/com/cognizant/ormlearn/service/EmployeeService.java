package com.cognizant.ormlearn.service;

import java.util.List;

import com.cognizant.ormlearn.model.Employee;

public interface EmployeeService {
	
	Employee findEmployee(int id);

	void saveEmployee(Employee employee);

	List<Employee> findAllPermanentEmployees();

	double findAverageSalaryBasedOnDeptId(int id);

	List<Employee> getAllEmployeesUsingNativeQuery();
}
