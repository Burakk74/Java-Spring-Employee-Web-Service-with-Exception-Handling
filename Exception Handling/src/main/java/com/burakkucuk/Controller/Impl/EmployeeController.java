package com.burakkucuk.Controller.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.burakkucuk.Controller.IEmployeeController;
import com.burakkucuk.dto.DtoEmployee;
import com.burakkucuk.service.IEmployeeService;

@RestController
@RequestMapping( "rest/api/employee")
public class EmployeeController implements IEmployeeController {

	
	@Autowired
	private IEmployeeService employeeService;
	
	
	
	@GetMapping("/list/{id}")
	@Override
	public DtoEmployee findEmployeeById(@PathVariable(value  = "id")Long id) {
 		return employeeService.findEmployeeById(id);
	}

}
