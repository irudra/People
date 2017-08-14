package com.rudra.transform.controller;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rudra.transform.domain.Employee;
import com.rudra.transform.service.Transformation;

@RestController
public class TransformationController {
	
	private final static Logger LOGGER = Logger.getLogger(TransformationController.class.getName());
	
	@Autowired
	private Transformation transformation;
	
	@RequestMapping(value="/employee/extra")
	public Employee transformEmployee() {
		LOGGER.info("***************Start transforming service******************");
		Employee employee = transformation.getEmployee();
		LOGGER.info("***************End transforming service******************");
		return employee;
	}
}
