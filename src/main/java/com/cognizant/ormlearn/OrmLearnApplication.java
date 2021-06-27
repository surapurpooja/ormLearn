package com.cognizant.ormlearn;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.cognizant.ormlearn.model.Country;
import com.cognizant.ormlearn.model.Department;
import com.cognizant.ormlearn.model.Employee;
import com.cognizant.ormlearn.model.Skill;
import com.cognizant.ormlearn.model.Stock;
import com.cognizant.ormlearn.service.CountryService;
import com.cognizant.ormlearn.service.DepartmentService;
import com.cognizant.ormlearn.service.EmployeeService;
import com.cognizant.ormlearn.service.SkillService;
import com.cognizant.ormlearn.service.StockService;

@SpringBootApplication
public class OrmLearnApplication {

	private static final Logger LOGGER = LoggerFactory.getLogger(OrmLearnApplication.class);
	@Autowired
	CountryService countryService;
	
	@Autowired
	EmployeeService employeeService;
	
	@Autowired
	StockService stockService;

	@Autowired
	DepartmentService departmentService;

	@Autowired
	SkillService skillService;

	public static void main(String[] args) {

		SpringApplication.run(OrmLearnApplication.class, args);
	}

	
	@Bean
	CommandLineRunner testGetAllCountries() {

		return args -> {
			LOGGER.info("Start");
			List<Country> countries = countryService.getAllCountries();
			LOGGER.debug("countries={}", countries);
			LOGGER.info("End");
		};
	}

	@Bean
	CommandLineRunner testAddCountry() {
		return args -> {
			LOGGER.info("START");
			countryService.addCountry(new Country("AA", "Arabian"));
			LOGGER.info("END");
		};
	}

	@Bean
	CommandLineRunner testDeleteCountryByCode() {
		return args -> {
			LOGGER.info("START");
			countryService.deleteCountry("AB");
			LOGGER.info("END");
		};
	}

	@Bean
	CommandLineRunner testFindCountryByCode() {
		return args -> {
			LOGGER.info("START");
			Country country = countryService.findCountryByCode("CL");
			LOGGER.debug("Country : {}", country);
			LOGGER.info("END");
		};
	}

	@Bean
	CommandLineRunner testUpdateCountry() {
		return args -> {
			LOGGER.info("START");
			countryService.updateCountry("AF", "Afganisthan");
			LOGGER.info("END");
		};
	}

	@Bean
	CommandLineRunner testGetAllMatchingCountries() {
		return args -> {
			LOGGER.info("START");
			LOGGER.debug("countries = {}", countryService.getSearchingCountry("ou"));
			LOGGER.info("END");
		};
	}
	@Bean
	CommandLineRunner testSortCountry() {
		return args -> {
			LOGGER.info("Start");
			try {

				List<Country> countryList = countryService.getSortingCountry("OU");
				LOGGER.debug("Countries={}", countryList);
			} catch (Exception e) {
				LOGGER.error("message={}", e.getMessage());
			}
			LOGGER.info("End");
		};
	}
	
	
	@Bean
	CommandLineRunner testForFacebookDate() {
		return args -> {
			LOGGER.info("Start");
			List<Stock> stockList = stockService.findByCodeAndDate();
			LOGGER.debug("Stocks={}", stockList);
			LOGGER.info("End");

		};
	}

	@Bean
	CommandLineRunner testForCodeAndPrice() {
		return args -> {
			LOGGER.info("Start");
			List<Stock> stockList = stockService.findByCodeAndPrice();
			LOGGER.debug("Stocks={}", stockList);
			LOGGER.info("End");
		};
	}

	@Bean
	CommandLineRunner testForStockHighest() {
		return args -> {
			LOGGER.info("Start");
			List<Stock> stockList = stockService.findByHighestVolume();
			LOGGER.debug("Stocks={}", stockList);
			LOGGER.info("End");
		};
	}

	@Bean
	CommandLineRunner testForStockLowest() {
		return args -> {
			LOGGER.info("Start");
			List<Stock> stockList = stockService.findByLowestVolumeNflx();
			LOGGER.debug("Stocks={}", stockList);
			LOGGER.info("End");
		};
	}

	
	@Bean
	CommandLineRunner testGetEmployee() {
		return args -> {
			LOGGER.info("START");
			Employee employee = employeeService.findEmployee(1);
			LOGGER.debug("Employee:{}", employee);
			LOGGER.debug("Department:{}", employee.getDepartment());
			LOGGER.debug("Skills:{}", employee.getSkillList());
			LOGGER.info("END");
		};
	}

	@Bean
	CommandLineRunner testAddEmployee() {
		return args -> {
			LOGGER.info("START");
			Employee employee = new Employee();
			employee.setName("Pooja");
			employee.setSalary(new BigDecimal(9000.0));
			employee.setPermanent(true);
			SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");
			employee.setDateOfBirth(ft.parse("2000-07-10"));
			Department department = departmentService.findDepartment(1);
			employee.setDepartment(department);
			employeeService.saveEmployee(employee);
			LOGGER.debug("Employee:{}", employee);
			LOGGER.info("END");
		};
	}

	@Bean
	CommandLineRunner testUpdateEmployee() {
		return args -> {
			LOGGER.info("START");
			Employee employee = employeeService.findEmployee(3);
			Department department = departmentService.findDepartment(4);
			employee.setDepartment(department);
			employeeService.saveEmployee(employee);
			LOGGER.debug("Employee:{}", employee);
			LOGGER.info("END");
		};
	}

	@Bean
	CommandLineRunner testGetDepartment() {
		return args -> {
			LOGGER.info("START");
			Department department = departmentService.findDepartment(4);
			LOGGER.debug("Department:{}", department);
			department.getEmployeeList().forEach(employee -> LOGGER.debug("{}", employee));
			LOGGER.info("END");
		};
	}

	@Bean
	CommandLineRunner testAddSkillToEmployee() {
		return args -> {
			LOGGER.info("START");
			Employee employee = employeeService.findEmployee(2);
			Skill skill = skillService.findSkill(3);
			employee.getSkillList().add(skill);
			employeeService.saveEmployee(employee);
			LOGGER.debug("Employee:{}", employee);
			LOGGER.info("END");
		};
	}

	@Bean
	CommandLineRunner testGetAllPermanentEmployees() {
		return args -> {
			LOGGER.info("START");
			List<Employee> employees = employeeService.findAllPermanentEmployees();
			LOGGER.debug("Permanent Employees:{}", employees);
			employees.forEach(employee -> LOGGER.debug("Skills:{}", employee.getSkillList()));
			LOGGER.info("END");
		};
	}

	@Bean
	CommandLineRunner testGetAverageSalary() {
		return args -> {
			LOGGER.info("START");
			LOGGER.debug("Average Salary: {}", employeeService.findAverageSalaryBasedOnDeptId(2));
			LOGGER.info("END");
		};
	}

	@Bean
	CommandLineRunner testGetAllEmployeesNative() {
		return args -> {
			LOGGER.info("START");
			List<Employee> employees = employeeService.getAllEmployeesUsingNativeQuery();
			employees.forEach(employee -> LOGGER.debug("Employee: {}", employee));
			LOGGER.info("END");
		};
	}
}
