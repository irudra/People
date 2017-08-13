package com.rudra.poc.transform;

import java.util.logging.Logger;

import org.apache.camel.ConsumerTemplate;
import org.apache.camel.ProducerTemplate;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import com.rudra.reader.domain.Employee;

@Component
public class TransformationImpl implements Transformation{

	private final static Logger LOGGER = Logger.getLogger(Transformation.class.getName());

	private ProducerTemplate producer; // used only for testing purpose

	public TransformationImpl(ProducerTemplate producer, ConsumerTemplate consumer) {
		this.producer = producer;
	}

	public Employee transform() {

		String se = producer.requestBody("direct:getEmployee", null, String.class);
		System.out.println(se);
		Gson gson = new Gson();
		
		Employee employee = gson.fromJson(se, Employee.class);
		employee.setHobby(producer.requestBody("direct:getEmployeeHobby", se, String.class));
		System.out.println(se);
		
		
		LOGGER.info("Received message  " + employee);
		
		
		 /*if (employee != null &&
		  employee.getDesignation().equalsIgnoreCase("Manager")) {
			 int a=1;
			 if(a==1){
				 throw new RuntimeException("I am in problem");
			 }
		  employee.setHobby("Golf"); return employee; } else {
		  employee.setHobby("Playing Football"); }*/
		 
		return employee;
	}
}
