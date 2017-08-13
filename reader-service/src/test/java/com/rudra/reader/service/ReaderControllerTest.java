package com.rudra.reader.service;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import com.rudra.reader.domain.Employee;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class ReaderControllerTest {

	@MockBean
	private EmployeeService service;

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	public void testGetEmployeeCallsEmployeeService() throws InterruptedException {
		when(service.findEmployee()).thenReturn(new Employee());
		String body = this.restTemplate.getForObject("/api/employee", String.class);
		assertNotNull(body);
		verify(service, times(1)).findEmployee();
	}

}
