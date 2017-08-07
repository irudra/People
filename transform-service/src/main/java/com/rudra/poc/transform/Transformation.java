package com.rudra.poc.transform;

import java.util.logging.Logger;

import org.apache.camel.ConsumerTemplate;
import org.apache.camel.ProducerTemplate;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import com.rudra.poc.reader.Employee;

@Component
public class Transformation {

	private final static Logger LOGGER = Logger.getLogger(Transformation.class.getName());

	private ProducerTemplate producer; // used only for testing purpose

	public Transformation(ProducerTemplate producer, ConsumerTemplate consumer) {
		this.producer = producer;
	}

	public Employee transform() {

		String se = producer.requestBody("direct:getEmployee", null, String.class);
		System.out.println(se);
		/*se = producer.requestBody("direct:getEmployeeHobby", se, String.class);
		System.out.println(se);*/
		Gson gson = new Gson();
		Employee employee = gson.fromJson(se, Employee.class);
		LOGGER.info("Received message  " + employee);
		
		
		if (employee != null &&
				employee.getDesignation().equalsIgnoreCase("Manager")) {
			employee.setHobby("Golf"); return employee; } else {
			employee.setHobby("Playing Football"); }
			
		return employee;
	}
}
