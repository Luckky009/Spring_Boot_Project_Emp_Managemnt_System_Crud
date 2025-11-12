package com.springboot.emp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.emp.entity.Employee;

public interface EmpRepository extends JpaRepository<Employee, Integer>{

	
}
