package com.burakkucuk.service.Impl;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.burakkucuk.dto.DtoDepartment;
import com.burakkucuk.dto.DtoEmployee;
import com.burakkucuk.exception.BaseException;
import com.burakkucuk.exception.ErrorMessage;
import com.burakkucuk.exception.MessageType;
import com.burakkucuk.model.Department;
import com.burakkucuk.model.Employee;
import com.burakkucuk.repository.IEmployeeRepository;
import com.burakkucuk.service.IEmployeeService;

@Service
public class EmployeeServiceImpl implements IEmployeeService {

	
	
	@Autowired
	private IEmployeeRepository employeeRepository; 
	
	@Override
	public DtoEmployee findEmployeeById(Long id) {
 		
		
      Optional<Employee> optional = employeeRepository.findById(id);
		if(optional.isEmpty()) {
			
			 throw new BaseException(new ErrorMessage(MessageType.NO_RECORD_EXIST,id.toString()));
		}
		 
		Employee employee = optional.get();
		
		
		Department department = employee.getDepartment();
		
		
		DtoEmployee reEmployee = new DtoEmployee();
		 DtoDepartment reDepartment = new DtoDepartment();
		
		
		BeanUtils.copyProperties(employee, reEmployee );
		BeanUtils.copyProperties(department, reDepartment);
		
		reEmployee.setDtoDepartment(reDepartment);
	 
		
		return reEmployee;
	}

}
