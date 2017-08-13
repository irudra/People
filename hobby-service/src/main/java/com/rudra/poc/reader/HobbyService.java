package com.rudra.poc.reader;

import java.util.concurrent.ThreadLocalRandom;

import org.springframework.stereotype.Component;

@Component
public class HobbyService {

	private String[] hobbies = { "Reading", "Playing chess", "Golf", "Coding", "running", "travelling" };

	public Employee addHobby(Employee employee) {
		int hobbiesNumber = ThreadLocalRandom.current().nextInt(0, hobbies.length);
		System.out.println("checking Hobby of employe with details: " +employee);
		employee.setHobby(hobbies[hobbiesNumber]);
		return employee;
	}
}
