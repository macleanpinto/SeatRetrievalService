package com.alpha.component.service;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alpha.component.dto.BayRequestDTO;
import com.alpha.model.Employee;

@RestController
public class TestController {

	
	@RequestMapping(value = "/employee", method = RequestMethod.GET)
	public Employee firstPage() {

		Employee emp = new Employee();
		emp.setName("emp1");
		emp.setDesignation("manager");
		emp.setEmpId("1");
		emp.setSalary(3000);
		BayRequestDTO request=new BayRequestDTO();
		request.setBayId("BLR-112");
		request.setFloorNumber(5);
		request.setWingId("C1");
	
		return emp;
	}

}
