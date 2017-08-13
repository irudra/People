package com.rudra.reader.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.rudra.reader.domain.Employee;

@Component
public class DefaultEmployeeService implements EmployeeService {

	private int counter;

	@Autowired
	private BonusService bonusService;

	public DefaultEmployeeService() {
	}

	/**
	 * Returns a new employee which is available to hired.
	 */
	public Employee findEmployee() {

		final String designation = getDesignationBasedOnId();

		final long bonus = bonusService.findBonus(counter);
		final Employee employee = new Employee(++counter, "A" + counter, designation, bonus);
		return employee;
	}

	private String getDesignationBasedOnId() {
		String designation = "Manager";

		if (counter % 2 == 0) {
			designation = "Normal";
		}
		return designation;
	}
}
