package com.rudra.poc.reader;

import java.io.IOException;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
@Path("/api")
public class HobbyController {

	@Autowired
	private ObjectMapper objectMapper;
	
	@Autowired
	private HobbyService service;
	
	@POST
	@Path("/hobby")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getEmployee(@RequestBody String e)
			throws InterruptedException, JsonParseException, JsonMappingException, IOException {
		Employee employee = objectMapper.readValue(e, Employee.class);
		return Response.ok(service.addHobby(employee)).build();
	}
}
