package com.rudra.poc.hobby;

import java.util.concurrent.ThreadLocalRandom;

import org.springframework.stereotype.Component;

@Component
public class HobbyService {

	private String[] hobbies = { "Reading", "Playing chess", "Golf", "Coding", "running", "travelling" };

	public String getHobby(Employee employee) {
		int hobbiesNumber = ThreadLocalRandom.current().nextInt(0, hobbies.length);
		return hobbies[hobbiesNumber];
	}
}
