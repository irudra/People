package com.rudra.reader.service;

/**
 * Service to calculate Bonus for the employee.
 * 
 * @author rudra
 *
 */
public interface BonusService {

	/**
	 * Returns bonus for the employee represented by the employee id.
	 * 
	 * @param employeeId
	 *            Id of the employee
	 * @return Bonus for the employee
	 */
	long findBonus(int employeeId);
}
