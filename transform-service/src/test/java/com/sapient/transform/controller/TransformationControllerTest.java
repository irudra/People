package com.sapient.transform.controller;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.rudra.transform.controller.TransformationController;
import com.rudra.transform.domain.Employee;
import com.rudra.transform.service.Transformation;
import com.sapient.transform.TestApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT, classes = { TestApplicationContext.class, Employee.class,
		TransformationController.class })
public class TransformationControllerTest {

	@MockBean
	private Transformation service;

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	public void testGetEmployeeCallsTransformationService() throws InterruptedException {
		when(service.getEmployee()).thenReturn(new Employee());
		String body = this.restTemplate.getForObject("/employee/extra", String.class);
		assertNotNull(body);
		verify(service, times(1)).getEmployee();
	}

}
