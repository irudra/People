package com.rudra.poc.reader;

import org.springframework.stereotype.Component;

@Component
public class PushEmployee {

	private int counter;

	public PushEmployee() {
	}

	public Employee findEmployee() {
		String designation = "Manager";
		long bonus = 2000L;
		if (counter % 2 == 0) {
			designation = "Normal";
			bonus = 1000L;
		}

		Employee employee = new Employee(++counter, "A" + counter, designation, bonus);
		return employee;
	}
}
