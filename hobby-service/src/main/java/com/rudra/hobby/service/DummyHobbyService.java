package com.rudra.hobby.service;

import java.util.concurrent.ThreadLocalRandom;

import org.springframework.stereotype.Component;

import com.rudra.hobby.domain.Employee;

@Component
public class DummyHobbyService implements HobbyService {

	private String[] hobbies = { "Reading", "Playing chess", "Golf", "Coding", "running", "travelling" };

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getHobby(Employee employee) {
		int hobbiesNumber = ThreadLocalRandom.current().nextInt(0, hobbies.length);
		return hobbies[hobbiesNumber];
	}
}
