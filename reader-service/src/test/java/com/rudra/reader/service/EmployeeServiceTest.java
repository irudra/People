package com.rudra.reader.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.rudra.reader.domain.Employee;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmployeeServiceTest {

	@MockBean
	private BonusService service;

	@Autowired
	private EmployeeService employeeService;

	@Test
	public void testGetEmployeeCallsBonusServiceToGetBonus() throws InterruptedException {
		when(service.findBonus(0)).thenReturn(100L);
		Employee employee = employeeService.findEmployee();

		assertEquals((Long) 100L, employee.getBonus());
	}

}
