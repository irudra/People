package com.rudra.reader.service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Path("/api")
public class ReaderController {

	@Autowired
	private EmployeeService employeeTest;

	@GET
	@Path("/employee")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getEmployee() throws InterruptedException {
		return Response.ok(employeeTest.findEmployee()).build();
	}
}
