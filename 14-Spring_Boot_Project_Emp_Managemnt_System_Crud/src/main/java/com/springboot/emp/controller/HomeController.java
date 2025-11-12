package com.springboot.emp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.springboot.emp.entity.Employee;
import com.springboot.emp.service.EmpService;

import jakarta.servlet.http.HttpSession;

@Controller
public class HomeController {

	@Autowired
	private EmpService empService;
	
	@GetMapping("/")
	public String index() {
		return "index";
	}
	@GetMapping("/loadEmpSave")
	public String loadEmpSave() {
		return "emp_save";
	}
	@GetMapping("/EditEmp")
	public String EditEmp() {
		return "edit_emp";
	}
	
	@PostMapping("/saveEmp")
	public String saveEmp(@ModelAttribute Employee emp, HttpSession session) {
		
		//System.out.println(emp);
		
		Employee newEmp = empService.saveEmp(emp);
		if(newEmp!=null) {
			//System.out.println("save success..!");
			session.setAttribute("msg", "Register Successfully..!");
		}else {
			//System.out.println("Something Wrong on the Server..!!");
			session.setAttribute("msg", "Something Wrong on the Server..!!");
		}
		return "redirect:/loadEmpSave";
	}
}
