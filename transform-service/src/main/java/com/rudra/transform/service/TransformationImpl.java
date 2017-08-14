package com.rudra.transform.service;

import java.util.logging.Logger;

import org.apache.camel.ConsumerTemplate;
import org.apache.camel.ProducerTemplate;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import com.rudra.transform.domain.Employee;

@Component
public class TransformationImpl implements Transformation {

	private final static Logger LOGGER = Logger.getLogger(Transformation.class.getName());

	private ProducerTemplate producer; // used only for testing purpose

	public TransformationImpl(ProducerTemplate producer, ConsumerTemplate consumer) {
		this.producer = producer;
	}

	@Override
	public Employee getEmployee() {

		String se = producer.requestBody("direct:getEmployee", null, String.class);
		System.out.println(se);
		Gson gson = new Gson();

		Employee employee = gson.fromJson(se, Employee.class);
		employee.setHobby(producer.requestBody("direct:getEmployeeHobby", se, String.class));
		System.out.println(se);

		LOGGER.info("Received message  " + employee);

		return employee;
	}
}
