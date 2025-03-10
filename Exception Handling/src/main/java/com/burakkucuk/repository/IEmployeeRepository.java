package com.burakkucuk.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.burakkucuk.model.Employee;


@Repository
public interface IEmployeeRepository extends JpaRepository<Employee, Long> {

}
