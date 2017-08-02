package com.rudra.poc.transform;

import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TransformationRouteBuilder extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		from("direct:getEmployee").process(exchange -> {
			exchange.getOut().setHeader(Exchange.HTTP_METHOD, "GET");
		}).to("http4://localhost:8181/api/employee");

		from("direct:getEmployeeHobby").process(exchange -> {
			exchange.getOut().setHeader(Exchange.HTTP_METHOD, "POST");
			exchange.getOut().setBody(exchange.getIn().getBody());
		}).to("http4://localhost:8182/api/hobby");
	}
}