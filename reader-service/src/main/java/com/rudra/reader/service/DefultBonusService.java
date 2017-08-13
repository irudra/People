package com.rudra.reader.service;

import org.springframework.stereotype.Component;

/**
 * Default service to calculate Bonus service for the employee.
 * 
 * @author rudra
 *
 */
@Component
public class DefultBonusService implements BonusService {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public long findBonus(int employeeId) {
		if (employeeId % 2 == 0) {
			return 1000L;
		}
		return 2000L;
	}

}
