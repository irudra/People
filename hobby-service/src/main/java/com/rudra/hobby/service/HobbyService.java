package com.rudra.hobby.service;

import com.rudra.hobby.domain.Employee;

/**
 * Service to get the hobby from a employee object. 
 * 
 * @author rudra
 *
 */
public interface HobbyService {

	/**
	 * Provides Hobby of the employee based the research on employee object.
	 * 
	 * @param employee
	 *            employee object
	 * @return hobby of the employee
	 */
	String getHobby(Employee employee);

}