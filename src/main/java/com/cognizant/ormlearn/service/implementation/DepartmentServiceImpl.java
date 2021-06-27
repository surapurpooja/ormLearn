package com.cognizant.ormlearn.service.Implementation;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.ormlearn.model.Department;
import com.cognizant.ormlearn.repository.DepartmentRepository;
import com.cognizant.ormlearn.service.DepartmentService;

@Transactional
@Service
public class DepartmentServiceImpl implements DepartmentService {
	@Autowired
	private DepartmentRepository departmentRepository;

	public Department findDepartment(int id) {
		return departmentRepository.findById(id).get();
	}

	public void saveDepartment(Department department) {
		departmentRepository.save(department);

	}

}
